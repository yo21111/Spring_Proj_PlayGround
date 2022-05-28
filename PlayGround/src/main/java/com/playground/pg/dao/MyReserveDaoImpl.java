package com.playground.pg.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ArtTimeDto;
import com.playground.pg.domain.CouponDto;
import com.playground.pg.domain.ReserveDto;

@Repository
public class MyReserveDaoImpl implements MyReserveDao {
	@Autowired
	private SqlSession session;
	private static String namespace = "com.playground.pg.dao.MyReserveMapper.";

	@Override
	public List<ReserveDto> getResList(String uId, String date1, String date2) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id_FK", uId);
		map.put("date1", date1);
		map.put("date2", date2);
		
		return session.selectList(namespace + "getResList", map);
	}

	@Override
	public ReserveDto getRes(int reserveNo) throws Exception {
		return session.selectOne(namespace + "getRes", reserveNo);
	}

	@Override
	public ArtDto getArtList(int exNo) throws Exception {
		return session.selectOne(namespace + "getArtList", exNo);
	}

	@Override
	public ArtDto updateArt(int exNo) {
		return session.selectOne(namespace + "getArt", exNo);
	}

	@Override
	public ArtTimeDto updateTime(int exNo) {
		return session.selectOne(namespace + "getTime", exNo);
	}

	@Override
	public List<ReserveDto> getResCnt(int exNo_FK) throws Exception {
		return session.selectList(namespace + "getResCnt", exNo_FK);
	}

	@Override
	public int updateReserve(ReserveDto reserveDto, String date, String time1, String time2) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reserveDto", reserveDto);
		map.put("date", date);
		map.put("time1", time1);
		map.put("time2", time2);
		
		return session.update(namespace + "resreveUpdate", map);
	}

	@Override
	public int deleteReserve(ReserveDto reserveDto) throws Exception {
		return session.delete(namespace + "deleteReserve", reserveDto);
	}

	@Override
	public int getPoint(String uId) throws Exception {
		return session.selectOne(namespace + "getPoint", uId);
	}

	@Override
	public int updatePoint(String uId, int upPoint) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id_FK", uId);
		map.put("upPoint", upPoint);
		
		return session.update(namespace + "updatePoint", map);
	}

	@Override
	public int updateCoupon(int coupon) throws Exception {
		return session.update(namespace + "updateCoupon", coupon);
	}
	
	

}
