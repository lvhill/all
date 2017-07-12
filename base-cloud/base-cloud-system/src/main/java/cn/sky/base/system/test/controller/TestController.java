package cn.sky.base.system.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.sky.base.system.test.dto.City;
import cn.sky.base.system.test.dto.Schoole;
import cn.sky.base.system.test.dto.User;
import cn.sky.base.system.test.feign.FeignShop;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("测试接口")
@RestController
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	private FeignShop feignShop;

	@ApiOperation("获取用户信息")
	@RequestMapping(value = "/user", method = { RequestMethod.POST, RequestMethod.GET })
	public User user() {
		User user = null;
		logger.info("start!");
		user = feignShop.user();
		logger.info("end!");
		return user;
	}

	@ApiOperation("获取城市信息")
	@RequestMapping(value = "/city", method = { RequestMethod.POST, RequestMethod.GET })
	public City city() {
		City city = null;
		logger.info("start!");
		city = feignShop.city(Schoole.getSchoole());
		logger.info("end!");
		return city;
	}

}
