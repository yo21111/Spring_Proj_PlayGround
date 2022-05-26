package com.playground.pg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playground.pg.dao.HomeDao;
import com.playground.pg.domain.ArtDto;

@Service
public class HomeServiceImpl implements HomeService {
	@Autowired
	HomeDao hDao;
	
	@Override
	public String gradeCheck(String id) throws Exception {
		String gradeChk = "";
		if(hDao.gradeCheck(id) == 1) {
			gradeChk = "A";
		}
		
		return gradeChk;
	}

	@Override
	public List<ArtDto> getArtList() throws Exception {
		return hDao.getArtList();
	}

}
