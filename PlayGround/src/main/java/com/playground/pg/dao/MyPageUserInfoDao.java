package com.playground.pg.dao;

import com.playground.pg.domain.MemberDto;

public interface MyPageUserInfoDao {
	// 아이디, 비밀번호에 해당하는 정보가 있는지 확인
	public int isMember(String id, String pw) throws Exception;

	// id에 해당하는 MemberDto 찾기
	public MemberDto findMember(String id) throws Exception;

	// 개인정보 업데이트 하기
	public int updateMember(MemberDto mDto) throws Exception;

	// 회원 탈퇴하기
	public int deleteMember(String id) throws Exception;
}
