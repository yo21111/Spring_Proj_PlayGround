package com.playground.pg.dao;

import com.playground.pg.domain.ReportDto;

public interface ReportDao {

	// 신고하기
	public int report(ReportDto reportDto) throws Exception;
	
}
