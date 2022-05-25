package com.playground.pg.dao;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ReserveDto;

public interface ReserveDao {

	// 작품 번호로 작품 정보 가져오기
	public ArtDto selectArt(int no) throws Exception;
	
	// 예매하기
	public int insertReserve(ReserveDto reserveDto) throws Exception;
	
	// 예매정보 수정하기
	public int updateReserve(ReserveDto reserveDto) throws Exception;
}
