package com.playground.pg.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.playground.pg.domain.ArtDto;

@Repository
public class HomeDaoImpl implements HomeDao {
	@Autowired
	private SqlSession session;
	private static String namespace = "com.playground.pg.dao.HomeMapper.";
	
	@Override
	public int gradeCheck(String id) throws Exception {
		return session.selectOne(namespace+"gradeCheck", id);
	}

	@Override
	public List<ArtDto> getArtList() throws Exception {
		return session.selectList(namespace+"selectArtList");
	}

}
