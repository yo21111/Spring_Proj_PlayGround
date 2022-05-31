package com.playground.pg.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.playground.pg.domain.MemberDto;
import com.playground.pg.service.JoinService;
import com.playground.pg.service.LoginService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class LoginServiceImplTest {
	@Autowired
	LoginService lService;
	
	@Autowired
	JoinService jService;
	
	@Test
	public void serviceTest() throws Exception{
		
		// 1. 멤버 생성
		MemberDto mDto = createMember();
		int insertRes = jService.joinMember(mDto);
		System.out.println("MemberDto : "+mDto); 
		assertTrue(insertRes == 1);
        
		// 2. 로그인 확인
		String id = mDto.getId();
		String pw =mDto.getPw();
		boolean LoginRes = lService.Login(id,pw);
		assertTrue(LoginRes);
		
		 // 3. 아이디 찾기 확인(핸드폰)
		 String name =mDto.getName();
		 String phone = mDto.getPhone();
		 String findId =lService.SearchID_phone(name, phone);
		 assertTrue(findId.equals("tester123"));
		
		 //4. 아이디 찾기 확인(이메일)
		 String email = mDto.getEmail();
		 findId =lService.SearchID_email(name, email);
		 assertTrue(findId.equals("tester123"));
	  
		 // 5. 비밀번호 찾기(이메일)
		 String findPw = lService.SearchPW(id,email);
		 assertTrue(findPw.equals("abcde12345"));
		 
		 // 6. 비밀번호 찾기(핸드폰) 
		 findPw = lService.SearchPW2(id,phone);
		 assertTrue(findPw.equals("abcde12345"));
		 
		 // 7. 비밀번호 변경
		 String nPw = "변경비밀번호12";
		 boolean newPw = lService.changePW(id,nPw);
		 assertTrue(newPw);
		 
	}
	
	
	
	
	//멤버 생성용 
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
