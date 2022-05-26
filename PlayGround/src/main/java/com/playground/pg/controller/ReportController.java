package com.playground.pg.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report")
public class ReportController {
	
	// 신고하기 페이지
	// 리뷰글, 작성자 아이디 매개변수로 받기
	public String report(HttpSession session) throws Exception {
		String uId = (String) session.getAttribute("uId_Session");
		
		return "신고페이지";
	}
	
}
