package com.playground.pg.dao;

import java.util.List;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ReserveDto;
import com.playground.pg.domain.ReviewDto;

public interface MypageMainDao {

	// 쿠폰 개수 조회
	public int getCouponCnt(String uId) throws Exception;

	// 잔여 포인트 조회
	public int getPoint(String uId) throws Exception;
	
	// 최근 3개월 예매 목록 조회
	public List<ReserveDto> getResList(String uId) throws Exception;
	
	// 예매한 작품 정보 조회(썸네일용) 
	public ArtDto getArtList(int exNo);

	// 최근 3개월 리뷰 목록 조회
	public List<ReviewDto> getRevList(String uId) throws Exception;



}
