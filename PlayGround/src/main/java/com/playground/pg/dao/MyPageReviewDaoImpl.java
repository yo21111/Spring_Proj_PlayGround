package com.playground.pg.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ReserveDto;
import com.playground.pg.domain.ReviewDto;

@Repository
public class MyPageReviewDaoImpl implements MyPageReviewDao {
	@Autowired
	private SqlSession session;
	private static String namespace = "com.playground.pg.dao.MyPageReviewMapper.";

	@Override
	public List<ReserveDto> getReserveList(String id, Date term1, Date term2) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("id_FK", id);
		map.put("term1", term1);
		map.put("term2", term2);

		return session.selectList(namespace+"selectReserveList", map);
	}

	@Override
	public int isWriteReview(String id_FK, int exNo_FK) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("id_FK", id_FK);
		map.put("exNo_FK", exNo_FK);

		return session.selectOne(namespace+"isWriteReview", map);
	}

	@Override
	public int insertReview(ReviewDto rDto) {
		return session.insert(namespace+"insertReview", rDto);
	}

	@Override
	public int selectReviewNo(String id_FK, int exNo_FK) {
		Map<String, Object> map = new HashMap<>();
		map.put("id_FK", id_FK);
		map.put("exNo_FK", exNo_FK);
		return session.selectOne(namespace+"selectReviewNo", map);
	}
	
	@Override
	public List<ReserveDto> getSearchList(String id, String tripstart, String tripend) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id_FK", id);
		map.put("tripstart", tripstart);
		map.put("tripend", tripend);
		
		return session.selectList(namespace + "searchList", map);
	}
	
	@Override
	public ArtDto seachrArt(int exNo) throws Exception {
		return session.selectOne(namespace + "searchArt", exNo);
	}
}
