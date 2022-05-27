package com.playground.pg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ReserveDto;
import com.playground.pg.domain.ReviewDto;
import com.playground.pg.service.MypageMainService;

@Controller
@RequestMapping("/mypage")
public class MyPageMainController {
	@Autowired
	MypageMainService mypageService;

	// 마이페이지 메인
	@GetMapping("/myPageHome")
	public String showMyPageHome(Model m, HttpSession session) throws Exception {
//		1. 세션에서 로그인 값 얻기
//		2. 로그인 null이면 -> 이전페이지로
//		3. 로그인 값이 있다면
//		3-1 쿠폰 총 갯수 가져오기
//		3-2 적립금 금액 가져오기
//		3-3 예매내역 Dto 가져오기
//		3-4 리뷰 Dto 가져오기
//		4. 가져온 내용 Model에 담기
//		5. 페이지 리턴
		
		// 유저 아이디 가져오기
		String uId = (String) session.getAttribute("uId_Session");
		
		
		// 이름 가져오기
		String name = mypageService.getMyName(uId);
		// 나의 사용가능한 쿠폰 개수 가져오기
		int couponCnt = mypageService.getCouponCnt(uId);
		
		// 나의 적립금 금액 가져오기
		int myPoint =mypageService.getMyPoint(uId);
		
		// 3개월 이내 나의 예매 내역 리스트 가져오기
		List<ReserveDto> resList = mypageService.getResList(uId);
		
		// 예매한 작품 정보 리스트 가져오기(썸네일 출력용)
		List<ArtDto> artList = mypageService.getArtList(uId);
		
		// 3개월 이내 나의 리뷰 내역 리스트 가져오기
		List<ReviewDto> revList = mypageService.getRevList(uId);
		
		m.addAttribute("name", name);
		m.addAttribute("couponCnt", couponCnt);
		m.addAttribute("myPoint", myPoint);
		m.addAttribute("reserveList", resList);
		m.addAttribute("artList", artList);
		m.addAttribute("reviewList", revList);
		
		return "마이페이지메인페이지";
	}
}
