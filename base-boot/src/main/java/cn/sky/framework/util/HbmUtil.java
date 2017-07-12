package cn.sky.framework.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HbmUtil {

	public static Session openSession() {
		SessionFactory sessionFactory = SpringUtil.getBean("sessionFactory",
				SessionFactory.class);
		return sessionFactory.openSession();
	}
}
