package com.playground.pg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playground.pg.service.LoginService;

@Controller
@RequestMapping("/Login")
public class LoginController {
	@Autowired
	LoginService lService;

	@GetMapping("/Login")
	public String Login(String pn) {
		// 메인페이지에서 로그인 버튼 클릭시 또는 아이디찾기 비밀번호 찾기 후클릭시 이동

		return "login";
	}

	@PostMapping("/isLogin")
	public String isLogin(String id, String Pw, String pn) throws Exception {

// 로그인관련 서비스 

		boolean LoginCK = lService.Login(id, Pw); // "로그인서비스.로그인메서드(String id String Pw)";
		// 메서드를 실행한 값을 boolean 으로 받는다

		if (LoginCK) {

			if (pn != null) {

				return "원래 있던 페이지 이동";
			}
			return "redirect:/";
			// 값이 true일 경우 메인페이지 이동

		} else {
			return "login_error";
			// 값이 false 일경우 로그인페이지로 메세지 출력
		}

	}

	@GetMapping("/Find")
	public String Findpage() {

		// 아이디 및 비밀 번호 찾기 클릭시 이동
		return "loginFind";

	}

	@PostMapping("/Find_phone")
	public String FindID_Phone(Model model) {
		// 아이디 찾기 버튼 클릭시
		String id = "로그인 서비스.아이디찾기 메서드(String name, String phone )";
		// sql에서 select에 사용하여 받는 아이디
		model.addAttribute("id", id);
		return "login_idFind";
	}

	@PostMapping("/Find_email")
	public String FindID_email(Model model) {
		// 아이디 찾기 버튼 클릭시
		String id = "로그인 서비스.아이디찾기 메서드(String name, String email )";
		// sql에서 select에 사용하여 받는 아이디
		model.addAttribute("id", id);
		return "login_idFind";
	}

	@PostMapping("/FindPw")
	public String FindPw(Model model) {
		// 비밀번호 찾기 버튼 클릭시
		String SearchPw = "로그인서비스.비밀번호찾기 메서드";

		model.addAttribute("SearchPw", SearchPw);
		return "login_pwFind";
	}

	@GetMapping("/ChangePw")
	public String ChangPw(String CP) {// ChangePw
		// 비밀번호 바꾸기 버튼클릭시

		// input hidden을 만들고 버튼 클릭시 Jquery 사용해서 값 주기
		return "아이디/비밀번호 찾기";
	}

	@PostMapping("/NewPw")
	public String NewPw(String id, String NPw) { // NewPw
		// 비밀번호 변경 클릭시
		// boolean result = "로그인서비스.비밀번호 변경메서드(String id, String NPw)";
		// update sql을 사용하여 input에 있는 값으로 바꾼다.

		// JSTL사용해서 아이디/비밀번호찾기에서 하겠습니다

		return "로그인페이지";
	}

}
