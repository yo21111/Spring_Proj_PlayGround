package com.playground.pg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.playground.pg.domain.MemberDto;
import com.playground.pg.service.JoinService;

@Controller
@RequestMapping("/Join")
public class JoinController {
	@Autowired
	JoinService jService;
	
	// 회원가입 페이지
	@GetMapping("/page")
	public String joinView() {
		return "회원가입페이지";
	}

	// 아이디 중복 체크 - ajax
	@PostMapping("/idCheck")
	@ResponseBody
	public ResponseEntity<String> idCheck(@RequestBody String id) {
		try {
			boolean check = jService.idCheck(id);
			// true : 이미 사용중인 아이디가 있음
			String result = (check == true) ? "N" : "Y";
			// 만약 중복 아이디가 있으면 "N" 없다면(사용 가능하면) "Y"
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("E", HttpStatus.BAD_REQUEST);
		}
	}

	// 인증번호 발송 - ajax
	@PostMapping("/certification")
	@ResponseBody
	public ResponseEntity<String> certification() {
		try {
			String answer = "인증번호 : ";
			
			// 인증번호 만들어서 answer 뒤에 붙히기
			answer += jService.certification();
			
			return new ResponseEntity<>(answer, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("오류가 발생하였습니다. 다시 시도해주세요.", HttpStatus.BAD_REQUEST);
		}
	}

	// 회원가입
	@PostMapping("/page")
	public String insertJoin(MemberDto memberDto) throws Exception {
		// 들어오는 값 : 아이디, 비밀번호, 이름, 생년월일(2022/05/26), 휴대폰번호, 이메일, 등급
		// 1. 유효성 검사
		// 2-1 검사 통과 못할 시 : 회원가입 페이지로 redirect
		// 2-2. 검사 통과 시 : MemberDTO DB에 insert
		// 회원 가입 감사 쿠폰 발급
		int result = jService.joinMember(memberDto);
		
		if (result == 0) {return "redirect:/Join/page";}
		
		return "메인페이지 or 로그인페이지";
	}

}
