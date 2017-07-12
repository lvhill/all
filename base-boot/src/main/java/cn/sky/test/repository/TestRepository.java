package cn.sky.test.repository;

import java.util.List;

import cn.sky.test.entity.Test;

public interface TestRepository {

	public List<Test> query();

	public boolean delete(String id);

	public void save(Test test);
}
