package com.playground.pg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 관리자 메인페이지
@Controller
public class AdminController {
	// @Autowired
	// AdminService adminService;

	
	// 1. 메인페이지 출력 내용
	@GetMapping("/admin")
	public String adminMain(Model m) {
		// 관리자가 아닐시 메인페이지로 리턴
		
		// 요일별 예매현황 최근 5일에 대해 일일 단위 select
		
		// 모델에 예매 현황 담기
		
		// 리뷰 신고 최근 일부 리스트 select하기
		
		// 리뷰 신고 미처리된 건수 select 하기
		
		// 모델에 리뷰 신고 리스트, 리뷰 신고 미처리 건수 담기
		
		// 문의 최근 일부 리스트 select하기
		
		// 문의 미처리된 건수 select 하기
		
		// 모델에 문의 리스트, 문의 미처리 건수 담기
		
		return "관리자 메인페이지";
	}
}
