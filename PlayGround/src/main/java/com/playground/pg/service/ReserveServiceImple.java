package com.playground.pg.service;

import org.springframework.stereotype.Service;

import com.playground.pg.domain.ReserveDto;

@Service
public class ReserveServiceImple implements ReserveService {
	
	/*
	 * @Override public ArtDto getArt(int no) throws Exception {
	 * 
	 * return null; 
	 * 
	 * }
	 */
	@Override
	public boolean insertReserve(ReserveDto reserveDto) throws Exception {
		return false;
	}

	@Override
	public ReserveDto getReserve(String id, int no) throws Exception {
		return null;
	}

	@Override
	public boolean updateReserve(ReserveDto resreveDto) throws Exception {
		return false;
	}

}
