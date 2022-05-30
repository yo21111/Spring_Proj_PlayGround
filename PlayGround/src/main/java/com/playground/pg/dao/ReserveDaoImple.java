package com.playground.pg.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ArtTimeDto;
import com.playground.pg.domain.ReserveDto;

@Repository
public class ReserveDaoImple implements ReserveDao {
	@Autowired
	private SqlSession session;
	private static String namespace = "com.playground.pg.dao.ReserveMapper.";
	
	
	@Override
	public ArtDto selectArt(int no) throws Exception {		
		return session.selectOne(namespace + "selectArt", no);
	}
	
	@Override
	public ArtTimeDto selectTime(int no) {
		return session.selectOne(namespace + "selectTime", no);
	}

	@Override
	public List<ReserveDto> selectResCnt(int no) {
		return session.selectList(namespace + "selectResCnt", no);
	}

	@Override
	public int insertReserve(ReserveDto reserveDto) throws Exception {
		return session.insert(namespace + "insertReserve", reserveDto);
	}

	@Override
	public int updateCoupon(Integer coupon) throws Exception {
		return session.update(namespace + "updateCoupon", coupon);
	}

	@Override
	public Integer getPoint(String uId) throws Exception {
		return session.selectOne(namespace + "selectPoint", uId);
	}

	@Override
	public int updatePoint(String uId, int remPoint) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id_FK", uId);
		map.put("remPoint", remPoint);
		
		return session.update(namespace + "updatePoint", map);
	}

	@Override
	public int insertPoint(String uId, int point) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id_FK", uId);
		map.put("point", point);
		
		return session.insert(namespace + "insertPoint", map);
	}
	
}
