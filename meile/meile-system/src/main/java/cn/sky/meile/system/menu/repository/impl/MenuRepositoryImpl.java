package cn.sky.meile.system.menu.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.sky.meile.system.menu.entity.SystemMenu;
import cn.sky.meile.system.menu.repository.MenuRepository;

@Repository
public class MenuRepositoryImpl implements MenuRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<SystemMenu> getChildMenus(String parentMenuID) {
		long parentMenuId = stringToLong(parentMenuID);
		if (parentMenuId == -1)
			return null;

		String hql = "from SystemMenu where parentMenuId=:parentMenuId";
		Session sess = sessionFactory.openSession();
		Query query = sess.createQuery(hql);
		query.setLong("parentMenuId", parentMenuId);

		@SuppressWarnings("unchecked")
		List<SystemMenu> list = query.list();
		sess.close();
		return list;
	}

	@Override
	public List<SystemMenu> getHeadMenus() {

		String hql = "from SystemMenu where parentMenuId in (select menuid from SystemMenu where parentMenuId = 0)";
		Session sess = sessionFactory.openSession();
		Query query = sess.createQuery(hql);

		@SuppressWarnings("unchecked")
		List<SystemMenu> list = query.list();
		sess.close();
		return list;
	}

	/**
	 * string转换为long
	 * 
	 * @param slong
	 * @return
	 */
	private long stringToLong(String slong) {
		long i = (long) 0;
		try {
			i = Long.parseLong(slong);
		} catch (Exception ex) {
			return -1;
		}
		return i;
	}

	@Override
	public List<SystemMenu> queryMenus() {
		String hql = "from SystemMenu";
		Session sess = sessionFactory.openSession();
		Query query = sess.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<SystemMenu> list = query.list();
		sess.close();
		return list;
	}

}
