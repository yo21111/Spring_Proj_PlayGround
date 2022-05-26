package com.playground.pg.service;

import java.util.List;

import com.playground.pg.domain.ReportDto;
import com.playground.pg.domain.ReviewDto;

public interface AdminService_report {

	
	// 신고글 리스트 가져오기
	public List<ReportDto> selectReportList() throws Exception;
	
	// 신고글 리뷰 리스트 가져오기
	public List<ReviewDto> selectReviewList() throws Exception;
	
	// 신고글 삭제하기
	public boolean deleteReport(int reportList) throws Exception;
	
	// 신고당한 리뷰글 삭제하기
	public boolean deleteReview(int reportList) throws Exception;
	
	
	
}
