package com.playground.pg.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ArtTimeDto;

public interface AdArtService {
	// state(B, N, A)를 기반으로 artDto리스트와 artTimeDto 찾기
	public Map<String, Object> selectArtList(String state) throws Exception;
	
	// exNo를 바탕으로 DB에서 현재 상태를 바꾸기
	public int changeState(String changeState, int exNo) throws Exception;
	
	// exNo를 바탕으로 artDto, artTimeDto 내용 반환하기
	public Map<String, Object> selectArt(int exNo) throws Exception;
	
	// todo의 값에 따라 insert 또는 update 하기
	public int insOrUpdArt(String todo, List<MultipartFile> multiFileList, HttpSession session, ArtDto aDto, ArtTimeDto atDto) throws Exception;

	// exNo에 해당하는 게시글 삭제하기
	public int deleteArt(int exNo) throws Exception;
}
