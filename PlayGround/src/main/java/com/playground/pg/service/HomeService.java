package com.playground.pg.service;

import java.util.List;

import com.playground.pg.domain.ArtDto;

public interface HomeService {
	// 관리자인지 여부 확인
	public String gradeCheck(String id) throws Exception;
	
	// 전시중인 작품 리스트 찾기  -> order by exNo DESC, LIMIT 3
	public List<ArtDto> getArtList() throws Exception;
}
