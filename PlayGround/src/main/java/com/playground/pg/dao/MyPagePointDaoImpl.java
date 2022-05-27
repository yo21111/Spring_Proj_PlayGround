package com.playground.pg.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.playground.pg.domain.PointDto;

@Repository
public class MyPagePointDaoImpl implements MyPagePointDao {
	@Autowired
	private SqlSession session;
	private static String namespace = "com.playground.pg.dao.MyPointMapper.";
	
	
	@Override
	public int getAllPoinitById(String id) throws Exception {
		return session.selectOne(namespace+"selectAllPoint", id);
	}

	@Override
	public List<PointDto> getPointList(String id) throws Exception {
		return session.selectList(namespace+"selectPointList", id);
	}

}
