package cn.sky.verify.controller;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sky.framework.util.ServletUtil;
import cn.sky.verify.util.RandomValidateCode;

/**
 * 验证码
 * 
 * @author ligaofu
 *
 */
@Controller
@RequestMapping("/verify")
public class VerifyCode {

	private final static String ValidateCode = "VALIDATECODE";

	/**
	 * 获得验证码
	 */
	@RequestMapping(value = "/verifyCode", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody void verifyCode() {
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
			e.printStackTrace();
		}
	}

	/**
	 * 判断输入的验证码是否正确
	 */
	@RequestMapping(value = "/checkVerifyCode", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody void checkVerifyCode() {
		String pVerifyCode = ServletUtil.getRequest().getParameter("verifyCode");
		String sVerifyCode = (String) ServletUtil.getSession().getAttribute(ValidateCode);

		if (sVerifyCode.equalsIgnoreCase(pVerifyCode)) {
			try {
				ServletUtil.getResponse().getWriter().print("success:checkVerifyCode");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 校验验证码的静态方法
	 * 
	 * @param verifyCode
	 *            验证码
	 * @return
	 */
	public static boolean checkVerifyCode(String verifyCode) {
		String sVerifyCode = (String) ServletUtil.getSession().getAttribute(ValidateCode);
		if (sVerifyCode.equalsIgnoreCase(verifyCode)) {
			return true;
		} else {
			return false;
		}
	}
}
