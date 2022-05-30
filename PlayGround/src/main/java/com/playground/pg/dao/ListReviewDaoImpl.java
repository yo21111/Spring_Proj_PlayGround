package com.playground.pg.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ArtTimeDto;
import com.playground.pg.domain.ReviewDto;

public class ListReviewDaoImpl implements ListReviewDao {
	@Autowired
	SqlSession session;
	private static String namespace = "com.playground.pg.dao.ListMapper.";

	// exNo_FK 로 해당 작품의 작성된 후기 글 리스트 가져오기
	public List<ReviewDto> getReviewList(int exNo_FK) throws Exception {
		return session.selectList(namespace + "", exNo_FK);
	}

	// artDto 값1개 가져오기
	public ArtDto getArtDto(int exNo_FK) throws Exception {
		return session.selectOne(namespace + "", exNo_FK);
	}

	// artTimeDto ** 가져오기
	public ArtTimeDto getArtTimeDto(int exNo_FK) throws Exception {
		return session.selectOne(namespace + "", exNo_FK);
	}

	// 전체 평균 평점 보여주기
	public int viewAveScore(int no) throws Exception {
		return session.selectOne(namespace + "", no);
	}

}
