package com.playground.pg.dao;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import com.playground.pg.domain.ArtDto;
import com.playground.pg.domain.ArtTimeDto;
import com.playground.pg.domain.MemberDto;
import com.playground.pg.domain.ReserveDto;
import com.playground.pg.domain.ReviewDto;
import com.playground.pg.service.AdArtService;
import com.playground.pg.service.JoinService;
import com.playground.pg.service.MyPageReviewService;
import com.playground.pg.service.MyPageUserInfoService;
import com.playground.pg.service.ReserveService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class ReviewServiceImplTest {
	@Autowired
	MyPageReviewService mprService;
	@Autowired
	JoinService jService;
	@Autowired
	MyPageUserInfoService mpuiService;
	@Autowired
	AdArtService aaService;
	@Autowired
	AdArtDao aaDao;
	@Autowired
	ReserveService rService;

	@Test
	public void serviceTest() throws Exception {
		int res = 0;

		// 1. 멤버 생성
		MemberDto mDto = createMember();
		res = jService.joinMember(mDto);
		assertTrue(res == 1);

		// 2. 작품 생성
		ArtDto aDto = makeArtDto();
		ArtTimeDto atDto = makeArtTimeDto();
		MockHttpSession session = new MockHttpSession();
		List<MultipartFile> list = new ArrayList<>();

		res = aaService.insOrUpdArt("insert", list, session, aDto, atDto);
		int exNo = aaDao.getMaxExNo();

		// 3. 작품 예매 정보 생성
		ReserveDto reDto = createReserve(exNo);
		
		boolean result = rService.insertReserve(reDto);
		assertTrue(result);

		// 4. 작품의 리뷰 작성 여부 확인
		Map<String, Object> map1 = mprService.reviewList("tester123", "");
		System.out.println("map : " + map1);
		int wrc1 = (int) map1.get("writeReviewCnt");
		int nwrc1 = (int) map1.get("notWriteReviewCnt");
		System.out.println("작성된 리뷰 갯수 : " + wrc1);
		assertTrue(wrc1 == 0);
		System.out.println("작성 안된 리뷰 갯수 : " + nwrc1);
		assertTrue(nwrc1 == 1);

		// 5. 리뷰 dto 생성
		// 부족한 정보 : 전시회 번호, 예매 일자
		ReviewDto rDto = createReview();
		rDto.setExNo(exNo);
		// 오늘 날짜 - 1일
		Date now = Date.valueOf(LocalDate.now().minusDays(1));
		rDto.setWriteDate(now);

		// 6. 리뷰 작성하기
		res = mprService.writeReview("tester123", rDto);
		System.out.println("ReviewDto : " + rDto);
		assertTrue(res == 1);

		// 7. 작품의 리뷰 작성 여부 확인
		Map<String, Object> map2 = mprService.reviewList("tester123", "");
		System.out.println("map : " + map2);
		int wrc2 = (int) map2.get("writeReviewCnt");
		int nwrc2 = (int) map2.get("notWriteReviewCnt");
		System.out.println("작성된 리뷰 갯수 : " + wrc2);
		assertTrue(wrc2 == 1);
		System.out.println("작성 안된 리뷰 갯수 : " + nwrc2);
		assertTrue(nwrc2 == 0);

		// 8. 확인 기간별 매개변수 넣어서 작동 여부 확인
		Map<String, Object> map3 = mprService.reviewList("tester123", "1M");
		assertTrue(map3.size() == 1);
		Map<String, Object> map4 = mprService.reviewList("tester123", "3M");
		assertTrue(map4.size() == 1);
		Map<String, Object> map5 = mprService.reviewList("tester123", "6M");
		assertTrue(map5.size() == 1);

		// 9. 멤버 삭제
		mpuiService.deleteMember("tester123");

		// 10. 작품 삭제
		res = aaService.deleteArt(exNo);
		assertTrue(res == 1);
	}

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

	public ReviewDto createReview() {
		ReviewDto rDto = new ReviewDto();

		rDto.setContent("정말 재미있는 전시입니다. 많은 분들께 추천드립니다.");
		rDto.setScore(3);

		return rDto;
	}

	public ArtDto makeArtDto() {
		ArtDto aDto = new ArtDto();
		aDto.setAllowNum(100);
		aDto.setExContent("content내용입니다.");
		aDto.setExContent1("1번 콘텐트 입니다.");
		aDto.setExContent2("2번 콘텐트 입니다.");
		aDto.setExContent3("3번 콘텐트 입니다.");
		aDto.setExhall("파크홀");
		aDto.setExName("이번 전시회의 이름");
		aDto.setExState("A");
		aDto.setGenre("참여형");
		aDto.setGrade(0);
		aDto.setLocation("서울");
		aDto.setPrice1(15000);
		aDto.setPrice2(10000);
		return aDto;
	}

	public ArtTimeDto makeArtTimeDto() {
		ArtTimeDto atDto = new ArtTimeDto();
		atDto.setExDate1(Date.valueOf("2022-05-12"));
		atDto.setExDate2(Date.valueOf("2022-06-22"));
		atDto.setExTime1_1("10:00");
		atDto.setExTime1_2("12:00");
		atDto.setExTime2_1("12:00");
		atDto.setExTime2_2("14:00");
		atDto.setExTime3_1("14:00");
		atDto.setExTime3_2("16:00");
		return atDto;
	}

	public ReserveDto createReserve(int exNo) {
		ReserveDto resDto = new ReserveDto();
		// 일반 예약(쿠폰, 포인트 사용x)시 : 아이디, 작품번호, 관람날짜, 관람시간(시작), 관람시간(끝),
		// 어른매수, 아이매수(기본값 0), 결제금액, 결제날자(예약날짜), 예약번호
		// 포인트 or 쿠폰사용시 일반 예약에 포인트, 쿠폰 추가

		Date reDate = Date.valueOf(LocalDate.now().minusDays(1));
		resDto.setNo(1);
		resDto.setuId("tester123");
		resDto.setExNo(1);
		resDto.setReDate(reDate);
		resDto.setReTime1("11:00");
		resDto.setReTime2("13:00");
		resDto.setAdCnt(6);
		resDto.setChCnt(0);
		resDto.setPayment(360000);
		resDto.setPayDate(reDate);
		resDto.setCoupon(null);
		resDto.setPoint(0);
		
		return resDto;
	}
}
