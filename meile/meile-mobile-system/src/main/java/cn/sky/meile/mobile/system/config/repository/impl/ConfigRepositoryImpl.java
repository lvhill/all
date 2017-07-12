package cn.sky.meile.mobile.system.config.repository.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import cn.sky.framework.cache.CacheUtil;
import cn.sky.meile.mobile.system.config.entity.ConfigEntity;
import cn.sky.meile.mobile.system.config.repository.ConfigRepository;

/**
 * 配置管理实现
 * 
 * @author gaofu
 * @see ConfigRepository
 */
@Repository
public class ConfigRepositoryImpl implements ConfigRepository {
	private final static Logger logger = LoggerFactory.getLogger(ConfigRepositoryImpl.class);

	private SessionFactory sessionFactory;

	private StringRedisTemplate stringRedisTemplate;

	public ConfigRepositoryImpl(@Autowired SessionFactory sessionFactory,
			@Autowired StringRedisTemplate stringRedisTemplate) {
		this.sessionFactory = sessionFactory;
		this.stringRedisTemplate = stringRedisTemplate;
		String themeKey = "theme";
		Session sess = sessionFactory.openSession();
		Query query = sess.createQuery("from ConfigEntity where key=:key");
		query.setParameter("key", themeKey);
		ConfigEntity config = (ConfigEntity) query.uniqueResult();
		if (config != null) {
			String theme = config.getValue();
			stringRedisTemplate.opsForValue().set(CacheUtil.addPrefix(themeKey), theme);
		}
	}

	@Override
	public String queryTheme() {
		String themeKey = "theme";
		String theme = stringRedisTemplate.boundValueOps(CacheUtil.addPrefix(themeKey)).get();
		if (theme == null || theme.length() == 0) {
			Session sess = sessionFactory.openSession();
			Query query = sess.createQuery("from ConfigEntity where key=:key");
			query.setParameter("key", themeKey);
			ConfigEntity config = (ConfigEntity) query.uniqueResult();
			if (config != null) {
				theme = config.getValue();
			} else {
				logger.error("数据库查询主题为空, 设置默认值default");
				theme = "default";
			}
			// 更新redis
			stringRedisTemplate.opsForValue().set(CacheUtil.addPrefix(themeKey), theme);
		}
		return theme;
	}

	@Override
	public void updateTheme(String theme) {
		// 更新redis
		String themeKey = "theme";
		stringRedisTemplate.opsForValue().set(CacheUtil.addPrefix(themeKey), theme);
		// 更新数据库
		ConfigEntity entity = new ConfigEntity();
		entity.setKey(themeKey);
		entity.setValue(theme);
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.saveOrUpdate(entity);
		tx.commit();
		sess.close();
	}

}
