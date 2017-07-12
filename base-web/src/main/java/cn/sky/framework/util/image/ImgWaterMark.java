package cn.sky.framework.util.image;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

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
			Image srcImg = ImageIO.read(srcImgFile);
			int srcImgWidth = srcImg.getWidth(null);
			int srcImgHeight = srcImg.getHeight(null);
			// 加水印
			BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = bufImg.createGraphics();
			g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
			g.setColor(textStyle.getFontColor()); // 根据图片的背景设置水印颜色
			g.setFont(textStyle.getFont());
			//
			drawString(srcImgWidth, srcImgHeight, g, textStyle, text);
			g.dispose();
			// 输出图片
			FileOutputStream outImgStream = new FileOutputStream(outImgPath);
			ImageIO.write(bufImg, "jpg", outImgStream);
			outImgStream.flush();
			outImgStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void drawString(int imgWidth, int imgHeight, Graphics2D g, TextStyle textStyle, String text) {
		FontMetrics fm = g.getFontMetrics();
		Rectangle2D rc = fm.getStringBounds(text, g);
		int textWidth = (int) rc.getWidth();
		int fontHigth = (int) rc.getHeight();
		int remainWidth = imgWidth - textStyle.getPaddingLeft() - textStyle.getPaddingRight();// 剩余的空白宽度
		System.out.println("ImgWidth: " + imgWidth + " , ImgHeight: " + imgWidth + ", textWidth:" + textWidth
				+ ", fontHigth: " + fontHigth + " , remainWidth: " + remainWidth);
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
		textStyle.setFont(new Font("Microsoft YaHei", Font.PLAIN, 85));
		textStyle.setPaddingLeft(100);
		textStyle.setPaddingRight(100);
		textStyle.setPaddingButtom(100);
		textStyle.setYfloat(TextStyle.YFloatButtom);
		textStyle.setTextAlign(TextStyle.TextAlignCentre);
		waterMark("d:/a.jpg", "d:/afterWatermark.jpg", textStyle, "将“一带一路”建成和平、繁荣、开放、创新、文明之路。");
	}

}
