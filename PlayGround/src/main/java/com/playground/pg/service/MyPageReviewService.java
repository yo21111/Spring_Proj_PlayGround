package com.playground.pg.service;

import java.util.Map;

import com.playground.pg.domain.ReviewDto;

public interface MyPageReviewService {
	// 리뷰 작성여부 : 리뷰테이블에서 id_FK, exNo_FK가 일치하는 리뷰가 1 또는 0  
	
	// 작성 가능한 리뷰 : 예매 테이블에서 리뷰 작성 안한 작품 리스트
	// 작성 완료한 리뷰 : 예매 테이블에서 리뷰 작성 완료한 작품 리스트
	public Map<String, Object> reviewList(String id, String term) throws Exception;

	// 리뷰 작성하기
	public int writeReview(String id, ReviewDto rDto) throws Exception;
	
}
