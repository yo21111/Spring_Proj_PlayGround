package com.playground.pg.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.playground.pg.domain.CouponDto;
import com.playground.pg.domain.CouponManageDto;

@Repository
public class AdCouponDaoImpl implements AdCouponDao {
	@Autowired
	private SqlSession session;
	private static String namespace = "com.playground.pg.dao.AdCouponMapper.";
	
	
	
	@Override
	public List<CouponDto> getCouponList() throws Exception {
		return session.selectList(namespace+"selectCouponList");
	}

	@Override
	public List<String> getAllID() throws Exception {
		return session.selectList(namespace+"selectAllIdList");
	}

	@Override
	public int addCouponById(String id, CouponDto cDto) throws Exception {
		cDto.setId_FK(id);
		return session.insert(namespace+"insertCouponById", cDto);
	}

	@Override
	public List<String> getID(CouponManageDto cmDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteCoupon(int couponNo) throws Exception {
		return session.delete(namespace+"deleteCoupon", couponNo);
	}

}
