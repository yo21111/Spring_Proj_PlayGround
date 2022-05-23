package com.playground.pg.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller	//예약하기 컨트롤러
@RequestMapping("/reserve")
public class ReserveController {

	
	// 날짜 선택 페이지, 작품번호를 매개변수로 받아야합니다.(지역, 제목조회용)
	@GetMapping("/selDay")	
	public ModelAndView selectDay() {
		Map<String, String> modelData = new HashMap<String, String>();
		return new ModelAndView("날짜선택페이지", modelData); // 예매화면 1
	}
	
	
	
	
}
