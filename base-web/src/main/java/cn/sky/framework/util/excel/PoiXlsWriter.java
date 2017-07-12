package cn.sky.framework.util.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

import cn.sky.framework.xml.XmlProperty;

/**
 * <p>
 * <b>excel导出工具类</b>, 支持多个sheet, 且可以在各个sheet之间切换
 * <p>
 * 
 * <p>
 * 注意: <br>
 * (1) 每个sheet最大行数是 <b>1048576行</b> <br>
 * (2) <b>excel</b>文件的后缀名是 <b>xlsx</b>
 * </p>
 * 
 * <p>
 * 测试: <br>
 * (1) 单个 sheet, 每行 43 个字符串字段，1048576行，10分钟52秒成功导入, 总行数: <b>1048576</b> 行 <br>
 * (2) 两个 sheet, 每个 sheet 每行 43 个字符串字段，每个 sheet 都有 1048576行，27分钟43秒成功导入, 总行数:
 * <b>(1048576 * 2) </b>行
 * </p>
 * 
 * @author ligaofu
 * 
 */
public class PoiXlsWriter {

	private OutputStream out;
	private SXSSFWorkbook workbook;

	/** sheet数组 */
	private SXSSFSheet[] sheetArray;

	/** 各个 sheet 的名称 */
	private String[] sheetNames;

	/** 各个sheet的当前行数 */
	private int[] sheetRowi;

	/** sheet数组当前下标 */
	private int sheeti;

	/** sheet的个数, sheet数组大小 */
	private int sheetArrayLength;

	/** sheet切换是否成功 */
	private boolean isSheetSwitched;

