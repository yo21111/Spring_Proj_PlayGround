package com.playground.pg.service;

import java.util.List;

import com.playground.pg.domain.FaqDto;
import com.playground.pg.domain.SearchCondition;

public interface FaqService {

	/*
	 * int totalCnt : 전체글 갯수 반환
	 */
	public int getTotalCnt() throws Exception;
	
	/*
	 * 관리자 여부 확인하기
	 */
	public boolean adminChk(String id) throws Exception;
	
	/*
	 * faq 리스트 가져오기
	 */
	public List<FaqDto> getFaqList(SearchCondition sc, String category) throws Exception;
	
	/*
	 * faq Dto 게시글 번호 바탕으로 찾기 -> 사용 x
	 */
	public FaqDto getFaq(int no) throws Exception;
	
	/*
	 * faq Dto DB에 넣기 + 넣은 dto의 게시글 번호 반환(사용x)
	 */
	public int writeFaq(FaqDto faqDto) throws Exception;
	
	/*
	 * 게시글 번호에 해당하는 데이터 삭제하기
	 */
	public boolean deleteFaq(int no) throws Exception;
}
