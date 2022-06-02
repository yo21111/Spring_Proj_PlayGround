package com.playground.pg.dao;

import java.util.Date;
import java.util.List;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ArtTimeDto;
import com.playground.pg.domain.CouponDto;
import com.playground.pg.domain.ReserveDto;

public interface MyReserveDao {

	// 검색 기간 사이의 예매 정보 리스트 조회용
	public List<ReserveDto> getResList(String uId, String date1, String date2) throws Exception;

	// 예매 상세페이지 출력용 예매정보(빈) 조회용
	public ReserveDto getRes(int reserveNo) throws Exception;

	// 예매 작품정보 리스트 조회용
	public ArtDto getArtList(int exNo) throws Exception;

	// 예매 정보 수정용 작품 조회
	public ArtDto updateArt(int exNo);

	// 예매 정보 수정용 작품 시간
	public ArtTimeDto updateTime(int exNo);

	// 예매 정보 수정하기
	public int updateReserve(ReserveDto reserveDto, String date, String time1, String time2);

	// 예매 인원 수 확인용 예매 리스트 조회
	public List<ReserveDto> getResCnt(int exNo) throws Exception;

	// 예매 환불하기
	public int deleteReserve(ReserveDto reserveDto) throws Exception;

	// 현재 보유한 포인트 조회
	public int getPoint(String uId) throws Exception;

	// 포인트 환불하기
	public int updatePoint(String uId, int upPoint) throws Exception;

	// 쿠폰 환불하기
	public int updateCoupon(int coupon) throws Exception;

	// 검색기간 없을때
	public List<ReserveDto> getMainList(String uId, Date date11, Date date21) throws Exception;

	
}
