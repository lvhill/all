package cn.sky.base.shop.test.controller;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import cn.sky.base.shop.test.dto.City;
import cn.sky.base.shop.test.dto.Schoole;
import cn.sky.base.shop.test.dto.User;
import cn.sky.base.shop.test.util.RandomValidateCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("测试接口")
@RestController
@RequestMapping("/test")
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	private Gson gson = new Gson();

	@ApiOperation("获取用户信息")
	@RequestMapping(value = "/user", method = { RequestMethod.POST, RequestMethod.GET })
	public User user() {
		User user = new User();
		user.setAge("21");
		user.setName("丁诗韵");
		return user;
	}

	@ApiOperation("获取城市信息")
	@RequestMapping(value = "/city", method = { RequestMethod.POST })
	public City city(@RequestBody Schoole schoole) {
		logger.info("接收参数: " + gson.toJson(schoole));
		return City.getCity();
	}

	@ApiOperation("测试")
	@RequestMapping(value = "/userJson", method = { RequestMethod.POST })
	public User test(@RequestBody User user) {
		logger.info("接收参数: " + gson.toJson(user));
		return user;
	}

	/**
	 * 获得验证码
	 */
	@RequestMapping(value = "/verifyCode", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody void verifyCode(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
		response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expire", 0);
		//
		RandomValidateCode validateCode = new RandomValidateCode();
		session.removeAttribute("RandomValidateCode");
		session.setAttribute("RandomValidateCode", validateCode.getValidateCode());
		try {
			ImageIO.write(validateCode.getValidateCodeImg(), "JPEG", response.getOutputStream());// 将内存中的图片通过流动形式输出到客户端
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
