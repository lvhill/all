package cn.sky.meile.mobile.shop.verify.controller;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.sky.framework.util.RandomValidateCode;
import cn.sky.framework.util.ServletUtil;

/**
 * 验证码
 * 
 * @author ligaofu
 *
 */
@RestController
@RequestMapping("/verify")
public class VerifyCodeController {
	private final static Logger logger = LoggerFactory.getLogger(VerifyCodeController.class);

	private final static String ValidateCode = "VALIDATECODE";

	/**
	 * 获得验证码
	 */
	@RequestMapping(value = "/verifyCode", method = { RequestMethod.GET, RequestMethod.POST })
	public void verifyCode() {
		HttpServletResponse response = ServletUtil.getResponse();
		HttpServletRequest request = ServletUtil.getRequest();
		HttpSession session = request.getSession();

		response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
		response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expire", 0);
		//
		RandomValidateCode validateCode = new RandomValidateCode();
		session.removeAttribute(ValidateCode);
		session.setAttribute(ValidateCode, validateCode.getValidateCode());
		try {
			ImageIO.write(validateCode.getValidateCodeImg(), "JPEG", response.getOutputStream());// 将内存中的图片通过流动形式输出到客户端
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * 判断输入的验证码是否正确
	 */
	@RequestMapping(value = "/checkVerifyCode", method = { RequestMethod.GET, RequestMethod.POST })
	public boolean checkVerifyCode() {
		String pVerifyCode = ServletUtil.getRequest().getParameter("verifyCode");
		String sVerifyCode = (String) ServletUtil.getSession().getAttribute(ValidateCode);

		if (sVerifyCode.equalsIgnoreCase(pVerifyCode)) {
			return true;
		}
		return false;
	}

	/**
	 * 校验验证码的静态方法
	 * 
	 * @param verifyCode
	 *            验证码
	 * @return
	 */
	public static boolean checkVerifyCode(String verifyCode) {
		if (verifyCode == null) {
			return false;
		}
		HttpServletRequest request = ServletUtil.getRequest();
		HttpSession session = request.getSession();
		String sVerifyCode = (String) session.getAttribute(ValidateCode);
		if (verifyCode.equalsIgnoreCase(sVerifyCode)) {
			return true;
		} else {
			return false;
		}
	}

}
