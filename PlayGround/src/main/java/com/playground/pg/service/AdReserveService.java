package com.playground.pg.service;

import java.util.List;

import com.playground.pg.domain.AdminReserveDto;
import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ReserveDto;

public interface AdReserveService {

	// 검색 여부 확인용
	public boolean searchChk(AdminReserveDto arDto) throws Exception; 
	
	// 예매 정보 리스트 가져오기
	public List<ReserveDto> getResList(AdminReserveDto arDto) throws Exception;
	
	// 예매 정보 리스트 가져오기(일일)
	public List<ReserveDto> getResDayList(AdminReserveDto arDto) throws Exception;
	
	// 전시중인 작품 리스트 가져오기
	public List<ArtDto> getArtList() throws Exception;

	// 차트 기준 조회용
	public boolean standChk(String criteria1, String criteria2);
}
