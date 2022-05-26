package com.playground.pg.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ArtTimeDto;

@Repository
public class AdArtDaoImpl implements AdArtDao {
	@Autowired
	private SqlSession session;
	private static String namespace = "com.playground.pg.dao.AdminArtMapper.";
	
	@Override
	public int getMaxExNo() throws Exception {
		return session.selectOne(namespace+"selectMaxExNo");
	}
	
	@Override
	public List<ArtDto> getArtDtoList(String state) throws Exception {
		return session.selectList(namespace+"selectArtDtoList", state);
	}

	@Override
	public List<Integer> getExNoList(String state) throws Exception {
		return session.selectList(namespace+"selectExNoList", state);
	}

	@Override
	public ArtTimeDto getArtTimeDto(int exNo) throws Exception {
		return session.selectOne(namespace+"selectArtTimeDto", exNo);
	}

	@Override
	public int changeState(String changeState, int exNo) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("changeState", changeState);
		map.put("exNo", exNo);
		return session.update(namespace+"changeState", map);
	}

	@Override
	public ArtDto getArtDto(int exNo) throws Exception {
		return session.selectOne(namespace+"selectArtDto", exNo);
	}

	@Override
	public int insertArtDto(ArtDto aDto) throws Exception {
		return session.insert(namespace+"insertArtDto", aDto);
	}

	@Override
	public int insertArtTimeDto(ArtTimeDto atDto) throws Exception {
		return session.insert(namespace+"insertArtTimeDto", atDto);
	}

	@Override
	public int updateArtDto(ArtDto aDto) throws Exception {
		return session.update(namespace+"updateArtDto", aDto);
	}

	@Override
	public int updateArtTimeDto(ArtTimeDto atDto) throws Exception {
		return session.update(namespace+"updateArtTimeDto", atDto);
	}

	@Override
	public int deleteArtDto(int exNo) throws Exception {
		return session.delete(namespace+"deleteArtDto", exNo);
	}

	@Override
	public int deleteArtTimeDto(int exNo) throws Exception {
		return session.delete(namespace+"deleteArtTimeDto", exNo);
	}

}
