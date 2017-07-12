package cn.sky.test.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.sky.test.entity.Test;
import cn.sky.test.repository.TestRepository;

@Repository
public class TestRepositoryImpl implements TestRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Test> query() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Test");
		@SuppressWarnings("unchecked")
		List<Test> list = (List<Test>) query.list();
		//
		session.close();
		return list;
	}

	public boolean delete(String id) {
		String hql = "delete Test as p where p.id=" + id;
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery(hql);
		int i = query.executeUpdate();
		tr.commit();
		session.close();
		if (i == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void save(Test test) {
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();// 开始事物
		session.save(test);// 执行
		tran.commit();// 提交
		session.close();
	}

}
