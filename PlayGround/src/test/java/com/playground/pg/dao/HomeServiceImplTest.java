package com.playground.pg.dao;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ArtTimeDto;
import com.playground.pg.domain.MemberDto;
import com.playground.pg.service.AdArtService;
import com.playground.pg.service.HomeService;
import com.playground.pg.service.JoinService;
import com.playground.pg.service.MyPageUserInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class HomeServiceImplTest {
	@Autowired
	JoinService jService;
	
	@Autowired
	HomeService homeService;
	
	@Autowired
	MyPageUserInfoService mpuiService;
	
	@Autowired
	AdArtService aaService;
	
	@Autowired
	AdArtDao aaDao;
	
	@Test
	public void serviceTest() throws Exception {
		
		// 1. 멤버 생성
		MemberDto mDto = createMember();
		int insertRes = jService.joinMember(mDto);
		System.out.println("MemberDto : "+mDto); 
		assertTrue(insertRes == 1);
		
		// 2. 관리자 체크
		String id = mDto.getId();
		String adChk = homeService.gradeCheck(id);
		assertTrue(adChk.equals("A"));
		
		// 3. 작품 생성
		ArtDto aDto = createArt();
		ArtTimeDto tDto = createArtTime();
		MockHttpSession session = new MockHttpSession();
		List<MultipartFile> list = new ArrayList<>();
		
		int artresult = aaService.insOrUpdArt("insert", list, session, aDto, tDto);
		int exNo = aaDao.getMaxExNo();
		System.out.println("aDto : " + aDto);
		assertTrue("작품 등록하기", artresult == 1);
		
		// 4. 전시중인 작품 리스트 찾기 확인
		List<ArtDto> chkList = homeService.getArtList();
		
		// 5. 생성했던 멤버 삭제하기
		int deleteRes = mpuiService.deleteMember(id);
		assertTrue(deleteRes == 1);
		
		// 6. 생성했던 작품정보 삭제하기
		int deleteArt = aaService.deleteArt(exNo);
		assertTrue(deleteArt == 1);
		
	}
	
	// 관리자 더미용
	public MemberDto createMember() {
		MemberDto mDto = new MemberDto();
		// 들어오는 값 : 아이디, 비밀번호, 이름, 생년월일(2022-05-26), 휴대폰번호, 이메일, 등급
		mDto.setId("tester123");
		mDto.setPw("abcde12345");
		mDto.setName("테스터");
		mDto.setBirth("2022-05-27");
		mDto.setPhone("01012341234");
		mDto.setEmail("tester123@naver.com");
		mDto.setGrade("A");
	
		return mDto;
	}
	
	// 작품정보 더미용
	public ArtDto createArt() {
		ArtDto artDto = new ArtDto();
		// 들어오는 값 : 작품번호, 장소, 작품명, 작품설명, 전시홀명, 최대인원수, 가격, 등급(일반,성인),
		// 가격2(할인가?), 장르, 전시상태, 썸네일이미지, 메인이미지, 추가설명1,2,3
		artDto.setLocation("서울");
		artDto.setExName("해바라기전시회");
		artDto.setExContent("가나다라마바사아가나다라마바사아가나다라마바사아가나다라마바사아");
		artDto.setExhall("해바라기전시관");
		artDto.setAllowNum(25);
		artDto.setPrice1(78000);
	//	artDto.setPrice2(68000);
	//	artDto.setGrade(0);
		artDto.setGenre("현대미술");
		artDto.setExState("N");
		artDto.setThumbImg("img1.png");
		artDto.setMainImg("img2.png");
		artDto.setExContent1("test1");
		artDto.setExContent2("test2");
		artDto.setExContent3("test3");
	
		return artDto;
	}
	
	// 작품시간 더미용
	public ArtTimeDto createArtTime() {
		ArtTimeDto timeDto = new ArtTimeDto();
		// 들어오는 값 : 작품번호, 전시기간(시작), 전시기간(끝), 전시시간1, 전시시간2, 전시시간3
		Date exDate1 = new Date(122, 04, 01);
		Date exDate2 = new Date(122, 04, 27);
		timeDto.setExDate1(exDate1);
		timeDto.setExDate2(exDate2);
		timeDto.setExTime1_1("09:00");
		timeDto.setExTime1_2("11:00");
		timeDto.setExTime2_1("11:00");
		timeDto.setExTime2_2("13:00");
		timeDto.setExTime3_1("13:00");
		timeDto.setExTime3_2("15:00");
	
		return timeDto;
	}	
	

}
