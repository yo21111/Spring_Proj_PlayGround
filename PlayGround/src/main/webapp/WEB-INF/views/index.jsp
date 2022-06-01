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
<title>PLAY GROUND</title>

<!-- font awesome -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<!-- css -->
<link rel="stylesheet" href="${urlInfo}css/main.css">
<link rel="stylesheet" href="${urlInfo}css/default.css">
<!-- js -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
								<li class="sub_list"><a href="#">FAQ</a></li>
								<li class="sub_list"><a href="#">1:1문의</a></li>
							</ul></li>
					</ul>
				</nav>
				<div class="quick_menu">
					<ul>
							<c:choose>
								<c:when test="${loginId eq null}">
									<a href="/Join/page" style="margin-right:20px;"><li>회원가입</li></a>
									<a href="/Login/Login"><li>LOGIN</li></a>
								</c:when>
								<c:otherwise>
									<a href="/Login/Logout" style="margin-right:20px;"><li>LOGOUT</li></a>
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
		<!-- 메인 시작 -->
		<div class="main">
			<img src="${urlInfo}image/main.jpg" class="back" alt="main">
			<div class="slide_icon">
				<img src="${urlInfo}image/slide.png" alt="slide">
				<div class="slide_ball"></div>
			</div>
		</div>
		<!-- 메인끝 -->
		<!-- 오늘의 전시 -->
		<article id="container">
			<div class="exhibition">
				<div class="center">
					<div class="title_box">
						<h2>오늘의 전시</h2>
						<span>현재 진행 중인 전시를 만나보세요!</span>
					</div>
				</div>
				<div class="exhibition_wrap">
					<div class="center">


						<!-- -------------------------------반복 구역 시작------------------------------- -->
						<c:forEach var="artDto" items="${artList}" varStatus="status">
							<c:set var="two" value="two" />
							<c:if test="${status.index % 2 == 0}">
								<c:set var="two" value="" />
							</c:if>
							<div class="box ${two}">
								<input type="hidden" value="${artDto.exNo}"> <img
									src="${urlInfo}image/${artDto.thumbImg}" alt="poster">
								<div class="info_box">
									<div class="info_wrap">
										<div class="txt_box">
											<span class="title"> ${artDto.exName} </span>
											<p>${artDto.exContent}</p>
										</div>
										<div class="btn_box">
											<a href="#">바로 예매</a> <a href="/exhibit/listView?exNo=${artDto.exNo}">자세히
												보기</a>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
						<!-- -------------------------------반복 구역 끝------------------------------- -->
					</div>
				</div>
			</div>

		</article>
		<!-- //오늘의 전시 -->
		<!-- 큐레이터 -->
		<article class="container">
			<div class="center">
				<div class="container_title">
					<h2>큐레이터와의 만남</h2>
					<p>전시를 즐기는 새로운 경험!</p>
				</div>
				<div class="cur_con">
					<div class="cur_con_text">
						<h2>QR 도슨트</h2>
						<p>
							조용하고 여유로운 관람을 원한다면<br> 전시장 곳곳에 배치된 QR 도슨트로<br> 주요 작품을
							스페셜하게 만나보세요!
						</p>
					</div>
					<div class="cur_con_pic">
						<img src="${urlInfo}image/curator.png" alt="curator">
					</div>
				</div>
			</div>
		</article>
		<!-- // 큐레이터 -->
		<!-- 스토어 -->
		<article class="container store">
			<div class="center">
				<div class="container_title">
					<h2>스토어</h2>
					<p>7월 중순 오픈예정서비스 입니다.</p>
				</div>
				<div class="store_con">
					<section>
						<div class="circle">
							<img src="${urlInfo}image/store1.png" alt="icon">
						</div>
						<div class="store_text">
							<h2>주문은 집에서 간편하게,</h2>
							<p>
								이제는 집에서 손쉽게<br> 구매할 수 있어요!
							</p>
						</div>
					</section>
					<section>
						<div class="circle">
							<img src="${urlInfo}image/store2.png" alt="icon">
						</div>
						<div class="store_text">
							<h2>고민할 필요 없이,</h2>
							<p>
								인터넷으로 주문한 상품을<br> 전시회장에서 편하게<br> 픽업할 수 있어요!
							</p>
						</div>
					</section>
					<section>
						<div class="circle">
							<img src="${urlInfo}image/store3.png" alt="icon">
						</div>
						<div class="store_text">
							<h2>남들보다 빠르게,</h2>
							<p>
								새로 나온 상품을 제일 먼저<br> 확인할 수 있어요!
							</p>
						</div>
					</section>
				</div>
		</article>
		<!-- // 스토어 -->
		<!-- 오시는 길 -->
		<article class="container">
			<div class="map">
				<div class="center">
					<div class="title_box">
						<h2>오시는 길</h2>
						<span>즐겁고 유익한 문화공간, 플레이 그라운드로 오세요!</span>
					</div>
				</div>

				<div class="map_wrap">
					<div class="center">
						<div class="txt_box">
							<div class="address">
								<span class="line"></span> <span class="title">플레이 그라운드</span>
								<div class="info">
									<ul>
										<li class="icon"><i class="material-icons">place</i></li>
									</ul>
									<ul class="text">
										<li>서울특별시 종로구 자하문로 6길 18-8 (통의동) 플레이 그라운드</li>
										<li>18-8, Jahamun-ro 6-fil, Jongno-gu, Seoul, Republic of
											Korea</li>
									</ul>
								</div>
							</div>
							<div class="traffic">
								<span class="line"></span> <span class="title">교통편</span>
								<div class="info">
									<div class="col">
										<ul>
											<li class="icon"><i class="material-icons">directions_subway</i></li>
										</ul>
										<ul class="text">
											<li>지하철 : 3호선 경복궁역 3번 출구에서 도보 3분</li>
										</ul>
									</div>
									<div class="col">
										<ul>
											<li class="icon"><i class="material-icons">directions_bus</i></li>
										</ul>
										<ul class="text">
											<li>버스 : 종로 09 - 경복궁역(01-685) 하차 후 도보 2분</li>
										</ul>
									</div>
									<div class="col">
										<ul>
											<li class="icon"><i class="material-icons">directions_car</i></li>
										</ul>
										<ul class="text">
											<li>자가용 : 주차 불가 <span>* 가까운 공영주차장을 이용해 주시기 바랍니다.</span></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<div class="img_box">
							<img src="${urlInfo}image/map.png" alt="">
						</div>
					</div>
				</div>
			</div>

		</article>
		<!-- // 오시는 길 -->
		<!-- 빈공간 그냥 무시하셈 -->
		<div class="contact">
			<div class="center">
				<div class="email link">
					<a class="pic" href="${urlInfo}image/icon2-1.png"><img
						class="pic" src="${urlInfo}image/icon1-1.png" alt="email"> <!-- <img src="image/email.png" alt="email"> -->
						<div class="link_text">
							<p>playground@mawer.com</p>
						</div> </a>
				</div>
				<div class="sns link">
					<a class="pic" href="${urlInfo}image/icon2-2.png"><img
						class="pic" src="${urlInfo}image/icon1-2.png" alt="sns"> <!-- <img src="image/sns.png" alt="sns"> -->
						<div class="link_text">
							<p>outstagram.com/playground</p>
							<p>mytube.com/playground</p>
						</div> </a>
				</div>
				<div class="map link">
					<a class="pic map" href="${urlInfo}image/icon2-3.png"><img
						class="pic map" src="${urlInfo}image/icon1-3.png" alt="map">
						<!-- <img src="image/map.png" alt="map"> -->
						<div class="link_text">
							<p>플레이그라운드 OO</p>
							<p>서울 광진구 OO OO</p>
						</div> </a>
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
	</div>
</body>

</html>