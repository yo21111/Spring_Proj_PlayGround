package com.playground.pg.service;

import java.util.List;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ArtTimeDto;
import com.playground.pg.domain.CouponDto;
import com.playground.pg.domain.ReserveDto;

public interface ReserveService {

	// 작품번호로 해당 작품 정보(빈) 가져오기
	public ArtDto getArt(int no) throws Exception;
	
	// 작품번호로 해당 작품 정보시간(빈) 가져오기
	public ArtTimeDto getTime(int no) throws Exception;

	// 작품번호로 해당 작품 예약인원 수 가져오기
	public int getResCnt(int no) throws Exception; 
	
	// 결제시 예매정보를 담은 빈을 매개변수로 받아 테이블에 추가
	public boolean insertReserve(ReserveDto reserveDto) throws Exception;

	// 해당 아이디가 가지고 있는 총 적립금 보여주기
	public int getAllPoinitById(String id) throws Exception;

	// 사용가능한 쿠폰 리스트
	public List<CouponDto> getPoCouponList(String id) throws Exception;

}
