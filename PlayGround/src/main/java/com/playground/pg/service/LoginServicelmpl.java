package com.playground.pg.service;

public class LoginServicelmpl implements LoginService{

	
	
	public boolean Login(String id ,String Pw)throws Exception{
	    	
	   boolean LoginOK = false;
	   int result = 0;//DAO.method;
	   if(result==1) {
		   LoginOK= true;
	   }
		
		return LoginOK;
	}
	//	로그인 메서드
	
	
	public String SearchID_phone(String name,String phone)throws Exception{
		  
	  String SearchID = "DAO.메서드 반환값";
		
		return SearchID;
	}
	//아이디 찾기 메서드
	
	
	public String SearchID_email(String name, String email)throws Exception{
		
		 String SearchID = "DAO.메서드 반환값";
		
		
		return SearchID;
	}
	//아이디 찾기 메서드
	
	public String SearchPW(String id, String email, String phone)throws Exception{
		
		String SearchPw = "DAO.메서드 반환값";
		return"SearchPw";
	}
	//비밀번호 찾기 메서드
	
	
	public void changePW(String NPw)throws Exception{
		
		 // DAO.몌서드(String NPw);
		
	}
	
}
