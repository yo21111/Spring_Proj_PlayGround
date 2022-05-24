package com.playground.pg.dao;

import java.util.List;

import com.playground.pg.domain.NoticeDto;
import com.playground.pg.domain.SearchCondition;

public interface NoticeDao {
	//전체 글 갯수 반환하기
	public int selectTotalCnt() throws Exception;
	
	// 관리자 여부 확인하기
	public String isAdminChk(String id) throws Exception;
	
	// 공지사항 리스트 반환하기
	public List<NoticeDto> selectNoticeList(SearchCondition sc) throws Exception;
	
	// 공지사항 페이지 반환하기
	public NoticeDto selectNotice(int no) throws Exception;
	
	// 게시글 번호 반환하기
	public int noticeNo(NoticeDto noticeDto) throws Exception;
	
	// noticeDto insert 하기
	public int insertNotice(NoticeDto noticeDto) throws Exception;

	// noticeDto update 하기
	public int updateNotice(NoticeDto noticeDto) throws Exception;
	
	// noticeDto delete 하기
	public int deleteNotice(int no) throws Exception;
	
	// 조회수 증가
	public void updateViewCnt(int no) throws Exception;
}
