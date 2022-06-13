package com.playground.pg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playground.pg.dao.MyPageCouponDao;
import com.playground.pg.domain.CouponDto;

@Service
public class MyPageCouponServiceImpl implements MyPageCouponService {
	@Autowired
	MyPageCouponDao mppDao;
	
	@Override
	public int getAllCouponById(String id) throws Exception {
		return mppDao.getAllCouponById(id);
	}

	@Override
	public List<CouponDto> getCouponList(String id) throws Exception {
		return mppDao.getCouponList(id);
	}

	@Override
	public List<CouponDto> getPoCouponList(String id) throws Exception {
		List<CouponDto> poCouponList = mppDao.getPoCouponList(id); 
		return poCouponList;
	}

	@Override
	public List<CouponDto> getImpoCouponList(String id) throws Exception {
		List<CouponDto> impoCouponList = mppDao.getimpoCouponList(id);
		return impoCouponList;
	}

	@Override
	public int updStateTest(String id) throws Exception {
		return mppDao.updStateTest(id);
	}
	
}