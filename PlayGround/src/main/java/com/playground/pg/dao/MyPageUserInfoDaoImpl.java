package com.playground.pg.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.playground.pg.domain.MemberDto;

@Repository
public class MyPageUserInfoDaoImpl implements MyPageUserInfoDao {
	@Autowired
	private SqlSession session;
	private static String namespace = "com.playground.pg.dao.UserInfoMapper.";

	
	@Override
	public int isMember(String id, String pw) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", pw);
		return session.selectOne(namespace+"isMember", map);
	}

	@Override
	public MemberDto findMember(String id) throws Exception {
		return session.selectOne(namespace+"findMember", id);
	}

	@Override
	public int updateMember(MemberDto mDto) throws Exception {
		return session.update(namespace+"updateMember", mDto);
	}

	@Override
	public int deleteMember(String id) throws Exception {
		return session.delete(namespace+"deleteMember", id);
	}

}
