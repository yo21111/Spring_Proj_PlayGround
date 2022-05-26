package com.playground.pg.dao;

import com.playground.pg.domain.CouponDto;
import com.playground.pg.domain.MemberDto;

public interface JoinDao {
	// 아이디 중복체크하기
	public int idCheck(String id) throws Exception;
	
	// member insert하기
	public int insertMember(MemberDto mDto) throws Exception;
	
	// 회원가입 감사 쿠폰 발급하기
	public int insertCoupon(CouponDto cDto) throws Exception;
}
