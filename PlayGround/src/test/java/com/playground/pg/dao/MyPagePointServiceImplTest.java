package com.playground.pg.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.playground.pg.domain.MemberDto;
import com.playground.pg.domain.PointDto;
import com.playground.pg.service.JoinService;
import com.playground.pg.service.MyPagePointService;
import com.playground.pg.service.MyPageUserInfoService;
import com.playground.pg.service.MypageMainService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MyPagePointServiceImplTest {
	@Autowired
	JoinService jService;
	
	@Autowired
	MyPageUserInfoService mpuiService;
	
	@Autowired
	MypageMainService mmService;
	
	@Autowired
	MyPagePointService mppService;

	@Test
	public void serviceTest() throws Exception {
		
		// 1. 멤버 생성
		MemberDto mDto = createMember();
		int insertRes = jService.joinMember(mDto);
		System.out.println("MemberDto : "+mDto); 
		assertTrue(insertRes == 1);		
		
		// 2. 나의 적립금 가져오기
		String id = mDto.getId();
		boolean insPoint = mmService.insPoint(id);
		assertTrue(insPoint);
		int chkPoint = mppService.getAllPoinitById(id);
		assertTrue(chkPoint == 3000);
		
		// 3. 적립금 리스트 확인
		List<PointDto> chkList = mppService.getPointList(id);
		
		// 4. 생성했던 멤버 삭제하기
		int deleteRes = mpuiService.deleteMember(id);
		assertTrue(deleteRes == 1);		
	}
	
	// 회원정보 더미용
	public MemberDto createMember() {
		MemberDto mDto = new MemberDto();
		// 들어오는 값 : 아이디, 비밀번호, 이름, 생년월일(2022-05-26), 휴대폰번호, 이메일, 등급
		mDto.setId("tester123");
		mDto.setPw("abcde12345");
		mDto.setName("테스터");
		mDto.setBirth("2022-05-27");
		mDto.setPhone("01012341234");
		mDto.setEmail("tester123@naver.com");
	
		return mDto;
	}
	
}
