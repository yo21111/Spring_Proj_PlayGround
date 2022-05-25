package com.playground.pg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController_report {
	// @Autowired
	// AdminService adminService;

	// 0. 관리자가 아닐시 메인페이지로 리턴 -> 서비스에 작성
	
	// 1. 리뷰 신고 페이지
	@GetMapping("/report")
	public String showReportList(Model m) {
		// 리뷰 신고 최신 순으로 정렬해서 리스트 select
		
		// 모델에 리뷰 신고 리스트 담기
		
		return "리뷰신고 페이지";
	}
	
	// 2. 신교된 리뷰 처리하기
	@PostMapping("/report")
	public String passReport(int[] reportList) {
		// 서비스에서 해당 배열을 돌려서 요소에 해당하는 no의 report 데이터를 테이블에서 삭제
		
		return "redirect:/admin/report";
	}
	
	// 3. 신교된 리뷰 삭제하기
	@PostMapping("/reportDelete")
	public String deleteReport(int[] reportList) {
		// 서비스에서 해당 배열을 돌려서 요소에 해당하는 no의 report 데이터를 테이블에서 삭제 + review 테이블에서도 삭제
		
		return "redirect:/admin/report";
	}
}
