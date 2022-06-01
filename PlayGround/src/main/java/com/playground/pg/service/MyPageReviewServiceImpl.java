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
import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ReserveDto;
import com.playground.pg.domain.ReviewDto;

@Service
public class MyPageReviewServiceImpl implements MyPageReviewService {
	@Autowired
	MyPageReviewDao mprDao;
	
	@Override
	public Map<String, Object> reviewList(String uId, String term) throws Exception {
		Map<String, Object> map = new HashMap<>();
		
		Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        
        if (term == null || term.equals("")) {
        	term = "1W";
        }
        
        int termNum = term.charAt(0) - '0';
        char termUnit = term.charAt(1);

        if(termUnit == 'W') {
        	cal.add(Calendar.DATE, -7);
        } else {
        	cal.add(Calendar.MONTH, -termNum);
        }

        Date term1 = cal.getTime();
        Date term2 = new Date();

        List<ReserveDto> allList = mprDao.getReserveList(uId, term1, term2);
		
		List<ReserveDto> writeReviewList = new ArrayList<>();
		List<ReserveDto> notWriteReviewList = new ArrayList<>();
		List<ArtDto> writeArtList = new ArrayList<>();
		List<ArtDto> notWriteArtList = new ArrayList<>();
		
		for (int i = 0; i < allList.size(); i++) {
			ReserveDto reDto = allList.get(i);
			int exNo = reDto.getExNo_FK();
			
			ArtDto artDto = mprDao.seachrArt(exNo);		
			int result = mprDao.isWriteReview(uId, reDto.getExNo_FK());
			if (result == 0) {
				notWriteReviewList.add(allList.get(i));
				notWriteArtList.add(artDto);
			} else {
				writeReviewList.add(allList.get(i));
				writeArtList.add(artDto);
			}
		}
		
		int wReviewCnt = writeReviewList.size();
		int nwReviewCnt = notWriteReviewList.size();
		
		map.put("writeReviewList", writeReviewList);
		map.put("notWriteReviewList", notWriteReviewList);
		map.put("writeReviewCnt", wReviewCnt);
		map.put("notWriteReviewCnt", nwReviewCnt);
		map.put("writeArtList", writeArtList);
		map.put("notWriteArtList", notWriteArtList);
		
		return map;
	}

	@Override
	public int writeReview(String id, ReviewDto rDto) throws Exception {
		String title = rDto.getContent().substring(0, 10) + "...";
		rDto.setTitle(title);
		rDto.setId_FK(id);
		return mprDao.insertReview(rDto);
	}
	
	@Override
	public int selectReviewNo(String id_FK, int exNo_FK) {
		return mprDao.selectReviewNo(id_FK, exNo_FK);
	}
	
	@Override
	public Map<String, Object> searchList(String id, String tripstart, String tripend) throws Exception {
		Map<String, Object> map = new HashMap<>();
		
		tripstart = tripstart.replaceAll("[^0-9]", "");
		tripend = tripend.replaceAll("[^0-9]", "");
		List<ReserveDto> searchList = mprDao.getSearchList(id, tripstart, tripend);
		
		List<ReserveDto> writeReviewList = new ArrayList<>();
		List<ReserveDto> notWriteReviewList = new ArrayList<>();
		List<ArtDto> writeArtList = new ArrayList<>();
		List<ArtDto> notWriteArtList = new ArrayList<>();
		
		
		for (int i = 0; i < searchList.size(); i++) {
			ReserveDto reDto = searchList.get(i);
			int exNo = reDto.getExNo_FK();
			
			ArtDto artDto = mprDao.seachrArt(exNo);
			int result = mprDao.isWriteReview(id, reDto.getExNo_FK());
			if (result == 0) {
				notWriteReviewList.add(searchList.get(i));
				notWriteArtList.add(artDto);
			} else {
				writeReviewList.add(searchList.get(i));
				writeArtList.add(artDto);
			}
		}
		
		int wReviewCnt = writeReviewList.size();
		int nwReviewCnt = notWriteReviewList.size();
		
		map.put("writeReviewList", writeReviewList);
		map.put("notWriteReviewList", notWriteReviewList);
		map.put("writeReviewCnt", wReviewCnt);
		map.put("notWriteReviewCnt", nwReviewCnt);
		map.put("writeArtList", writeArtList);
		map.put("notWriteArtList", notWriteArtList);
		
		return map;
	}

	@Override
	public String getViewDate(String term) throws Exception {
		if(term.equals("1W")) {
			term = "1주일간";
		} else if(term.equals("1M")) {
			term = "1달간";
		} else if(term.equals("3M")) {
			term = "3달간";
		} else {
			term = "6달간";
		}
		return term;
	}
}
