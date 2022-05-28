package com.playground.pg.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playground.pg.dao.MypageMainDao;
import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ReserveDto;
import com.playground.pg.domain.ReviewDto;

@Service
public class MypageMainServiceImpl implements MypageMainService {
	@Autowired
	MypageMainDao mypageDao;
	
	@Override
	public String getMyName(String uId) {
		return mypageDao.getName(uId);
	}

	@Override
	public int getCouponCnt(String uId) throws Exception {
		return mypageDao.getCouponCnt(uId);
	}

	@Override
	public int getMyPoint(String uId) throws Exception {
		return mypageDao.getPoint(uId);
	}

	@Override
	public List<ReserveDto> getResList(String uId) throws Exception {
		List<ReserveDto> list = mypageDao.getResList(uId);
				
		return list;
	}
	
	@Override
	public List<ArtDto> getArtList(String uId) throws Exception {
		List<ReserveDto> resList = mypageDao.getResList(uId);
		List<ArtDto> artList = new ArrayList<ArtDto>();
		for (int i = 0; i < resList.size(); i++) {
			ReserveDto reserveDto = resList.get(i);
			int exNo = reserveDto.getExNo_FK();
			artList.add(mypageDao.getArtList(exNo));
		}
		
		return artList;
	}

	@Override
	public List<ReviewDto> getRevList(String uId) throws Exception {
		List<ReviewDto> list = mypageDao.getRevList(uId);
		
		return list;
	}

}
