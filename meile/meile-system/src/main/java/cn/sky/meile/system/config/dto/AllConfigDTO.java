package cn.sky.meile.system.config.dto;

import java.util.List;

public class AllConfigDTO {
	private String shopTheme;
	private List<String> shopThemeList;

	private String systemTheme;
	private List<String> systemThemeList;

	public String getShopTheme() {
		return shopTheme;
	}

	public void setShopTheme(String shopTheme) {
		this.shopTheme = shopTheme;
	}

	public List<String> getShopThemeList() {
		return shopThemeList;
	}

	public void setShopThemeList(List<String> shopThemeList) {
		this.shopThemeList = shopThemeList;
	}

	public String getSystemTheme() {
		return systemTheme;
	}

	public void setSystemTheme(String systemTheme) {
		this.systemTheme = systemTheme;
	}

	public List<String> getSystemThemeList() {
		return systemThemeList;
	}

	public void setSystemThemeList(List<String> systemThemeList) {
		this.systemThemeList = systemThemeList;
	}

}
