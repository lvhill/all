package cn.sky.meile.mobile.shop.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.sky.framework.rest.RestMessage;
import cn.sky.framework.util.ThemeUtil;
import cn.sky.meile.mobile.shop.config.dto.ConfigDTO;
import cn.sky.meile.mobile.shop.config.service.ConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("配置")
@RestController
@RequestMapping("/config")
public class ConfigController {

	@Autowired
	private ConfigService configService;

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

}
