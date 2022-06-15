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
<link rel="stylesheet" href="${urlInfo}css/sub_default.css">
<link rel="stylesheet" href="${urlInfo}css/login.css">
<!-- js -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="${urlInfo}script/sub_Query.js"></script>
    <script src="${urlInfo}script/myQuery.js"></script>

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
					<ul style="text-align:right;">
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
		<div class="login_page">
        <div class="center">
            <div class="title">
                <h2>로그인</h2>
            </div>
            <div class="login_container">
                <div class="sub_container">
                    고객님의 아이디는 ${id} 입니다.
                </div>
                <div class="login_btn">
                    <a href="/Login/Login" class="login two">로그인</a>
                    <a href="/Login/Find" class="pw">비밀번호 찾기</a>
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
</body>
<!-- <input type="button" value="중복 체크" id="id_button"> -->

</html>