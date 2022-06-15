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
    <title>오늘의 전시</title>
    <!-- font awesome -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- css -->
    <link rel="stylesheet" href="${urlInfo}css/main.css">
    <link rel="stylesheet" href="${urlInfo}css/sub_default.css">
    <!-- <link rel="stylesheet" href="../css/exhibition.css"> -->
    <link rel="stylesheet" href="${urlInfo}css/notice.css">
    <!-- js -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="${urlInfo}script/script.js"></script>
    <%-- <script src="${urlInfo}script/sub_Query.js"></script> --%>

</head>

<body>
    <div id="wrap">
        <header>
            <div class="center">
                <!-- <div class="header_fix"> -->
                <!-- <div class="logo"> -->
                <a href="/" class="logo">
                    <span>PLAY</span>
                    <span>GROUND</span>
                </a>
                <!-- <a href="#"><img src="image/logo.png" alt="logo"></a> -->
                <!-- </div> -->
                <nav class="gnb">
                    <ul class="main_menu">
                        <li class="main_list"><a href="/">PLAY GROUND</a>
                            <ul class="sub_menu">
                                <li class="sub_list"><a href="/exhibit/list?exState=N">오늘의 전시</a></li>
                                <li class="sub_list"><a href="/exhibit/list?exState=B">지난 전시</a></li>
                                <li class="sub_list"><a href="/exhibit/list?exState=A">예정 전시</a></li>
                            </ul>
                        </li>
                        <li class="main_list"><a href="#">STORE</a>
                            <!-- <ul class="sub_menu">
                <li class="sub_list"><a href="#"></a></li>
              </ul> -->

                        </li>
                        <li class="main_list"><a href="#">BOARD</a>
                            <ul class="sub_menu">
                                <li class="sub_list"><a href="#">공지사항</a></li>
                                <li class="sub_list"><a href="/faq/bbs">FAQ</a></li>
                                <li class="sub_list"><a href="/inquiry/board">1:1문의</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>
                <div class="top_header">

                    <ul>
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
                <!-- <div class="top_button"> -->
                <a href="#">
                    <i class="material-icons" style="font-size:30px">vertical_align_top</i>

                </a>
                <!-- </div> -->

            </div>
        </div>
        <!-- 탑버튼 끝 -->
        <!-- 전시 목록 -->
        <article class="notice">

            <div class="center">
                <ul class="tab_bar">
                    <li class="tab_btn">공지사항</li>
                    <li class="tab_btn on">FAQ</li>
                    <li class="tab_btn"><a href="/inquiry/board">1:1 문의</a></li>
                </ul>
                <!-- // 탭 -->
                <!-- FAQ-->
                <section class="tab_con view">
                    <div class="faq">
                        <div class="fitter_bar">
                            <ul class="fitter">
                                <li class="fitter_menu on">전체</li>
                                <li class="fitter_menu">전시·프로그램</li>
                                <li class="fitter_menu">회원안내</li>
                                <li class="fitter_menu">위치·시설안내</li>
                                <li class="fitter_menu">기타</li>
                            </ul>
                        </div>
                        <div class="search_bar">
                            <select name="" id="">
                            <option value="">제목</option>
                            <option value="">내용</option>
                        </select>
                            <form action="">
                                <input type="text" placeholder="검색어를 입력하세요">
                                <button><i class="fa fa-search"></i></button>
                            </form>
                        </div>
                        <div class="notice_con view">
                            <div class="total_bar">
                                <span>총 00건</span>
                                <span>Page : 1/2</span>
                            </div>
                            <div class="top_label">
                                <span class="num">No.</span>
                                <span class="cate">구분</span>
                                <span class="title">제목</span>
                                <span class="update">게시일</span>
                                <span class="view">조회수</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">16</span>
                                <span class="cate">전시·프로그램</span>
                                <span class="title">단체 관람 전 미술관 답사를 하고 싶습니다. 어떻게 신청할 수 있나요?</span>
                                <span class="update">2022-05-24</span>
                                <span class="view">55</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">15</span>
                                <span class="cate">전시·프로그램</span>
                                <span class="title">전시장에서 사진촬영이 가능한가요?</span>
                                <span class="update">2022-05-16</span>
                                <span class="view">95</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">14</span>
                                <span class="cate">전시·프로그램</span>
                                <span class="title">코로나 19로 인한 큐레이팅 서비스를 일시 중단합니다.</span>
                                <span class="update">2022-02-11</span>
                                <span class="view">122</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">위치·시설안내</span>
                                <span class="title">플레이 그라운드는 주차가 가능한가요?</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">위치·시설안내</span>
                                <span class="title">플레이 그라운드에 휠체어로 입장이 가능한가요?</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">회원안내</span>
                                <span class="title">아이디·비밀번호를 잊어버렸어요.</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">회원안내</span>
                                <span class="title">휴면 계정으로 전환됐어요. 어떻게 해야 하나요?</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">기타</span>
                                <span class="title">신용카드나 현금영수증 발급이 가능한가요?</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>
                            <div class="pagenation">
                                <ul>
                                    <li>
                                        <a href=""><i class="fa fa-angle-double-left"></i></a>
                                    </li>
                                    <li>
                                        <a href=""><i class="fa fa-angle-left"></i></a>
                                    </li>
                                    <li>
                                        <a href="">1</a>
                                    </li>
                                    <li>
                                        <a href="">2</a>
                                    </li>
                                    <li>
                                        <a href=""><i class="fa fa-angle-right"></i></a>
                                    </li>
                                    <li>
                                        <a href=""><i class="fa fa-angle-double-right"></i></a>
                                    </li>
                                </ul>
                            </div>

                        </div>
                        <div class="notice_con">
                            <div class="total_bar">
                                <span>총 00건</span>
                                <span>Page : 1/2</span>
                            </div>
                            <div class="top_label">
                                <span class="num">No.</span>
                                <span class="cate">구분</span>
                                <span class="title">제목</span>
                                <span class="update">게시일</span>
                                <span class="view">조회수</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">16</span>
                                <span class="cate">전시·프로그램</span>
                                <span class="title">단체 관람 전 미술관 답사를 하고 싶습니다. 어떻게 신청할 수 있나요?</span>
                                <span class="update">2022-05-24</span>
                                <span class="view">55</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">15</span>
                                <span class="cate">전시·프로그램</span>
                                <span class="title">전시장에서 사진촬영이 가능한가요?</span>
                                <span class="update">2022-05-16</span>
                                <span class="view">95</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">14</span>
                                <span class="cate">전시·프로그램</span>
                                <span class="title">코로나 19로 인한 큐레이팅 서비스를 일시 중단합니다.</span>
                                <span class="update">2022-02-11</span>
                                <span class="view">122</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">14</span>
                                <span class="cate">전시·프로그램</span>
                                <span class="title">예시 텍스트 입니다.</span>
                                <span class="update">2022-02-11</span>
                                <span class="view">122</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">14</span>
                                <span class="cate">전시·프로그램</span>
                                <span class="title">예시 텍스트 입니다.</span>
                                <span class="update">2022-02-11</span>
                                <span class="view">122</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">14</span>
                                <span class="cate">전시·프로그램</span>
                                <span class="title">예시 텍스트 입니다.</span>
                                <span class="update">2022-02-11</span>
                                <span class="view">122</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">14</span>
                                <span class="cate">전시·프로그램</span>
                                <span class="title">예시 텍스트 입니다.</span>
                                <span class="update">2022-02-11</span>
                                <span class="view">122</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">14</span>
                                <span class="cate">전시·프로그램</span>
                                <span class="title">예시 텍스트 입니다.</span>
                                <span class="update">2022-02-11</span>
                                <span class="view">122</span>
                            </div>
                            <div class="pagenation">
                                <ul>
                                    <li>
                                        <a href=""><i class="fa fa-angle-double-left"></i></a>
                                    </li>
                                    <li>
                                        <a href=""><i class="fa fa-angle-left"></i></a>
                                    </li>
                                    <li>
                                        <a href="">1</a>
                                    </li>
                                    <li>
                                        <a href="">2</a>
                                    </li>
                                    <li>
                                        <a href=""><i class="fa fa-angle-right"></i></a>
                                    </li>
                                    <li>
                                        <a href=""><i class="fa fa-angle-double-right"></i></a>
                                    </li>
                                </ul>
                            </div>

                        </div>
                        <div class="notice_con">
                            <div class="total_bar">
                                <span>총 00건</span>
                                <span>Page : 1/2</span>
                            </div>
                            <div class="top_label">
                                <span class="num">No.</span>
                                <span class="cate">구분</span>
                                <span class="title">제목</span>
                                <span class="update">게시일</span>
                                <span class="view">조회수</span>
                            </div>

                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">회원안내</span>
                                <span class="title">아이디·비밀번호를 잊어버렸어요.</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">회원안내</span>
                                <span class="title">휴면 계정으로 전환됐어요. 어떻게 해야 하나요?</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">회원안내</span>
                                <span class="title">예시 텍스트 입니다.</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">회원안내</span>
                                <span class="title">예시 텍스트 입니다.</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">회원안내</span>
                                <span class="title">예시 텍스트 입니다.</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">회원안내</span>
                                <span class="title">예시 텍스트 입니다.</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">회원안내</span>
                                <span class="title">예시 텍스트 입니다.</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">회원안내</span>
                                <span class="title">예시 텍스트 입니다.</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>

                        </div>
                        <div class="notice_con">
                            <div class="total_bar">
                                <span>총 00건</span>
                                <span>Page : 1/2</span>
                            </div>
                            <div class="top_label">
                                <span class="num">No.</span>
                                <span class="cate">구분</span>
                                <span class="title">제목</span>
                                <span class="update">게시일</span>
                                <span class="view">조회수</span>
                            </div>

                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">위치·시설안내</span>
                                <span class="title">플레이 그라운드는 주차가 가능한가요?</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">위치·시설안내</span>
                                <span class="title">플레이 그라운드에 휠체어로 입장이 가능한가요?</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">위치·시설안내</span>
                                <span class="title">예시 텍스트 입니다.</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">위치·시설안내</span>
                                <span class="title">예시 텍스트 입니다.</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">위치·시설안내</span>
                                <span class="title">예시 텍스트 입니다.</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">위치·시설안내</span>
                                <span class="title">예시 텍스트 입니다.</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">위치·시설안내</span>
                                <span class="title">예시 텍스트 입니다.</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">위치·시설안내</span>
                                <span class="title">예시 텍스트 입니다.</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>

                        </div>
                        <div class="notice_con">
                            <div class="total_bar">
                                <span>총 00건</span>
                                <span>Page : 1/2</span>
                            </div>
                            <div class="top_label">
                                <span class="num">No.</span>
                                <span class="cate">구분</span>
                                <span class="title">제목</span>
                                <span class="update">게시일</span>
                                <span class="view">조회수</span>
                            </div>

                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">기타</span>
                                <span class="title">신용카드나 현금영수증 발급이 가능한가요?</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">기타</span>
                                <span class="title">예시 텍스트 입니다.</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">기타</span>
                                <span class="title">예시 텍스트 입니다.</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">기타</span>
                                <span class="title">예시 텍스트 입니다.</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">기타</span>
                                <span class="title">예시 텍스트 입니다.</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>
                            <div class="notice_txt">
                                <span class="num">00</span>
                                <span class="cate">기타</span>
                                <span class="title">예시 텍스트 입니다.</span>
                                <span class="update">0000-00-00</span>
                                <span class="view">00</span>
                            </div>
                        </div>

                    </div>
                </section>
                
            </div>
        </article>
        <!-- //오늘의 전시 -->
        <footer class="footer">
            <div class="center">
                <span>본 페이지는 상업적 목적이 아닌 개인 포트폴리오로 제작되었습니다.</span>
                <span class="copyright">Copyright ⓒ 2022.PLAY GROUND ALL rights reserved.</span>
            </div>
        </footer>
    </div>
</body>

</html>