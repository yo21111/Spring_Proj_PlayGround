package com.playground.pg.dao;

import java.util.List;

import com.playground.pg.domain.CouponDto;
import com.playground.pg.domain.CouponManageDto;

public interface AdCouponDao {
	// 쿠폰 테이블 내용 리스트로 가져오기
	public List<CouponDto> getCouponList() throws Exception;
	
	// member 테이블의 모든 유저 아이디 가져오기
	public List<String> getAllID() throws Exception;
	
	// 쿠폰 추가하기
	public int addCouponById(String id, CouponDto cDto) throws Exception;
	
	// member 테이블의 특정 유저 아이디 가져오기
	public List<String> getID(CouponManageDto cmDto) throws Exception;
	
	// 쿠폰 삭제하기
	public int deleteCoupon(int couponNo) throws Exception;
}
