package com.playground.pg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playground.pg.domain.InquiryDto;
import com.playground.pg.domain.ReportDto;
import com.playground.pg.domain.ReserveDto;
import com.playground.pg.service.AdminMainService;

// 관리자 메인페이지
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminMainService amService;

	
	// 1. 메인페이지 출력 내용
	@GetMapping("/")
	public String adminMain(Model m) throws Exception {
		// 관리자가 아닐시 메인페이지로 리턴 -> 인터셉터로 구현
		
		// 요일별 예매현황 최근 5일에 대해 일일 단위 select
		List<ReserveDto> reserveList  = amService.showReserveList();
		
		// 모델에 예매 현황 담기
		m.addAttribute("reserveList", reserveList);
		
		// 리뷰 신고 최근 일부 리스트 select하기 (adCnt, chCnt 각각 있으므로 프론트에서 합칠 것)
		List<ReportDto> reportList  = amService.showReportList();
		
		
		// 리뷰 신고 미처리된 건수 select 하기
		int reportCnt = amService.getReportCnt();
		
		// 모델에 리뷰 신고 리스트, 리뷰 신고 미처리 건수 담기
		m.addAttribute("reportList", reportList);
		m.addAttribute("reportCnt", reportCnt);
		
		
		// 문의 최근 일부 리스트 select하기
		List<InquiryDto> inquireList  = amService.showInquireList();
		
		
		// 문의 미처리된 건수 select 하기
		int inquireCnt = amService.getInquireCnt();
		
		// 모델에 문의 리스트, 문의 미처리 건수 담기
		m.addAttribute("inquireList", inquireList);
		m.addAttribute("inquireCnt", inquireCnt);
		
		return "관리자 메인페이지";
	}
}
