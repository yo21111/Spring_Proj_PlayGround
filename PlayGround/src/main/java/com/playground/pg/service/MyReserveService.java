package com.playground.pg.service;

import java.util.List;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ArtTimeDto;
import com.playground.pg.domain.ReserveDto;

public interface MyReserveService {

	// 검색 기간 사이의 예매목록 가져오기
	public List<ReserveDto> getResList(String uId, String date1, String date2) throws Exception;

	// 예매 상세 페이지 출력용 예매 정보 가져오기
	public ReserveDto getRes(int reserveNo) throws Exception;

	// 예매한 작품 정보 리스트가져오기
	public List<ArtDto> getArtList(String uId, String date1, String date2) throws Exception;

	// 예매 상세 페이지 출력용 작품 정보 가져오기
	public ArtDto getArt(int reserveNo) throws Exception;

	// 예매 정보 수정할 작품 정보 가져오기
	public ArtDto updateArt(int exNo) throws Exception;

	// 예매 정보 수정할 작품 시간 가져오기
	public ArtTimeDto updateTime(int exNo) throws Exception;

	// 예매 정보 수정하기
	public boolean updateReserve(ReserveDto reserveDto, String date, String time1, String time2);

	// 예매 인원 수 가져오기
	public int getResCnt(int exNo) throws Exception;

	// 예매 환불하기
	public boolean deleteReserve(ReserveDto reserveDto) throws Exception;

}
