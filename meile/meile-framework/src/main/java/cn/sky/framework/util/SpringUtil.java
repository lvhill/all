package cn.sky.framework.util;

import org.springframework.context.ApplicationContext;

import cn.sky.framework.spring.SpringContextHolder;

public class SpringUtil {

	public static ApplicationContext getApplicationContext() {
		return SpringContextHolder.getApplicationContext();
	}

	public synchronized static Object getBean(String name) {
		return SpringContextHolder.getBean(name);
	}

	public synchronized static <T> T getBean(String name, Class<T> clazz) {
		return SpringContextHolder.getBean(name, clazz);
	}

	public synchronized static <T> T getBean(Class<T> clazz) {
		return SpringContextHolder.getBean(clazz);
	}

}
