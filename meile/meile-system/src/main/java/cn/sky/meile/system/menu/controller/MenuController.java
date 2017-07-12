package cn.sky.meile.system.menu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.sky.framework.rest.RestMessage;
import cn.sky.framework.util.ServletUtil;
import cn.sky.meile.system.authority.vo.AuthorityItem;
import cn.sky.meile.system.menu.entity.SystemMenu;
import cn.sky.meile.system.menu.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;

	@RequestMapping(value = "/queryMenus", method = { RequestMethod.POST, RequestMethod.GET })
	public RestMessage<List<SystemMenu>> queryMenus() {
		RestMessage<List<SystemMenu>> responseDto = new RestMessage<List<SystemMenu>>();
		HttpSession httpSession = ServletUtil.getSession();
		String userName = (String) httpSession.getAttribute(AuthorityItem.loginUserName);
		if (userName == null || userName.length() == 00) {
			return responseDto;
		}
		responseDto.setSuccess(true);
		List<SystemMenu> list = menuService.queryMenus();
		responseDto.setEntity(list);
		return responseDto;
	}
}
