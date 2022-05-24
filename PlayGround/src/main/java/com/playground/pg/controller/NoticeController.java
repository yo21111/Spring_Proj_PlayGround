package com.playground.pg.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.playground.pg.domain.NoticeDto;
import com.playground.pg.domain.PageHandler;
import com.playground.pg.domain.SearchCondition;
import com.playground.pg.service.NoticeService;

@RequestMapping("/notice")
@Controller
public class NoticeController {
	@Autowired
	NoticeService noticeService;

	@GetMapping("/bbs")
	public String showNotice(HttpSession session, SearchCondition sc, Model m) throws Exception {
		// = 전체 글 갯수 db통해서 구하기
		int totalCnt = noticeService.getTotalCnt();

		PageHandler ph = new PageHandler(totalCnt, sc);
		// 관리자 여부 db에서 확인하기 + 공지사항 리스트 가져오기 : 서비스에서 구현
		boolean adminChk = noticeService.idAdmin((String) session.getAttribute("uId_Session"));
		List<NoticeDto> list = noticeService.getNoticeList(sc);

		// 모델에 1. 공지사항리스트, 2. 관리자 여부, 3. PageHandler 넣기
		m.addAttribute("noticeList", list);
		m.addAttribute("adminChk", adminChk);
		m.addAttribute("ph", ph);

		return "공지사항리스트";
	}

	@GetMapping("/board")
	public String showNoticePage(HttpSession session, SearchCondition sc, int no, Model m) throws Exception {
		// PageHandler ph = new PageHandler(totalCnt, sc);
		int totalCnt = noticeService.getTotalCnt();
		PageHandler ph = new PageHandler(totalCnt, sc);

		// 관리자 여부 db에서 확인하기 하여 boolean값 받기 아니라면 /bbs로 리턴
		boolean adminChk = noticeService.idAdmin((String) session.getAttribute("uId_Session"));
		if (!adminChk) {
			return "redirect:/notice/bbs";
		}

		NoticeDto noticeDto = noticeService.getNotice(no);
		// 모델에 1. 공지사항 Dto, 2. PageHandler 넣기, 3. readonly 값 넣기
		m.addAttribute("noticeDto", noticeDto);
		m.addAttribute("ph", ph);
		m.addAttribute("readonly", "readonly");

		return "공지사항페이지";
	}

	@GetMapping("/write")
	public String showNoticeWrite(int page) {
		// 목록으로 돌아가기 위한 page(페이지 번호) 받아서 넣기 -> EL ${param.page}
		return "공지사항작성페이지";
	}

	@PostMapping("/write")
	public String createNotice(@RequestParam NoticeDto noticeDto, @RequestParam MultipartFile file, HttpSession session)
			throws Exception {
		// noticeDto 내용 DB에 insert하기
		if (!file.isEmpty()) {

			String fileName = file.getOriginalFilename();
			String savePath = session.getServletContext().getRealPath("/resources/uploadFile/");

			file.transferTo(new File(savePath + fileName));

			noticeDto.setImg(fileName);
		}

		int no = noticeService.writeNotice(noticeDto);

		// 작성한 게시글의 글번호 받아와서 url에 붙히기
		return "redirect:/notice/board?no=" + no;
	}

	@GetMapping("/update")
	public String showNoticeUpdate(int page, int no, Model m) throws Exception {
		// 목록으로 돌아가기 위한 page(페이지 번호) 받아서 넣기
		// -> EL ${param.page}
		// no 게시글 번호로 noticeDto를 가져와서 넣기
		NoticeDto noticeDto = noticeService.getNotice(no);
		m.addAttribute("noticeDto", noticeDto);
		return "공지사항작성페이지";
	}

	@PutMapping("/update")
	public String updateNotice(@RequestParam NoticeDto noticeDto, @RequestParam MultipartFile file, HttpSession session)
			throws Exception {
		if (!file.isEmpty()) {

			String fileName = file.getOriginalFilename();
			String savePath = session.getServletContext().getRealPath("/resources/uploadFile/");

			file.transferTo(new File(savePath + fileName));

			noticeDto.setImg(fileName);
		}
		
		// noticeDto 내용 DB에 update하기
		int no = noticeService.updateNotice(noticeDto);
		// 작성한 게시글의 글번호 받아와서 url에 붙히기
		return "redirect:/notice/board?no=" + no;
	}

	@DeleteMapping("/bbs")
	public String deleteNotice(int no) throws Exception {
		// no에 해당하는 게시글 삭제하기
		noticeService.deleteNotice(no);
		return "redirect:/notice/bbs";
	}
}
