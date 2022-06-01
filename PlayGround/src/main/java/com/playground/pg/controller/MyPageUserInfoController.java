package com.playground.pg.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
		return "mypage_userInfo_pwChk";
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
		
		return "mypage_userInfo_userUpdate";
	}
	
	// 개인정보 업데이트
	@PostMapping("/userupdate")
	public String userUpdate(MemberDto mDto, HttpSession session) throws Exception {
		mDto.setId((String)session.getAttribute("uId_Session"));
		System.out.println("member : "+mDto);
		// 개인정보 업데이트 하기
		mpuiService.updateMember(mDto);
		
		return "redirect:/mypage/myPageHome";
	}
	
	// 회원 탈퇴 페이지
	@GetMapping("/userdelete")
	public String showUserDelete() {
		return "mypage_userInfo_userDelete";
	}
	
	// 회원 탈퇴
	@PostMapping("/userdelete")
	public String userDelete(HttpSession session) throws Exception {
		String id = (String)session.getAttribute("uId_Session");
		mpuiService.deleteMember(id);
		session.invalidate();
		return "redirect:/";
	}
}
