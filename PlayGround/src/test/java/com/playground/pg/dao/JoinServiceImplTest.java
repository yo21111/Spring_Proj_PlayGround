package com.playground.pg.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.playground.pg.domain.CouponDto;
import com.playground.pg.domain.MemberDto;
import com.playground.pg.service.JoinService;
import com.playground.pg.service.MyPageUserInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class JoinServiceImplTest {
	@Autowired
	JoinService jService;

	@Autowired
	MyPageUserInfoService mpuiService;

	@Test
	public void serviceTest() throws Exception {
		MemberDto mDto = createMember();
		
		//1. 회원가입 확인
		int insertRes  = jService.joinMember(mDto);
		System.out.println("MemberDto : "+mDto);
		assertTrue(insertRes == 1);
		
		//2. 회원 가입 시 쿠폰 생성 확인
		CouponDto cDto = jService.selectCouponForTest("tester123");
		System.out.println("cDto : " + cDto);
		
		//3. 아이디 중복 확인
		boolean idChkRes = jService.idCheck("tester123");
		assertTrue(idChkRes);
		
		//4. 인증번호 생성 확인
		String cert = jService.certification();
		System.out.println("cert : "+cert);
		
		//5. 회원 가입시 생성했던 쿠폰 삭제하기 -> delete 유저에 포함
//		int deleteCoupon = jService.deleteCouponForTest("tester123");
//		assertTrue(deleteCoupon == 1);

		//6. 생성했던 회원정보 삭제하기
		int deleteRes = mpuiService.deleteMember("tester123");
		assertTrue(deleteRes == 1);
		
	}
	
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
