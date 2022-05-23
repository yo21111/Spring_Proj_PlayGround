package com.playground.pg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playground.pg.domain.InquiryDto;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {
	
	// 1:1 문의 페이지
	@GetMapping("/board")
	public String updateInq(String uId) {
		// 작성자명 매개변수로 받기
		return "1:1문의 페이지";
	}
	
	// 문의보내기
	@PostMapping("/board")
	public String insertIng(InquiryDto inquiryDto) {
		// InquiryDTO db에 insert
		// 카테고리, 작성자, 제목, 내용, 작성일자
		return "redirect:/마이페이지/문의내역 or /메인페이지";
	}
	
	// 1:1 문의 페이지(내가 쓴글 목록)
	@GetMapping("/my")
	public String myInq(String uId) {
		// 아이디 매개변수로 받기
		// 아이디를 이용하여 리스트 출력
		return "1:1문의 페이지(내가 쓴글 목록)";
	}
	
	
	// 1:1 문의 페이지(내가 쓴글 상세)
	@GetMapping("/detail")
	public String selectInq(int no) {
		// 문의 글 번호 매개변수로 받기
		// 번호를 이용하여 InquiryDto 반환
		return "/inquiry/detail?no="/*+no*/;
	}
	
	
	
	/*관리자 영역*/
	
	//문의관리 페이지(리스트), 비동기처리?
	@GetMapping("/admin")
	public String adminInq() {
		// 문의사항 List 출력
		// 메뉴 선택마다 상태 값 변경
		return "관리자페이지(문의관리)";
	}
	
	//문의관리 페이지(상세)
	@GetMapping("/adDetail")
	public String detailInq(int no) {
		// 문의 게시글 번호 매개변수로 받기
		// 해당 번호를 이용하여 InquiryDto 반환
		// 게시글번호, 카테고리, 제목, 작성날짜, 작성자, 처리상태 조회
		return "/inquiry/admin?no="/*+no*/;
	}
	
	//문의관리 페이지(답변)
	@GetMapping("/adReply")
	public String replyInq(int no) {
		// 문의 게시글 번호 매개변수로 받기
		// 해당 번호를 이용하여 InquiryDto 반환
		// 게시글번호, 카테고리, 제목, 작성날짜, 작성자, 처리상태 조회
		
		return "문의관리 페이지(답변)";
	}
	
	//답변하기
	@PostMapping("/adReply")
	public String insertReply(int no, String text) {
		// 문의 게시글 번호, 답변내용 매개변수로 받기
		// 해당 번호를 이용하여 InquiryDto 반환
		// 해당 Dto에 답변내용 insert
		
		return "/inquire/adInq?no="/*+no*/;
	}
	
	//문의관리 페이지(답변완료)
	@GetMapping("/adInq")
	public String compleInq(int no) {
		// 문의 게시글 번호 매개변수로 받기
		// 해당 번호를 이용하여 InquiryDto 반환
		// 게시글번호, 문의제목, 작성일자, 작성자, 처리상태, 내용, 답변 조회
		return "문의관리 페이지(답변완료)";
	}
	
	@DeleteMapping("/delete")
	public String deleteInq(int no) {
		// no에 해당하는 문의글 삭제하기
		return "redirect:/1:1문의 페이지(내가 쓴글 목록)";
		// 관리자일 경우 "관리자페이지(문의관리)";
	}

}
