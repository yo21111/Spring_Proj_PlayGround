<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="loginId" value="${sessionScope.id}" />
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="${urlInfo}script/sub_Query.js"></script>
<script src="${urlInfo}script/myQuery.js"></script>

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
		<div class="login_page">
			<div class="center">
				<div class="title">

					<h2>로그인</h2>
				</div>
				<div class="login_center">
					<div class="id_find">
						<h2>아이디 찾기</h2>
						<form>
							<input class="name_form" type="text" placeholder="이름을 입력해주세요.">
						</form>
						<div class="select_wrap">
							<form class="sel_form">
								<div class="select on">
									<input type="radio" name="sel" value="email" id="email"
										checked="checked"> <label for="email">이메일</label>
								</div>
								<div class="select">
									<input type="radio" name="sel" value="phone" id="phone">
									<label for="phone">휴대폰 번호</label>
								</div>
							</form>

							<div class="form_box view" id="e_mail">
								<input class="id" type="text" placeholder="이메일"> <span>@</span>
								<input class="address" type="text"> <select name=""
									id="">
									<option value="typing">직접입력</option>
									<option value="naver">naver.com</option>
									<option value="nate">nate.com</option>
								</select>
							</div>
							<div class="form_box" id="ph">
								<input class="num" type="text" placeholder="010"> <span>-</span>
								<input class="num" type="text" placeholder="0000"> <span>-</span>
								<input class="num" type="text" placeholder="0000">
							</div>
						</div>
						<!--성공/오류시 페이지 걸어야합니다.-->
						<a href="" class="btn">아이디 찾기</a>
					</div>
					<div class="pw_find">
						<h2>비밀번호 찾기</h2>
						<form>
							<input class="name_form" type="text" placeholder="아이디를 입력해주세요.">
						</form>
						<div class="select_wrap">
							<form class="sel_form">
								<div class="select_1 on">
									<input type="radio" name="selec" value="e_mail" id="mail"
										checked="checked"> <label for="mail">이메일</label>
								</div>
								<div class="select_1">
									<input type="radio" name="selec" value="ph" id="call">
									<label for="call">휴대폰 번호</label>
								</div>
							</form>

							<div class="form_box view" id="email">
								<input class="id" type="text" placeholder="이메일"> <span>@</span>
								<input class="address" type="text"> <select name=""
									id="">
									<option value="typing">직접입력</option>
									<option value="naver">naver.com</option>
									<option value="nate">nate.com</option>
								</select>
							</div>
							<div class="form_box" id="phone">
								<input class="num" type="text" placeholder="010"> <span>-</span>
								<input class="num" type="text" placeholder="0000"> <span>-</span>
								<input class="num" type="text" placeholder="0000">
							</div>
						</div>
						<!--성공/오류시 페이지 걸어야합니다.-->
						<a href="" class="btn">비밀번호 찾기</a>
					</div>

				</div>
			</div>
		</div>
	</div>
	<footer class="footer">
		<div class="center">
			<span>본 페이지는 상업적 목적이 아닌 개인 포트폴리오로 제작되었습니다.</span> <span
				class="copyright">Copyright ⓒ 2022.PLAY GROUND ALL rights
				reserved.</span>
		</div>
	</footer>
</body>

</html>