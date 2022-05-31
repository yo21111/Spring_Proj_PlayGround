package com.playground.pg.service;

public interface LoginService {

	
	public boolean Login(String id,String Pw)throws Exception;
	//	로그인 메서드
	
	
	public String SearchID_phone(String name,String phone)throws Exception;
	//아이디 찾기 메서드 핸드폰
	
	public String SearchID_email(String name, String email)throws Exception;
	//아이디 찾기 메서드  이메일
	
	public String SearchPW(String id, String email)throws Exception;
	//비밀번호 찾기 메서드 이메일
	
	public String SearchPW2(String id, String phone)throws Exception;
	//비밀번호 찾기 메서드  핸드폰
	
	public boolean changePW(String id ,String NPw)throws Exception;
	//비밀번호 변경 메서드
	
	
	
}
