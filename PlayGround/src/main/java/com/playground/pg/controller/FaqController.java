package com.playground.pg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playground.pg.SearchCondition;
import com.playground.pg.domain.FaqDto;

@Controller
@RequestMapping("/faq")
public class FaqController {
	
	@GetMapping("/bbs")
	public String showFaq(SearchCondition sc, Model m) {
		int totalCnt; //=  전체 글 갯수 db통해서 구하기
		
		//PageHandler ph = new PageHandler(totalCnt, sc);
		// 관리자 여부 db에서 확인하기 + faq리스트 가져오기 : 서비스에서 구현
		// 모델에 1. faq리스트, 2. 관리자 여부, 3. PageHandler 넣기
		
		return "faq";
	}
	
	@GetMapping("/write")
	public String showFaqWrite(int page) {
		//목록으로 돌아가기 위한 page(페이지 번호) 받아서 넣기
		return "faqwrite";
	}
	
	@PostMapping("/write")
	public String createFaq(FaqDto faqDto, Model m) {
	  //faqDto 내용 DB에 insert하기
	  //작성한 게시글의 글번호 받아와서 url에 붙히기
	  return "redirect:/faq/write?no="/*+no*/;
	}

	@DeleteMapping("/bbs")
	public String deleteFaq(int no, Model m) {
	 // no에 해당하는 게시글 삭제하기
	  return "redirect:/faq";
	}
}
