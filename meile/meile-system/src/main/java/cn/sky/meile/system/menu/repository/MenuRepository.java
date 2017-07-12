package cn.sky.meile.system.menu.repository;

import java.util.List;

import cn.sky.meile.system.menu.entity.SystemMenu;

public interface MenuRepository {

	/**
	 * 根据父菜单id查询子菜单
	 * 
	 * @param parentMenuID
	 * @return
	 */
	public List<SystemMenu> getChildMenus(String parentMenuID);

	/**
	 * 查询后台头部菜单
	 * 
	 * @return
	 */
	public List<SystemMenu> getHeadMenus();

	/**
	 * 查询后台所有的菜单
	 * 
	 * @return
	 */
	public List<SystemMenu> queryMenus();

}
