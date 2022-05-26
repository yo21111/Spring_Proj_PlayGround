package com.playground.pg.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.playground.pg.domain.ReportDto;

@Repository
public class ReportDaoImpl implements ReportDao {
	@Autowired
	private SqlSession session;
	private static String namespace = "com.playground.pg.dao.ReportMapper.";
	
	@Override
	public int report(ReportDto reportDto) throws Exception {
		return session.insert(namespace + "insertReport", reportDto);
	}

}
