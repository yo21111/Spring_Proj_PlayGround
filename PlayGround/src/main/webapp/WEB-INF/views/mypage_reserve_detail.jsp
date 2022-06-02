<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="loginId" value="${sessionScope.uId_Session}" />
<c:set var="urlInfo" value="/resources/" />
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>mypage</title>

<!-- font awesome -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<!-- css -->
<link rel="stylesheet" href="${urlInfo}css/default.css">
<link rel="stylesheet" href="${urlInfo}css/mypage.css">
<!-- js -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="${urlInfo}script/script.js"></script>

</head>

<body>
	<div id="wrap">
		<header>
			<div class="center">
				<!-- <div class="header_fix"> -->
				<!-- <div class="logo"> -->
				<a href="/#container" class="logo"> <span>PLAY</span> <span>GROUND</span>
				</a>
				<!-- <a href="#"><img src="image/logo.png" alt="logo"></a> -->
				<!-- </div> -->
				<nav class="gnb">
					<ul class="main_menu">
						<li class="main_list"><a href="/">PLAY GROUND</a>
							<ul class="sub_menu">
								<li class="sub_list"><a href="/exhibit/list?exState=N">현재 전시</a></li>
								<li class="sub_list"><a href="/exhibit/list?exState=B">지난 전시</a></li>
								<li class="sub_list"><a href="/exhibit/list?exState=A">예정 전시</a></li>
							</ul></li>
						<li class="main_list"><a href="#">STORE</a> <!-- <ul class="sub_menu">
                <li class="sub_list"><a href="#"></a></li>
              </ul> --></li>
						<li class="main_list"><a href="#">BOARD</a>
							<ul class="sub_menu">
								<li class="sub_list"><a href="#">공지사항</a></li>
								<li class="sub_list"><a href="#">FAQ</a></li>
								<li class="sub_list"><a href="#">1:1문의</a></li>
							</ul></li>
					</ul>
				</nav>
				<div class="top_header">
					<ul>
						<c:choose>
							<c:when test="${loginId eq null}">
								<a href="/Join/page" style="margin-right: 20px;"><li>회원가입</li></a>
								<a href="/Login/Login"><li>LOGIN</li></a>
							</c:when>
							<c:otherwise>
								<a href="/Login/Logout" style="margin-right: 20px;"><li>LOGOUT</li></a>
								<a href="/myPage/myPageHome"><li>MY PAGE</li></a>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
			<!-- </div> -->
		</header>
		<!-- 탑버튼 시작 -->
		<div class="center">
			<div id="top_button">
				<a href="#"> <i class="material-icons" style="font-size: 30px">vertical_align_top</i>
				</a>
			</div>
		</div>
		<!-- 탑버튼 끝 -->
		<div class="containts">
			<div class="center myp">
				<div class="menu_bar">
					<ul class="main_meun">
						<a href="MY PAGE">MY PAGE</a>
					</ul>
					<ul class="main_list myt">
						<a class="main_title" href="/mypage/reList">MY TICKETS</a>
						<li class="sub_list"><a href="/mypage/reList">티켓예매목록</a></li>
					</ul>
					<ul class="main_list">
						<a class="main_title" href="">MY INFO</a>
						<li class="sub_list"><a href="/mypage/mycoupon?page=1">나의 쿠폰</a></li>
						<li class="sub_list"><a href="/mypage/mypoint?page=1">적립금</a></li>
						<li class="sub_list"><a href="/mypage/myreview?page=1">나의 리뷰</a></li>
						<li class="sub_list"><a href="/mypage/userpwchk">개인정보변경/탈퇴</a></li>
					</ul>
				</div>
				<div class="contents3">
          <h2 class="con_title">예매상세내역</h2>
          <fmt:formatDate var="reNo" value="${reserveDto.reDate }" pattern="yyyyMM"/>
          <p>예매번호 : ${reNo}****</p>
          <div class="con3_box">
            <div class="con3_box_thum">
              <a href="/exhibit/listView?exNo=${reserveDto.exNo_FK }"><img src="${urlInfo}image/${artDto.thumbImg}" alt="thum"></a>
            </div>
            <div class="con3_box_text">
              <h3>${artDto.exName}</h3>
              <ul>
                <li><strong>예매일시 :</strong>
                  <p>${reserveDto.reDate}</p>
                </li>
                <li><strong>예약매수 :</strong>
                  <p>${reserveDto.adCnt + reserveDto.chCnt}매</p>
                </li>
                <li><strong>장소 :</strong>
                  <p>PlayGround - ${artDto.location}</p>
                </li>
                <li><strong>예약상태 :</strong>
                  <p>예약완료</p>
                </li>
              </ul>
            </div>
          </div>
          <div class="board_view">
            <h2 class="con_title">결제정보</h2>
            <ul>
              <li><strong>티켓금액</strong>
                <p class="in_t"><span>${artDto.price1 * reserveDto.adCnt + artDto.price2 * reserveDto.chCnt}원</span></p>
              </li>
              <li><strong>결제금액</strong>
                <p class="in_t"><span>${reserveDto.payment}원</span></p>
              </li>
              <li><strong>매수</strong>
                <p class="in_t"><span>${reserveDto.adCnt + reserveDto.chCnt}매</span></p>
              </li>
              <li><strong>영수증</strong>
                <p class="in_t"><span>카드(현대/일시불)
                    결제일: ${reserveDto.payDate}</span></p>
              </li>
            </ul>
          </div>
          <div class="normal">
            <div class="normal_button">
              <a href="">일정변경</a>
              <a href="/mypage/reList_delete?reserveNo=${reserveDto.no}">예매취소</a>
            </div>
            <div class="normal_tilte">
              <h2 class="con_title">티켓목록</h2>
            </div>
            <div class="board_list">
              <table>
                <tr>
                  <!-- <input type="checkbox" name="chk_info" value="information" id="on"> -->
                  <th>티켓번호</th>
                  <th>매수</th>
                  <th>관람일</th>
                  <th>상태</th>
                  <th>가격</th>
                </tr>
              </table>
              <div class="board_list in">
                <table>
                  <tr>
                    <!-- <input type="checkbox" name="chk_info" value="information" id="on"> -->
                    <th>${reserveDto.reDate}***</th>
                    <th>${reserveDto.adCnt + reserveDto.chCnt}매</th>
                    <th>${reserveDto.reDate}</th>
                    <th>사용가능</th>
                    <th>${artDto.price1 * reserveDto.adCnt + artDto.price2 * reserveDto.chCnt}원</th>
                  </tr>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <footer class="footer">
      <div class="center">
        <span>본 페이지는 상업적 목적이 아닌 개인 포트폴리오로 제작되었습니다.</span>
        <span class="copyright">Copyright ⓒ 2022.PLAY GROUND ALL rights reserved.</span>
      </div>
    </footer>
  </div>