package com.playground.pg.service;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playground.pg.dao.MyReserveDao;
import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ArtTimeDto;
import com.playground.pg.domain.ReserveDto;

@Service
public class MyReserveServiceImpl implements MyReserveService {
	@Autowired
	MyReserveDao mypageDao;
	
	@Override
	public List<ReserveDto> getResList(String uId, String date1, String date2) throws Exception {
		if (date1 == null || date2 == null) {
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			
			cal.add(Calendar.DATE, -7);
			
			Date date11 = cal.getTime();
			Date date21 = new Date();
			
			List<ReserveDto> list = mypageDao.getMainList(uId, date11, date21);
			
			return list;
		}
		
		
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
		
		List<ReserveDto> resList = new ArrayList<>();
		if (date1 == null || date2 == null) {
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			
			cal.add(Calendar.DATE, -7);
			
			Date date11 = cal.getTime();
			Date date21 = new Date();
			
			resList = mypageDao.getMainList(uId, date11, date21);
			
		} else {			
			resList = mypageDao.getResList(uId, date1, date2);
		}
		List<ArtDto> artList = new ArrayList<ArtDto>();
		for (int i = 0; i < resList.size(); i++) {
			ReserveDto reserveDto = resList.get(i);
			int exNo = reserveDto.getExNo_FK();
			artList.add(mypageDao.getArtList(exNo));
			System.out.println(exNo);
		}
		return artList;
	}

	@Override
	public ArtDto getArt(int reserveNo) throws Exception {
		ReserveDto reserveDto = mypageDao.getRes(reserveNo);
		int exNo = reserveDto.getExNo_FK();
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
	public boolean deleteReserve(ReserveDto reserveDto) throws Exception {
		// 포인트 환불하기
		int usePoint = reserveDto.getPoint();
		if(usePoint != 0) {
			// 현재 보유한 포인트
			String uId = reserveDto.getId_FK();
			int myPoint = mypageDao.getPoint(uId);
			// 환불된 포인트
			int upPoint = myPoint + usePoint;
			// 보유한 포인트 수정
			int pointResult = mypageDao.updatePoint(uId, upPoint);
		}
		// 쿠폰 환불하기
		Integer coupon = reserveDto.getCoupon_FK();
		if(coupon != null) {
			int couponResult = mypageDao.updateCoupon(coupon); 			
		}
		// 예약 정보 삭제하기
		int result = mypageDao.deleteReserve(reserveDto);
		
		return result == 1 ? true : false;
	}

}
