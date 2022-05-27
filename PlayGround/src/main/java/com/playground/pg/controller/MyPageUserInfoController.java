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

import com.playground.pg.domain.MemberDto;
import com.playground.pg.service.MyPageUserInfoService;

@Controller
@RequestMapping("/mypage")
public class MyPageUserInfoController {
	@Autowired
	MyPageUserInfoService mpuiService;
	
	// 개인정보 변경 : 비밀번호 확인 페이지
	@GetMapping("/userpwchk")
	public String userPwCheck() {
		return "개인정보변경 비밀번호 확인 페이지";
	}
	
	// 개인정보 변경 : 비밀번호 확인
	@PostMapping("/userpwchk")
	public String userPwCheckProc(HttpSession session, String pw, Model m) throws Exception {
		String id = (String)session.getAttribute("uId_Session");
		
		// 해당 아이디에 해당하는 비밀번호가 아니라면
		if (!mpuiService.isMember(id, pw)) {
			String msg = "비밀번호가 일치하지 않습니다.";
			m.addAttribute("msg", msg);
			// 비밀번호 확인페이지로 이동
			return "redirect:/mypage/userpwchk";
			
		}
		
		return "redirect:/mypage/userupdate";
	}
	
	// 개인정보 변경 페이지
	@GetMapping("/userupdate")
	public String showUserUpdate(HttpSession session, Model m) throws Exception {
		String id = (String)session.getAttribute("uId_Session");
		
		// MemberDto 찾아서 모델에 넣기
		MemberDto mDto = mpuiService.findMember(id);
		m.addAttribute("MemberDto", mDto);
		
		return "개인정보 변경 페이지";
	}
	
	// 개인정보 업데이트
	@PutMapping("/userupdate")
	public String userUpdate(MemberDto mDto, Model m) throws Exception {
		
		// 개인정보 업데이트 하기
		mpuiService.updateMember(mDto);
		
		String msg = "개인정보를 변경하였습니다.";
		m.addAttribute("msg", msg);
		return "redirect:/mypage/userpwchk";
	}
	
	// 회원 탈퇴 페이지
	@GetMapping("/userdelete")
	public String showUserDelete() {
		return "회원 탈퇴 페이지";
	}
	
	// 회원 탈퇴
	@DeleteMapping("/userdelete")
	public String userDelete(HttpSession session) throws Exception {
		String id = (String)session.getAttribute("uId_Session");
		mpuiService.deleteMember(id);
		return "redirect:/";
	}
}
