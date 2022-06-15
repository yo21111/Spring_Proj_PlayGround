package com.playground.pg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playground.pg.dao.FaqDao;
import com.playground.pg.domain.FaqDto;
import com.playground.pg.domain.SearchCondition;

@Service
public class FaqServiceImpl implements FaqService {
	@Autowired
	FaqDao faqDao;
	
	@Override
	public int getTotalCnt() throws Exception {
		return faqDao.selectTotalCnt();
	}
	
	
	@Override
	public boolean adminChk(String id) throws Exception {
		boolean result = false;
		String grade = faqDao.adminChk(id);
		if(grade == null) {
			grade = "M";
		}  
		
		if(grade.equals("A")) {
			result = true;
		}
		
		return result;
	}


	@Override
	public List<FaqDto> getFaqList(SearchCondition sc, String category) throws Exception {
		List<FaqDto> list = null;
		
		if (category != null) {
			// 카테고리 선택으로 리스트를 찾는 경우
			list = faqDao.selectFaqListCategory(category, sc);
		} else {
			// 검색으로 리스트를 찾는 경우
			list = faqDao.selectFaqList(sc);
		}
		return list;
	}

	@Override
	public FaqDto getFaq(int no) throws Exception {
		FaqDto faqDto = faqDao.selectFaq(no);
		return faqDto;
	}

	@Override
	public int writeFaq(FaqDto faqDto) throws Exception {
		int result = faqDao.insertFaq(faqDto);
		if (result == 0) {
			//만약 insert가 진행 안되면 0 반환
			return 0;
		}
		
		return faqDao.findFaqNo(faqDto);
	}

	@Override
	public boolean deleteFaq(int no) throws Exception {
		int result = faqDao.deleteFaq(no);
		return result == 1 ? true : false;
	}

}
