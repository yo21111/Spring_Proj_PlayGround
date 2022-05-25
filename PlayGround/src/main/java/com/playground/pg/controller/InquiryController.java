package com.playground.pg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playground.pg.domain.InquiryDto;
import com.playground.pg.service.InquiryService;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {
	@Autowired
	InquiryService inquiryService;
	
	
	// 1:1 문의 페이지
	@GetMapping("/board")
	public String updateInq(String uId, Model m) {
		// 작성자명 매개변수로 받기
		
		// 작성자명 모델에 넣기
		m.addAttribute("uId", uId);
		
		return "1:1문의 페이지";
	}
	
	// 문의보내기
	@PostMapping("/board")
	public String insertIng(InquiryDto inquiryDto) throws Exception {
		// InquiryDTO db에 insert
		// 카테고리, 작성자, 제목, 내용, 작성일자
		
		// 문의 정보(빈) insert 하는 서비스
		boolean result = inquiryService.insertInq(inquiryDto);
		
		return "redirect:/마이페이지/문의내역 or /메인페이지";
	}
	
	// 1:1 문의 페이지(내가 쓴글 목록)
	@GetMapping("/my")
	public String myInq(String uId, Model m) throws Exception {
		// 아이디 매개변수로 받기
		// 아이디를 이용하여 리스트 출력
		
		List<InquiryDto> list = inquiryService.getInqList(uId);
		m.addAttribute("inqList", list);
		
		return "1:1문의 페이지(내가 쓴글 목록)";
	}
	
	
	// 1:1 문의 페이지(내가 쓴글 상세)
	@GetMapping("/detail")
	public String selectInq(int no, Model m) throws Exception {
		// 문의 글 번호 매개변수로 받기
		
		// 문의게시글 번호를 이용하여 InquiryDto 반환
		InquiryDto inquiryDto = inquiryService.getInq(no);
		// 게시글 내용(빈) 모델에 넣기
		m.addAttribute("inquiryDto", inquiryDto);
		
		return "/inquiry/detail?no="+no;
	}
	

	/***********관리자 영역 컨트롤러***************/
	
	//문의관리 페이지(리스트, 전체목록)
	@GetMapping("/admin")
	public String adminInq(String state, Model m) throws Exception {
		// State 값 -> 전체목록 : All, 처리예정목록 : Not, 처리완료목록 : Fin

		// 문의사항 List 출력
		List<InquiryDto> list = inquiryService.getAdminInqList(state);
		// 처리 해야할 문의 개수 표시
		int inqCnt = inquiryService.getInqCnt();
		
		m.addAttribute("inqList", list);
		m.addAttribute("inqCnt", inqCnt);
		
		return "/inquiry/admin?state="+state;
	}
	
	
	//문의관리 페이지(상세)
	@GetMapping("/adDetail")
	public String detailInq(int no, Model m) throws Exception {
		
		// 문의 게시글 번호 매개변수로 받기 후 InquiryDto 반환
		// 게시글번호, 카테고리, 제목, 작성날짜, 작성자, 처리상태 조회
		InquiryDto inquiryDto = inquiryService.getInq(no);
		// 처리 해야할 문의 개수 표시
		int inqCnt = inquiryService.getInqCnt();
		
		m.addAttribute("inquiryDto", inquiryDto);
		m.addAttribute("inqCnt", inqCnt);
		
		return "/inquiry/adDetail?no="+no;
	}
	
	//문의관리 페이지(답변)
	@GetMapping("/adReply")
	public String replyInq(int no, Model m) throws Exception {
		
		// 문의 게시글 번호 매개변수로 받기 후 InquiryDto 반환
		// 게시글번호, 카테고리, 제목, 작성날짜, 작성자, 처리상태 조회
		InquiryDto inquiryDto = inquiryService.getInq(no);
		m.addAttribute("inquiryDto", inquiryDto);
		
		return "문의관리 페이지(답변)";
	}
	
	//답변하기
	@PutMapping("/adReply")
	public String insertReply(int no, String text) throws Exception {
		// 문의 게시글 번호, 답변내용 매개변수로 받기
		
		// 해당 번호 게시글에 답변내용 update
		boolean result = inquiryService.updateReply(no, text);
		
		return "/inquire/adInq?no="+no;
	}
	
	//문의관리 페이지(답변완료)
	@GetMapping("/adInq")
	public String compleInq(int no, Model m) throws Exception {
		
		
		// 문의 게시글 번호 매개변수로 받기 후 InquiryDto 반환
		// 게시글번호, 문의제목, 작성일자, 작성자, 처리상태, 내용, 답변 조회
		InquiryDto inquiryDto = inquiryService.getInq(no);
		m.addAttribute("inquiryDto", inquiryDto);
		
		return "문의관리 페이지(답변완료)";
	}
	
	// 문의 삭제하기
	@DeleteMapping("/delete")
	public String deleteInq(int no) throws Exception {
		// no에 해당하는 문의글 삭제하기
		
		// 문의 삭제 서비스
		boolean result = inquiryService.deleteInq(no);
		
		
		return "redirect:/관리자페이지(문의관리)";
	}

}
