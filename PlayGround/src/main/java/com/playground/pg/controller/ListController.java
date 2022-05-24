package com.playground.pg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/list")

@Controller
public class ListController {
	
	// 전시 상세페이지
	@GetMapping("/listView") 
	public String showList(int no, Model m) {
		// 작품번호 매개변수로 받음
		return "전시상품";
	}
	
	
}
