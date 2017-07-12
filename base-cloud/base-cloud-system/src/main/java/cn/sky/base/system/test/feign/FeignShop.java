package cn.sky.base.system.test.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sky.base.system.test.dto.City;
import cn.sky.base.system.test.dto.Schoole;
import cn.sky.base.system.test.dto.User;

@FeignClient("base-cloud-shop/base-cloud-shop")
public interface FeignShop {

	@RequestMapping(value = "/test/user", method = RequestMethod.POST)
	public User user();

	@RequestMapping(value = "/test/city", method = RequestMethod.POST)
	public City city(@RequestBody Schoole schoole);

}
