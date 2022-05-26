package com.playground.pg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playground.pg.dao.ReportDao;
import com.playground.pg.domain.ReportDto;

@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
	ReportDao reportDao;
	
	@Override
	public boolean report(ReportDto reportDto) throws Exception {
		int result = reportDao.report(reportDto);
		return result == 1 ? true : false;
	}

}
