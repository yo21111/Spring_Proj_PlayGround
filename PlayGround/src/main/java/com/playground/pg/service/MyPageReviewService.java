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
	
	// 테스트용 작성된 리뷰 번호 찾기
	public int selectReviewNo(String id_FK, int exNo_FK);
	
	// 검색한 기간내 작성 가능한, 작성한 리뷰
	public Map<String, Object> searchList(String id, String tripstart, String tripend) throws Exception;

	// term에 따른 글자 반환
	public String getViewDate(String term) throws Exception;
}
