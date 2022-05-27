package com.playground.pg.dao;

import java.util.List;

import com.playground.pg.domain.PointDto;

public interface MyPagePointDao {
	// 해당 아이디가 가지고 있는 총 적립금 보여주기
	public int getAllPoinitById(String id) throws Exception;
	
	// 적립금 리스트 보여주기 order by pointDate DESC
	public List<PointDto> getPointList(String id) throws Exception;
}
