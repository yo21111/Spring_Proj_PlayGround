package com.playground.pg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playground.pg.dao.AdReserveDao;
import com.playground.pg.domain.AdminReserveDto;
import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ReserveDto;

@Service
public class AdReserveServiceImpl implements AdReserveService {
	@Autowired
	AdReserveDao arDao;
		
	@Override
	public boolean searchChk(AdminReserveDto arDto) throws Exception {
		String date1 = arDto.getDate1();
		String date2 = arDto.getDate2();
		String exName = arDto.getExName();
		String location = arDto.getLocation();
		
		boolean result = false;
		
		if (date1 != null && date2 != null && exName != null && location != null) {
			result = true;
		}
		
		return result;
	}

	@Override
	public List<ReserveDto> getResList(AdminReserveDto arDto) throws Exception {
		String date1 = arDto.getDate1();
		String date2 = arDto.getDate2();
		List<ReserveDto> list = arDao.getResList(date1, date2); 
		return list;
	}

	@Override
	public List<ReserveDto> getResDayList(AdminReserveDto arDto) throws Exception {
		String date1 = arDto.getDate1();
		String date2 = arDto.getDate2();
		List<ReserveDto> list = arDao.getResDayList(date1, date2); 
		return list;
	}

	@Override
	public List<ArtDto> getArtList() throws Exception {
		List<ArtDto> list = arDao.getArtList();
		return list;
	}

	@Override
	public boolean standChk(String criteria1, String criteria2) {
		boolean result = false;
		if(criteria1 != null && criteria2 != null) {
			result = true;
		}
		return result;
	}
	
	
	
	

}
