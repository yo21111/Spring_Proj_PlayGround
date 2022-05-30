package com.playground.pg.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.playground.pg.domain.FaqDto;
import com.playground.pg.domain.MemberDto;
import com.playground.pg.domain.SearchCondition;
import com.playground.pg.service.FaqService;
import com.playground.pg.service.JoinService;
import com.playground.pg.service.MyPageUserInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class FaqDaoImplTest {
	@Autowired
	FaqDao faqDao;
	
	@Autowired
	FaqService faqServcie;
	
	@Autowired
	JoinService jService;
	
	@Autowired
	MyPageUserInfoService mpuiService;
		
	@Test
	public void serviceTest() throws Exception {
		
		// 1. 멤버 생성
		MemberDto mDto = createMember();
		int insertRes = jService.joinMember(mDto);
		System.out.println("MemberDto : "+mDto); 
		assertTrue(insertRes == 1);
		
		// 2. 관리자 확인
		String id = mDto.getId();
		boolean adChk = faqServcie.adminChk(id);
		assertTrue(adChk);
		
		// 3. faq 글 쓰기 확인
		FaqDto faqDto = createFaq();
		int insRes = faqDao.insertFaq(faqDto);
		assertTrue(insRes==1);
		
		// 4. faq 리스트 가져오기
//		SearchCondition sc = ?;
//		String category = null;
//		List<FaqDto> chkFaq = faqServcie.getFaqList(sc, category);
		
		// 5. faq 총 개수 가져오기 확인
		int rows = faqDao.selectTotalCnt();
		assertTrue(rows == 1);
		
		// 6. faq 상세내용 가져오기 확인
		faqDto = faqServcie.getFaq(1);
				
		// 7. faq 삭제
		int delRes = faqDao.deleteFaq(1);
		assertTrue(delRes==1);
		
		// 8. 멤버 삭제
		int delMem = mpuiService.deleteMember(id);
		assertTrue(delMem == 1);
		
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
	
	public FaqDto createFaq() {
		FaqDto faqDto = new FaqDto();
		
		faqDto.setCategory("A");
		faqDto.setTitle("title title");
		faqDto.setContent("contentcontet");
		faqDto.setWriter("writer");
		
		return faqDto;
	}
	
}
