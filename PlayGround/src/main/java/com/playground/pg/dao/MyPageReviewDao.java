package com.playground.pg.dao;

import java.util.Date;
import java.util.List;

import com.playground.pg.domain.ReserveDto;
import com.playground.pg.domain.ReviewDto;

public interface MyPageReviewDao {
	// reDate를 기준으로 오늘부터 String term 전에 해당하는 reserve 리스트 가져오기
	// 조건 : 1. id, 2. between(String term1, String term2)
	// order by reDate DESC
	public List<ReserveDto> getReserveList(String id, Date term1, Date term2) throws Exception;
	
	// 해당 ReserveDto에 대한 리뷰를 작성했는지에 대한 여부
	public int isWriteReview(String id_FK, int exNo_FK) throws Exception;
	
	// 리뷰 작성하기
	public int insertReview(ReviewDto rDto);
}
