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
				<a href="#" class="logo"> <span>PLAY</span> <span>GROUND</span>
				</a>
				<!-- <a href="#"><img src="image/logo.png" alt="logo"></a> -->
				<!-- </div> -->
				<nav class="gnb">
					<ul class="main_menu">
						<li class="main_list"><a href="#">PLAY GROUND</a>
							<ul class="sub_menu">
								<li class="sub_list"><a href="#">현재 전시</a></li>
								<li class="sub_list"><a href="#">지난 전시</a></li>
								<li class="sub_list"><a href="#">예정 전시</a></li>
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
								<a href="#" style="margin-right: 20px;"><li>회원가입</li></a>
								<a href="#"><li>LOGIN</li></a>
							</c:when>
							<c:otherwise>
								<a href="#" style="margin-right: 20px;"><li>LOGOUT</li></a>
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
						<a class="main_title" href="mypage2.html">MY TICKETS</a>
						<li class="sub_list"><a href="mypage2.html">티켓예매목록</a></li>
					</ul>
					<ul class="main_list">
						<a class="main_title" href="">MY INFO</a>
						<li class="sub_list"><a href="mypage4.html">나의 쿠폰</a></li>
						<li class="sub_list"><a href="mypage8.html">적립금</a></li>
						<li class="sub_list"><a href="my_review.html">나의 리뷰</a></li>
						<li class="sub_list"><a href="mypage5.html">개인정보변경/탈퇴</a></li>
					</ul>
				</div>
				
				<!-- //aside bar -->
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
                            <li><input type="password" placeholder="비밀번호를 입력해 주세요."></li>
                            <li><input type="password" placeholder="비밀번호를 재입력해 주세요.">
                                <ul class="hint">
                                    <li>10~14자 이상 영문, 숫자, 특수문자를 조합하여 입력해 주세요.</li>
                                </ul>
                            </li>
                            <li class="name_form">
                                <input type="text" placeholder="이름을 입력해 주세요." value="${MemberDto.name}">
                            </li>
                            <li class="birth">
                                <select name="year" id="" class="year">
                                	<c:forEach var="i" begin="1930" end="2022">
                               			<option value="${i}">${i}년</option>
                                	</c:forEach>
	                            </select>
                                <select name="month" id="" class="month">
	                                <c:forEach var="i" begin="1" end="12">
	                               		<option value="${i}">${i}월</option>
	                                </c:forEach>
	                            </select>
	                            <select name="" id="" class="day">
	                                <c:forEach var="i" begin="1" end="31">
	                               		<option value="${i}">${i}일</option>
	                                </c:forEach>                            
	                            </select>
	                                <li class="email">
	                                    <input type="text" class="id" placeholder="이메일">
	                                    <span>@</span>
	                                    <input type="text" class="address">
	                                    <select name="" id="">
	                                <option value="">직접입력</option>
	                                <option value="">naver.com</option>
	                                <option value="">nate.com</option>
	                            </select>
                                </li>
                            <li class="phone">
                                <input type="text" class="ph" placeholder="010">
                                <span>-</span>
                                <input type="text" class="ph" placeholder="0000">
                                <span>-</span>
                                <input type="text" class="ph" placeholder="0000">
                                <button class="confirm">인증번호 발송</button>
                                <ul class="code">
                                    <li>
                                        <input type="text" class="code" placeholder="인증번호를 입력해주세요.">
                                        <button class="confirm">인증확인</button>
                                    </li>
                                </ul>
                            </li>
                            <li class="agree">
                                <span>메일 수신동의</span>
                                <form class="sel_form">
                                    <div class="select">
                                        <input type="radio" name="sel" value="agree" id="agree" checked="checked">
                                        <label for="agree">수신함</label>
                                    </div>
                                    <div class="select">
                                        <input type="radio" name="sel" value="disagree" id="disagree">
                                        <label for="disagree">수신안함</label>
                                    </div>
                                </form>
                                <p> * 전시정보, 기타 다양한 정보를 빠르게 만나실 수 있습니다.</p>

                            </li>
                        </ul>
                    </div>
                    <a href="mypage7.html" class="reset">회원탈퇴</a>
                    <div class="btn_2">
                        <a href="">돌아가기</a>
                        <a href="">변경하기</a>

                    </div>
                </div>
            </div>
        </div>
    </div>