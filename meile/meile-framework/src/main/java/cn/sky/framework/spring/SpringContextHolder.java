package cn.sky.framework.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class SpringContextHolder implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextHolder.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public synchronized static Object getBean(String name) {
		return applicationContext.getBean(name);
	}

	public synchronized static <T> T getBean(String name, Class<T> clazz) {
		return applicationContext.getBean(name, clazz);
	}

	public synchronized static <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}
}