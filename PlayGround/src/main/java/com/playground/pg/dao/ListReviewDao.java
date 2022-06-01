package com.playground.pg.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ArtTimeDto;
import com.playground.pg.domain.ReviewDto;

public interface ListReviewDao {
	// exNo_FK 로 해당 작품의 작성된 후기 글 리스트 가져오기
	public List<ReviewDto> getReviewList(int exNo_FK) throws Exception;
	
	// artDto 값1개 가져오기
	public ArtDto getArtDto(int exNo_FK) throws Exception;
	
	// artTimeDto ** 가져오기
	public ArtTimeDto getArtTimeDto(int exNo_FK) throws Exception;
	
	// 전체 평균 평점 보여주기
	public int viewAveScore(int no) throws Exception;
	
	// 위시 리스트 확인
	public int isWish(String id, int exNo) throws Exception;
	
	public int insertWish(String id, int exNo) throws Exception;
	
	public int deleteWish(String id, int exNo) throws Exception;
}
