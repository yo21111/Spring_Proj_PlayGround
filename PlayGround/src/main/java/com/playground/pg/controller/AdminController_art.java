package com.playground.pg.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ArtTimeDto;

@Controller
@RequestMapping("/admin")
public class AdminController_art {
	// @Autowired
	// AdminService adminService;

	// 0. 관리자가 아닐시 메인페이지로 리턴 -> 서비스에 작성

	// ------------------------------ 게시글 관리 시작-----------------------------------
	// 1. 게시글 관리 목록 불러오기 , state : 현재 전시 상태
	@GetMapping("/artList")
	public String artManageList(String state, Model m) {
		// 게시글 목록 가져오기(리스트 2개 artDto, artTimeDto), state 기반으로 찾기

		// 모델에 게시글 목록(리스트 2개) 넣기

		return "게시글 관리 목록 페이지";
	}

	// 2. 게시글 목록에서 상태변경 클릭시
	@PostMapping("/state")
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
		
		// readonly 답기
		m.addAttribute("readonly", "readonly");
		
		return "게시글 작성 페이지";
	}

	// 6. 게시글 작성완료 클릭 시 . todo -> insert, update 구분하기 위한 것
	@PostMapping("/artWrite")
	public String artWritePost(String todo, @RequestParam ArtDto artDto, @RequestParam ArtTimeDto artTimeDto,
			@RequestParam List<MultipartFile> multiFileList, HttpSession session) {
		// img 이름 담을 배열
		String[] imgArr = new String[2];
		
		// 파일이 저장되는 위치
		String savePath = session.getServletContext().getRealPath("resources");
		String root = savePath + "\\" + "uploadFile";

		File fileCheck = new File(root);
		if (!fileCheck.exists())
			fileCheck.mkdirs();

		List<Map<String, String>> fileList = new ArrayList<>();

		for (int i = 0; i < multiFileList.size(); i++) {
			String originFile = multiFileList.get(i).getOriginalFilename();
			String ext = originFile.substring(originFile.lastIndexOf("."));
			String changeFile = UUID.randomUUID().toString() + ext;

			Map<String, String> map = new HashMap<>();
			map.put("originFile", originFile);
			map.put("changeFile", changeFile);
			
			// 배열에 저장되는 이름 저장하기
			imgArr[i] = changeFile;
			
			fileList.add(map);
		}

		// 파일 업로드
		try {
			for(int i = 0; i < multiFileList.size(); i++) {
				File uploadFile = new File(root + "\\" + fileList.get(i).get("changeFile"));
				multiFileList.get(i).transferTo(uploadFile);
			}
			
		} catch (IllegalStateException | IOException e) {
			// 만약 업로드 실패하면 파일 삭제
			for(int i = 0; i < multiFileList.size(); i++) {
				new File(root + "\\" + fileList.get(i).get("changeFile")).delete();
			}
			e.printStackTrace();
		}
		
		artDto.setThumbImg(imgArr[0]);
		artDto.setMainImg(imgArr[1]);
		
		//todo가 insert이면 서비스로 각 Dto 보내서 insert 하기
		
		//todo가 update면 서비스로 각 Dto 보내서 update 하기
		
		return "redirect:/admin/artList";
	}

	// 7. 게시글 삭제하기 클릭 시
	@PostMapping("/artDelete")
	public String deleteArt(int exNo) {
		// exNo 에 해당 하는 게시글 삭제하기

		return "redirect:/admin/artList";
	}

	// ------------------------------ 게시글 관리 끝 ------------------------------------

}
