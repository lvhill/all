package cn.sky.test.service;

import cn.sky.test.entity.Test;

public interface TestService {

	public String query();

	public boolean delete(String id);

	public void save(Test test);
}
