package com.playground.pg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.playground.pg.dao.InquiryDao;
import com.playground.pg.domain.InquiryDto;

@Service
public class InquiryServiceImpl implements InquiryService {
	@Autowired
	InquiryDao inquiryDao;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean insertInq(InquiryDto inquiryDto) throws Exception {
		int result = inquiryDao.insertInq(inquiryDto);
		return result == 1 ? true : false;
	}

	@Override
	public List<InquiryDto> getInqList(String uId) throws Exception {
		List<InquiryDto> list = inquiryDao.getInqList(uId);
		return list;
	}

	@Override
	public InquiryDto getInq(int no) throws Exception {
		return inquiryDao.getInq(no);
	}

	
	/*******관리자 영역*******/
	
	@Override
	public int getInqCnt() throws Exception { 
		return inquiryDao.getInqCnt();
	}
	
	@Override
	public boolean deleteInq(int no) throws Exception {
		int result = inquiryDao.deleteInq(no);
		return result == 1 ? true : false;
	}

	@Override
	public List<InquiryDto> getAdminInqList() throws Exception {
		List<InquiryDto> list = inquiryDao.getAdminInqList();
		return list;
	}
	
	@Override
	public List<InquiryDto> getAdminInqListN() throws Exception {
		List<InquiryDto> list = inquiryDao.getAdminInqListN();
		return list;
	}
	
	@Override
	public List<InquiryDto> getAdminInqListF() throws Exception {
		List<InquiryDto> list = inquiryDao.getAdminInqListF();
		return list;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean updateReply(int no, String text) throws Exception {
		int result = inquiryDao.updateReply(no, text);
		return result == 1 ? true : false;
	}

}
