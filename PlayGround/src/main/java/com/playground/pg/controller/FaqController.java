package com.playground.pg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playground.pg.domain.FaqDto;
import com.playground.pg.domain.NoticeDto;
import com.playground.pg.domain.PageHandler;
import com.playground.pg.domain.SearchCondition;
import com.playground.pg.service.FaqService;

@Controller
@RequestMapping("/faq")
public class FaqController {
	@Autowired
	FaqService faqService;

	@GetMapping("/bbs")
	public String showFaq(HttpSession session, SearchCondition sc, String category, Model m) throws Exception {
		// = 전체 글 갯수 db통해서 구하기
		int totalCnt = faqService.getTotalCnt();

		// 페이징에 사용하는 pageHandler 객체 생성
		PageHandler ph = new PageHandler(totalCnt, sc);

		// 관리자 여부 db에서 확인하기 + faq리스트 가져오기 : 서비스에서 구현
		boolean adminChk = faqService.adminChk((String) session.getAttribute("uId_Session"));
		List<FaqDto> list = faqService.getFaqList(sc, category);

		// 모델에 1. faq리스트, 2. 관리자 여부, 3. PageHandler 넣기
		m.addAttribute("faqList", list);
		m.addAttribute("adminChk", adminChk);
		m.addAttribute("ph", ph);

		return "faq";
	}

	@GetMapping("/write")
	public String showFaqWrite(int page, Model m) {
		// 목록으로 돌아가기 위한 page(페이지 번호) 받아서 넣기
		m.addAttribute("page", page);
		return "faqwrite";
	}

	@PostMapping("/write")
	public String createFaq(FaqDto faqDto, Model m) throws Exception{
		int no;
		// faqDto 내용 DB에 insert하기
		no = faqService.writeFaq(faqDto);
		
		if (no == 0) {
			m.addAttribute("faqDto", faqDto);
			return "redirect:/faq/write";
		}

		// list페이지로 이동
		return "redirect:/faq/bbs";
	}

	@DeleteMapping("/bbs")
	public String deleteFaq(int no) throws Exception {
		// no에 해당하는 게시글 삭제하기
		boolean result = faqService.deleteFaq(no);
		return "redirect:/faq/bbs";
	}
}
