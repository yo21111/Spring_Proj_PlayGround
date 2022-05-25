package com.playground.pg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ArtTimeDto;
import com.playground.pg.service.AdArtService;

@Controller
@RequestMapping("/admin")
public class AdminController_art {
	@Autowired
	AdArtService aaService;

	// 0. 관리자가 아닐시 메인페이지로 리턴 -> 서비스에 작성

	// ------------------------------ 게시글 관리 시작-----------------------------------
	// 1. 게시글 관리 목록 불러오기 , state : 현재 전시 상태
	@GetMapping("/artList")
	public String artManageList(String state, Model m) {
		// state가 없다면 "A"로 변경
		if (state == null) state = "A";
		
		// 게시글 목록 가져오기(리스트 2개 artDto, artTimeDto), state 기반으로 찾기

		// 모델에 게시글 목록(리스트 2개) 넣기

		return "게시글 관리 목록 페이지";
	}

	// 2. 게시글 목록에서 상태변경 클릭시
	@PutMapping("/state")
	public String changeState(String state, int exNo, String changeState) {
		// exNo 를 바탕으로 DB에서 현재 상태를 changeState로 바꾸기

		return "redirect:/admin/artList?state=" + state;
	}

	// 3. 게시글 상세페이지 보기 -> ListController 매핑으로 프론트에서 처리

	// 4. 게시글 작성하기 클릭 시
	@GetMapping("/artWrite")
	public String writeArt() {

		return "게시글 작성 페이지";
	}

	// 5. 게시글 수정하기 클릭 시
	@GetMapping("/artReWrite")
	public String reWriteArt(int exNo, Model m) {
		// exNo로 ArtDto 내용과 ArtTimeDto 내용 select 하기

		// 모델에 각 Dto 담기
		
		return "게시글 작성 페이지";
	}

	// 6. 게시글 작성완료 클릭 시 . todo -> insert, update 구분하기 위한 것
	@PostMapping("/artWrite")
	public String artWritePost(String todo, @RequestParam ArtDto artDto, @RequestParam ArtTimeDto artTimeDto,
			@RequestParam List<MultipartFile> multiFileList, HttpSession session) throws Exception {
		// 파일 업로드 + insert/update
		aaService.insOrUpdArt(todo, multiFileList, session, artDto, artTimeDto);
		
		return "redirect:/admin/artList?state=A";
	}

	// 7. 게시글 삭제하기 클릭 시
	@PostMapping("/artDelete")
	public String deleteArt(int exNo) {
		// exNo 에 해당 하는 게시글 삭제하기

		return "redirect:/admin/artList?state=N";
	}

	// ------------------------------ 게시글 관리 끝 ------------------------------------

}
