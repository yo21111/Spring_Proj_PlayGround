package com.playground.pg.dao;

import java.util.List;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ReserveDto;

public interface AdReserveDao {

	// 예약 정보 리스트 가져오기
	public List<ReserveDto> getResList(String date1, String date2) throws Exception;
	
	// 예약 정보 리스트(일일) 가져오기 
	public List<ReserveDto> getResDayList(String date1, String date2) throws Exception;
	
	// 진행중인 작품 정보 리스트 가져오기
	public List<ArtDto> getArtList() throws Exception;
	
	
	
}
