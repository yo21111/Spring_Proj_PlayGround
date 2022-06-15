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
                                <li class="sub_list"><a href="/faq/bbs">FAQ</a></li>
                                <li class="sub_list"><a href="/inquiry/board">1:1문의</a></li>
							</ul>
						</li>
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
				 <!-- //aside bar -->
				<form action="/mypage/userpwchk" method="post">
					<div class="persnal_con">
						<h2>개인정보변경/탈퇴</h2>
						<p>회원님의 개인정보를 소중하게 보호하려고 노력하고 있습니다. 비밀번호 확인 후 개인정보를 제공합니다.</p>
						<ul class="pw_wrap">
							<li class="title">비밀번호</li>
							<li><input type="password" name="pw"
								placeholder="비밀번호를 입력해주세요."></li>
						</ul>
						<div style="color:red;font-weight:bold;">${param.msg}</div>
						<div class="btn">
							<button type="submit">확인</button>
						</div>
					</div>
				</form>
			</div>
		</div>
    </div>