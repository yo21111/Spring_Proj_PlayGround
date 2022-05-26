package com.playground.pg.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ReserveDto;

@Repository
public class AdReserveDaoImpl implements AdReserveDao {
	@Autowired
	private SqlSession session;
	private static String namespace = "com.playground.pg.dao.AdminReserveMapper.";
	
	@Override
	public List<ReserveDto> getResList(String date1, String date2) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date1", date1);
		map.put("date2", date2);
		
		return session.selectList(namespace + "getResList", map);
	}
	
	@Override
	public List<ReserveDto> getResDayList(String date1, String date2) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date1", date1);
		map.put("date2", date2);
		
		return session.selectList(namespace + "getResDayList", map);
	}

	@Override
	public List<ArtDto> getArtList() throws Exception {
		return session.selectList(namespace + "getArtList");
	}

}
