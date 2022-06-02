package com.playground.pg.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playground.pg.domain.PageHandler;
import com.playground.pg.domain.PointDto;
import com.playground.pg.domain.SearchCondition;
import com.playground.pg.service.MyPagePointService;

@Controller
@RequestMapping("/mypage")
public class MyPageController_point {
	@Autowired
	MyPagePointService mppService;
	
	// 적립금 페이지
	@GetMapping("/mypoint")
	public String showMyPoint(Model m, HttpSession session, int page) throws Exception {
		String id = (String)session.getAttribute("uId_Session");
		
		// 해당 아이디가 가지고 있는 총 적립금 보여주기
		int allPoint = mppService.getAllPoinitById(id);
		
		// 적립금 리스트 보여주기 order by pointDate DESC
		List<PointDto> list = mppService.getPointList(id);
		
		// 적립금 유효기간 보여주기
		List<Date> lastDay = mppService.getDayList(id);
		
		SearchCondition sc = new SearchCondition(page, 10);
		PageHandler ph = new PageHandler(list.size(), sc);
		
		m.addAttribute("lastDay", lastDay);
		m.addAttribute("allPoint", allPoint);
		m.addAttribute("pointList", list);
		m.addAttribute("ph", ph);
		
		return "mypage_point";
	}
}
