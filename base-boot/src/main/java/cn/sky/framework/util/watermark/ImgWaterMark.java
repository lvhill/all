package cn.sky.framework.util.watermark;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import cn.sky.framework.util.Base64ImgUtil;

/**
 * 图片水印工具类
 * 
 * @author gflid
 *
 */
public class ImgWaterMark {

	/**
	 * 图片添加水印
	 * 
	 * @param srcImgPath
	 *            源图片路径
	 * @param outImgPath
	 *            输出图片路径
	 * @param text
	 *            水印文本
	 */
	public static void waterMark(String srcImgPath, String outImgPath, String text) {
		waterMark(srcImgPath, outImgPath, new TextStyle(), text);
	}

	/**
	 * 图片添加水印
	 * 
	 * @param srcImgPath
	 *            源图片路径
	 * @param outImgPath
	 *            输出图片路径
	 * @param textStyle
	 *            文本样式
	 * @param text
	 *            水印文本
	 */
	public static void waterMark(String srcImgPath, String outImgPath, TextStyle textStyle, String text) {
		try {
			// 读取原图片信息
			File srcImgFile = new File(srcImgPath);
			InputStream imgIn = new FileInputStream(srcImgFile);
			// 输出图片
			FileOutputStream imgOut = new FileOutputStream(outImgPath);
			waterMark(imgIn, imgOut, textStyle, text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 图片添加水印
	 * 
	 * @param srcImgPath
	 *            源图片输入流
	 * @param outImgPath
	 *            水印图片输出流
	 * @param text
	 *            水印文本
	 */
	public static void waterMark(InputStream imgIn, OutputStream imgOut, String text) {
		waterMark(imgIn, imgOut, new TextStyle(), text);
	}

	/**
	 * 图片添加水印
	 * 
	 * @param srcImgPath
	 *            源图片输入流
	 * @param outImgPath
	 *            水印图片输出流
	 * @param textStyle
	 *            文本样式
	 * @param text
	 *            水印文本
	 */
	public static void waterMark(InputStream imgIn, OutputStream imgOut, TextStyle textStyle, String text) {
		try {
			// 读取原图片信息
			Image srcImg = ImageIO.read(imgIn);
			int srcImgWidth = srcImg.getWidth(null);
			int srcImgHeight = srcImg.getHeight(null);
			// 加水印
			BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = bufImg.createGraphics();
			// 背景透明
			bufImg = g.getDeviceConfiguration().createCompatibleImage(srcImgWidth, srcImgHeight,
					Transparency.TRANSLUCENT);
			g.dispose();
			g = bufImg.createGraphics();
			// 消除java.awt.Font字体的锯齿
			g.setStroke(new BasicStroke(3.5f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			//
			g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
			g.setColor(textStyle.getFontColor()); // 根据图片的背景设置水印颜色
			g.setFont(textStyle.getFont());
			//
			drawString(srcImgWidth, srcImgHeight, g, textStyle, text);
			g.dispose();
			// 输出图片
			ImageIO.write(bufImg, "png", imgOut);
			imgOut.flush();
			imgOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 图片添加水印
	 * 
	 * @param imgIn
	 *            源图片输入流
	 * @param text
	 *            水印文本
	 * @return 水印图片Base64字符串
	 */
	public static String waterMark(InputStream imgIn, String text) {
		return waterMark(imgIn, new TextStyle(), text);
	}

	/**
	 * 图片添加水印
	 * 
	 * @param imgIn
	 *            源图片输入流
	 * @param textStyle
	 *            文本样式
	 * @param text
	 *            水印文本
	 * @return 水印图片Base64字符串
	 */
	public static String waterMark(InputStream imgIn, TextStyle textStyle, String text) {
		String base64 = "";
		try {
			// 读取原图片信息
			Image srcImg = ImageIO.read(imgIn);
			int srcImgWidth = srcImg.getWidth(null);
			int srcImgHeight = srcImg.getHeight(null);
			// 加水印
			BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = bufImg.createGraphics();
			// 背景透明
			bufImg = g.getDeviceConfiguration().createCompatibleImage(srcImgWidth, srcImgHeight,
					Transparency.TRANSLUCENT);
			g.dispose();
			g = bufImg.createGraphics();
			// 消除java.awt.Font字体的锯齿
			g.setStroke(new BasicStroke(3.5f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			//
			g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
			g.setColor(textStyle.getFontColor()); // 根据图片的背景设置水印颜色
			g.setFont(textStyle.getFont());
			//
			drawString(srcImgWidth, srcImgHeight, g, textStyle, text);
			g.dispose();
			// 输出图片
			ByteArrayOutputStream imgOut = new ByteArrayOutputStream();
			ImageIO.write(bufImg, "png", imgOut);
			base64 = Base64ImgUtil.imgToBase64(imgOut);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return base64;
	}

	private static void drawString(int imgWidth, int imgHeight, Graphics2D g, TextStyle textStyle, String text) {
		FontMetrics fm = g.getFontMetrics();
		Rectangle2D rc = fm.getStringBounds(text, g);
		int textWidth = (int) rc.getWidth();
		int remainWidth = imgWidth - textStyle.getPaddingLeft() - textStyle.getPaddingRight();// 剩余的空白宽度
		//
		int x = 0;
		int y = 0;
		int lineNum = 0;
		List<String> lines = new ArrayList<String>();
		if (textStyle.isAutoWrapText()) {// 文本自动换行
			if (textWidth > remainWidth) {
				int tw = 0;
				int i;
				int j;
				for (i = 0, j = 1; j < text.length(); ++j) {
					tw = (int) fm.getStringBounds(text.substring(i, j), g).getWidth();
					if (tw > remainWidth) {
						lines.add(text.substring(i, j - 1));
						i = j - 1;
						++lineNum;
					}
				}
				if (i < j) {
					lines.add(text.substring(i, j));
					++lineNum;
				}

			} else {
				lines.add(text);
			}
		} else {
			lines.add(text);
		}
		//
		int yHeight = lineNum * textStyle.getFont().getSize() + (lineNum - 1) * textStyle.getRowledge();
		//
		if (TextStyle.XFloatLeft.equals(textStyle.getXfloat())) {// 文本块左漂浮
			x = textStyle.getPaddingLeft();
		}
		if (TextStyle.XFloatRight.equals(textStyle.getXfloat())) {// 文本块右漂浮
			x = imgWidth - textWidth - textStyle.getPaddingRight();
		}
		if (TextStyle.XFloatCentre.equals(textStyle.getXfloat())) {// 文本块横向居中
			x = (imgWidth - textWidth) / 2;
		}
		//
		if (TextStyle.YFloatTop.equals(textStyle.getYfloat())) {// 文本块上漂浮
			y = textStyle.getPaddingTop() + textStyle.getFont().getSize();
		}
		if (TextStyle.YFloatButtom.equals(textStyle.getYfloat())) {// 文本块下漂浮
			y = imgHeight - textStyle.getPaddingButtom() - yHeight;
		}
		if (TextStyle.YFloatCentre.equals(textStyle.getYfloat())) {// 文本块垂直居中
			y = (imgHeight - yHeight) / 2;
		}
		//
		int nx = 0;
		int ny = 0;
		for (int i = 0; i < lines.size(); ++i) {
			if (TextStyle.TextAlignLeft.equals(textStyle.getTextAlign())) {// 文字左对齐
				nx = x;
			}
			if (TextStyle.TextAlignRight.equals(textStyle.getTextAlign())) {// 文字右对齐
				int gs = remainWidth - (int) fm.getStringBounds(lines.get(i), g).getWidth();
				nx = x + gs;
			}
			if (TextStyle.TextAlignCentre.equals(textStyle.getTextAlign())) {// 文字居中对齐
				int gs = remainWidth - (int) fm.getStringBounds(lines.get(i), g).getWidth();
				nx = x + gs / 2;
			}
			//
			ny = y + i * (textStyle.getFont().getSize() + textStyle.getRowledge());
			//
			g.drawString(lines.get(i), nx, ny);

		}

	}

	public static void main(String[] args) {
		TextStyle textStyle = new TextStyle();
		Color color = new Color(85, 72, 44);
		textStyle.setFontColor(color);
		textStyle.setRowledge(15);
		textStyle.setFont(new Font("Microsoft YaHei", Font.PLAIN, 30));
		textStyle.setPaddingLeft(60);
		textStyle.setPaddingRight(60);
		textStyle.setPaddingButtom(160);
		textStyle.setYfloat(TextStyle.YFloatButtom);
		textStyle.setTextAlign(TextStyle.TextAlignCentre);
		waterMark("d:/1.png", "d:/1-water.png", textStyle, "我已完成雅姿微雕周末护理手法教学基础班的学习！小伙伴们，和我一起加入安利产品基础班的学习吧！");
	}

}
