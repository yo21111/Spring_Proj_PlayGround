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
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link rel="stylesheet" href="${urlInfo}css/default.css">
  <link rel="stylesheet" href="${urlInfo}css/myreview.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="${urlInfo}script/script.js"></script>
  <script src="${urlInfo}script/mypage_review.js"></script>
</head>

<body>
  <div id="wrap">
    <header>
      <div class="center">
        <a href="/#container" class="logo">
          <span>PLAY</span>
          <span>GROUND</span>
        </a>

        <nav class="gnb">
          <ul class="main_menu">
            <li class="main_list"><a href="#">PLAY GROUND</a>
              <ul class="sub_menu">
                <li class="sub_list"><a href="#">현재 전시</a></li>
                <li class="sub_list"><a href="#">지난 전시</a></li>
                <li class="sub_list"><a href="#">예정 전시</a></li>
              </ul>
            </li>
            <li class="main_list"><a href="#">STORE</a>
            </li>
            <li class="main_list"><a href="#">BOARD</a>
              <ul class="sub_menu">
                <li class="sub_list"><a href="#">공지사항</a></li>
                <li class="sub_list"><a href="#">FAQ</a></li>
                <li class="sub_list"><a href="#">1:1문의</a></li>
              </ul>
            </li>
          </ul>
        </nav>
        <div class="quick_menu">
          <ul>
            <li><a href="login.html">LOGIN</a></li>
            <li><a href="/mypage/myPageHome">MY PAGE</a></li>
          </ul>
        </div>
      </div>
      <!-- </div> -->
    </header>
    <div class="center">
      <div id="top_button">
        <a href="#">
          <i class="material-icons" style="font-size:30px">vertical_align_top</i>
        </a>
      </div>
    </div>
    <div class="containts">
      <div class="center myp">
        <div class="menu_bar">
          <ul class="main_meun"><a href="/mypage/myPageHome">MY PAGE</a></ul>
          <ul class="main_list myt">
            <a class="main_title" href="/mypage/reList">MY TICKETS</a>
            <li class="sub_list"><a href="/mypage/reList">티켓예매목록</a></li>
          </ul>
          <ul class="main_list">
            <a class="main_title" href="">MY INFO</a>
            <li class="sub_list"><a href="/mypage/mycoupon?page=1">나의 쿠폰</a></li>
            <li class="sub_list"><a href="/mypage/mypoint?page=1">적립금</a></li>
            <li class="sub_list"><a href="/mypage/myreview?page=1">나의 리뷰</a></li>
            <li class="sub_list"><a href="/mypage/userupdate">개인정보변경/탈퇴</a></li>
          </ul>
        </div>
        <!-- 나의리뷰 -->
        <div class="my_review">
          <div class="title">
            나의 리뷰
          </div>
          <div class="review_tabs">
            <ul class="tabs">
              <li class="tab-link current" data-tab="tab-1">작성 가능한 리뷰</li>
              <li class="tab-link" data-tab="tab-2">작성 완료한 리뷰</li>

              <!-- <li class="tab-link" data-tab="tab-5">tab5</li> -->
            </ul>

            <div id="tab-1" class="tab-content current">
              <div class="all_date">
                <div class="period">
                  <ul>
                    <li class="1W"><a href="/mypage/myreview?page=1&term=1W">1주일</a></li>
                    <li class="1M"><a href="/mypage/myreview?page=1&term=1M">1개월</a></li>
                    <li class="3M"><a href="/mypage/myreview?page=1&term=3M">3개월</a></li>
                    <li class="6M"><a href="/mypage/myreview?page=1&term=6M">6개월</a></li>
                  </ul>
                </div>
