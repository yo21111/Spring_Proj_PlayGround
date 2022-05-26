package com.playground.pg.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playground.pg.domain.PageHandler;
import com.playground.pg.domain.SearchCondition;
import com.playground.pg.domain.MemberDto;
import com.playground.pg.domain.ReserveDto;


// 마이페이지 메인, 예매목록조회, 예매상세, 예매환불, 
// 리뷰, 쿠폰, 적립금, 개인정보변경, 회원탈퇴

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	// 마이페이지 메인
	@GetMapping("/myPageHome")
	public String showMyPageHome(Model m, HttpSession session) {
//1. 세션에서 로그인 값 얻기
//		2. 로그인 null이면 -> 이전페이지로
//		3. 로그인 값이 있다면
//		3-1 쿠폰 총 갯수 가져오기
//		3-2 적립금 금액 가져오기
//		3-3 예매내역 Dto 가져오기
//		3-4 리뷰 Dto 가져오기
//		4. 가져온 내용 Model에 담기
//		5. 페이지 리턴

		return "myPageHome";
	}
	
	// 예매목록 페이지
	@GetMapping("/reList")
	public String showReList(ReserveDto reserveDto, 
		SearchCondition sc, Model m) {
		// = 전체 글 갯수 db통해서 구하기
		int totalCnt;
		// 페이징에 사용하는 pageHandler
		
		//작품번호, 선택날짜, 티켓 매수 매개변수로 받기
		return "reList";
	}

	// 예매목록 상세 페이지
	@GetMapping("/reList_Detail")
	public String showReList_Detail(ReserveDto reserveDto) {
		//작품번호, 선택날짜, 금액, 티켓 매수 매개변수로 받기
		
		return "reList_Detail";
	}

	// 예매수정하기 (일정변경)
	@GetMapping("/scheduleUpdate")
	public String selectReserve(ReserveDto reserveDto) {
		// 수정할 예매 번호 찾기 위해 아이디와 작품번호 전달 받기
		// 해당하는 reserveDTO 넣기
		return "scheduleUpdate";
	}
	// 예매수정하기 (일정변경)
	@PostMapping("/scheduleUpdate")
	public String updateReserve(ReserveDto reserveDto, String date) {

		// 수정할날짜로 DTO 수정하기
		return "redirect:/mypage/reList";
	}
	
	// 예매 환불 페이지 조회
	@GetMapping("/refund")
	public String showRefund(ReserveDto reserveDto) {
		
		//작품번호, 선택날짜, 금액, 티켓 매수 매개변수로 받기

		return "refund";
	}
	// 예매 환불 
	@PostMapping("/refund")
	public String Refund(ReserveDto reserveDto) {
		
		//작품번호, 선택날짜, 금액, 티켓 매수 매개변수로 받기
		// ReserveDto에 delete
		return "refund";
	}

	// 나의 리뷰 페이지
	@GetMapping("/review")
	public String showReview(ReserveDto reserveDto, SearchCondition sc) {
		// = 전체 글 갯수 db통해서 구하기
		int totalCnt;
		// 페이징에 사용하는 pageHandler 객체 생성
		
		//작품번호, 선택날짜, 티켓 매수 매개변수로 받기
		return "review";
	}

	// 리뷰 작성
	@PostMapping("/review")
	public String insertReview(ReserveDto reserveDto) {
     //해당 작품의 리뷰 작성하기 
		return "review";
	}

	// 쿠폰
	@GetMapping("/coupon")
	public String showCoupon(int no, SearchCondition sc) {
		// = 전체 쿠폰 갯수 db통해서 구하기
		int totalCnt;
		// 페이징에 사용하는 pageHandler 객체 생성
		
		//사용 가능한 쿠폰 / 사용완료 쿠폰 
		return "coupon";
	}

	// 적립금
	@GetMapping("/point")
	public String showPoint(int no, SearchCondition sc) {
		// = 전체 내역 갯수 db통해서 구하기
		int totalCnt;
		// 페이징에 사용하는 pageHandler 객체 생성
		
		//적립금 날짜, 유형, 내용, 내역 매개변수
		return "point";
	}

	// 개인정보수정
	@PostMapping("/updateInfo")
	public String updateInfo(MemberDto memberDto) {
		
		return "redirect:/updateInfo";
	}

	// 회원탈퇴
	@DeleteMapping("/withdraw")
	public String withdraw(MemberDto memberDto) {
		// MemberDTO DB에 delete
		return "메인페이지";
	}

}