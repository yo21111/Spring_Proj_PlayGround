package com.playground.pg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playground.pg.dao.AdminReportDao;
import com.playground.pg.domain.ReportDto;
import com.playground.pg.domain.ReviewDto;

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
	public List<ReviewDto> selectReviewList() throws Exception {
		List<ReportDto> reportList = adminReportDao.selectReportList();
		List<ReviewDto> reviewList = new ArrayList<ReviewDto>();
		for (int i = 0; i < reportList.size(); i++) {
			ReportDto reportDto = reportList.get(i);
			int no = reportDto.getNo_FK();
			reviewList.add(adminReportDao.selectReviewList(no)); 
		}
		
		return reviewList;
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
