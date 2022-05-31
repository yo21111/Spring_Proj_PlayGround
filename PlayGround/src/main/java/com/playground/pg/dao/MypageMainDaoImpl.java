package com.playground.pg.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ReserveDto;
import com.playground.pg.domain.ReviewDto;

@Repository
public class MypageMainDaoImpl implements MypageMainDao {
	@Autowired
	private SqlSession session;
	private static String namespace = "com.playground.pg.dao.MyPageMainMapper.";

	@Override
	public String getName(String uId) {
		return session.selectOne(namespace + "getName",uId);
	}

	@Override
	public int getCouponCnt(String uId) throws Exception {
		return session.selectOne(namespace + "getCouponCnt",uId);
	}

	@Override
	public int getPoint(String uId) throws Exception {
		Integer point = session.selectOne(namespace + "getPoint", uId);
		if (point == null) {
			return 0;
		} else {
			return point;
		}
	}

	@Override
	public List<ReserveDto> getResList(String uId) throws Exception {
		return session.selectList(namespace + "getResList", uId);
	}
	
	@Override
	public ArtDto getArtList(int exNo) {
		return session.selectOne(namespace + "getArtList", exNo);
	}

	@Override
	public List<ReviewDto> getRevList(String uId) throws Exception {
		return session.selectList(namespace + "getRevList", uId);
	}

	@Override
	public int insPoint(String id) throws Exception {
		return session.insert(namespace + "insPoint", id);
	}
	
	

}
