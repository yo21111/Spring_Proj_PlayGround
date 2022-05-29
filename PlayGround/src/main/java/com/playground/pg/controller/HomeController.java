package com.playground.pg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.service.HomeService;

@Controller
public class HomeController {
	@Autowired
	HomeService hService;
	
	@GetMapping("/")
	public String showMainPage(HttpSession session, Model m) throws Exception {
		String id = (String)session.getAttribute("uId_Session");
		if(id != null) {
			String userGrade = hService.gradeCheck(id);
			// 관리자인지, 로그인 상태인지 확인
			if(userGrade.equals("A")) {
				// 모델에 넣기 "A" : 관리자, "M" : 일반 유저
				m.addAttribute("gradeChk", "A");
			} else {
				m.addAttribute("gradeChk", "M");
			}
		}
		
		// 현재 전시중인 작품 리스트 찾기 -> order by exNo DESC, LIMIT 3
		List<ArtDto> list = hService.getArtList();
		
		m.addAttribute("artList", list);
		
		return "index";
	}
}
