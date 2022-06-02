package com.playground.pg.dao;

import java.sql.Date;
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
		Integer result = session.selectOne(namespace+"selectAllPoint", id);
		return result == null ? 0 : result;
	}

	@Override
	public List<PointDto> getPointList(String id) throws Exception {
		return session.selectList(namespace+"selectPointList", id);
	}

	@Override
	public List<Date> getDayList(String id_FK) throws Exception {
		return session.selectList(namespace + "selectDayList", id_FK);
	}
	
	

}
