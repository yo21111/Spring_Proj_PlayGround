package com.playground.pg.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.playground.pg.domain.CouponDto;
import com.playground.pg.domain.MemberDto;

@Repository
public class JoinDaoImpl implements JoinDao {
	@Autowired
	private SqlSession session;
	private static String namespace = "com.playground.pg.dao.JoinMapper.";
	
	@Override
	public int idCheck(String id) throws Exception {
		return session.selectOne(namespace+"idCheck", id);
	}

	@Override
	public int insertMember(MemberDto mDto) throws Exception {
		return session.insert(namespace+"insertMember", mDto);
	}

	@Override
	public int insertCoupon(CouponDto cDto) throws Exception {
		return session.insert(namespace+"insertCoupon", cDto);
	}

}
