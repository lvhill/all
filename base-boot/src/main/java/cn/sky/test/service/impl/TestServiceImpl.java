package cn.sky.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sky.test.entity.Test;
import cn.sky.test.repository.TestRepository;
import cn.sky.test.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestRepository testRepository;

	@Override
	public List<Test> query() {
		List<Test> list = testRepository.query();
		return list;
	}

	public boolean delete(String id) {
		return testRepository.delete(id);
	}

	@Override
	public void save(Test test) {
		testRepository.save(test);
	}

}
