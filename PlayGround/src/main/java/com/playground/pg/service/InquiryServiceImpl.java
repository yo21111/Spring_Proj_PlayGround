package com.playground.pg.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.playground.pg.domain.InquiryDto;

@Service
public class InquiryServiceImpl implements InquiryService {

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean insertInq(InquiryDto inquiryDto) throws Exception {
		return false;
	}

	@Override
	public List<InquiryDto> getInqList(String uId) throws Exception {
		return null;
	}

	@Override
	public InquiryDto getInq(int no) throws Exception {
		return null;
	}

	@Override
	public boolean deleteInq(int no) throws Exception {
		return false;
	}

	@Override
	public List<InquiryDto> getAdminInqList() throws Exception {
		return null;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean updateReply(int no, String text) throws Exception {
		return false;
	}

}
