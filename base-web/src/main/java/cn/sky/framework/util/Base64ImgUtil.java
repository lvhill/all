package cn.sky.framework.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;

/**
 * 图片和Base64字符串互转工具
 * 
 */
public class Base64ImgUtil {

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
	 * @param imgIn
	 *            图片输入流
	 * @return
	 */
	public static String imgToBase64(InputStream imgIn) {
		byte[] data = null;
		// 读取图片字节数组
		try {
			data = new byte[imgIn.available()];
			imgIn.read(data);
			imgIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(Base64.encodeBase64(data));
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
	public static boolean base64ToImg(String base64, OutputStream imgOut) {
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
			imgOut.write(b);
			return true;
		} catch (Exception e) {
			return false;
		}
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
	}
}