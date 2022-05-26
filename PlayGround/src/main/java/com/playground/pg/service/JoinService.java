package com.playground.pg.service;

import com.playground.pg.domain.MemberDto;

public interface JoinService {
	// 아이디 중복체크하기
	public boolean idCheck(String id) throws Exception;
	
	// 인증번호 만들기
	public String certification() throws Exception;
	
	// MemberDto에서 받은 값들 유효성 검사하기
	// 유효성 검사 통과시 insert하기 + 회원 가입 감사 쿠폰 발급하기
	public int joinMember(MemberDto mDto) throws Exception;
	
}
