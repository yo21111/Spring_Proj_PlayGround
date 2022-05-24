package com.playground.pg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.playground.pg.dao.NoticeDao;
import com.playground.pg.domain.NoticeDto;
import com.playground.pg.domain.SearchCondition;

@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	NoticeDao noticeDao;

	@Override
	public int getTotalCnt() throws Exception {
		return noticeDao.selectTotalCnt();
	}

	@Override
	public boolean idAdmin(String id) throws Exception {
		String grade = noticeDao.isAdminChk(id);
		boolean result = false;
		if (grade.equals("A")) {
			result = true;
		}
		return result;
	}

	@Override
	public List<NoticeDto> getNoticeList(SearchCondition sc) throws Exception {
		return noticeDao.selectNoticeList(sc);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public NoticeDto getNotice(int no) throws Exception {
		noticeDao.updateViewCnt(no);
		return noticeDao.selectNotice(no);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int writeNotice(NoticeDto noticeDto) throws Exception {
		noticeDao.insertNotice(noticeDto);
		return noticeDao.noticeNo(noticeDto);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateNotice(NoticeDto noticeDto) throws Exception {
		noticeDao.updateNotice(noticeDto);
		return noticeDto.getNo();
	}

	@Override
	public boolean deleteNotice(int no) throws Exception {
		int result = noticeDao.deleteNotice(no);
		return result == 1 ? true : false;
	}
	
	
}
