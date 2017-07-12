package cn.sky.meile.system.menu.service;

import java.util.List;

import cn.sky.meile.system.menu.entity.SystemMenu;

public interface MenuService {

	/**
	 * 查询后台所有的菜单
	 * 
	 * @return
	 */
	public List<SystemMenu> queryMenus();

}
