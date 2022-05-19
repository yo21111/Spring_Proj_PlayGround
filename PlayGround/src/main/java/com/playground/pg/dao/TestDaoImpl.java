package com.playground.pg.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDaoImpl implements TestDao {
	
	@Autowired
	private SqlSession session;
	private static String namespace = "com.playground.pg.dao.TestMapper";
	
	@Override
	public String testMtd(String testStr) throws Exception {
		return session.selectOne(namespace + "select", testStr);
	}
}
