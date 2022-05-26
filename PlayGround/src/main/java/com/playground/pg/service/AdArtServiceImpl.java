package com.playground.pg.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.playground.pg.dao.AdArtDao;
import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ArtTimeDto;

@Service
public class AdArtServiceImpl implements AdArtService {
	@Autowired
	AdArtDao aaDao;

	@Override
	public Map<String, Object> selectArtList(String state) throws Exception {
		Map<String, Object> map = new HashMap<>();

		List<ArtDto> artList = aaDao.getArtDtoList(state);
		List<Integer> exNoList = aaDao.getExNoList(state);
		List<ArtTimeDto> artTimeList = new ArrayList<>();
		for (int i = 0; i < exNoList.size(); i++) {
			ArtTimeDto atDto = aaDao.getArtTimeDto(exNoList.get(i));
			artTimeList.add(atDto);
		}

		map.put("artList", artList);
		map.put("artTimeList", artTimeList);

		return map;
	}

	@Override
	public int changeState(String changeState, int exNo) throws Exception {
		return aaDao.changeState(changeState, exNo);
	}

	@Override
	public Map<String, Object> selectArt(int exNo) throws Exception {
		Map<String, Object> map = new HashMap<>();
		ArtDto aDto = aaDao.getArtDto(exNo);
		ArtTimeDto atDto = aaDao.getArtTimeDto(exNo);
		map.put("artDto", aDto);
		map.put("artTimeDto", atDto);
		return map;
	}

	@Override
	public int insOrUpdArt(String todo, List<MultipartFile> multiFileList, HttpSession session, ArtDto aDto,
			ArtTimeDto atDto) throws Exception {

		// img 이름 담을 배열
		String[] imgArr = new String[2];

		// 파일이 저장되는 위치
		String savePath = session.getServletContext().getRealPath("resources");
		String root = savePath + "\\" + "uploadFile";

		File fileCheck = new File(root);
		if (!fileCheck.exists())
			fileCheck.mkdirs();

		List<Map<String, String>> fileList = new ArrayList<>();

		for (int i = 0; i < multiFileList.size(); i++) {
			String originFile = multiFileList.get(i).getOriginalFilename();
			String ext = originFile.substring(originFile.lastIndexOf("."));
			String changeFile = UUID.randomUUID().toString() + ext;

			Map<String, String> map = new HashMap<>();
			map.put("originFile", originFile);
			map.put("changeFile", changeFile);

			// 배열에 저장되는 이름 저장하기
			imgArr[i] = changeFile;

			fileList.add(map);
		}

		// 파일 업로드
		try {
			for (int i = 0; i < multiFileList.size(); i++) {
				File uploadFile = new File(root + "\\" + fileList.get(i).get("changeFile"));
				multiFileList.get(i).transferTo(uploadFile);
			}

		} catch (IllegalStateException | IOException e) {
			// 만약 업로드 실패하면 파일 삭제
			for (int i = 0; i < multiFileList.size(); i++) {
				new File(root + "\\" + fileList.get(i).get("changeFile")).delete();
			}
			e.printStackTrace();
		}

		aDto.setThumbImg(imgArr[0]);
		aDto.setMainImg(imgArr[1]);
		
		int result = 0;
		
		if (todo.equals("insert")) {
			// todo가 insert이면 서비스로 각 Dto 보내서 insert 하기
			result = aaDao.insertArtDto(aDto);
			if(result == 0) return result;
			atDto.setExNo_FK(aaDao.getMaxExNo() + 1);
			result = aaDao.insertArtTimeDto(atDto);
		} else if (todo.equals("update")) {
			// todo가 update면 서비스로 각 Dto 보내서 update 하기
			result = aaDao.updateArtDto(aDto);
			if(result == 0) return result;
			atDto.setExNo_FK(aDto.getExNo());
			result = aaDao.updateArtTimeDto(atDto);			
		}

		return result;
	}

	@Override
	public int deleteArt(int exNo) throws Exception {
		int result = 0;
		result = aaDao.deleteArtDto(exNo);
		if(result == 0) return result;
		result = aaDao.deleteArtTimeDto(exNo);
		return result;
	}

}
