package com.playground.pg.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playground.pg.dao.MyPageReviewDao;
import com.playground.pg.domain.ReserveDto;
import com.playground.pg.domain.ReviewDto;

@Service
public class MyPageReviewServiceImpl implements MyPageReviewService {
	@Autowired
	MyPageReviewDao mprDao;
	
	@Override
	public Map<String, Object> reviewList(String id, String term) throws Exception {
		Map<String, Object> map = new HashMap<>();
		
		Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        
        int termNum = term.charAt(0) - '0';
        char termUnit = term.charAt(1);

        if(termUnit == 'W') {
        	cal.add(Calendar.DATE, -7);
        } else {
        	cal.add(Calendar.MONTH, -termNum);
        }

        Date term1 = cal.getTime();
        Date term2 = new Date();

        List<ReserveDto> allList = mprDao.getReserveList(id, term1, term2);
		
		List<ReserveDto> writeReviewList = new ArrayList<>();
		List<ReserveDto> notWriteReviewList = new ArrayList<>();
		
		for (int i = 0; i < allList.size(); i++) {
			int result = mprDao.isWriteReview(id, allList.get(i).getExNo());
			if (result == 0) {
				notWriteReviewList.add(allList.get(i));
			} else {
				writeReviewList.add(allList.get(i));
			}
		}
		
		int wReviewCnt = writeReviewList.size();
		int nwReviewCnt = notWriteReviewList.size();
		
		map.put("writeReviewList", writeReviewList);
		map.put("notWriteReviewList", notWriteReviewList);
		map.put("writeReviewCnt", wReviewCnt);
		map.put("notWriteReviewCnt", nwReviewCnt);
		
		return map;
	}

	@Override
	public int writeReview(String id, ReviewDto rDto) throws Exception {
		String title = rDto.getContent().substring(0, 10) + "...";
		rDto.setTitle(title);
		rDto.setId(id);
		return mprDao.insertReview(rDto);
	}
	
	
}
