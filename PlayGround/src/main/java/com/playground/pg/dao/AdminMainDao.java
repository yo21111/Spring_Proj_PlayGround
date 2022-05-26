package com.playground.pg.dao;

import java.util.List;

import com.playground.pg.domain.InquiryDto;
import com.playground.pg.domain.ReportDto;
import com.playground.pg.domain.ReserveDto;

public interface AdminMainDao {
	// 요일별 예매현황 최근 5일에 대해 일일 단위 select
	//1. exNo에 따른 allowNum
	public int getAllowNum(int exNo) throws Exception;
	
	
	//2. 오늘부터 -5일까지의 정보 -> order by reDate DESC
	//2-1. 예매현황 adCnt의 합계와 chCnt의 합계 // 일일단위
	//2-2. 예매현황 payment의 합계 // 일일단위
	//2-3. 일일단위의 reDate 값
	public List<ReserveDto> showReserveList() throws Exception;
	
	// 리뷰 신고 최근 일부 리스트 select하기
	// List(ReportDto) 를 limit 10, order by reportNo DESC
	public List<ReportDto> showReportList() throws Exception;
	
	
	// 리뷰 신고 미처리된 건수(총 갯수) select 하기	
	public int getReportCnt() throws Exception;
	
	
	// 문의 최근 일부 리스트 select하기	
	//List<InquiryDto> 를 limit 10, order by no DESC
	public List<InquiryDto> showInquireList() throws Exception;
	
	
	// 문의 미처리된 건수(총 갯수) select 하기
	public int getInquireCnt() throws Exception;
}
