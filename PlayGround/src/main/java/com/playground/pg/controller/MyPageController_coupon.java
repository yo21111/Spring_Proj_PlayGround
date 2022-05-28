package com.playground.pg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playground.pg.domain.PageHandler;
import com.playground.pg.domain.CouponDto;
import com.playground.pg.domain.SearchCondition;
import com.playground.pg.service.MyPageCouponService;


@Controller
@RequestMapping("/mypage")
public class MyPageController_coupon {
	@Autowired
	MyPageCouponService mppService;
	
	
	// 쿠폰 페이지
	@GetMapping("/mycoupon")
	public String showMyCoupon(Model m, HttpSession session, int page) throws Exception {
		String id = (String)session.getAttribute("uId_Session");
		
		// 해당 아이디가 가지고 있는 총 쿠폰 갯수 보여주기
		int allCoupon = mppService.getAllCouponById(id);
		
		// 쿠폰 리스트 보여주기 order by couponDate DESC
		List<CouponDto> list = mppService.getCouponList(id);
		
		SearchCondition sc = new SearchCondition(page, 10);
		PageHandler ph = new PageHandler(list.size(), sc);
		
		m.addAttribute("allCoupon", allCoupon);
		m.addAttribute("CouponList", list);
		m.addAttribute("ph", ph);
		
		return "쿠폰 페이지";
	}
}
