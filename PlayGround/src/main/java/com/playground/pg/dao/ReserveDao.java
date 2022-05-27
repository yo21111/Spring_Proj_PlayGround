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

}
