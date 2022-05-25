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
	public List<String> getIDBirth(CouponManageDto cmDto) throws Exception {
		return session.selectList(namespace+"selectIdListByBirth", cmDto);
	}
	
	@Override
	public String getIDAcc(CouponManageDto cmDto, String id) throws Exception {
		Integer accPrice1 = cmDto.getAccPrice();
		Integer accTicket1 = cmDto.getAccTicket();
		
		if (accPrice1 == 0 && accTicket1 == 0) {
			return id;
		} else if (accPrice1 != 0) {
			Integer accPrice2 = session.selectOne(namespace+"selectAccPrice", id);
			if (accPrice2 == null) {accPrice2 = 0;}
			if (accPrice1 <= accPrice2) {
				return id;
			} else {
				return "";
			}
		} else {
			Integer accTicketAdult = session.selectOne(namespace+"selectadCnt", id);
			Integer accTicketChild = session.selectOne(namespace+"selectchCnt", id);
			if (accTicketAdult == null) {accTicketAdult = 0;}
			if (accTicketChild == null) {accTicketChild = 0;}
			
			int accTicket2 = accTicketAdult + accTicketChild;
			if (accTicket1 <= accTicket2) {
				return id;
			} else {
				return "";
			}
		}
	}
	
	@Override
	public int deleteCoupon(int couponNo) throws Exception {
		return session.delete(namespace+"deleteCoupon", couponNo);
	}

}
