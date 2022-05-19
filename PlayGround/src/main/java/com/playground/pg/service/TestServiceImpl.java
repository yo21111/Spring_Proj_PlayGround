package com.playground.pg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playground.pg.dao.TestDao;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	TestDao testDao;
	
	@Override
	public String testMtd(String str) throws Exception {
		String testStr = testDao.testMtd(str);
		return testStr;
	}
	
}