<!-- 				   <form action="/mypage/search" name="search" method="get">
	                <div class="review_date">
	                  <div class="start_date">
	                    <input type="date" id="start" name="tripstart" value="" min="2017-01-01"
	                      max="2022-12-31">
	                     <input type="hidden" name=page value="1">
	                  </div>
	                  <span> ~ </span>
	                  <div class="end_date">
	                    <input type="date" id="end" name="tripend" value="" min="2017-01-01" max="2022-12-31">
	                  </div>
	                  <div class="search_button">
	                    <button id="searchBtn1" type="button">검색</button>
	                  </div>
	                </div>
                </form> -->
              </div>
			  <c:choose>
	           <c:when test="${notWriteReviewList.size() eq 0}">
	               <p>해당 기간내에 작성가능한 리뷰가 없습니다.</p>
	           </c:when>
	           <c:otherwise>
	                <p class="introText">최근 <span>${viewDate}</span>의 작성 가능한 리뷰 입니다.</p>
				<c:forEach var="resDto" items="${notWriteReviewList}" varStatus="status" >      							          
		        <c:forEach var="artDto" items="${notWriteArtList}">
	              <div class="review_list">
	                <div class="list_table">
		                  <table>
		                    <tr class="list_title">
		                      <td class="one">티켓정보</td>
		                      <td class="two">작성기간</td>
		                      <td class="two">리뷰작성</td>
		                    </tr>
		                    <tr class="list_content">
		                      <td class="one">
			                        <div class="ticket_img">
			                          <img src="${urlInfo}/image/${artDto.thumbImg}" alt="poster2">
			                        </div>
		                        <div class="ticket_text">
		                          <p>${artDto.exName}</p>
		                          <p>${artDto.location}</p>
		                         
		                          <c:set var="totalCnt" value="${resDto.adCnt + resDto.chCnt}" />
		                          <p><span class="payDate">${resDto.payDate}</span> | <c:out value="${totalCnt}매" /></p>
		                        </div>
		                      </td>
		                      <td class="two deadline">2022-06-17</td>
		                      <td class="two">
		                        <button class="open">리뷰작성</button>
		                      </td>
		                    </tr>
		                  </table>

                </div>
              </div>

              <!-- 팝업창 -->
              <form name=review action="/mypage/myreview" method="post">
	              <div class="popup_background">
	                <div class="popup_text">
	                  <div class="title">
	                    나의 리뷰
	                    <a href="#" class="close"></a>
	                  </div>
	                  <div class="hidden">
	                  <div class="ticket_make">
	                    <div class="img_text">
	                      <div class="ticket_img">
	                        <img src="${urlInfo}image/poster2_02.jpg" alt="poster">
	
	                      </div>
	                      <div class="ticket_text">
	                        <p>${notWriteArtList[status.current].exName}</p>
	                        <p>${notWriteArtList[status.current].location}</p>
	                        <c:set var="totalCnt" value="${notWriteArtList[status.current].adCnt + notWriteArtList[status.current].chCnt}" />
	                        <p>${notWriteArtList[status.current].payDate} | <c:out value="${totalCnt}매" /></p>
	                      </div>
	                    </div>
	                    <div class="ticket_date">
	                      2022-06-17
	                    </div>
	                  </div>
	                  <div class="evaluate review_text">
	                    <span class="red">*</span><span>전시는 어떠섰나요?</span>
	                    <img class="score" src="${urlInfo}image/empty.png" alt="empty">
	                    <img class="score" src="${urlInfo}image/empty.png" alt="empty">
	                    <img class="score" src="${urlInfo}image/empty.png" alt="empty">
	                    <img class="score" src="${urlInfo}image/empty.png" alt="empty">
	                    <img class="score" src="${urlInfo}image/empty.png" alt="empty">
	                    <input type="text" value="" readonly="readonly">
	                  </div>
	                  <div class="evaluate">
	                    <div class="sub_title">
	                      <span class="red">*</span><span>솔직한 상품 리뷰를 남겨주세요.</span>
	                    </div>
	                    <textarea name="content" id="review_letter" cols="30" rows="14" placeholder="특정인의 명예를 훼손하거나 저작권을 침해한 경우 개인정보를 호함한 경우 (연락처, 이메일, SNS, 주소 등) 상업적 목적이 담긴 경우는 블라인드처리 될 수 있습니다."></textarea>
	                 	<input type="hidden" name="exNo_FK" value=""> 
	                  </div>
	                  <div class="evaluate picture">
	                    <span class="red">*</span><span>사진파일 첨부하기</span>
	                    <div class="picture_add">
	                      <a href="#"><img src="${urlInfo}image/picture_add.png" alt="picture_add"></a>
	                      <a href="#"><img src="${urlInfo}image/picture_add.png" alt="picture_add"></a>
	                      <a href="#"><img src="${urlInfo}image/picture_add.png" alt="picture_add"></a>
	                      <a href="#"><img src="${urlInfo}image/picture_add.png" alt="picture_add"></a>
	                    </div>
	                    <div class="grey">사진은 10MB이하의 PNG, GIF, JPG 파일만 등록 가능합니다.</div>
	                  </div>
	                </div>
	                  <div class="attach_close">
	                    <div class="attach">
	                      <button type="button">리뷰 등록</button>
	                    </div>
	                    <div class="close">
	                      <a href="#">닫기</a>
	                    </div>
	                  </div>
	                </div>
	              </div>
              </form>
              <!-- //팝업창 -->
             	</c:forEach>
             	</c:forEach>
              </c:otherwise>                	
            </c:choose>

            </div>
            <div id="tab-2" class="tab-content">
              <div class="all_date">
                <div class="period">
                  <ul>
                    <li class="1W"><a href="/mypage/myreview?page=1&term=1W">1주일</a></li>
                    <li class="1M"><a href="/mypage/myreview?page=1&term=1M">1개월</a></li>
                    <li class="3M"><a href="/mypage/myreview?page=1&term=3M">3개월</a></li>
                    <li class="6M"><a href="/mypage/myreview?page=1&term=6M">6개월</a></li>
                  </ul>
                </div>
      <!--           <form action="/mypage/search" name="search2" method="get">
	                <div class="review_date">
	                  <div class="start_date">
	                    <input type="date" id="start2" name="tripstart" value="" min="2017-01-01"
	                      max="2022-12-31">
	                    <input type="hidden" name=page value="1">
	                  </div>
	                  <span> ~ </span>
	                  <div class="end_date">
	                    <input type="date" id="end2" name="tripend" value="" min="2017-01-01" max="2022-12-31">
	                  </div>
	                  <div class="search_button">
	                    <button id="searchBtn2" type="button">검색</button>
	                  </div>
	                </div>
                </form> -->
              </div>
              <div class="review_list">
                <p class="introText">최근 <span>${viewDate}</span>의 작성 리뷰 입니다.</p>
                <div class="list_table">
                	<c:choose>
                		<c:when test="${writeReviewList.size() eq 0}">
                			<p>해당 기간내에 작성한 리뷰가 없습니다.</p>
                		</c:when>
                		<c:otherwise>
                			<c:forEach var="resDto" items="writeReviewList">
			                  <table>
			                    <tr class="list_title">
			                      <td class="one">티켓정보</td>
			                      <td class="two">작성기간</td>
			                      <td class="two">리뷰작성</td>
			                    </tr>
			                    <tr class="list_content">
			                      <td class="one">
			                      	<c:forEach var="artDto" items="${writeArtList}">
				                        <div class="ticket_img">
				                          <img src="${urlInfo}image/${artDto.thumbImg}" alt="poster2">
				                        </div>
				                        <div class="ticket_text">
				                          <p>${artDto.exName}</p>
				                          <p>${artDto.location}</p>
				                          <c:set var="totalCnt" value="${resDto.adCnt + resDto.chCnt}" />
				                          <p><span class="payDate">${resDto.payDate}</span> | <c:out value="${totalCnt}매" /></p>
				                        </div>
			                      	</c:forEach>
			                      </td>
			                      <td class="two deadline">2022-06-17</td>
			                      <td class="two">
			                        <button>리뷰보기</button>
			                      </td>
			                    </tr>
			                  </table>
                          	</c:forEach>
                		</c:otherwise>
                	</c:choose>
                </div>
              </div>
              
