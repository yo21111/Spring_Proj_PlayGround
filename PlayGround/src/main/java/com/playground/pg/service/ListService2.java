package com.playground.pg.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playground.pg.dao.ListReviewDao;
import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ArtTimeDto;
import com.playground.pg.domain.ReviewDto;

@Service
public class ListService2 {
	@Autowired
	ListReviewDao listDao;
	
	// 1. artDto, artTimeDto, reviewDto 가져오기
	public Map<String, Object> showPage(int exNo) throws Exception {
		Map<String, Object> map = new HashMap<>();
		
		ArtDto artDto = listDao.getArtDto(exNo);
		ArtTimeDto artTimeDto = listDao.getArtTimeDto(exNo); 
		List <ReviewDto> reviewListDto =listDao.getReviewList(exNo); 
		
		// 유효성 체크 (=null 체크) <- 중요한거
		int totalScore = 0;
		if(reviewListDto.size() != 0) {
			totalScore = listDao.viewAveScore(exNo);
		
		}
		
		double aveScore = Math.floor((double)totalScore / reviewListDto.size()*10)/10;
		
		map.put("ArtDto", artDto);
		map.put("ArtTimeDto", artTimeDto);
		map.put("ReviewList", reviewListDto);
		map.put("aveScore", aveScore);
		return map;
	}
	
	// 2. 후기 평점 평균 가져오기 -> exNo을 기준  집가서 지우기**
	public double getAveScore(int exNo) {
		return 0;
	}
	
	// 3. exState(전시상태) 기준으로 리스트(artDto, artTimeDto) 가져오기
	public Map<String, Object> showState(String exState){
		return null;
	}
	
	// 위시리스트에 있는지 확인
	public int isWishList(String id, int exNo) throws Exception {
		int res = listDao.isWish(id, exNo);
		if(res == 0) {
			listDao.insertWish(id, exNo);
		} else {
			listDao.deleteWish(id, exNo);
		}
		return res;
	}
	
	
	// 전시상태별 리스트 출력 
	public void stateList() throws Exception{
		
	}
}

