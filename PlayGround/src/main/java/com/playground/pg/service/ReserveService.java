package com.playground.pg.service;

import com.playground.pg.domain.ReserveDto;

public interface ReserveService {

	// 작품번호로 해당 작품 정보(빈) 가져오기
	//public ArtDto getArt(int no) throws Exception;
	
	// 결제시 예매정보를 담은 빈을 매개변수로 받아 테이블에 추가
	public boolean insertReserve(ReserveDto reserveDto) throws Exception;

	// 아아이디와 작품번호로 예약정보(빈) 가져오기
	public ReserveDto getReserve(String id, int no) throws Exception; 
	
	// 마이페이지에서 예매날짜 변경한 정보(빈) 받아와서 해당 정보로 업데이트
	public boolean updateReserve(ReserveDto resreveDto) throws Exception; 
	
	
	
}
