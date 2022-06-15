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
<link rel="stylesheet" href="${urlInfo}css/join.css">
<!-- js -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="${urlInfo}script/script.js"></script>
<script src="${urlInfo}script/mypage_userinfo.js"></script>

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
						<li class="sub_list"><a href="/mypage/myreview?page=1">나의 리뷰</a></li>
						<li class="sub_list"><a href="/mypage/userpwchk">개인정보변경/탈퇴</a></li>
					</ul>
				</div>

				<!-- //aside bar -->
				<form action="/mypage/userupdate" id="updateFrm" method="post">
					<div class="persnal_con">
						<h2>개인정보변경/탈퇴</h2>
						<div class="sub_title">
							<h3>회원정보</h3>
							<span>* 표시는 필수 입력 항목입니다.</span>
						</div>
						<div class="con">
							<ul class="label">
								<li>비밀번호<span> *</span></li>
								<li class="new_pw">새 비밀번호<span> *</span></li>
								<li class="name">이름<span> *</span></li>
								<li>생년월일<span> *</span></li>
								<li>이메일<span> *</span></li>
								<li class="ph">휴대폰 번호<span> *</span></li>
								<li>수신거부<span> *</span></li>
							</ul>

							<ul class="info">
								<li><input type="password" name="pw" id="pwInput"
									placeholder="비밀번호를 입력해 주세요."></li>
								<li><input type="password" id="pwChkInput"
									placeholder="비밀번호를 재입력해 주세요.">
									<ul class="hint">
										<li>10~14자 이상 영문, 숫자, 특수문자를 조합하여 입력해 주세요.</li>
									</ul></li>
								<li class="name_form"><input type="text"
									placeholder="이름을 입력해 주세요." name="name" id="nameInput">
								</li>
								<li class="birth"><input type="hidden" name="birth"
									id="birthInput"> <select id="birth_yearInput"
									class="year">
										<option value="">년도</option>
										<c:forEach var="i" begin="1930" end="2022">
											<option value="${i}">${i}년</option>
										</c:forEach>
								</select> <select id="birth_monthInput" class="month">
										<option value="">월</option>
										<c:forEach var="i" begin="1" end="12">
											<option value="${i}">${i}월</option>
										</c:forEach>
								</select> <select id="birth_dayInput" class="day">
										<option value="">일</option>
										<c:forEach var="i" begin="1" end="31">
											<option value="${i}">${i}일</option>
										</c:forEach>
								</select>
								<li class="email"><input type="hidden" name="email"
									id="emailInput"> <input type="text" class="id"
									id="email1" placeholder="이메일"> <span>@</span> <input
									type="text" class="address" id="email2"> <select
									id="emailDomain">
										<option value="">직접입력</option>
										<option value="naver.com">naver.com</option>
										<option value="nate.com">nate.com</option>
										<option value="google.com">google.com</option>
										<option value="daum.net">daum.net</option>
								</select></li>
								<li class="phone"><input type="hidden" name="phone"
									id="phoneInput"> <input type="hidden"
									id="certification"><input type="text" class="ph"
									placeholder="010" id="ph0" maxlength="3"> <span>-</span>
									<input type="text" class="ph" placeholder="0000" id="ph1"
									maxlength="4"> <span>-</span> <input type="text"
									class="ph" placeholder="0000" id="ph2" maxlength="4">
								</li>
								<li class="agree"><span>메일 수신동의</span>
									<div class="sel_form">
										<div class="select">
											<input type="radio" name="sel" value="agree" id="agree"
												checked="checked"> <label for="agree">수신함</label>
										</div>
										<div class="select">
											<input type="radio" name="sel" value="disagree" id="disagree">
											<label for="disagree">수신안함</label>
										</div>
									</div>
									<p>* 전시정보, 기타 다양한 정보를 빠르게 만나실 수 있습니다.</p></li>
							</ul>
						</div>
						<a href="/mypage/userdelete" class="reset">회원탈퇴</a>
						<div class="btn_2">
							<a href="/mypage/myPageHome">돌아가기</a>
							<button type="button" id="updateBtn">변경하기</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>