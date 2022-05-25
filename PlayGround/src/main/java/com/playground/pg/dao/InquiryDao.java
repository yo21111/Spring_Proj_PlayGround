package com.playground.pg.dao;

import java.util.List;

import com.playground.pg.domain.InquiryDto;

public interface InquiryDao {
	
	// 문의내용 테이블에 추가
	public int insertInq(InquiryDto inquiryDto) throws Exception;
	
	// 나의 문의내역 목록 가져오기
	public List<InquiryDto> getInqList(String uId) throws Exception;
	
	// 상세 문의내용 가져오기
	public InquiryDto getInq(int no) throws Exception;
	
	/**********관리자 영역***********/
	
	// 처리해야 할 문의 내역 수 가져오기
	public int getInqCnt() throws Exception;
	
	// 문의내역 삭제하기
	public int deleteInq(int no) throws Exception;
	
	// 문의내역 목록(전체) 가져오기
	public List<InquiryDto> getAdminInqList() throws Exception;
	
	// 문의내역 목록(처리예정) 가져오기
	public List<InquiryDto> getAdminInqListN() throws Exception;
	
	// 문의내역 목록(처리완료) 가져오기
	public List<InquiryDto> getAdminInqListF() throws Exception;
	
	// 답변내용 추가하기
	public int updateReply(int no, String text) throws Exception;
		
}
