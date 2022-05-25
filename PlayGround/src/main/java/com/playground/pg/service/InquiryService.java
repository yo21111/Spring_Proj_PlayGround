package com.playground.pg.service;

import com.playground.pg.domain.InquiryDto;

public interface InquiryService {
	
	// 문의 내용(빈) 받아서 테이블에 추가
	public boolean insertInq(InquiryDto inquiryDto) throws Exception;
	
	
}
