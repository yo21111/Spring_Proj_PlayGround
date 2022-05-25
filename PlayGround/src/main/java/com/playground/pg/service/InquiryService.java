package com.playground.pg.service;

import java.util.List;

import com.playground.pg.domain.InquiryDto;

public interface InquiryService {
	
	// 문의 내용(빈) 받아서 테이블에 추가
	public boolean insertInq(InquiryDto inquiryDto) throws Exception;

	// 해당 아이디의 문의내역리스트 가져오기
	public List<InquiryDto> getInqList(String uId) throws Exception;

	// 문의 게시글 번호로 해당 게시글 내용(빈) 가져오기
	public InquiryDto getInq(int no) throws Exception;


	
	
	
	/********관리자 영역 서비스************/
	
	// 처리 해야 할 문의 건수 가져오기
	public int getInqCnt() throws Exception;

	// 문의 게시글 번호로 해당 게시글 삭제
	public boolean deleteInq(int no) throws Exception;

	// 문의 게시글 리스트 가져오기
	public List<InquiryDto> getAdminInqList() throws Exception;

	public boolean updateReply(int no, String text) throws Exception;
	
	
	
}
