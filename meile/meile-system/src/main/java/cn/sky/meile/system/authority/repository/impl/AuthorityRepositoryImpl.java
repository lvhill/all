package cn.sky.meile.system.authority.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.sky.meile.system.authority.entity.SystemMember;
import cn.sky.meile.system.authority.repository.AuthorityRepository;

@Repository
public class AuthorityRepositoryImpl implements AuthorityRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public SystemMember getMemberByName(String name) {

		String hql = "from SystemMember where name='" + name + "'";

		Session sess = sessionFactory.openSession();
		List<?> list = sess.createQuery(hql).list();
		SystemMember systemMember = null;
		if (!list.isEmpty())
			systemMember = (SystemMember) list.get(0);
		sess.close();
		return systemMember;
	}

}
