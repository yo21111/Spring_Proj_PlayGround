package com.playground.pg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playground.pg.dao.AdCouponDao;
import com.playground.pg.domain.CouponDto;
import com.playground.pg.domain.CouponManageDto;

@Service
public class AdCouponServiceImpl implements AdCouponService {
	@Autowired
	AdCouponDao adcDao;
	
	@Override
	public List<CouponDto> getCouponList() throws Exception {
		return adcDao.getCouponList();
	}

	@Override
	public int addCoupon(String criteria, CouponDto cDto, CouponManageDto cmDto) throws Exception {
		int result = 0;
		
		if(criteria.equals("all")) {
			// 유저의 모든 아이디 가져오기
			List<String> idList = adcDao.getAllID();
			// 모든 유저에 아이디를 바탕으로 쿠폰 데이터 생성
			for(int i = 0; i < idList.size(); i++) {
				int res = adcDao.addCouponById(idList.get(i), cDto);
				// insert가 성공할 때마다 result 1씩 증가
				if (res==1) result++;
			}
		} else {
			/*///////////조건부 시작////////////*/
			if(cmDto.getId() != null) {
				// 특정 아이디가 있다면 해당 아이디에 대한 쿠폰만 생성 후 리턴
				return adcDao.addCouponById(cmDto.getId(), cDto);
			}
			
			List<String> idList = adcDao.getID(cmDto);
			for(int i = 0; i < idList.size(); i++) {
				int res = adcDao.addCouponById(idList.get(i), cDto);
				// insert가 성공할 때마다 result 1씩 증가
				if (res==1) result++;
			}
			
			/*///////////조건부 끝 /////////////*/
		}
		
		return result;
	}

	@Override
	public int deleteCoupon(int[] couponNo) throws Exception {
		int result = 0;
		
		for(int i = 0; i < couponNo.length; i++) {
			int res = adcDao.deleteCoupon(couponNo[i]);
			if(res == 1) result ++;
		}
		return result;
	}

}
