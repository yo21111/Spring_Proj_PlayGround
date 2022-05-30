package com.playground.pg.service;

import java.util.List;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ReserveDto;
import com.playground.pg.domain.ReviewDto;

public interface MypageMainService {

	// 나의 이름 가져오기
	public String getMyName(String uId);
	
	// 나의 사용가능한 쿠폰 개수 가져오기
	public int getCouponCnt(String uId) throws Exception;

	// 나의 적립금 가져오기
	public int getMyPoint(String uId) throws Exception;

	// 3개월 이내 나의 예매 내역 리스트 가져오기
	public List<ReserveDto> getResList(String uId) throws Exception;

	// 예매한 작품 정보 리스트 가져오기
	public List<ArtDto> getArtList(String uId) throws Exception;
	
	// 3개월 이내 나의 리뷰 내역 리스트 가져오기
	public List<ReviewDto> getRevList(String uId) throws Exception;

	// 테스트용 적립금 추가
	public boolean insPoint(String id) throws Exception; 

}
