package cn.sky.framework.util;

import java.awt.Color;
import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;

import cn.sky.framework.util.watermark.ImgWaterMark;
import cn.sky.framework.util.watermark.TextStyle;

/**
 * 图片和Base64字符串互转工具
 * 
 */
public class Base64ImgUtil {
	protected final static String base64Prefix = "data:image/png;base64,";

	/**
	 * 将图片转换成Base64编码字符串
	 * 
	 * @param imgPath
	 *            图片路径
	 * @return
	 */
	public static String imgToBase64(String imgPath) {
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
			in = new FileInputStream(imgPath);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(Base64.encodeBase64(data));
	}

	/**
	 * 将图片转换成Base64编码字符串
	 * 
	 * @param imgInStream
	 *            图片输入流
	 * @return
	 */
	public static String imgToBase64(InputStream imgInStream) {
		byte[] data = null;
		// 读取图片字节数组
		try {
			data = new byte[imgInStream.available()];
			imgInStream.read(data);
			imgInStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(Base64.encodeBase64(data));
	}

	/**
	 * 将图片转换成Base64编码字符串
	 * 
	 * @param imgOutStream
	 *            图片输出流
	 * @return
	 * @throws Exception
	 */
	public static String imgToBase64(OutputStream imgOutStream) throws Exception {
		return imgToBase64(parse(imgOutStream));
	}

	/**
	 * Base64编码字符串转成图片
	 * 
	 * @param base64
	 *            base64图片数据
	 * @param imgPath
	 *            保存图片路径
	 * @return
	 */
	public static boolean base64ToImg(String base64, String imgPath) {
		if (base64 == null) // 图像数据为空
			return false;
		try {
			// Base64解码
			byte[] b = Base64.decodeBase64(base64);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成jpeg图片
			OutputStream out = new FileOutputStream(imgPath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Base64编码字符串转成图片
	 * 
	 * @param base64
	 *            base64图片数据
	 * @param imgOut
	 *            图片输出流
	 * @return
	 */
	public static boolean base64ToImg(String base64, OutputStream imgOutStream) {
		if (base64 == null) // 图像数据为空
			return false;
		try {
			// Base64解码
			byte[] b = Base64.decodeBase64(base64);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成jpeg图片
			imgOutStream.write(b);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/***
	 * InputStream 转 OutputStream
	 * 
	 * @param in
	 * @return
	 * @throws Exception
	 */
	public static ByteArrayOutputStream parse(InputStream in) throws Exception {
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
		int ch;
		while ((ch = in.read()) != -1) {
			swapStream.write(ch);
		}
		return swapStream;
	}

	/**
	 * OutputStream 转 InputStream
	 * 
	 * @param out
	 * @return
	 * @throws Exception
	 */
	public static ByteArrayInputStream parse(OutputStream out) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		baos = (ByteArrayOutputStream) out;
		ByteArrayInputStream swapStream = new ByteArrayInputStream(baos.toByteArray());
		return swapStream;
	}

	public static void main(String[] args) throws IOException {
		String imgFile = "d:/1.png";// 待处理的图片
		String imgbese = imgToBase64(imgFile);
		System.out.println(imgbese);
		//
		String imgFilePath = "d:/2.jpg";// 新生成的图片
		base64ToImg(imgbese, imgFilePath);
		//
		FileInputStream in = new FileInputStream(imgFilePath);
		imgbese = imgToBase64(in);
		System.out.println(imgbese);
		//
		imgFilePath = "d:/3.jpg";// 新生成的图片
		OutputStream out = new FileOutputStream(imgFilePath);
		base64ToImg(imgbese, out);
		out.flush();
		out.close();
		//
		TextStyle textStyle = new TextStyle();
		Color color = new Color(85, 72, 44);
		textStyle.setFontColor(color);
		textStyle.setRowledge(15);
		textStyle.setFont(new Font("STXingkai", Font.BOLD, 15));
		textStyle.setPaddingLeft(148);
		textStyle.setPaddingRight(250);
		textStyle.setPaddingButtom(455);
		textStyle.setYfloat(TextStyle.YFloatButtom);
		textStyle.setTextAlign(TextStyle.TextAlignCentre);
		//
		FileInputStream imgInStream = new FileInputStream("d:/1.png");
		String base64 = ImgWaterMark.waterMark(imgInStream, textStyle, "乔伊亚历山大·比基卡利斯勒·埃利奥特福克斯威");
		System.out.println(base64);
		base64ToImg(base64, "d:/1_waterMarkBase64.png");
	}
}