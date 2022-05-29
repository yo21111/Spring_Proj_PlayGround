package com.playground.pg.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.playground.pg.domain.MemberDto;
import com.playground.pg.service.JoinService;
import com.playground.pg.service.MyPageUserInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MyUserInfoServiceImplTest {
	@Autowired
	MyPageUserInfoService mpuiService;
	
	@Autowired
	JoinService jService;
	
	@Test
	public void serviceTest() throws Exception {
		
		// 1. 멤버 생성
		MemberDto mDto = createMember();
		int insertRes = jService.joinMember(mDto);
		System.out.println("MemberDto : "+mDto); 
		assertTrue(insertRes == 1);
		
		// 2. 비밀번호 체크
		String id = mDto.getId();
		String pw = mDto.getPw();
		boolean chkMem = mpuiService.isMember(id, pw);
		assertTrue(chkMem);
		
		// 3. 회원정보 변경
		MemberDto updDto = updateMember();
		int updMem = mpuiService.updateMember(updDto);
		assertTrue(updMem == 1);
		
		// 4. 회원 탈퇴
		int delMem = mpuiService.deleteMember(id);
		assertTrue(delMem == 1);
		
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
	
	// 회원정보 변경용
	public MemberDto updateMember() {
		MemberDto mDto = new MemberDto();
		// 들어오는 값 : 아이디, 비밀번호, 이름, 생년월일(2022-05-26), 휴대폰번호, 이메일, 등급
		mDto.setId("tester123");
		mDto.setPw("edfgh12345");
		mDto.setName("변경된이름");
		mDto.setBirth("2022-02-27");
		mDto.setPhone("0109999999");
		mDto.setEmail("tester456@naver.com");
	
		return mDto;
	}
	
}
