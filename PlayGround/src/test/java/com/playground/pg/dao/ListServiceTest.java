package com.playground.pg.dao;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.playground.pg.domain.MemberDto;
import com.playground.pg.service.JoinService;
import com.playground.pg.service.ListService;
import com.playground.pg.service.MyPageUserInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class ListServiceTest {
	@Autowired
	ListService listService;
	
	@Autowired
	JoinService jService;
	
	@Autowired
	MyPageUserInfoService mpuiService;
	
	@Autowired
	ListReviewDao listDao;
	
	@Before
	public void insertMember() {
		MemberDto mDto = new MemberDto();
		// 들어오는 값 : 아이디, 비밀번호, 이름, 생년월일(2022-05-26), 휴대폰번호, 이메일, 등급
		mDto.setId("tester123");
		mDto.setPw("abcde12345");
		mDto.setName("테스터");
		mDto.setBirth("2022-05-27");
		mDto.setPhone("01012341234");
		mDto.setEmail("tester123@naver.com");
		try {
			int insertRes = jService.joinMember(mDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 전시회 데이터 넣기
	}
	
	@After
	public void deleteMember() {
		// 해당 멤버 삭제 코드
		try {
			int deleteRes = mpuiService.deleteMember("tester123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void isWishListTest() throws Exception {
		String id = "tester123";
		//전시회 제목을 바탕으로 전시회 번호를 select 
		int exNo = 0;
		
		// 회원가입 하느 메서드
		
		int res = listService.isWishList(id, exNo);
		// res가 찜하기 되어있으면 1 안되어있으면 0
		assertTrue(res == 0);
		
		res = listDao.insertWish(id, exNo);
		assertTrue(res == 1);
		
		res = listDao.deleteWish(id, exNo);
		assertTrue(res == 0);
		
		
	}
	
}
