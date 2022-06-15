package com.playground.pg.dao;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ArtTimeDto;
import com.playground.pg.domain.InquiryDto;
import com.playground.pg.domain.MemberDto;
import com.playground.pg.domain.ReportDto;
import com.playground.pg.domain.ReserveDto;
import com.playground.pg.domain.ReviewDto;
import com.playground.pg.service.AdArtService;
import com.playground.pg.service.JoinService;
import com.playground.pg.service.MyPageReviewService;
import com.playground.pg.service.MyPageUserInfoService;
import com.playground.pg.service.MypageMainService;
import com.playground.pg.service.ReserveService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MyPageMainServiceTest {
	@Autowired
	ReserveService reserveService;

	@Autowired
	JoinService jService;

	@Autowired
	AdArtService aaService;
	
	@Autowired
	MyPageUserInfoService mpuiService;
	
	@Autowired
	AdArtDao aaDao;
	
	@Autowired
	MyPageReviewService mprService;
	
	@Autowired
	MypageMainService mmService;
	
	@Test
	public void serviceTest() throws Exception {
		
		// 1. 멤버 생성
		MemberDto mDto = createMember();
		int insertRes = jService.joinMember(mDto);
		System.out.println("MemberDto : "+mDto); 
		assertTrue(insertRes == 1);
		 
		// 2. 작품 생성
		ArtDto aDto = createArt();
		ArtTimeDto tDto = createArtTime();
		MockHttpSession session = new MockHttpSession();
		List<MultipartFile> list = new ArrayList<>();
		
		int artresult = aaService.insOrUpdArt("insert", list, session, aDto, tDto);
		int exNo = aaDao.getMaxExNo();
		System.out.println("aDto : " + aDto);
		assertTrue("작품 등록하기", artresult == 1);

		// 3. 작품 예매 정보 생성
		ReserveDto resDto = createReserve(exNo);
		boolean insertRes2 = reserveService.insertReserve(resDto);
		System.out.println("ReserveDto : " + resDto);
		assertTrue("예약하기 실행", insertRes2 == true);
		
		// 4. 리뷰 dto 생성
		// 부족한 정보 : 전시회 번호, 예매 일자
		ReviewDto rDto = createReview();
		rDto.setExNo_FK(exNo);
		// 오늘 날짜 - 1일
		Date now = Date.valueOf(LocalDate.now().minusDays(1));
		rDto.setWriteDate(now);

		// 5. 리뷰 작성하기
		int insRev = mprService.writeReview("tester123", rDto);
		System.out.println("작성된 리뷰 정보 : " + rDto);
		assertTrue(insRev == 1);
		
		// 6. 나의 이름 가져오기 확인
		String id = mDto.getId();
		String name = mDto.getName();
		String chkName = mmService.getMyName(id);
		assertTrue(chkName.equals(name));
		
		// 7. 나의 사용 가능한 쿠폰 개수 확인
		int chkCoupon = mmService.getCouponCnt(id);
		assertTrue(chkCoupon == 1);
		
		// 8. 나의 적립금 가져오기
		boolean insPoint = mmService.insPoint(id);
		assertTrue(insPoint);
		int chkPoint = mmService.getMyPoint(id);
		assertTrue(chkPoint == 3000);
		
		// 9. 3개월 이내 나의 예매 내역 리스트 가져오기 확인
		List<ReserveDto> chkRes = mmService.getResList(id);
		
		// 10. 예매한 작품 정보 리스트 가져오기
		List<ArtDto> chkArt = mmService.getArtList(id);
		
		// 11. 3개월 이내 나의 리뷰 내역 리스트 가져오기 확인
		List<ReviewDto> chkRev = mmService.getRevList(id);
		
		// 12. 생성했던 멤버 삭제하기
		int deleteRes = mpuiService.deleteMember(id);
		assertTrue(deleteRes == 1);
		
		// 13. 생성했던 작품정보 삭제하기
		int deleteArt = aaService.deleteArt(exNo);
		assertTrue(deleteArt == 1);
	}
	
		// 예약정보 더미용
		public ReserveDto createReserve(int exNo) {
			ReserveDto resDto = new ReserveDto();
			// 일반 예약(쿠폰, 포인트 사용x)시 : 아이디, 작품번호, 관람날짜, 관람시간(시작), 관람시간(끝),
			// 어른매수, 아이매수(기본값 0), 결제금액, 결제날자(예약날짜), 예약번호
			// 포인트 or 쿠폰사용시 일반 예약에 포인트, 쿠폰 추가
			String reDate = "20220422";
			resDto.setId_FK("tester123");
			resDto.setExNo_FK(exNo);
			resDto.setReDate(reDate);
			resDto.setReTime1("11:00");
			resDto.setReTime2("13:00");
			resDto.setAdCnt(6);
			resDto.setChCnt(0);
			resDto.setPayment(360000);
			resDto.setPayDate(reDate);
			resDto.setCoupon_FK(null);
			resDto.setPoint(0);
		
			return resDto;
		}
			
		// 회원정보 더미용
		public MemberDto createMember() {
			MemberDto mDto = new MemberDto();
			// 들어오는 값 : 아이디, 비밀번호, 이름, 생년월일(2022-05-26), 휴대폰번호, 이메일, 등급
			mDto.setId("tester123");
			mDto.setPw("abcde12345");
			mDto.setName("테스터");
			mDto.setBirth("2022-05-27");
			mDto.setPhone("01012341234");
			mDto.setEmail("tester123@naver.com");
		
			return mDto;
		}
		
		// 작품정보 더미용
		public ArtDto createArt() {
			ArtDto artDto = new ArtDto();
			// 들어오는 값 : 작품번호, 장소, 작품명, 작품설명, 전시홀명, 최대인원수, 가격, 등급(일반,성인),
			// 가격2(할인가?), 장르, 전시상태, 썸네일이미지, 메인이미지, 추가설명1,2,3
			artDto.setLocation("서울");
			artDto.setExName("해바라기전시회");
			artDto.setExContent("가나다라마바사아가나다라마바사아가나다라마바사아가나다라마바사아");
			artDto.setExhall("해바라기전시관");
			artDto.setAllowNum(25);
			artDto.setPrice1(78000);
		//	artDto.setPrice2(68000);
		//	artDto.setGrade(0);
			artDto.setGenre("현대미술");
			artDto.setExState("N");
			artDto.setThumbImg("img1.png");
			artDto.setMainImg("img2.png");
			artDto.setExContent1("test1");
			artDto.setExContent2("test2");
			artDto.setExContent3("test3");
		
			return artDto;
		}
		
		// 작품시간 더미용
		public ArtTimeDto createArtTime() {
			ArtTimeDto timeDto = new ArtTimeDto();
			// 들어오는 값 : 작품번호, 전시기간(시작), 전시기간(끝), 전시시간1, 전시시간2, 전시시간3
			Date exDate1 = new Date(122, 04, 01);
			Date exDate2 = new Date(122, 04, 27);
			timeDto.setExDate1(exDate1);
			timeDto.setExDate2(exDate2);
			timeDto.setExTime1_1("09:00");
			timeDto.setExTime1_2("11:00");
			timeDto.setExTime2_1("11:00");
			timeDto.setExTime2_2("13:00");
			timeDto.setExTime3_1("13:00");
			timeDto.setExTime3_2("15:00");
		
			return timeDto;
		}
		
		// 리뷰작성 더미용
		public ReviewDto createReview() {
			ReviewDto rDto = new ReviewDto();

			rDto.setContent("정말 재미있는 전시입니다. 많은 분들께 추천드립니다.");
			rDto.setScore(3);

			return rDto;
		}	
}
