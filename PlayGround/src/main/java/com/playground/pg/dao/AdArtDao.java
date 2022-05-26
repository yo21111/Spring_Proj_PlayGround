package com.playground.pg.dao;

import java.util.List;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ArtTimeDto;

public interface AdArtDao {
	//가장 큰 MaxExNo 반환하기
	public int getMaxExNo() throws Exception;
	
	// state로 artDto 리스트 반환하기 -> exNo DESC
	public List<ArtDto> getArtDtoList(String state) throws Exception;
	
	// state로 art테이블에서 exNo 정보만 담은 리스트 반환하기 -> exNo DESC
	public List<Integer> getExNoList(String state) throws Exception;
	
	// exNo를 바탕으로 artTimeDto 반환하기
	public ArtTimeDto getArtTimeDto(int exNo) throws Exception;
	
	//  exNo를 바탕으로 db에서 현재 상태 변경하기
	public int changeState(String changeState, int exNo) throws Exception;
	
	// exNo를 바탕으로 artDto 반환하기
	public ArtDto getArtDto(int exNo) throws Exception;
	
	// artDto insert하기
	public int insertArtDto(ArtDto aDto) throws Exception;
	
	// artTimeDto insert하기
	public int insertArtTimeDto(ArtTimeDto atDto) throws Exception;
	
	// artDto update하기
	public int updateArtDto(ArtDto aDto) throws Exception;
	
	// artTimeDto update 하기
	public int updateArtTimeDto(ArtTimeDto atDto) throws Exception;
	
	// exNo에 해당하는 artDto 삭제하기
	public int deleteArtDto(int exNo) throws Exception;
	
	// exNo에 해당하는 artTimeDto 삭제하기
	public int deleteArtTimeDto(int exNo) throws Exception;
}
