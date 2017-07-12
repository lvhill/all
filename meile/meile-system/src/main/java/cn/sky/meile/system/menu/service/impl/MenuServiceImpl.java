package cn.sky.meile.system.menu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sky.meile.system.menu.entity.SystemMenu;
import cn.sky.meile.system.menu.repository.MenuRepository;
import cn.sky.meile.system.menu.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepository;

	@Override
	public List<SystemMenu> queryMenus() {
		return menuRepository.queryMenus();
	}

}
