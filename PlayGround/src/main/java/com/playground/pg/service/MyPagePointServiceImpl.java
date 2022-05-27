package com.playground.pg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playground.pg.dao.MyPagePointDao;
import com.playground.pg.domain.PointDto;

@Service
public class MyPagePointServiceImpl implements MyPagePointService {
	@Autowired
	MyPagePointDao mppDao;
	
	@Override
	public int getAllPoinitById(String id) throws Exception {
		return mppDao.getAllPoinitById(id);
	}

	@Override
	public List<PointDto> getPointList(String id) throws Exception {
		// TODO Auto-generated method stub
		return mppDao.getPointList(id);
	}

}
