package com.playground.pg.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playground.pg.dao.JoinDao;
import com.playground.pg.domain.CouponDto;
import com.playground.pg.domain.MemberDto;

@Service
public class JoinServiceImpl implements JoinService {
	@Autowired
	JoinDao jDao;
	
	@Override
	public boolean idCheck(String id) throws Exception {
		int result = jDao.idCheck(id);
		return result == 1 ? true : false;
	}

	@Override
	public String certification() throws Exception {
		String result = "";
		
		for (int i = 0; i < 6; i++) {
			result += (int)(Math.random()*10);
		}
		
		return result;
	}

	@Override
	public int joinMember(MemberDto mDto) throws Exception {
		// 유효검사 통과 못할 시 0을 반환하기
		if(!validationMember(mDto)) {
			return 0;
		}
		
		int joinResult = jDao.insertMember(mDto);
		if(joinResult == 0) return joinResult;
		
		String id = mDto.getId();
		CouponDto cDto = new CouponDto(); 
		cDto.setId_FK(id);
		cDto.setCoupon("회원가입 감사 쿠폰");
		//5% 할인 쿠폰
		cDto.setDisRate(5);
		
		// 오늘부터 한달 뒤까지 사용 가능
		Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, 1);
        cDto.setCouDate2(cal.getTime());
		
		cDto.setCouInfo(id + "님 PlayGround에 오신걸 환영합니다!");
		
		joinResult = jDao.insertCoupon(cDto);
		return joinResult;
	}
	
	// 유효성 검사 메서드
	// 들어오는 값 : 아이디, 비밀번호, 이름, 생년월일(2022-05-26), 휴대폰번호, 이메일, 등급
	public boolean validationMember(MemberDto mDto) throws Exception {
		boolean result = true;
		
		// 유효성 검사 작성
		
		return result;
	}

}
