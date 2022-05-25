package com.playground.pg.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Login")
public class LoginController {
	
	@GetMapping("/Login")
	public String Login() {
	    //메인페이지에서 로그인 버튼 클릭시 또는 아이디찾기 비밀번호 찾기 후클릭시 이동  
		
		return"로그인페이지";
	}
	
	
	@PostMapping("/isLogin")
	public String isLogin(String id, String Pw)throws Exception {
//	@오토와일드
// 로그인관련 서비스 
	 	
	        
	     boolean LoginCK="로그인서비스.로그인메서드(String id String Pw)";
      //메서드를 실행한 값을 boolean 으로 받는다
		 if(LoginCK) {
			 return"메인페이지 이동";
			 //값이 true일 경우 메인페이지 이동
		 }else {
			 return"redirect:/Login/Login?msg=아이디 또는 비밀번호를 확인해주세요";
			 //값이 false 일경우 로그인페이지로 메세지 출력
		 }
			 
	}
	

	@GetMapping("/Find")
	public String Findpage() {
		
	//아이디 및 비밀 번호 찾기 클릭시 이동
		return"아이디/비밀번호 찾기페이지";
		
	}
	
	
	
	@PostMapping("/Find_phone")
	public String FindID_Phone(Model model) {
		//아이디 찾기 버튼 클릭시  
		       String id  ="로그인 서비스.아이디찾기 메서드(String name, String phone )";
		//sql에서 select에 사용하여 받는 아이디
		  model.addAttribute("id", id);                              
		return"아이디/비밀번호 찾기 페이지";
	}
	

	@PostMapping("/Find_email")
	public String FindID_email(Model model) {
		//아이디 찾기 버튼 클릭시  
	       String id  ="로그인 서비스.아이디찾기 메서드(String name, String email )";
			//sql에서 select에 사용하여 받는 아이디
			  model.addAttribute("id", id);                              
			return"아이디/비밀번호 찾기 페이지";
	}
	
	
	@PostMapping("/pw")
	public String FindPw(Model model) {
	    //비밀번호 찾기 버튼 클릭시
		String PW = "로그인서비스.비밀번호찾기 메서드";
		//메서드가 실행되어 비밀번호값을 반환 받는다.
      String Pw= PW.substring(0,PW.length()-5);
      //PW를 잘라서 Pw대입
      String star = "*****";
     
       Pw.concat(star);
       //Pw에 star더하기
       model.addAttribute("PW", Pw);
		return"아이디/비밀번호 찾기 페이지";
	}
     
	

	  @PostMapping("/changePW")
	  public String changePW(String Cgpw) {  //Change pw
	  // 비밀번호 변경 클릭시
	     "로그인서비스.비밀번호 변경메서드(String Cgpw)";
		  //update sql을 사용하여 input에 있는 값으로 바꾼다.
		  
		
		  return"로그인페이지";
	  }
	  
	
}
