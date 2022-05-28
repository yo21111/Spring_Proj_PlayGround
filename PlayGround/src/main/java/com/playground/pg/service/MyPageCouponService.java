package com.playground.pg.service;

import java.util.List;

import com.playground.pg.domain.CouponDto;

public interface MyPageCouponService {
	// 해당 아이디가 가지고 있는 총 쿠폰 보여주기
	public int getAllCouponById(String id) throws Exception;
	
	//사용 가능한 쿠폰 / 이미 사용한 쿠폰
	// order by CouponDate1 where state = U
	// order by CouponDate1 where state = N
	//state U : 사용 가능, state : N 이미 사용된
	public List<CouponDto> getCouponList(String id) throws Exception;
}
