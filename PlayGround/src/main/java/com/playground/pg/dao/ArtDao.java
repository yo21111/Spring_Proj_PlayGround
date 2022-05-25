package com.playground.pg.dao;

import java.util.List;

import com.playground.pg.domain.ArtDto;

public interface ArtDao{
	
	// 특정 전시w회 리스트 가져오기
	public List<ArtDto> selectView(String exName) throws Exception;

	// 전시상태 B N A 별로 리스트 가져오기 
	public List<ArtDto> StateBNA(String exState) throws Exception;
}