	/**
	 * 打开excel文件
	 * 
	 * @param fileName
	 *            excel文件名, 后缀名是 <b>xlsx</b>
	 */
	public void open(String fileName) {
		try {
			if (fileName != null && fileName != "") {
				out = new FileOutputStream(fileName);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 打开输出流
	 * 
	 * @param out
	 *            输出流
	 */
	public void open(OutputStream out) {
		this.out = out;
	}

	/**
	 * 创建一个sheet
	 * 
	 * @return 创建sheet是否成功
	 */
	public boolean createSheet() {
		return createSheet(1);
	}

	/**
	 * 创建多个sheet
	 * 
	 * @param sheetNum
	 *            sheet个数, sheetNum要大于0
	 * @return 创建sheet是否成功
	 */
	public boolean createSheet(int sheetNum) {
		if (sheetNum < 1)
			return false;
		return createSheet(new String[sheetNum]);
	}

	/**
	 * <p>
	 * 通过 sheet 名称数组方式, 创建多个 sheet
	 * </p>
	 * <p>
	 * 注意:<br>
	 * (1) 当 sheet 中没有写入内容的时候, 该 sheet 是不会创建的 <br>
	 * (2) 当 sheet 名称数组中有 null或空字符串的时候, 该 null或空字符串将换成 sheet* , * 表示
	 * 该null或空字符串在数组中的序数, 如: { null, ""} 换成 {"sheet1", "sheet2"}<br>
	 * (3) 当 sheet 名称数组中有多个非空字符串相同的时候,
	 * 将依次给这些相同的字符串(不包括相同字符串中的第一个字符串)末尾添加上该字符串在数组中的序数, 如: { "a","b",
	 * "a","c","d","a"} 换成 { "a","b", "a3","c","d","a6"}<br>
	 * </p>
	 * 
	 * @param sheetNames
	 *            sheet的名称数组
	 * @return
	 */
	public boolean createSheet(String[] sheetNames) {
		if (out == null || sheetNames == null || sheetNames.length == 0)
			return false;
		//
		this.sheetNames = changeSheetNames(sheetNames);
		int sheetNum = this.sheetNames.length;
		sheetArrayLength = sheetNum;
		sheetArray = new SXSSFSheet[sheetNum];
		sheetRowi = new int[sheetNum];
		for (int i = 0; i < sheetNum; ++i) {
			sheetRowi[i] = 0;// 各个sheet当前行数是0
		}
		workbook = new SXSSFWorkbook();
		sheeti = 0;// sheet数组当前下标默认是0, 默认切换到第一个sheet
		sheetArray[sheeti] = (SXSSFSheet) workbook
				.createSheet(this.sheetNames[sheeti]);
		isSheetSwitched = true;// sheet切换成功
		return true;
	}

	/**
	 * 获得 sheet 的名称数组
	 * 
	 * @return
	 */
	public String[] getSheetNames() {
		return sheetNames;
	}

	/**
	 * <p>
	 * 获得第 i 个 sheet 的名称
	 * </p>
	 * <p>
	 * 注意: <br>
	 * (1) 第一个 sheet 对应的 i 是 1
	 * </p>
	 * 
	 * @return 该 sheet 不存在, 返回 null
	 */
	public String getSheetName(int i) {
		if (i < 1 || i > sheetNames.length) {
			return null;
		}
		return sheetNames[i - 1];
	}

	/**
	 * 调整 sheet 名称数组, 将数组里面的 null和空字符串 换成 sheet* , * 表示 该null或空字符串在数组中的序数<br>
	 * 如: { null, ""} 换成 {"sheet1", "sheet2"}
	 * 
	 * @param sheetNames
	 * @return
	 */
	protected String[] changeSheetNames(String[] sheetNames) {
		String[] resultSheetNames = new String[sheetNames.length];
		for (int i = 0; i < sheetNames.length; ++i) {
			if (sheetNames[i] == null || sheetNames[i] == "") {
				resultSheetNames[i] = "sheet" + (i + 1);
			} else {
				resultSheetNames[i] = sheetNames[i];
				// 消除相同的字符串
				for (int ii = i + 1; ii < sheetNames.length; ++ii) {
					if (sheetNames[i] == sheetNames[ii]) {
						sheetNames[ii] += "" + (ii + 1);
					}
				}
			}
		}
		return resultSheetNames;
	}

	/**
	 * <p>
	 * 切换到第几个sheet
	 * <p>
	 * 第一个 sheet 对应的 sheeti 是 1, 而不是 0
	 * 
	 * @param sheeti
	 * @return 切换是否成功
	 */
	public boolean switchSheet(int sheeti) {
		if (sheeti < 1 || sheeti > sheetArrayLength) {
			isSheetSwitched = false;
			return false;
		}
		//
		this.sheeti = sheeti - 1;
		if (sheetArray[sheeti - 1] == null) {
			sheetArray[sheeti - 1] = (SXSSFSheet) workbook
					.createSheet(sheetNames[sheeti - 1]);
		}
		isSheetSwitched = true;
		return true;
	}

	/**
	 * <p>
	 * 切换到指定名称的 sheet
	 * <p>
	 * 
	 * @param sheetName
	 * @return 切换是否成功
	 */
	public boolean switchSheet(String sheetName) {
		if (sheetName == null || sheetName == "") {
			isSheetSwitched = false;
			return false;
		}
		for (int i = 0; i < sheetNames.length; ++i) {
			if (sheetNames[i].endsWith(sheetName)) {
				sheeti = i;
				if (sheetArray[i] == null) {
					sheetArray[i] = (SXSSFSheet) workbook
							.createSheet(sheetNames[i]);
				}
				isSheetSwitched = true;
				return true;
			}
		}
		isSheetSwitched = false;
		return false;
	}

	/**
	 * 向excel文件里追加一行
	 * 
	 * @param record
	 */
	public void addRow(Object[] record) {
		if (sheetArray != null && isSheetSwitched
				&& sheetRowi[sheeti] < 1048576) {
			SXSSFRow row = (SXSSFRow) sheetArray[sheeti]
					.createRow(this.sheetRowi[sheeti]);
			for (int i = 0; i < record.length; i++) {
				SXSSFCell cell = (SXSSFCell) row.createCell((short) i);
				String value = ObjectToString(record[i]);
				cell.setCellValue(new XSSFRichTextString(value));
			}
			sheetRowi[sheeti]++;
		}
	}

	/**
	 * 关闭文件
	 */
	public void close() {
		try {
			if (out != null && workbook != null) {
				workbook.write(out);
				out.flush();
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Object类型转换为String类型
	 * 
	 * @param param
	 * @return
	 */
	protected String ObjectToString(Object param) {
		String result = "";
		if (param instanceof String) {
			result = (String) param;
		} else if (param instanceof Integer) {
			int i = ((Integer) param).intValue();
			result = String.valueOf(i);
		} else if (param instanceof Double) {
			double d = ((Double) param).doubleValue();
			result = String.valueOf(d);
		} else if (param instanceof Float) {
			float f = ((Float) param).floatValue();
			result = String.valueOf(f);
		} else if (param instanceof Long) {
			long l = ((Long) param).longValue();
			result = String.valueOf(l);
		} else if (param instanceof Boolean) {
			boolean b = ((Boolean) param).booleanValue();
			result = String.valueOf(b);
		} else if (param instanceof Date) {
			Date d = (Date) param;
			result = String.valueOf(d);
		}
		return result;
	}

	/**
	 * 单个sheet示例, sheet名称取默认值
	 */
	@SuppressWarnings("unused")
	private static void exampleOneSheet() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm ss");// 设置日期格式
		System.out.println("开始时间: " + df.format(new Date()));// new
																// Date()为获取当前系统时间
		long starTime = System.currentTimeMillis();
		//
		String[] row = { "姓名", "性别" };
		//
		PoiXlsWriter xls = new PoiXlsWriter();
		xls.open("target/excel.xlsx");
		xls.createSheet();
		//
		xls.addRow(row);
		//
		xls.close();
		//
		long endTime = System.currentTimeMillis();
		long Time = endTime - starTime;
		System.out.println("所花费时间: " + Time + "ms");
		System.out.println("结束时间: " + df.format(new Date()));
	}

	/**
	 * 多个sheet示例, sheet名称取默认值
	 */
	@SuppressWarnings("unused")
	private static void exampleMultiSheet() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm ss");// 设置日期格式
		System.out.println("开始时间: " + df.format(new Date()));// new
																// Date()为获取当前系统时间
		long starTime = System.currentTimeMillis();
		//
		String[] row = { "姓名", "性别" };
		//
		PoiXlsWriter xls = new PoiXlsWriter();
		xls.open("target/excel.xlsx");
		xls.createSheet(20);
		//
		for (int i = 1; i <= 20; ++i) {
			xls.switchSheet(i);
			xls.addRow(row);
		}
		//
		xls.close();
		//
		long endTime = System.currentTimeMillis();
		long Time = endTime - starTime;
		System.out.println("所花费时间: " + Time + "ms");
		System.out.println("结束时间: " + df.format(new Date()));
	}

	/**
	 * 多个sheet示例, 自定义sheet名称
	 */
	@SuppressWarnings("unused")
	private static void exampleMultiSheetWithName() {
		FileOutputStream bos = null;
		try {
			bos = new FileOutputStream("output.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.setOut(new PrintStream(bos));
		//
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm ss");// 设置日期格式
		System.out.println("开始时间: " + df.format(new Date()));// new
																// Date()为获取当前系统时间
		long starTime = System.currentTimeMillis();
		//
		String[] sheetNames = { "a", "", null, "b", "a", "c", "b", "a" };
		String[] row = { "姓名", "性别" };
		//
		PoiXlsWriter xls = new PoiXlsWriter();
		xls.open("target/excel.xlsx");
		xls.createSheet(sheetNames);
		//
		String[] rsheetNames = xls.getSheetNames();
		for (int i = 0; i < rsheetNames.length; ++i) {
			System.out.print(rsheetNames[i] + " ");
		}
		System.out.println();
		//
		xls.addRow(row);
		//
		xls.switchSheet("sheet2");
		xls.addRow(row);
		xls.switchSheet("sheet3");
		xls.addRow(row);
		xls.switchSheet("b");
		xls.addRow(row);
		xls.switchSheet("a5");
		xls.addRow(row);
		xls.switchSheet("b7");
		xls.addRow(row);
		xls.switchSheet("a8");
		xls.addRow(row);
		//
		xls.close();
		//
		long endTime = System.currentTimeMillis();
		long Time = endTime - starTime;
		System.out.println("所花费时间: " + Time + "ms");
		System.out.println("结束时间: " + df.format(new Date()));
	}

	//
	public static void main(String args[]) {
		TxtWriter txt = new TxtWriter();
		txt.open("out.log");
		//
		Properties param = XmlProperty.readPropertiesFromXML("param.xml");
		String[] head = param.getProperty("head").split(",");
		String[] contents = param.getProperty("contents").split(",");
		int sheetNum = Integer.parseInt(param.getProperty("sheetNum"));
		int maxRow = Integer.parseInt(param.getProperty("maxRow"));// 1048576
		//
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm ss");// 设置日期格式
		txt.write("======================================= " + sheetNum + " * "
				+ maxRow + " 开始 ======================================");
		txt.write("开始时间: " + df.format(new Date()));// new Date()为获取当前系统时间
		long starTime = System.currentTimeMillis();
		//
		txt.write("sheet的个数: " + sheetNum + ", 每个sheet的行数: " + maxRow
				+ ", 总行数: " + sheetNum + " * " + maxRow);
		//
		PoiXlsWriter xls = new PoiXlsWriter();
		xls.open("excel.xlsx");
		xls.createSheet(sheetNum);
		//
		for (int i = 1; i <= sheetNum; ++i) {
			xls.switchSheet(i);
			xls.addRow(head);
			// 1048576
			for (int ii = 0; ii < maxRow; ++ii) {
				contents[0] = "chk_" + ii;
				xls.addRow(contents);
			}
		}
		//
		xls.close();
		//
		long endTime = System.currentTimeMillis();
		long Time = endTime - starTime;
		txt.write("所花费时间: " + Time + "ms");
		txt.write("结束时间: " + df.format(new Date()));
		txt.write("======================================= " + sheetNum + " * "
				+ maxRow + " 结束 ======================================");
		txt.close();
	}
}
