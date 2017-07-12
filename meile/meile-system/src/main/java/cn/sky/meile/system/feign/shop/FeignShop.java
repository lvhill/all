package cn.sky.meile.system.feign.shop;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sky.framework.rest.RestMessage;
import cn.sky.meile.system.config.dto.ConfigDTO;

@FeignClient("meile-shop/meile-shop")
public interface FeignShop {

	/**
	 * 查询主题
	 * 
	 * @return
	 */
	@RequestMapping(value = "/config/queryTheme", method = { RequestMethod.POST })
	public RestMessage<String> queryTheme();

	/**
	 * 更新主题
	 * 
	 * @param msg
	 */
	@RequestMapping(value = "/config/updateTheme", method = { RequestMethod.POST })
	public void updateTheme(@RequestBody RestMessage<String> msg);

	/**
	 * 查询配置
	 * 
	 * @return
	 */
	@RequestMapping(value = "/config/queryConfig", method = { RequestMethod.POST })
	public RestMessage<ConfigDTO> queryConfig();

	/**
	 * 更新 配置
	 * 
	 * @param inmsg
	 * @return
	 */
	@RequestMapping(value = "/config/updateConfig", method = { RequestMethod.POST })
	public RestMessage<String> updateConfig(@RequestBody RestMessage<ConfigDTO> inmsg);

}
