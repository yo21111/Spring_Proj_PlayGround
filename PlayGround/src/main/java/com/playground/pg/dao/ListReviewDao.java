package com.playground.pg.dao;

import java.util.List;

import com.playground.pg.domain.ReviewDto;

public interface ListReviewDao {
	// exNo_FK 로 해당 작품의 작성된 후기 글 리스트 가져오기
	public List<ReviewDto> getReviewList(int exNo_FK) throws Exception;
	
	// 전체 평균 평점 보여주기
	public int viewAveScore(int no, int score) throws Exception;
	
}
