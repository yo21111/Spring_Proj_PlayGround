package com.playground.pg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public String isLogin(String id, String Pw, String pn, HttpServletRequest request) throws Exception {

		// 로그인관련 서비스 
		boolean loginCk = lService.Login(id, Pw); // "로그인서비스.로그인메서드(String id String Pw)";
		// 메서드를 실행한 값을 boolean 으로 받는다
		
		if (loginCk) {
			HttpSession session = request.getSession();
			session.setAttribute("uId_Session", id);
			
			if (pn.equals("") || pn == null) {
				// 값이 true일 경우 메인페이지 이동
				return "redirect:/";
			} else {
				String refer = request.getHeader("REFERER");
				return "redirect:"+refer;
			}
		} else {
			return "login_error";
			// 값이 false 일경우 로그인페이지로 메세지 출력
		}

	}

	@GetMapping("/Logout")
	public String Logout(HttpSession session) {
		// 로그아웃 버튼클릭시

		session.invalidate();

		return "redirect:/";
	}

	@GetMapping("/Find")
	public String Findpage() {

		// 아이디 및 비밀 번호 찾기 클릭시 이동
		return "loginFind";

	}

	@PostMapping("/Find_phone")
	public String FindID_Phone(Model model, String name, String phone) throws Exception {
		// 아이디 찾기 버튼 클릭시
		String id = lService.SearchID_phone(name, phone);
		// sql에서 select에 사용하여 받는 아이디
		if(id == null) {
			return "login_error";
		}
		model.addAttribute("id", id);
		return "login_idFind";
	}

	@PostMapping("/Find_email")
	public String FindID_email(Model model, String name, String email) throws Exception {
		// 아이디 찾기 버튼 클릭시
		String id = lService.SearchID_email(name, email);
		// sql에서 select에 사용하여 받는 아이디
		if(id == null) {
			return "login_error";
		}
		model.addAttribute("id", id);
		return "login_idFind";
	}

	@PostMapping("/FindPw_email")
	public String FindPw_email(Model model, String id, String email) throws Exception {
		// 비밀번호 찾기 버튼 클릭시
		String SearchPw = lService.SearchPW(id, email);
		if(SearchPw == null) {
			return "login_error";
		}
		model.addAttribute("SearchPw", SearchPw);
		return "login_pwFind";
	}

	@PostMapping("/FindPw_phone")
	public String FindPw_phone(Model model, String id, String phone) throws Exception {
		// 비밀번호 찾기 버튼 클릭시
		String SearchPw = lService.SearchPW2(id, phone);
		if(SearchPw == null) {
			return "login_error";
		}
		model.addAttribute("SearchPw", SearchPw);
		return "login_pwFind";

	}

}
