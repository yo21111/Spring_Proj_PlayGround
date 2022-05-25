package com.playground.pg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.playground.pg.dao.ReserveDao;
import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ReserveDto;

@Service
public class ReserveServiceImple implements ReserveService {
	@Autowired
	ReserveDao reserveDao;
	
	@Override public ArtDto getArt(int no) throws Exception {		
		return reserveDao.selectArt(no);  
	 }
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean insertReserve(ReserveDto reserveDto) throws Exception {
		int result = reserveDao.insertReserve(reserveDto);
		return result == 1 ? true : false;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean updateReserve(ReserveDto resreveDto) throws Exception {
		int result = reserveDao.updateReserve(resreveDto);
		return result == 1? true : false;
	}

}
