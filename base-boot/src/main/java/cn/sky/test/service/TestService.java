package cn.sky.test.service;

import java.util.List;

import cn.sky.test.entity.Test;

public interface TestService {

	public List<Test> query();

	public boolean delete(String id);

	public void save(Test test);
}
