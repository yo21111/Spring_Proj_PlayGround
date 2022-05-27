package com.playground.pg.dao;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ArtTimeDto;
import com.playground.pg.service.AdArtService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class AdArtServiceImplTest {
	@Autowired
	AdArtService aaService;
	@Autowired
	AdArtDao aaDao;

	@Test
	public void serviceTest() throws Exception {
		ArtDto aDto = makeArtDto();
		ArtTimeDto atDto = makeArtTimeDto();
		
		MockHttpSession session = new MockHttpSession();
		List<MultipartFile> list = new ArrayList<>();
		
		aaService.insOrUpdArt("insert", list, session, aDto, atDto);
		Map<String, Object> map = aaService.selectArtList("A");
		
		List<ArtDto> artList = (List<ArtDto>)map.get("artList");
		List<ArtTimeDto> artTimeList = (List<ArtTimeDto>)map.get("artTimeList");
		assertTrue(artList.size() == 1);
		assertTrue(artTimeList.size() == 1);
		
		int maxNo = aaDao.getMaxExNo();
		aaService.deleteArt(maxNo);
	}
	
	public ArtDto makeArtDto() {
		ArtDto aDto = new ArtDto();
		aDto.setAllowNum(100);
		aDto.setExContent("content내용입니다.");
		aDto.setExContent1("1번 콘텐트 입니다.");
		aDto.setExContent2("2번 콘텐트 입니다.");
		aDto.setExContent3("3번 콘텐트 입니다.");
		aDto.setExhall("파크홀");
		aDto.setExName("이번 전시회의 이름");
		aDto.setExState("A");
		aDto.setGenre("참여형");
		aDto.setGrade(0);
		aDto.setLocation("서울");
		aDto.setPrice1(15000);
		aDto.setPrice2(10000);
		return aDto;
	}
	
	public ArtTimeDto makeArtTimeDto() {
		ArtTimeDto atDto = new ArtTimeDto();
		atDto.setExDate1(Date.valueOf("2022-05-22"));
		atDto.setExDate2(Date.valueOf("2022-06-22"));
		atDto.setExTime1_1("10:00");
		atDto.setExTime1_2("12:00");
		atDto.setExTime2_1("12:00");
		atDto.setExTime2_2("14:00");
		atDto.setExTime3_1("14:00");
		atDto.setExTime3_2("16:00");
		return atDto;
	}
}
