package com.playground.pg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playground.pg.dao.ArtDao;
import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ArtTimeDto;
import com.playground.pg.domain.ReserveDto;
import com.playground.pg.domain.SearchCondition;
import com.playground.pg.service.MyReserveService;

@Controller
@RequestMapping("/mypage")
public class MypageController_reserve {
	@Autowired
	MyReserveService mypageService;
	
		// 예매목록 페이지
		@GetMapping("/reList")
		public String showReList(HttpSession session, String date1, String date2, Model m) throws Exception {
			// 아이디, 검색 시작 날짜, 검색 종료 날짜 매개변수로 받기
			
			// 유저 아이디 가져오기
			String uId = (String) session.getAttribute("uId_Session");
			
			// 검색기간 사이의 예매 정보 리스트 가져오기
			List<ReserveDto> resList = mypageService.getResList(uId, date1, date2);
			
			// 예매한 작품정보 리스트 가져오기
			List<ArtDto> artList = mypageService.getArtList(uId, date1, date2);
			
			//모델에 예약정보 리스트 담기
			m.addAttribute("reserveList", resList);
			// 모델에 작품정보 리스트 담기
			m.addAttribute("artList", artList);
			
			return "예매목록페이지";
		}

		// 예매목록 상세 페이지
		@GetMapping("/reList_Detail")
		public String showReList_Detail(int reserveNo, Model m) throws Exception {
			// 예매번호 매개변수로 받기
			
			// 선택한 예매 정보(빈) 가져오기
			ReserveDto reserveDto = mypageService.getRes(reserveNo);
			
			// 예매한 작품 정보(빈) 가져오기
			ArtDto artDto = mypageService.getArt(reserveNo);
			
			// 모델에 예약정보 넣기
			m.addAttribute("reserveDto", reserveDto);
			// 모델에 작품정보 넣기
			m.addAttribute("artDto", artDto);
			
			return "예매상세페이지";
		}

		// 예매수정하기 (일정변경)
		@GetMapping("/scheduleUpdate")
		public String selectReserve(int exNo, Model m) throws Exception {
			// 예매 가능한 날짜 표시를 위해 작품번호 가져오기
			
			// 작품 정보(빈) 가져오기
			ArtDto artDto = mypageService.updateArt(exNo);
			// 작품 시간(빈) 가져오기
			ArtTimeDto artTimeDto = mypageService.updateTime(exNo);
			// 예약 인원 수 가져오기
			int resCnt = mypageService.getResCnt(exNo);
			
			// 모델에 작품 정보 넣기
			m.addAttribute("artDto", artDto);
			// 모델에 작품 시간 정보 넣기
			m.addAttribute("artTimeDto", artTimeDto);
			// 모델에 예약 인원 수 넣기
			m.addAttribute("resCnt", resCnt);
						
			return "일정변경 페이지";
		}
		
		// 예매수정하기 (일정변경)
		@PutMapping("/scheduleUpdate")
		public String updateReserve(ReserveDto reserveDto, String date,
				String time1, String time2) {

			// 수정할날짜로 DTO 수정하기
			boolean result = mypageService.updateReserve(reserveDto, date, time1, time2);
			
			return "redirect:/mypage/reList";
		}

		// 예매 환불 
		@PostMapping("/refund")
		public String Refund(ReserveDto reserveDto) throws Exception {
			
			// 예매번호 매개변수로 이용
			// ReserveDto에 delete
			boolean result = mypageService.deleteReserve(reserveDto);
			
			return "redirect:/마이페이지";
		}
		
}
