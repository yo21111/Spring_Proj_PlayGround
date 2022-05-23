package com.playground.pg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	@PutMapping("/board")
	public String insertIng(InquiryDto inquiryDto) {
		// InquiryDTO db에 insert
		// 카테고리, 작성자, 제목, 내용, 작성일자
		return "redirect:/마이페이지/문의내역 or /메인페이지";
	}
	
	

}
