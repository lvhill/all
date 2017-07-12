package cn.sky.meile.shop.config.repository;

/**
 * 配置管理
 * 
 * @author gaofu
 *
 */
public interface ConfigRepository {

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
