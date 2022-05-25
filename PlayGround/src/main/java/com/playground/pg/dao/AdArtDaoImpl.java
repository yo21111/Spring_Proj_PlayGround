package com.playground.pg.dao;

import java.util.List;

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
	public List<ArtDto> getArtDtoList(String state) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getExNoList(String state) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArtTimeDto getArtTimeDto(int exNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int changeState(String changeState, int exNo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArtDto getArtDto(int exNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertArtDto(ArtDto aDto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertArtTimeDto(ArtTimeDto atDto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateArtDto(ArtDto aDto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateArtTimeDto(ArtTimeDto atDto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteArtDto(int exNo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteArtTimeDto(int exNo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
