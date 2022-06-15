<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="loginId" value="${sessionScope.uId_Session}" />
<c:set var="urlInfo" value="/resources/" />
<c:set var="today" value="<%=new java.util.Date()%>" />
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
    <script src="${urlInfo}script/sub_Query.js"></script>
    <script src="${urlInfo}script/inquiry.js"></script>

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
                                <li class="sub_list"><a href="#">FAQ</a></li>
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
                    <li class="tab_btn"><a href="#">공지사항</a></li>
                    <li class="tab_btn"><a href="#">FAQ</a></li>
                    <li class="tab_btn on">1:1 문의</li>
                </ul>
                <!-- // 탭 -->
                <!-- 1:1 문의 -->
                
                <section class="tab_con view">
                    <div class="question">
                        <div class="form_wrap">
                        <form action="/inquiry/board" method="post">
                            <div class="row">
                                <ul class="label">
                                    <li>카테고리</li>
                                </ul>
                                <ul class="txt">
                                    <li>
                                        <select name="category" id="">
	                                        <option value="기타">- 선택 -</option>
	                                        <option value="전시·프로그램">전시·프로그램</option>
	                                        <option value="회원안내">회원안내</option>
	                                        <option value="위치·시설안내">위치·시설안내</option>
	                                        <option value="기타">기타</option>
                                    	</select>
                                    </li>
                                </ul>
                            </div>
                            <div class="row two">
                                <div>
                                    <ul class="label">
                                        <li>제목</li>
                                    </ul>
                                    <ul class="txt">
                                        <li>
                                            <input type="text" name="title" placeholder="제목을 입력해 주세요.">
                                        </li>
                                    </ul>
                                </div>
                                <div>
                                    <ul class="label">
                                        <li>게시일</li>
                                    </ul>
                                    <ul class="txt">
                                    	<c:set var="date">
                                    		<fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/>
                                    	</c:set>
                                        <li><input type="text" id="writeDate" name="writeDate" readonly="readonly" value="${date}" /></li>
                                    </ul>
                                    <input type="hidden" name="writer" value="loginId" />
                                </div>
                            </div>
<!--                             <div class="row three">
                                <ul class="label">
                                    <li>첨부파일</li>
                                </ul>
                                <ul class="txt">
                                    <li>
                                        <form action="">
                                            <input type="file" id="ex_file" placeholder="파일 선택">
                                            <label for="ex_file">파일 첨부</label>
                                        </form>
                                    </li>
                                </ul>
                            </div> -->

                                <textarea name="content" cols="175" rows="15"></textarea>
                            <div class="btn">
                                <!-- 등록하기, 다시쓰기 버튼을 input="submit"으로 만들어보았습니다,,, -->
                                    <label for="submit" class="submit">등록하기</label>
                                    <input type="submit" id="submit">
                                    <label for="cancel" class="submit">다시쓰기</label>
                                    <input type="reset" id="cancel"> 
                            </div>
						</form>
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