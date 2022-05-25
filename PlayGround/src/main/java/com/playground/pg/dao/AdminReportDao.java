package com.playground.pg.dao;

import java.util.List;

import com.playground.pg.domain.ReportDto;

public interface AdminReportDao {

	// 신고글 목록 가져오기
	public List<ReportDto> selectReportList() throws Exception;
	
	// 신고글 삭제하기
	public int deleteReport(int reportList) throws Exception;
	
	// 리뷰글 번호 조회하기
	public int selectReview(int reportList) throws Exception;
	
	// 리뷰글 삭제하기
	public int deleteReview(int reportList) throws Exception;
	
}
