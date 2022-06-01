<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script src="${urlInfo}mypage_userinfo.js"></script>

</head>

<body>
	<div id="wrap">
		<header>
			<div class="center">
				<!-- <div class="header_fix"> -->
				<!-- <div class="logo"> -->
				<a href="/" class="logo"> <span>PLAY</span> <span>GROUND</span>
				</a>
				<!-- <a href="#"><img src="image/logo.png" alt="logo"></a> -->
				<!-- </div> -->
				<nav class="gnb">
					<ul class="main_menu">
						<li class="main_list"><a href="/">PLAY GROUND</a>
							<ul class="sub_menu">
								<li class="sub_list"><a href="/exhibit/list?exState=N">현재
										전시</a></li>
								<li class="sub_list"><a href="/exhibit/list?exState=B">지난
										전시</a></li>
								<li class="sub_list"><a href="/exhibit/list?exState=A">예정
										전시</a></li>
							</ul></li>
						<li class="main_list"><a href="#">STORE</a></li>
						<li class="main_list"><a href="#">BOARD</a>
							<ul class="sub_menu">
								<li class="sub_list"><a href="#">공지사항</a></li>
								<li class="sub_list"><a href="#">FAQ</a></li>
								<li class="sub_list"><a href="#">1:1문의</a></li>
							</ul></li>
					</ul>
				</nav>
				<div class="quick_menu">
					<ul style="text-align: right;">
						<c:choose>
							<c:when test="${loginId eq null}">
								<a href="/Join/page" style="margin-right: 20px;">회원가입</a>
								<a href="/Login/Login">LOGIN</a>
							</c:when>
							<c:otherwise>
								<a href="/Login/Logout" style="margin-right: 20px;">LOGOUT</a>
								<a href="/mypage/myPageHome">MY PAGE</a>
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
						<a href="/mypage/myPageHome">MY PAGE</a>
					</ul>
					<ul class="main_list myt">
						<a class="main_title" href="mypage2.html">MY TICKETS</a>
						<li class="sub_list"><a href="mypage2.html">티켓예매목록</a></li>
					</ul>
					<ul class="main_list">
						<a class="main_title" href="">MY INFO</a>
						<li class="sub_list"><a href="mypage4.html">나의 쿠폰</a></li>
						<li class="sub_list"><a href="mypage8.html">적립금</a></li>
						<li class="sub_list"><a href="my_review.html">나의 리뷰</a></li>
						<li class="sub_list"><a href="/mypage/userpwchk">개인정보변경/탈퇴</a></li>
					</ul>
				</div>
				<!-- //aside bar -->
				<div class="persnal_con">
					<h2>개인정보변경/탈퇴</h2>
					<div class="sub_title">
						<h3>회원탈퇴 안내사항</h3>
					</div>
					<div class="reset_info">
						<ul>
							<li>- 회원 탈퇴 후에는 회원 정보가 영구삭제됩니다.</li>
							<li>- 회원 탈퇴 후에는 플레이그라운드 멤버십 혜택을 이용할 수 없습니다.</li>
							<li>- 탈퇴할 경우 현재 사용 중인 아이디로는 30일 이내 재가입이 불가능합니다.</li>

						</ul>
					</div>
					<ul class="pw_wrap">
						<li class="title">회원탈퇴</li>
						<li><input type="password"
							placeholder="본인 확인을 위하여 비밀번호를 입력해주세요."></li>
					</ul>
					<div class="check_wrap">
						<label for="ok" class="ok">안내사항을 확인했으며 이에 동의합니다.</label>
						<input type="checkbox" id="ok"> 
					</div>
					<div class="btn_2">
						<a href="/mypage/myPageHome">돌아가기</a> <button type="button" id="pop_up" class="open">탈퇴하기</button>

					</div>
					<div id="pop_bg" class="popup_background">
						<div class="overlayer">
							<div class="logo">
								<span class="logo_typ">PLAY</span> <span class="logo_typ">GROUND</span>
							</div>
							<div class="caution">
								<span>회원탈퇴를 진행하시겠습니까?</span>
								<p>
									탈퇴 시 고객님꼐서 보유하셨던 등급 혜택 및 쿠폰은 모두 소멸되어 이용이 불가합니다. <br>또한 탈퇴한
									계정 및 이용 내역은 복구할 수 없습니다.
								</p>
								<div class="btn_2">
									<a href="" id="back" class="close">돌아가기</a> <button type="button" id="deleteUser">탈퇴하기</button>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>