package com.playground.pg.dao;

public interface LoginDao {

	public int LoginCnt(String id,String Pw)throws Exception;
	 
	
	public String ResultId(String name,String phone)throws Exception;
	
	
	public String ResultId2(String name,String email)throws Exception;
	
	
	public String ResultPw(String id, String phone)throws Exception;
	
	
	public String ResultPw2(String id,String email)throws Exception;
	
	
	public int ChangePw(String id, String Npw)throws Exception;
	
	
	
	
	
}
