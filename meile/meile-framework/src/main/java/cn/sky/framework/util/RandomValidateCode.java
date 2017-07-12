package cn.sky.framework.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 随机验证码生成类
 * 
 * @author gaofu
 *
 */
public class RandomValidateCode {

	private String validateCode; // 生成的验证码字符串
	private BufferedImage validateCodeImg; // 生成的验证码图片
	//
	private int imgWidth = 100;// 图片宽
	private int imgHeight = 30;// 图片高
	private int lineSize = 5;// 干扰线数量
	private int codeNum = 4;// 随机产生字符数量
	//
	private Random random = new Random();
	private String randomScope = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";// 随机范围

	public RandomValidateCode() {
		init();
	}

	/**
	 * 
	 * @param imgWidth
	 *            图片宽/像素
	 * @param imgHeight
	 *            图片高/像素
	 * @param lineSize
	 *            干扰线数量
	 * @param codeNum
	 *            随机产生字符数量
	 */
	public RandomValidateCode(int imgWidth, int imgHeight, int lineSize, int codeNum) {
		this.imgWidth = imgWidth;
		this.imgHeight = imgHeight;
		this.lineSize = lineSize;
		this.codeNum = codeNum;
		init();
	}

	// 初始化
	private void init() {
		// BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
		validateCodeImg = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_BGR);
		Graphics graphics = validateCodeImg.getGraphics();// 产生Image对象的Graphics对象,该对象可以在图像上进行各种绘制操作
		graphics.fillRect(0, 0, imgWidth, imgHeight);
		graphics.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
		graphics.setColor(getRandColor(110, 133));
		// 绘制干扰线
		for (int i = 0; i <= lineSize; i++) {
			drowLine(graphics);
		}
		// 绘制随机字符
		validateCode = "";
		int beginX = random.nextInt(imgWidth - 17 * codeNum);
		for (int i = 0; i < codeNum; i++) {
			validateCode += drowChar(graphics, i, beginX);
		}
		graphics.dispose();
	}

	public BufferedImage getValidateCodeImg() {
		return validateCodeImg;
	}

	public String getValidateCode() {
		return validateCode;
	}

	/*
	 * 获得字体
	 */
	private Font getFont() {
		return new Font("Fixedsys", Font.CENTER_BASELINE, 22);
	}

	/*
	 * 获得颜色
	 */
	private Color getRandColor(int fc, int bc) {
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc - 16);
		int g = fc + random.nextInt(bc - fc - 14);
		int b = fc + random.nextInt(bc - fc - 18);
		return new Color(r, g, b);
	}

	/**
	 * 绘制字符
	 */
	private char drowChar(Graphics g, int i, int beginX) {
		char rand = getRandomChar();
		//
		g.setFont(getFont());
		g.setColor(new Color(random.nextInt(101), random.nextInt(121), random.nextInt(141)));
		g.translate(random.nextInt(3), random.nextInt(3));
		g.drawString(String.valueOf(rand), beginX + 15 * i, 15 + random.nextInt(10));
		return rand;
	}

	/**
	 * 绘制干扰线
	 */
	private void drowLine(Graphics g) {
		int x = random.nextInt(imgWidth);
		int y = random.nextInt(imgHeight);
		int xl = random.nextInt(13);
		int yl = random.nextInt(15);
		g.drawLine(x, y, x + xl, y + yl);
	}

	/**
	 * 获取随机的字符
	 */
	private char getRandomChar() {
		int num = random.nextInt(randomScope.length());
		return randomScope.charAt(num);
	}

}