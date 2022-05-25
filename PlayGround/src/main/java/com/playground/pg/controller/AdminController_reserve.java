package com.playground.pg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playground.pg.domain.AdminReserveDto;

@Controller
@RequestMapping("/admin")
public class AdminController_reserve {
	// @Autowired
	// AdminService adminService;

	// 0. 관리자가 아닐시 메인페이지로 리턴 -> 서비스에 작성
	
	// 1-1. 예매 현황 관리 페이지
	// 매개변수 : 검색 기간1, 검색 기간2, 검색 기준, 지역명, 작품명
	@GetMapping("/reserve")
	public String reserveManage(Model m, @ModelAttribute AdminReserveDto arDto) {
		// searchTF : 검색 관련 입력을 했는 지 유무 ("T" / "F")
		String searchTF = "F";
		
		boolean searchChk;// = 서비스에서 매개변수들을 가지고 가서 확인 
		
		//--------- 만약 검색관련 입력이 있다면 -------- 시작
		// 예매 테이블 정보 날짜 오름차순으로 select (between 검색기간 1, 검색기간 2)
		
		// 모델에 가져온 리스트 넣기
		
		// 검색 결과가 있으므로 searchTF 변경
		searchTF = "T";
		
		//--------- 만약 검색관련 입력이 있다면 -------- 끝
		
		// 전시 중인 작품들 작품명 select 해오기 : select, option 데이터 넣기용
		
		// 전시 중인 작품들 작품명 리스트 모델에 넣기

		// searchTF 값 모델에 넣기
		
		return "예매관리 페이지";
	}
	
	// 1-2. 예매 관리에서 취소 요청 -> 마이페이지에서 개인이 하는 것으로
	
	// 2. 예매현황 표 페이지
	// 매개변수 : 검색 기간1, 검색 기간2, 검색 기준, 지역명, 작품명
	@GetMapping("/reserve_table")
	public String reserveTable(Model m, @ModelAttribute AdminReserveDto arDto) {
		
		// searchTF : 검색 관련 입력을 했는 지 유무 ("T" / "F")
				String searchTF = "F";
				
				boolean searchChk;// = 서비스에서 매개변수들을 가지고 가서 확인 
				
				//--------- 만약 검색관련 입력이 있다면 -------- 시작
				// 예매 테이블 정보 날짜 오름차순으로 select (between 검색기간 1, 검색기간 2) - group by 일일단위
				
				// 모델에 가져온 리스트 넣기
				
				// 검색 결과가 있으므로 searchTF 변경
				searchTF = "T";
				
				//--------- 만약 검색관련 입력이 있다면 -------- 끝
				
				// 전시 중인 작품들 작품명 select 해오기 : select, option 데이터 넣기용
				
				// 전시 중인 작품들 작품명 리스트 모델에 넣기

				// searchTF 값 모델에 넣기
		
		return "예매현황 표 페이지";
	}
	
	// 3. 예매 현황 차트 페이지
	// 매개변수 : 검색 기간1, 검색 기간2, 검색 기준, 지역명, 작품명, 차트 조회기준, 차트 가로기준
	@GetMapping("/reserve_chart")
	public String reserveChart(Model m, @ModelAttribute AdminReserveDto arDto, String criteria1, String criteria2) {
		
		// searchTF : 검색 관련 입력을 했는 지 유무 ("T" / "F")
				String searchTF = "F";
				
				boolean searchChk;// = 서비스에서 매개변수들을 가지고 가서 확인 
				
				//--------- 만약 검색관련 입력이 있다면 -------- 시작
				// 차트 조회 기준, 차트 가로기준이 없다면 해당 페이지로 다시 돌아가기 : 메시지 주기?
				
				// 예매 테이블 정보 날짜 오름차순으로 select (between 검색기간 1, 검색기간 2)- group by 일일단위
				
				// 모델에 가져온 리스트 넣기
				
				// 검색 결과가 있으므로 searchTF 변경
				searchTF = "T";
				
				//--------- 만약 검색관련 입력이 있다면 -------- 끝
				
				// 전시 중인 작품들 작품명 select 해오기 : select, option 데이터 넣기용
				
				// 전시 중인 작품들 작품명 리스트 모델에 넣기

				// searchTF 값 모델에 넣기
		
		return "예매현황 차트 페이지";
	}
}
