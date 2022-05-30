package com.playground.pg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playground.pg.dao.MyPageUserInfoDao;
import com.playground.pg.domain.MemberDto;

@Service
public class MyPageUserInfoServiceImpl implements MyPageUserInfoService{
	@Autowired
	MyPageUserInfoDao mpuiDao;

	@Override
	public boolean isMember(String id, String pw) throws Exception {
		boolean result = mpuiDao.isMember(id, pw) == 1 ? true : false;
		return result;
	}

	@Override
	public MemberDto findMember(String id) throws Exception {
		return mpuiDao.findMember(id);
	}

	@Override
	public int updateMember(MemberDto mDto) throws Exception {
		return mpuiDao.updateMember(mDto);
	}

	@Override
	public int deleteMember(String id) throws Exception {
		int res = 0;
		res = mpuiDao.deleteCoupon(id);
		res = mpuiDao.deletePoint(id);
		res = mpuiDao.deleteReserve(id);
		res = mpuiDao.deleteReport(id);
		res = mpuiDao.deleteReview(id);
		res = mpuiDao.deleteWishList(id);
		res = mpuiDao.deleteMember(id);
		return res;
	}
	
}
