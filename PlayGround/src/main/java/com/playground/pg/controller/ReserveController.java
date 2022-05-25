package com.playground.pg.controller;

import java.util.HashMap;
import java.util.Map;

import org.checkerframework.checker.units.qual.m;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.playground.pg.domain.ReserveDto;
import com.playground.pg.service.ReserveService;

@Controller	//예약하기 컨트롤러
@RequestMapping("/reserve")
public class ReserveController {

	
	// 날짜 선택 페이지
	@GetMapping("/select")	// 조회x 선택 select 헷갈릴시 selDay or day로 변경
	public String selectDay(int no, Model m) {//작품번호 매개변수로 받기
		
		// 작품번호 이용하여 해당 작품관련 DTO 반환받기(작품제목, 전시장소 표시용)
		//ArtDto artDto = reserveService.getArt(no);
		//m.addAttribute("artDto", artDto);
		
		return "예매화면(날짜선택)";
		
	}
	
	// 결제 화면 페이지
	@GetMapping("/pay")
	public String payment(int no, String date, String time1, String time2, Model m) {
		// 작품번호, 선택한 날짜, 시간 매개변수로 받기
		

		// 작품번호 이용하여 해당 작품관련 DTO 반환받기(작품정보 표시용)		
		//ArtDto artDto = reserveService.getArt(no)
		//m.addAttribute("artDto", artDto);
		// 선택한 날짜, 시간 모델에 넣기
		m.addAttribute("date",date);
		m.addAttribute("date",time1);
		m.addAttribute("date",time2);
		
		return "결제페이지";
	}
	
	// 결제하기
	@PostMapping("/pay") // 결제하기
	public String order(ReserveDto reserveDto) {
		// ReserveDto에 작품번호, 선택날짜, 시작,종료시간, 어른매수, 아이매수, 가격, 포인트, 쿠폰 매개변수로 받기
		
		// reserveDTO에 내용 넣은 후 DB에 insert하기
		//boolean result = reserveService.insertReserve(reserveDto);
		
		return "redirect:결제완료 페이지";
	}
	
	
	
	
	
	
	// 예매수정하기(마이페이지 컨트롤러로 변경예정)
	@GetMapping("/update")
	public String selectReserve(String id, int no, Model m) {
		// 수정할 예매 번호 찾기 위해 아이디와 작품번호 전달 받기
		
		
		// 해당하는 reserveDTO 넣기
		//ReserveDto reserveDto = reserveService.getReserve(id, no);
		//m.addAttribute("reserveDto", reserveDto);
		
		return "예매수정페이지";
	}
	
	
	// 예매수정하기(마이페이지 컨트롤러로 변경예정)
	@PutMapping("/update")
	public String updateReserve(ReserveDto reserveDto) {
		// ReserveDTO 매개변수로 받기(수정한 날짜 업데이트)
		
		// 수정할날짜로 DTO 수정하기
		//boolean result = reserveService.updateReserve(resreveDto);
		
		
		return "redirect:/마이페이지/예매내역";		
	}
}















/*
 * package com.playground.pg.controller;
 * 
 * import java.util.HashMap; import java.util.Map;
 * 
 * import org.springframework.stereotype.Controller; import
 * org.springframework.util.MultiValueMap; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.servlet.ModelAndView;
 * 
 * @Controller //예약하기 컨트롤러
 * 
 * @RequestMapping("/reserve") public class ReserveController {
 * 
 * 
 * // 날짜 선택 페이지, 작품번호를 매개변수로 받아야합니다.(작품, 작품시간 DTO반환용)
 * 
 * @GetMapping("/select") // 조회x 선택 select 헷갈릴시 selDay or day로 변경 public
 * ModelAndView selectDay(
 * 
 * @RequestParam Map<String, String> params) {
 * 
 * //int no = params.get("작품번호");
 * 
 * Map<String, String> modelData = new HashMap<String, String>();//임시용 // 작품관련
 * DTO 서비스 통해 반환 후 모델에 넣기
 * 
 * return new ModelAndView("날짜선택페이지", modelData); // 예매화면 1,2
 * 
 * }
 * 
 * // select페이지에서 작품번호, 날짜, 시간 전달 받기
 * 
 * @GetMapping("/pay") // 결제 화면 public ModelAndView payment(
 * 
 * @RequestParam Map<String, String> params) {
 * 
 * // int no = params.get("작품번호"); // String date = params.get("선택날짜"); //
 * String time1 = params.get("시작시간"); // String time2 = params.get("종료시간");
 * 
 * Map<String, String> modelData = new HashMap<String, String>(); // 마이페이지 서비스에서
 * 쿠폰, 포인트 정보 조회 // 작품번호 이용 작품DTO 반환 return new ModelAndView("결제페이지",
 * modelData); // 예매화면 3 }
 * 
 * // 결제페이지에서 작품번호, 선택날짜, 시작,종료시간, 어른매수, 아이매수, 가격, 포인트, 쿠폰 매개변수로 받기
 * 
 * @PostMapping("/input") // 결제하기 public String order(
 * 
 * @RequestParam Map<String, String> params) {
 * 
 * // reserveDTO 내용 DB에 insert하기
 * 
 * return "redirect:결제완료 페이지"; }
 * 
 * @GetMapping("/update") public String updateReserve(int no, String uId) { //
 * 수정할 예매 번호 찾기 위해 아이디와 작품번호 전달 받기 // reserveDTO 넣기 }
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 */
