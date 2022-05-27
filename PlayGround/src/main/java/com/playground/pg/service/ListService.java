package com.playground.pg.service;

import java.util.Map;

public class ListService {
	// 1. artDto, artTimeDto, reviewDto 가져오기
	public Map<String, Object> showpage(int exNo) {
		return null;
	}
	
	// 2. 후기 평점 평균 가져오기 -> exNo을 기준
	public double getAveScore(int exNo) {
		return 0;
	}
	
	// 3. exState(전시상태) 기준으로 리스트(artDto, artTimeDto) 가져오기
	public Map<String, Object> showState(String exState){
		return null;
		
	}
}

