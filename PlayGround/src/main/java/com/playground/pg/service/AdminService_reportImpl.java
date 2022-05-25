package com.playground.pg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playground.pg.dao.AdminReportDao;
import com.playground.pg.domain.ReportDto;

@Service
public class AdminService_reportImpl implements AdminService_report {
	@Autowired
	AdminReportDao adminReportDao;

	@Override
	public List<ReportDto> selectReportList() throws Exception {
		List<ReportDto> list = adminReportDao.selectReportList();
		return list;
	}

	@Override
	public boolean deleteReport(int reportList) throws Exception {
		int result = adminReportDao.deleteReport(reportList);
		return result == 1 ? true : false;
	}

	@Override
	public boolean deleteReview(int reportList) throws Exception {
		int reviewNo = adminReportDao.selectReview(reportList);
		int result = adminReportDao.deleteReview(reviewNo);
		return result == 1 ? true : false;
	}

}
