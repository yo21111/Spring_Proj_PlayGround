package com.playground.pg.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.playground.pg.domain.InquiryDto;
import com.playground.pg.domain.ReportDto;
import com.playground.pg.domain.ReserveDto;

@Repository
public class AdminMainDaoImpl implements AdminMainDao {
	@Autowired
	private SqlSession session;
	private static String namespace = "com.playground.pg.dao.AdminMainMapper.";
	
	@Override
	public int getAllowNum(int exNo) throws Exception {
		return session.selectOne(namespace+"getAllowNum", exNo);
	}

	@Override
	public List<ReserveDto> showReserveList() throws Exception {
		return session.selectList(namespace+"selectReserveList");
	}

	@Override
	public List<ReportDto> showReportList() throws Exception {
		return session.selectList(namespace+"selectReportList");
	}

	@Override
	public int getReportCnt() throws Exception {
		return session.selectOne(namespace+"selectReportCnt");
	}

	@Override
	public List<InquiryDto> showInquireList() throws Exception {
		return session.selectList(namespace+"selectInquiryList");
	}

	@Override
	public int getInquireCnt() throws Exception {
		return session.selectOne(namespace+"selectInquiryCnt");
	}

}
