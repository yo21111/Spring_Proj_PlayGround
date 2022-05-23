package com.playground.pg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playground.pg.domain.MemberDto;

@Controller
@RequestMapping("/Join")
public class JoinController {

	// 회원가입 페이지
	@GetMapping("/page")
	public String joinView() {
		return"회원가입페이지";
	}
	
	// 회원가입
	@PutMapping("/page")
	public String insertJoin(MemberDto memberDto) {
		// MemberDTO DB에 insert
		// 이름, 생년월일, 성별, 아이디, 비밀번호, 이메일, 주소, 휴대폰번호
		return "메인페이지 or 로그인페이지";
	}
	
}
