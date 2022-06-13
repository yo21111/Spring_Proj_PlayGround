package com.playground.pg.dao;

import java.util.List;

import com.playground.pg.domain.CouponDto;


public interface MyPageCouponDao {
	// 해당 아이디가 가지고 있는 총 쿠폰 보여주기
	public int getAllCouponById(String id) throws Exception;
	
	// 쿠폰 리스트 보여주기 order by CouponDate DESC
	public List<CouponDto> getCouponList(String id) throws Exception;

	// 사용가능한 쿠폰 리스트
	public List<CouponDto> getPoCouponList(String id) throws Exception;
	
	// 사용완료한 쿠폰 리스트
	public List<CouponDto> getimpoCouponList(String id) throws Exception;

	public int updStateTest(String id) throws Exception;

}