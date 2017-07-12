package cn.sky.framework.cache;

import cn.sky.framework.util.property.BaseProperties;

public class CacheUtil {
	public final static String cachePrefix = BaseProperties.load("static.properties").getProperty("cache.prefix");

	/**
	 * 添加缓存前缀
	 * 
	 * @param key
	 * @return
	 */
	public static String addPrefix(String key) {
		return cachePrefix + key;
	}

}
