package com.playground.pg.service;

import com.playground.pg.domain.ReportDto;

public interface ReportService {

	// 신고하기
	public boolean report(ReportDto reportDto) throws Exception;
	
}
