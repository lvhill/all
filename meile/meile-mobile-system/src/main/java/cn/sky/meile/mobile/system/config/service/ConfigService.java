package cn.sky.meile.mobile.system.config.service;

public interface ConfigService {

	/**
	 * 查询主题
	 * 
	 * @return
	 */
	public String queryTheme();

	/**
	 * 更新主题
	 * 
	 * @param theme
	 */
	public void updateTheme(String theme);

}
