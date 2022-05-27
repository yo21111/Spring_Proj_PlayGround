package com.playground.pg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.playground.pg.dao.ReserveDao;
import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ArtTimeDto;
import com.playground.pg.domain.ReserveDto;

@Service
public class ReserveServiceImple implements ReserveService {
	@Autowired
	ReserveDao reserveDao;
	
	@Override public ArtDto getArt(int no) throws Exception {		
		return reserveDao.selectArt(no);  
	 }
	
	
	
	@Override
	public ArtTimeDto getTime(int no) throws Exception {
		return reserveDao.selectTime(no);
	}

	@Override
	public int getResCnt(int no) throws Exception {
		List<ReserveDto> list = reserveDao.selectResCnt(no);
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
	@Transactional(rollbackFor = Exception.class)
	public boolean insertReserve(ReserveDto reserveDto) throws Exception {
		int result = reserveDao.insertReserve(reserveDto);
		return result == 1 ? true : false;
	}


}
