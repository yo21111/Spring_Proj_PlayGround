package com.playground.pg.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.playground.pg.domain.ArtDto;
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
	public int insertReserve(ReserveDto reserveDto) throws Exception {
		return session.insert(namespace + "insertReserve", reserveDto);
	}

	@Override
	public int updateReserve(ReserveDto reserveDto) throws Exception {
		return session.update(namespace + "updateReserve", reserveDto);
	}

}
