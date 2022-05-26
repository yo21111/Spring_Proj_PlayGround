package com.playground.pg.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.playground.pg.domain.ReportDto;
import com.playground.pg.domain.ReviewDto;

@Repository
public class AdminReportDaoImpl implements AdminReportDao {
	@Autowired
	private SqlSession session;
	private static String namespace = "com.playground.pg.dao.AdminReportMapper.";
	
	
	@Override
	public List<ReportDto> selectReportList() throws Exception {
		return session.selectList(namespace + "selectReportList");
	}
	
	@Override
	public ReviewDto selectReviewList(int no) throws Exception {
		return session.selectOne(namespace + "selectReviewList", no);
	}

	@Override
	public int deleteReport(int reportList) throws Exception {
		return session.delete(namespace + "deleteReport", reportList);
	}
	
	@Override
	public int selectReview(int reportList) throws Exception {
		return session.selectOne(namespace + "selectReview", reportList);
	}

	@Override
	public int deleteReview(int reviewNo) throws Exception {
		return session.delete(namespace + "deleteReview", reviewNo);
	}

}
