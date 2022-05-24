package com.playground.pg.dao;

import java.util.List;

import com.playground.pg.domain.FaqDto;
import com.playground.pg.domain.SearchCondition;

public interface FaqDao {
	// 전체 글 갯수 반환
	public int selectTotalCnt() throws Exception;
	
	// 관리자 여부 반환
	public String adminChk(String id) throws Exception;
	
	//faq 리스트 가져오기 (카테고리 선택O)
	public List<FaqDto> selectFaqListCategory(String category, SearchCondition sc) throws Exception;

	//faq 리스트 가져오기 (카테고리 선택X)
	public List<FaqDto> selectFaqList(SearchCondition sc) throws Exception;
	
	// faq 게시글 가져오기 -> 사용 x
	public FaqDto selectFaq(int no) throws Exception;
	
	// faq db에 넣기
	public int insertFaq(FaqDto faqDto) throws Exception;
	
	// insert한 faq데이터의 게시글 번호 가져오기 -> 사용 x
	public int findFaqNo(FaqDto faqDto) throws Exception;
	
	// faq 데이터 삭제하기
	public int deleteFaq(int no) throws Exception;
}
