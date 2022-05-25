package com.playground.pg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playground.pg.domain.ReportDto;
import com.playground.pg.service.AdminService_report;

@Controller
@RequestMapping("/admin")
public class AdminController_report {
	@Autowired
	AdminService_report adminService;

	// 0. 관리자가 아닐시 메인페이지로 리턴 -> 서비스에 작성
	
	// 1. 리뷰 신고 페이지
	@GetMapping("/report")
	public String showReportList(Model m) throws Exception {
		// 리뷰 신고 최신 순으로 정렬해서 리스트 select
		
		// 모델에 리뷰 신고 리스트 담기
		List<ReportDto> list = adminService.selectReportList();
		m.addAttribute("reportList",list);
		
		return "리뷰신고 페이지";
	}
	
	// 2. 신고된 리뷰 처리하기
	@PostMapping("/report")
	public String passReport(int[] reportList) throws Exception {
		// 서비스에서 해당 배열을 돌려서 요소에 해당하는 no의 report 데이터를 테이블에서 삭제
		for (int i = 0; i < reportList.length; i++) {
			boolean result1 = adminService.deleteReport(reportList[i]);
		}
		
		return "redirect:/admin/report";
	}
	
	// 3. 신고된 리뷰 삭제하기
	@PostMapping("/reportDelete")
	public String deleteReport(int[] reportList) throws Exception {
		// 서비스에서 해당 배열을 돌려서 요소에 해당하는 no의 report 데이터를 테이블에서 삭제 + review 테이블에서도 삭제
		for (int i = 0; i < reportList.length; i++) {
			boolean result1 = adminService.deleteReport(reportList[i]);
			boolean result2 = adminService.deleteReview(reportList[i]);
		}		
		return "redirect:/admin/report";
	}
}
