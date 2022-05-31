package com.playground.pg.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginDaoImp implements LoginDao {
 @Autowired
   public SqlSession session;
 private static String namespace = "com.playground.pg.dao.LoginMapper.";
 
 @Override
	public int LoginCnt(String id,String Pw)throws Exception{
		Map<String , Object> map = new HashMap<>();
		
		map.put("id", id);
		map.put("Pw", Pw);
	
	 
	return session.selectOne(namespace+"LoginCnt",map);
}
	 
 @Override
	public String ResultId(String name,String phone)throws Exception{
	 
		Map<String , Object> map = new HashMap<>();
		
		map.put("name", name);
		map.put("phone", phone);
		
		return session.selectOne(namespace+"ResultId",map);
	}
	
 
 @Override
public String ResultId2(String name, String email) throws Exception {

		Map<String , Object> map = new HashMap<>();
		
		map.put("name", name);
		map.put("email", email);
		
		return session.selectOne(namespace+"ResultId2",map);
	}

@Override
	public String ResultPw(String id,String email)throws Exception{
	Map<String , Object> map = new HashMap<>();
	
	map.put("id", id);
	map.put("email", email);
		
		return session.selectOne(namespace+"ResultPw",map);
	}
	
@Override
	public String ResultPw2(String id, String phone) throws Exception {
	Map<String , Object> map = new HashMap<>();
	
	map.put("id", id);
	map.put("phone", phone);
	
	return session.selectOne(namespace+"ResultPw2",map);
}


 @Override
	public int ChangePw(String id, String Npw)throws Exception{
	 Map<String , Object> map = new HashMap<>();
	 
	 map.put("id",id);
	 map.put("Npw",Npw);	
	 
		return  session.update(namespace+"ChangePw",map);
	}


	
}
