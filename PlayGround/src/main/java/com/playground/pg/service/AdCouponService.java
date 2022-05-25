package com.playground.pg.service;

import java.util.List;

import com.playground.pg.domain.CouponDto;
import com.playground.pg.domain.CouponManageDto;

// 관리자 - 쿠폰관리 인터페이스
public interface AdCouponService {
	// 쿠폰 테이블 내용 리스트로 가져오기
	public List<CouponDto> getCouponList() throws Exception;
	
	// 쿠폰 추가하기 : 모든 유저인 경우, 조건부 유저인 경우
	public int addCoupon(String criteria, CouponDto cDto, CouponManageDto cmDto) throws Exception;
	
	// 쿠폰 삭제하기
	public int deleteCoupon(int[] couponNo) throws Exception;
}
