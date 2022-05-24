package com.playground.pg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/exhibit")
@Controller
public class ListController {
	
	// 전시 상세페이지
	@GetMapping("/listView") 
	public String showEx(String exName, Model m) {
		// 작품제목(exName) 매개변수로 받음
		//	전시제목, 전시 기간, 관람 시간, 가격, 할인 정보, 전시 문의 번호(임시)
		return "전시상품";
	}

	// 전시 리스트페이지
	@GetMapping("/list")
	public String showExList(String exName, String exState, Model m) {
		// 작품제목(exName) 매개변수로 받음
		// 전시상태(exState) 에서 B(before 지난), N(now 현재), A(after 예정)로 
		// 전시상태별로 분류할 수 있는 값을 받아옴
		return "전체목록";
	}
	
}
