package com.playground.pg.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Login")
public class LoginController {
	
	@PostMapping("/isLogin")
	public String isLogin(HttpServletRequest req, HttpServletResponse resp)throws Exception {
//	@오토와일드
// 로그인관련 서비스 
	 
    String user  = "로그인서비스.로그인메서드";	
//서비스 속 메서드가 실행되면 값을 반환받는다 	
//		
		
	//	if(user==admin){
//  req.setAtrribute("admin","true");	
	     
	     return "메인페이지";
	         //메인페이지 이동	
		

//  }else{
	     // req.setAtrribute("isLogin","true");
		
		//return"메인페이지"; 


	}
	@PostMapping("/id")
	public String SearchID(String name, String phone, String emali) {
		//아이디 찾을때 쓰는 값들 
		String ID = "로그인서비스.아이디찾기메서드 ";
		//sql에서 select에 사용하여 받는 아이디
		
		//req.setAtrribute("id",ID);
		return"아이디/비밀번호 찾기 페이지";
	}
	@GetMapping("/pw")
	public String SearchPw(String id, String phone, String email) {
	
		String PW = "로그인서비스.비밀번호찾기 메서드";
		//메서드 실행시 
		//select sql을 사용하여 비밀번호를 가져온다
	//	req.setAtrribute("pw",PW);
		return"아이디/비밀번호 찾기 페이지";
	}

	
	//비밀번호 변경은 마이페이지에서 하자고 퍼블리셔분이 얘기해주셧습니다
	//어떻게들 생각하시는지 몰라서 일단 만들었습니다.
	  @GetMapping("/changePW")
	  public String changePW(String Cgpw) {  //Change pw
	
	   //로그인서비스.비밀번호 변경메서드;
		  //update sql을 사용하여 input에 있는 값으로 바꾼다.
		  
		  //return"로그인페이지"  //만일 마이페이지가 아닌 아이디/비밀번호 찾기에서 할경우
		  return"마이페이지";
	  }
	  //s
	
}
