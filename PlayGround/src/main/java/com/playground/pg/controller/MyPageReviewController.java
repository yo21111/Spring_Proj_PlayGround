package com.playground.pg.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.PageHandler;
import com.playground.pg.domain.ReserveDto;
import com.playground.pg.domain.ReviewDto;
import com.playground.pg.domain.SearchCondition;
import com.playground.pg.service.MyPageReviewService;

@Controller
@RequestMapping("/mypage")
public class MyPageReviewController {
	@Autowired
	MyPageReviewService mprService;
	
	// String term : 최근 얼만큼의 리뷰 작성 가능 또는 작성완료한 리뷰인지 확인
	// -> 1주일(1W) -> 기본값, 1개월(1M), 3개월(3M), 6개월(6M)
	@GetMapping("/myreview")
	public String showMyReview(int page, Model m, HttpSession session, @RequestParam(required=false, defaultValue="1W") String term) throws Exception {
		String id = (String)session.getAttribute("uId_Session");
		
		Map<String, Object> map = mprService.reviewList(id, term);
		
		// 작성 가능한 리뷰 : 예매 테이블에서 리뷰 작성 안한 작품 리스트
		List<ReserveDto> notWriteReviewList = (List<ReserveDto>)map.get("notWriteReviewList");
		// 작성 가능한 리뷰 작품정보(썸네일 용)
		List<ArtDto> notWriteArtList = (List<ArtDto>)map.get("notWriteArtList");
		// 작성 완료한 리뷰 : 예매 테이블에서 리뷰 작성 완료한 작품 리스트
		List<ReserveDto> writeReviewList = (List<ReserveDto>)map.get("writeReviewList");
		// 작성 완료한 리뷰 작품정보(썸네일 용)
		List<ArtDto> writeArtList = (List<ArtDto>)map.get("writeArtList");
		
		int writeReviewCnt = (int)map.get("writeReviewCnt");
		int notWriteReviewCnt = (int)map.get("notWriteReviewCnt");
		SearchCondition sc = new SearchCondition(page, 10);
		PageHandler writePh = new PageHandler(writeReviewCnt, sc);
		PageHandler notWritePh = new PageHandler(notWriteReviewCnt, sc);
		
		// 날짜 표시용(1W = 1주일, 1M = 1달, 3M = 3달, 6M = 6달)
		String viewDate = mprService.getViewDate(term);
		
		//모델에 담기
		m.addAttribute("notWriteReviewList", notWriteReviewList);
		m.addAttribute("writeReviewList", writeReviewList);
		m.addAttribute("writePh", writePh);
		m.addAttribute("notWritePh", notWritePh);
		m.addAttribute("viewDate", viewDate);
		m.addAttribute("notWriteArtList", notWriteArtList);
		m.addAttribute("writeArtList", writeArtList);
		
		// 작성기간은 reDate의 한달 뒤로 자바스크립트로 계산할 것
		
		return "mypage_review";
	}
	
	
	//리뷰작성
	@PostMapping("/myreview")
	public String writeReview(HttpSession session, ReviewDto rDto) throws Exception {
		String id = (String)session.getAttribute("uId_Session");
		mprService.writeReview(id, rDto);
		return "redirect:/mypage/myPageHome";
	}
}
