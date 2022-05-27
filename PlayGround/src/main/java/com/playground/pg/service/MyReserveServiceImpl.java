package com.playground.pg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playground.pg.dao.MyReserveDao;
import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ArtTimeDto;
import com.playground.pg.domain.CouponDto;
import com.playground.pg.domain.ReserveDto;

@Service
public class MyReserveServiceImpl implements MyReserveService {
	@Autowired
	MyReserveDao mypageDao;
	
	@Override
	public List<ReserveDto> getResList(String uId, String date1, String date2) throws Exception {
		List<ReserveDto> list = mypageDao.getResList(uId, date1, date2);
		return list;
	}

	@Override
	public ReserveDto getRes(int reserveNo) throws Exception {
		ReserveDto reserveDto = mypageDao.getRes(reserveNo);
		return reserveDto;
	}

	@Override
	public List<ArtDto> getArtList(String uId, String date1, String date2) throws Exception {
		List<ReserveDto> resList = mypageDao.getResList(uId, date1, date2);
		List<ArtDto> artList = new ArrayList<ArtDto>();
		for (int i = 0; i < artList.size(); i++) {
			ReserveDto reserveDto = resList.get(i);
			int exNo = reserveDto.getExNo();
			artList.add(mypageDao.getArtList(exNo));
		}
		return artList;
	}

	@Override
	public ArtDto getArt(int reserveNo) throws Exception {
		ReserveDto reserveDto = mypageDao.getRes(reserveNo);
		int exNo = reserveDto.getExNo();
		ArtDto artDto = mypageDao.getArtList(exNo);
		return artDto;
	}

	@Override
	public ArtDto updateArt(int exNo) throws Exception {
		ArtDto artDto = mypageDao.updateArt(exNo);
		return artDto;
	}

	@Override
	public ArtTimeDto updateTime(int exNo) throws Exception {
		ArtTimeDto artTimeDto = mypageDao.updateTime(exNo);
		return artTimeDto;
	}
	
	@Override
	public int getResCnt(int exNo) throws Exception {
		List<ReserveDto> list = mypageDao.getResCnt(exNo);
		int resCnt = 0;
		int adCnt = 0;
		int chCnt = 0;
		for (int i = 0; i < list.size(); i++) {
			ReserveDto reserveDto = list.get(i);
			adCnt = reserveDto.getAdCnt();
			chCnt = reserveDto.getChCnt();
			resCnt = adCnt + chCnt;
		}
		return resCnt;
	}

	@Override
	public boolean updateReserve(ReserveDto reserveDto, String date, String time1, String time2) {
		int result = mypageDao.updateReserve(reserveDto, date, time1, time2);
		return result == 1 ? true : false;
	}

	@Override
	public boolean deleteReserve(ReserveDto reserveDto, CouponDto couponDto) throws Exception {
		int result = mypageDao.deleteReserve(reserveDto);
		
		// 포인트 환불하기
		int usePoint = reserveDto.getPoint();
		if(usePoint != 0) {
			// 현재 보유한 포인트
			String uId = reserveDto.getuId();
			int myPoint = mypageDao.getPoint(uId);
			// 환불된 포인트
			int upPoint = myPoint + usePoint;
			// 보유한 포인트 수정
			int pointResult = mypageDao.updatePoint(uId, upPoint);
		}
		// 쿠폰 환불하기
		int coupon = reserveDto.getCoupon();
		if(coupon != 0) {
			int couponResult = mypageDao.insertCoupon(couponDto); 			
		}
		
		return result == 1 ? true : false;
	}

}
