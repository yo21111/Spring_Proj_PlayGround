package com.playground.pg.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.playground.pg.domain.MemberDto;
import com.playground.pg.domain.NoticeDto;
import com.playground.pg.service.JoinService;
import com.playground.pg.service.NoticeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class NoticeServiceImplTest {
	@Autowired
	JoinService jService;
	
	@Autowired
	NoticeService nService;
	
	@Test
	public void serviceTest() throws Exception {
		
		// 1. 멤버 생성
		MemberDto mDto = createMember();
		int insertRes = jService.joinMember(mDto);
		System.out.println("MemberDto : "+mDto); 
		assertTrue(insertRes == 1);
		
		// 2. 공지사항 등록
		NoticeDto nDto = createNotice();
		int insNotice = nService.writeNotice(nDto);
		assertTrue(insNotice == 1);
		
		// 3. 공지사항 수정
		nDto = nService.getNotice(1);
		int updNotice = nService.updateNotice(nDto);
		assertTrue(updNotice == 1);
		
		// 4. 공지사항 삭제
		boolean delNotice = nService.deleteNotice(1);
		assertTrue(delNotice);
		
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
	
	// 공지사항 더미용
	public NoticeDto createNotice() {
		NoticeDto nDto = new NoticeDto();
		// 들어오는 값 : 공지번호, 카테고리, 제목, 내용, 작성자, 사진, 조회수, 작성일자, 수정일자
		nDto.setCategory("공지사항");
		nDto.setTitle("공지사항 입니다.");
		nDto.setContent("공지사항 입니다.");
		nDto.setWriter("tester123");
		nDto.setImg("img.jpg");
		return nDto;
	}
	
}
