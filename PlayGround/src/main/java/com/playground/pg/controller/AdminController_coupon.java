package com.playground.pg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playground.pg.domain.CouponDto;
import com.playground.pg.domain.CouponManageDto;
import com.playground.pg.service.AdCouponService;

@Controller
@RequestMapping("/admin")
public class AdminController_coupon {
	@Autowired
	AdCouponService acService;

	// 0. 관리자가 아닐시 메인페이지로 리턴 -> 서비스에 작성

	// 1. 쿠폰 관리 페이지
	@GetMapping("/coupon")
	public String showCouponList(Model m) throws Exception {
		// 쿠폰 테이블에서 리스트로 select
		List<CouponDto> list = acService.getCouponList();
		// 모델에 리스트 넣기
		m.addAttribute("couponList", list);
		
		return "쿠폰관리 페이지";
	}

	// 2. 쿠폰 추가 페이지
	@GetMapping("/addcoupon")
	public String addCouponPage() {
		return "쿠폰추가 페이지";
	}

	// 2. 쿠폰 추가하기
	// criteria : 조건 -> 모든 유저 all / 조건부 유저 notall
	@PostMapping("/addcoupon")
	public String addCoupon(CouponDto cDto, String criteria, CouponManageDto cmDto) throws Exception {
		// criteria가 모든 유저인 경우의 쿠폰 insert
		// criteria가 조건부 유저인 경우의 쿠폰 insert : 각 조건에 따른 알고리즘 적용
		int result = acService.addCoupon(criteria, cDto, cmDto);
		
		return "redirect:/admin/coupon";
	}

	// 3. 쿠폰 삭제하기
	@DeleteMapping("/deletecoupon")
	public String deleteCoupon(int[] couponNo) throws Exception {
		// 해당 배열 요소에 있는 번호를 쿠폰 테이블에서 삭제
		int result = acService.deleteCoupon(couponNo);
		
		return "redirect:/admin/coupon";
	}
}
