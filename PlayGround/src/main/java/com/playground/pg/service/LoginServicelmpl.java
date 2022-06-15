package com.playground.pg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playground.pg.dao.LoginDao;

@Service
public class LoginServicelmpl implements LoginService {
	@Autowired
	LoginDao lDao;

	public boolean Login(String id, String Pw) throws Exception {
		int result = lDao.LoginCnt(id, Pw);
		return result == 1 ? true : false;
	}
	// 로그인 메서드

	public String SearchID_phone(String name, String phone) throws Exception {
		String SearchID = lDao.ResultId(name, phone);
		return SearchID;
	}
	// 아이디 찾기 메서드

	public String SearchID_email(String name, String email) throws Exception {
		String SearchID = lDao.ResultId2(name, email);
		return SearchID;
	}
	// 아이디 찾기 메서드

	public String SearchPW(String id, String email) throws Exception {
		String SearchPw = lDao.ResultPw(id, email);
		return SearchPw;
	}
	// 비밀번호 찾기 메서드

	public String SearchPW2(String id, String phone) throws Exception {
		String SearchPw = lDao.ResultPw2(id, phone);
		return SearchPw;
	}
	// 비밀번호 찾기 메서드

	public boolean changePW(String id, String NPw) throws Exception {
		int result = lDao.ChangePw(id, NPw);
		return result == 1 ? true : false;
	}
	// 비밀번호 변경 메서드
}
