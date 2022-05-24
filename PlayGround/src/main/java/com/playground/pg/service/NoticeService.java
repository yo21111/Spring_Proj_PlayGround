package com.playground.pg.service;

import java.util.List;

import com.playground.pg.domain.NoticeDto;
import com.playground.pg.domain.SearchCondition;

public interface NoticeService {
	// 전체 글 갯수 db통해서 구하기
	public int getTotalCnt() throws Exception;
	
	// db에서 관리자 여부 확인하기
	public boolean idAdmin(String id) throws Exception;
	
	// 공지사항 리스트 가져오기
	public List<NoticeDto> getNoticeList(SearchCondition sc) throws Exception;
	
	// 게시글 번호로 공지사항 페이지 가져오기 + 조회수 증가
	public NoticeDto getNotice(int no) throws Exception;
	
	//NoticeDto 내용 DB에 INSERT 후 해당 게시글 번호 반환하기
	public int writeNotice(NoticeDto noticeDto) throws Exception;
	
	// NoticeDto 내용 update 후 no 값만 다시 반환하기
	public int updateNotice(NoticeDto noticeDto) throws Exception;

	// 게시글 번호에 해당하는 게시글 삭제하기
	public boolean deleteNotice(int no) throws Exception;
}
