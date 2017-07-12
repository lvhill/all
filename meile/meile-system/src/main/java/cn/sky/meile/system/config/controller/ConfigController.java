package cn.sky.meile.system.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.sky.framework.rest.RestMessage;
import cn.sky.framework.util.ThemeUtil;
import cn.sky.meile.system.config.dto.AllConfigDTO;
import cn.sky.meile.system.config.dto.ConfigDTO;
import cn.sky.meile.system.config.service.ConfigService;
import cn.sky.meile.system.feign.shop.FeignShop;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("配置")
@RestController
@RequestMapping("/config")
public class ConfigController {

	@Autowired
	private ConfigService configService;

	@Autowired
	private FeignShop feignShop;

	@ApiOperation("查询主题")
	@RequestMapping(value = "/queryTheme", method = { RequestMethod.POST })
	public RestMessage<String> queryTheme() {
		RestMessage<String> outmsg = new RestMessage<String>();
		String theme = configService.queryTheme();
		outmsg.setEntity(theme);
		outmsg.setSuccess(true);
		return outmsg;
	}

	@ApiOperation("更新主题")
	@RequestMapping(value = "/updateTheme", method = { RequestMethod.POST })
	public RestMessage<String> updateTheme(@RequestBody RestMessage<String> inmsg) {
		RestMessage<String> outmsg = new RestMessage<String>();
		String theme = inmsg.getEntity();
		if (theme != null) {
			List<String> themeList = ThemeUtil.getThemefoldersName();
			if (themeList.contains(theme)) {
				configService.updateTheme(theme);
			} else {
				outmsg.setFaultstring(theme + "主题不存在");
				return outmsg;
			}
		} else {
			outmsg.setFaultstring(theme + "主题不存在");
			return outmsg;
		}
		outmsg.setSuccess(true);
		return outmsg;
	}

	@ApiOperation(value = "查询配置")
	@RequestMapping(value = "/queryConfig", method = { RequestMethod.POST })
	public RestMessage<ConfigDTO> queryConfig() {
		RestMessage<ConfigDTO> outmsg = new RestMessage<ConfigDTO>();
		ConfigDTO configDTO = new ConfigDTO();
		String theme = configService.queryTheme();
		configDTO.setTheme(theme);
		List<String> themeList = ThemeUtil.getThemefoldersName();
		configDTO.setThemeList(themeList);
		outmsg.setEntity(configDTO);
		outmsg.setSuccess(true);
		return outmsg;
	}

	@ApiOperation("更新配置")
	@RequestMapping(value = "/updateConfig", method = { RequestMethod.POST })
	public RestMessage<String> updateConfig(@RequestBody RestMessage<ConfigDTO> inmsg) {
		RestMessage<String> outmsg = new RestMessage<String>();
		String theme = inmsg.getEntity().getTheme();
		if (theme != null) {
			List<String> themeList = ThemeUtil.getThemefoldersName();
			if (themeList.contains(theme)) {
				configService.updateTheme(theme);
			} else {
				outmsg.setFaultstring(theme + "主题不存在");
				return outmsg;
			}
		}
		outmsg.setSuccess(true);
		return outmsg;
	}

	@ApiOperation(value = "查询全部配置")
	@RequestMapping(value = "/queryAllConfig", method = { RequestMethod.POST })
	public RestMessage<AllConfigDTO> queryAllConfig() {
		RestMessage<AllConfigDTO> outmsg = new RestMessage<AllConfigDTO>();
		AllConfigDTO allConfigDTO = new AllConfigDTO();
		//
		String systemTheme = configService.queryTheme();
		allConfigDTO.setSystemTheme(systemTheme);
		List<String> sytemThemeList = ThemeUtil.getThemefoldersName();
		allConfigDTO.setSystemThemeList(sytemThemeList);
		//
		ConfigDTO shopConfigDTO = feignShop.queryConfig().getEntity();
		if (shopConfigDTO != null) {
			allConfigDTO.setShopTheme(shopConfigDTO.getTheme());
			allConfigDTO.setShopThemeList(shopConfigDTO.getThemeList());
		}
		//
		outmsg.setEntity(allConfigDTO);
		outmsg.setSuccess(true);
		return outmsg;
	}

	@ApiOperation("更新全部配置")
	@RequestMapping(value = "/updateAllConfig", method = { RequestMethod.POST })
	public RestMessage<String> updateAllConfig(@RequestBody RestMessage<AllConfigDTO> inmsg) {
		RestMessage<String> outmsg = new RestMessage<String>();
		String shopTheme = inmsg.getEntity().getShopTheme();
		if (shopTheme != null) {
			RestMessage<ConfigDTO> shopConfigDTO = new RestMessage<ConfigDTO>();
			ConfigDTO shopConfig = new ConfigDTO();
			shopConfig.setTheme(shopTheme);
			shopConfigDTO.setEntity(shopConfig);
			RestMessage<String> msg = feignShop.updateConfig(shopConfigDTO);
			if (!msg.isSuccess()) {
				outmsg.setFaultstring(msg.getFaultstring());
				return outmsg;
			}
		}

		String systemTheme = inmsg.getEntity().getSystemTheme();
		if (systemTheme != null) {
			List<String> systemThemeList = ThemeUtil.getThemefoldersName();
			if (systemThemeList.contains(systemTheme)) {
				configService.updateTheme(systemTheme);
			} else {
				outmsg.setFaultstring(systemTheme + "主题不存在");
				return outmsg;
			}
		}

		outmsg.setSuccess(true);
		return outmsg;
	}

}
