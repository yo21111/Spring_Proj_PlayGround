package com.playground.pg.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.playground.pg.domain.NoticeDto;
import com.playground.pg.domain.SearchCondition;

@Repository
public class NoticeDaoImpl implements NoticeDao {
	@Autowired
	private SqlSession session;
	private static String namespace = "com.playground.pg.dao.NoticeMapper.";
	
	@Override
	public int selectTotalCnt() throws Exception {
		return session.selectOne(namespace+"selectTotalCnt");
	}
	@Override
	public String isAdminChk(String id) throws Exception {
		return session.selectOne(namespace+"adminChk", id);
	}
	@Override
	public List<NoticeDto> selectNoticeList(SearchCondition sc) throws Exception {
		return session.selectList(namespace+"selectList", sc);
	}
	@Override
	public NoticeDto selectNotice(int no) throws Exception {
		return session.selectOne(namespace+"selectNotice", no);
	}
	@Override
	public int noticeNo(NoticeDto noticeDto) throws Exception {
		return session.selectOne(namespace+"selectNoticeNo", noticeDto);
	}
	@Override
	public int insertNotice(NoticeDto noticeDto) throws Exception {
		return session.insert(namespace+"insertNotice", noticeDto);
	}
	@Override
	public int updateNotice(NoticeDto noticeDto) throws Exception {
		return session.update(namespace+"updateNotice", noticeDto);
	}
	@Override
	public int deleteNotice(int no) throws Exception {
		return session.delete(namespace+"deleteNotice", no);
	}
	@Override
	public void updateViewCnt(int no) throws Exception {
		session.update(namespace+"updateViewCnt", no);
	}
	
	
}
