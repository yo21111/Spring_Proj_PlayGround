package com.playground.pg.dao;

import java.util.List;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ArtTimeDto;
import com.playground.pg.domain.ReserveDto;

public interface ReserveDao {

	// 작품 번호로 작품 정보 가져오기
	public ArtDto selectArt(int no) throws Exception;
	
	// 작품 번호로 작품시간 정보 가져오기 
	public ArtTimeDto selectTime(int no);
	
	// 작품 번호로 예매 인원 수 가져오기
	public List<ReserveDto> selectResCnt(int no);
	
	// 예매하기
	public int insertReserve(ReserveDto reserveDto) throws Exception;

	// 예매시 사용한 쿠폰 삭제
	public int deleteCoupon(int coupon) throws Exception;

	// 현재 보유한 전체 포인트 조회
	public int getPoint(String uId) throws Exception;

	// 현재 보유한 포인트 업데이트(사용한 포인트 만큼 감소)
	public int updatePoint(String uId, int remPoint) throws Exception;

}
