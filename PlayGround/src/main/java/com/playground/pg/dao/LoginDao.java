package com.playground.pg.dao;

public interface LoginDao {

	public int LoginCnt(String id,String Pw)throws Exception;
	 
	
	public String ResultId(String id,String Pw)throws Exception;
	
	
	public String ResultPw(String id,String Pw)throws Exception;
	
	
	public String ChangePw(String Npw)throws Exception;
	
	
	
	
	
}
