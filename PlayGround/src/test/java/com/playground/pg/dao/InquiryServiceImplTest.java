package com.playground.pg.dao;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.playground.pg.domain.InquiryDto;
import com.playground.pg.service.InquiryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class InquiryServiceImplTest {
	@Autowired
	InquiryService inqService;

	@Test
	public void serviceTest() throws Exception {
		
		// 1. 문의 생성 확인
		InquiryDto inqDto = createInquiry();
		boolean insInq = inqService.insertInq(inqDto);
		System.out.println("InquiryDto : " + inqDto);
		assertTrue(insInq);
		
		// 2. 문의 내역 가져오기 확인
		String id = inqDto.getWriter();
		List<InquiryDto> chkInq = inqService.getInqList(id);
		
		/*******관리자 영역*******/
		// 3. 처리 해야할 문의 건수 확인
		int chkCnt = inqService.getInqCnt();
		assertTrue(chkCnt == 1);
		
		// 4. 문의글 리스트 확인
		String state = "All"; // Not(처리예정), Fin(처리완료)
		chkInq = inqService.getAdminInqList(state);
		
		// 5. 문의 답변하기
		InquiryDto getInqDto = inqService.getInq(1);
		getInqDto.setContent("답변입니다.");
		String context = getInqDto.getContent();
		int inqNo = getInqDto.getNo();
		boolean replyRes = inqService.updateReply(inqNo, context);
		assertTrue(replyRes);
		
		// 6. 문의 삭제하기
		boolean delInq = inqService.deleteInq(inqNo);
		assertTrue(delInq);
	}
	
	public InquiryDto createInquiry() {
		InquiryDto inqDto = new InquiryDto();
		// 들어오는 값 : 문의번호, 카테고리, 제목, 내용, 작성자(아이디), 작성날짜, 처리상태, 답변
		inqDto.setCategory("환불문의");
		inqDto.setTitle("제목입니다.");
		inqDto.setContent("내용입니다.");
		inqDto.setWriter("tester123");
		inqDto.setWriteDate("2022-06-15");
		
		return inqDto;
	}
	
}
