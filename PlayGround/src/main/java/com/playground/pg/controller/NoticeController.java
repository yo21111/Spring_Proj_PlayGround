package com.playground.pg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playground.pg.domain.NoticeDto;
import com.playground.pg.domain.SearchCondition;

@RequestMapping("/notice")
@Controller
public class NoticeController {
	@GetMapping("/bbs")
	public String showNotice(SearchCondition sc, Model m) {
		int totalCnt; //=  전체 글 갯수 db통해서 구하기
		
		//PageHandler ph = new PageHandler(totalCnt, sc);
		// 관리자 여부 db에서 확인하기 + 공지사항 리스트 가져오기 : 서비스에서 구현
		// 모델에 1. 공지사항리스트, 2. 관리자 여부, 3. PageHandler 넣기
		
		return "공지사항리스트";
	}
	
	@GetMapping("/board")
	public String showNoticePage(SearchCondition sc, int no, Model m) {
		//PageHandler ph = new PageHandler(totalCnt, sc);
		// 관리자 여부 db에서 확인하기 하여 boolean값 받기 아니라면 /bbs로 리턴
		// 모델에 1. 공지사항 Dto, 2. PageHandler 넣기, 3. readonly 값 넣기
		
		return "공지사항리스트";
	}
	
	@GetMapping("/write")
	public String showNoticeWrite(int page) {
		//목록으로 돌아가기 위한 page(페이지 번호) 받아서 넣기
		return "공지사항작성페이지";
	}
	
	@PostMapping("/write")
	public String createNotice(NoticeDto noticeDto, Model m) {
	  //noticeDto 내용 DB에 insert하기
	  //작성한 게시글의 글번호 받아와서 url에 붙히기
	  return "redirect:/notice/write?no="/*+no*/;
	}

	@GetMapping("/update")
	public String showNoticeUpdate(int page, int no) {
		//목록으로 돌아가기 위한 page(페이지 번호) 받아서 넣기
		// no 게시글 번호로 noticeDto를 가져와서 넣기
		return "공지사항작성페이지";
	}
	
	@PutMapping("/update")
	public String updateNotice(NoticeDto noticeDto, Model m) {
	  //noticeDto 내용 DB에 insert하기
	  //작성한 게시글의 글번호 받아와서 url에 붙히기
	  return "redirect:/notice/write?no="/*+no*/;
	}
	
	@DeleteMapping("/bbs")
	public String deleteNotice(int no, Model m) {
	 // no에 해당하는 게시글 삭제하기
	  return "redirect:/notice";
	}
}
