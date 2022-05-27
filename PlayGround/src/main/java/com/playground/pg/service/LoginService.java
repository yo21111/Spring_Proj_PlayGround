package com.playground.pg.service;

public interface LoginService {

	
	public boolean Login(String id,String Pw)throws Exception;
	//	로그인 메서드
	
	
	public String SearchID_phone(String name,String phone)throws Exception;
	//아이디 찾기 메서드
	
	
	public String SearchID_email(String name, String email)throws Exception;
	//아이디 찾기 메서드
	
	public String SearchPW(String id, String email, String phone)throws Exception;
	//비밀번호 찾기 메서드
	
	
	public void changePW(String NPw)throws Exception;
	//비밀번호 변경 메서드
	
	
	
}
