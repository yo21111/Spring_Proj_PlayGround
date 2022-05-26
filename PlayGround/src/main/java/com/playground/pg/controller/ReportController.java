package com.playground.pg.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playground.pg.domain.ReportDto;
import com.playground.pg.domain.ReviewDto;
import com.playground.pg.service.ReportService;

@Controller
@RequestMapping("/report")
public class ReportController {
	@Autowired
	ReportService reportService;
	
	// 신고하기 페이지
	// 작성자 아이디 매개변수로 받기, 시안에 리뷰 정보 있을경우 수정
	@RequestMapping("/page")
	public String showReport(Model m, HttpSession session) throws Exception {
		
		// 작성자 아이디 화면 표시용
		String uId = (String) session.getAttribute("uId_Session");
		// 작성자 아이디 모델에 넣기
		m.addAttribute("uId", uId);
		
		return "신고페이지";
	}
	
	// 신고하기
	@PostMapping("/insert")
	public String report(ReportDto reportDto) throws Exception {
		
		boolean result = reportService.report(reportDto);
		
		return "redirect:메인페이지 or 신고내역 페이지?";
	}
	
}
