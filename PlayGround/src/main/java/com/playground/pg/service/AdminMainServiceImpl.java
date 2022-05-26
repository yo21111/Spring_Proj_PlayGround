package com.playground.pg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playground.pg.dao.AdminMainDao;
import com.playground.pg.domain.InquiryDto;
import com.playground.pg.domain.ReportDto;
import com.playground.pg.domain.ReserveDto;

@Service
public class AdminMainServiceImpl implements AdminMainService {
	@Autowired
	AdminMainDao amDao;

	@Override
	public List<ReserveDto> showReserveList() throws Exception {
		List<ReserveDto> reserveList = amDao.showReserveList();
		for (int i = 0; i < reserveList.size(); i++) {
			int exNo = reserveList.get(i).getExNo();
			int allowNum = amDao.getAllowNum(exNo);
			reserveList.get(i).setAllowNum(allowNum);
		}
		return reserveList;
	}

	@Override
	public List<ReportDto> showReportList() throws Exception {
		return amDao.showReportList();
	}

	@Override
	public int getReportCnt() throws Exception {
		return amDao.getReportCnt();
	}

	@Override
	public List<InquiryDto> showInquireList() throws Exception {
		return amDao.showInquireList();
	}

	@Override
	public int getInquireCnt() throws Exception {
		return amDao.getInquireCnt();
	}

}