<%--       <!-- 리뷰 확인/삭제용 팝업창 -->
              <form name=review action="/mypage/delete" method="post">
	              <div class="popup_background">
	                <div class="popup_text">
	                  <div class="title">
	                    나의 리뷰
	                    <a href="#" class="close"></a>
	                  </div>
	                  <div class="hidden">
	                  <div class="ticket_make">
	                    <div class="img_text">
	                      <div class="ticket_img">
	                        <img src="${urlInfo}image/poster2_02.jpg" alt="poster">
	
	                      </div>
	                      <div class="ticket_text">
	                        <p>우연히 웨스 앤더슨</p>
	                        <p>플레이그라운드</p>
	                        <p>2022-05-17 | 1매</p>
	                      </div>
	                    </div>
	                    <div class="ticket_date">
	                      2022-06-17
	                    </div>
	                  </div>
	                  <div class="evaluate review_text">
	                    <span class="red">*</span><span>전시는 어떠섰나요?</span>
	                  </div>
	                  <div class="evaluate">
	                    <div class="sub_title">
	                      <span class="red">*</span><span>솔직한 상품 리뷰를 남겨주세요.</span>
	                    </div>
	                    <textarea name="content" id="review_letter" cols="30" rows="14" placeholder="특정인의 명예를 훼손하거나 저작권을 침해한 경우 개인정보를 호함한 경우 (연락처, 이메일, SNS, 주소 등) 상업적 목적이 담긴 경우는 블라인드처리 될 수 있습니다."></textarea>
	                 	<input type="hidden" name="exNo_FK" value=""> 
	                  </div>
	                </div>
	                  <div class="attach_close">
	                    <div class="attach">
	                      <button type="button">리뷰 삭제</button>
	                    </div>
	                    <div class="close">
	                      <a href="#">닫기</a>
	                    </div>
	                  </div>
	                </div>
	              </div>
              </form>
              <!-- //팝업창 --> --%>
              
            </div>

          </div>
          <div class="next_page">
            <a class="next_page_icon" href="#"><img src="${urlInfo}image/pre.png" alt="pre"></a>
            <a href="#">1</a>
            <a href="#">2</a>
            <a href="#">3</a>
            <a href="#">4</a>
            <a class="next_page_icon" href="#"><img src="${urlInfo}image/next.png" alt="next"></a>
          </div>
        </div>
        <!-- //나의리뷰 -->
        
      </div>
    </div>
    <footer class="footer">
      <div class="center">
        <span>본 페이지는 상업적 목적이 아닌 개인 포트폴리오로 제작되었습니다.</span>
        <span class="copyright">Copyright ⓒ 2022.PLAY GROUND ALL rights reserved.</span>
      </div>
    </footer>
 </div>
</body>