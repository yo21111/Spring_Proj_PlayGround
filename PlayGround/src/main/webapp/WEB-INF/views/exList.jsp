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
<link rel="stylesheet" href="${urlInfo}css/sub_default.css">
<link rel="stylesheet" href="${urlInfo}css/exhibition.css">
<!-- js -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="${urlInfo}script/script.js"></script>
<script src="${urlInfo}script/sub_Query.js"></script>

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
						<li class="main_list"><a href="#">PLAY GROUND</a>
							<ul class="sub_menu">
								<li class="sub_list"><a href="/exhibit/list?exState=N">현재
										전시</a></li>
								<li class="sub_list"><a href="/exhibit/list?exState=B">지난
										전시</a></li>
								<li class="sub_list"><a href="/exhibit/list?exState=A">예정
										전시</a></li>
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
		<!-- 전시 목록 -->
		<article class="exhibition">
			<!-- 탭 -->
			<div class="center">
				<c:choose>
					<c:when test="${param.exState eq 'N' }">
						<ul class="tab_bar">
							<li class="tab_menu on">오늘의 전시</li>
							<li class="tab_menu">지난 전시</li>
							<li class="tab_menu">예정 전시</li>
						</ul>
					</c:when>
					<c:when test="${param.exState eq 'B' }">
						<ul class="tab_bar">
							<li class="tab_menu">오늘의 전시</li>
							<li class="tab_menu on">지난 전시</li>
							<li class="tab_menu">예정 전시</li>
						</ul>
					</c:when>
					<c:when test="${param.exState eq 'A' }">
						<ul class="tab_bar">
							<li class="tab_menu">오늘의 전시</li>
							<li class="tab_menu">지난 전시</li>
							<li class="tab_menu on">예정 전시</li>
						</ul>
					</c:when>
				</c:choose>
			</div>
			<!-- // 탭 -->
			<!-- 오늘의 전시 -->
			<section class="tab_con ${view_N}">
				<div class="today center">

					<c:choose>
						<c:when test="${artList_N.size() eq 0}">
							<div class="txt_box">
								<div class="info">
									<span class="txt">진행 중인 전시가 없습니다.</span> <span class="today">오늘의
										전시를 기대해주세요!</span>
								</div>
								<div class="logo">
									<span>PLAY</span> <span>GROUND</span>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<c:forEach var="artDto_N" items="${artList_N}" varStatus="status">
								<div class="con_box">
									<div class="thumb">
										<img src="${urlInfo}image/${artDto_N.thumbImg}" alt="past">
									</div>
									<div class="info_box">
										<div class="info_wrap">
											<span class="title">플레이 그라운드 ${artDto_N.location}</span>

											<p class="name">${artDto_N.exName}</p>

											<p class="exp">${artDto_N.exContent}</p>
											<div class="info">
												<ul class="lable">
													<li>· 전시기간</li>
													<li>· 관람시간</li>
													<li>· 관람안내</li>
													<li>· 티켓가격</li>
												</ul>
												<ul class="text_info">
													<li>: ${artTimeList_N[status.index].exDate1} ~
														${artTimeList_N[status.index].exDate2}</li>
													<li>: ${artTimeList_N[status.index].exTime1_1} ~
														${artTimeList_N[status.index].exTime3_2} (입장마감 :
														${artDto_N.exContent1}) <span>* 매월 첫째 주 월요일 휴관 |
															공휴일은 정상개관</span>
													</li>
													<c:if test="${artDto_N.grade >= 19}">
														<li>: 청소년 관람 불가 전시입니다. (신분증을 필히 지참하여 주십시오.)</li>
													</c:if>
													<li>: 일반가(현장가) 성인 ${artDto_N.price1}원 | 할인가(온라인) 성인
														${artDto_N.price1 - 500}원</li>
												</ul>
											</div>
											<div class="btn_wrap">
												<a href="/exhibit/listView?exNo=${artDto_N.exNo}"
													class="btn one"><span>자세히 보기</span></a> <a href="#"
													class="btn two"><span>예매하기</span></a>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</c:otherwise>
					</c:choose>


				</div>

			</section>
			<!-- 지난 전시 1page-->
			<section class="tab_con ${view_B}">
				<div class="past center">
					<ul class="con_box">
						<c:choose>
							<c:when test="${artList_B.size() eq 0}">
								<div class="txt_box">
									<div class="info">
										<span class="txt">종료된 전시가 없습니다.</span> <span class="today">오늘의
											전시를 확인해주세요!</span>
									</div>
									<div class="logo">
										<span>PLAY</span> <span>GROUND</span>
									</div>
								</div>
							</c:when>
							<c:otherwise>
								<c:forEach var="artDto_B" items="${artList_B}"
									varStatus="status">
									<li><a href="#" class="thumb"> <img
											src="${urlInfo}image/${artDto_B.thumbImg}" alt="past">
											<div class="dark">
												<span>종료된 전시입니다.</span>
											</div>
									</a>
										<div class="info_box">
											<span class="title">${artDto_B.exName}</span>
												<span class="priod">${artTimeList_B[status.index].exDate1}
													~ ${artTimeList_B[status.index].exDate2}</span>
										</div></li>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</ul>
					<!-- <div class="pagenation">
						<ul>
							<li><a href="#"><i class="fa fa-angle-double-left"></i></a>
							</li>
							<li><a href="#"><i class="fa fa-angle-left"></i></a></li>
							<li><a href="#">1</a></li>
							<li><a href="exhibition_2_1.html">2</a></li>
							<li><a href="exhibition_2_1.html"><i
									class="fa fa-angle-right"></i></a></li>
							<li><a href="exhibition_2_1.html"><i
									class="fa fa-angle-double-right"></i></a></li>
						</ul>
					</div> -->
				</div>
			</section>


			<section class="tab_con ${view_A}">
				<div class="will center">
					<div class="txt_box">
						<c:choose>
							<c:when test="${artList_A.size() eq 0}">
								<div class="info">
									<span class="txt">진행 예정 전시가 없습니다.</span> <span class="today">오늘의
										전시를 확인해보세요!</span>
								</div>
								<div class="logo">
									<span>PLAY</span> <span>GROUND</span>
								</div>
							</c:when>
							<c:otherwise>
								<c:forEach var="artDto_A" items="${artList_A}"
									varStatus="status">
									<li><a href="#" class="thumb"> <img
											src="${urlInfo}image/${artDto_A.thumbImg}" alt="past">
											<div class="dark">
												<span>종료된 전시입니다.</span>
											</div>
									</a>
										<div class="info_box">
											<a href="#"> <span class="title">${artDto_A.exName}</span>
												<span class="priod">${artTimeList_A[status.index].exDate1}
													~ ${artTimeList_A[status.index].exDate2}</span>
											</a>
										</div></li>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</section>
		</article>
		<!-- //오늘의 전시 -->
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