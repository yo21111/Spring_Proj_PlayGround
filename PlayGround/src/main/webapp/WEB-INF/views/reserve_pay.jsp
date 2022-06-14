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
  <title>예매하기</title>
  <link rel="stylesheet" href="${urlInfo}css/sub01.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="${urlInfo}script/sub01.js"></script>
</head>

<body>
  <div id="wrap">
    <div class="center">
      <form action="/reserve/pay" id="payFrm" method="post">
      <div class="page">
        <div class="left_text">
        <c:choose>
	        <c:when test="${artDto.grade >= 19}">
		          <div class="left">
		            <span>성인 (20세 이상)</span>
		            <div class="price_count">
		              <div class="price">
		                <span>${artDto.price1 }</span>원
		                <input type="hidden" id="ticketPrice" value="${artDto.price1 }">
		              </div>
		              <div class="count">
		                <select name="adCnt" id="items1">
		                  <option value="0">0매</option>
		                  <option value="1">1매</option>
		                  <option value="2">2매</option>
		                  <option value="3">3매</option>
		                  <option value="4">4매</option>
		                </select>
		              </div>
		            </div>
		          </div>
	          </c:when>
	          <c:otherwise>
		          <div class="left">
		            <span>성인 (20세 이상)</span>
		            <div class="price_count">
		              <div class="price">
		                <span>${artDto.price1 }</span>원
		                <input type="hidden" id="ticketPrice" value="${artDto.price1 }">
		              </div>
		              <div class="count">
		                <select name="adCnt" id="items1">
		                  <option value="0">0매</option>
		                  <option value="1">1매</option>
		                  <option value="2">2매</option>
		                  <option value="3">3매</option>
		                  <option value="4">4매</option>
		                </select>
		              </div>
		            </div>
		          </div>
				  <div class="left">
		            <span>아동/청소년</span>
		            <div class="price_count">
		              <div class="price">
		                <span>${artDto.price2 }</span>원
		                <input type="hidden" id="ticketPrice2" value="${artDto.price2 }">
		              </div>
		              <div class="count">
		                <select name="chCnt" id="items3">
		                  <option value="0">0매</option>
		                  <option value="1">1매</option>
		                  <option value="2">2매</option>
		                  <option value="3">3매</option>
		                  <option value="4">4매</option>
		                </select>
		              </div>
		            </div>
		          </div>               
	          </c:otherwise>
          </c:choose>
          <div class="text">
            <ul> <span>* 주의 사항</span>
              <li>취소 기한은 방문 전날 까지만 가능합니다.</li>
              <li>결제는 현장에서 진행 됩니다.</li>
              <li>성인 전시회의 경우 아동/청소년은 입장이 불가합니다.</li>
              <li>그 외 추가 사항 있을 시 추가 기재</li>
            </ul>
          </div>
        </div>
        <div class="right">
          <table>
            <tr>
              <td rowspan="5" class="image">${artDto.thumbImg }</td>
              <td class="one">장소 명</td>
              <td>
              	<span>${artDto.location }</span>
              </td>
              
            </tr>
            <tr>
              <!-- <td></td> -->
              <td class="one">작품 제목</td>
              <td><span>${artDto.exName }</span></td>
            </tr>
            <tr>
              <!-- <td></td> -->
              <td class="one">선택 일자</td>
              <td><span>${date}</span></td>
            </tr>
            <tr>
              <!-- <td></td> -->
              <td class="one">관람 시간</td>
              <td><span>${time1}~${time2}</span></td>
            </tr>
            <tr>
              <!-- <td></td> -->
              <td class="one">관람 등급</td>
              <td>
              <c:choose>
              	<c:when test="${artDto.grade >= 19 }">
              		<span>성인</span>
              	</c:when>
              	<c:otherwise>
              		<span>전연령</span>
              	</c:otherwise>
              </c:choose>
              </td>
            </tr>
          </table>
          <h3>결제 정보</h3>
          <table>
            <tr>
              <td class="one bottom">티켓 가격</td>
              <td><span id="totTicketPrice">0,000</span>원</td>
            </tr>
            <tr>
              <td class="one bottom">포인트</td>
              <td>
                <button id="minus" type="button">-</button>
                <input id="usePoint" readonly value="0">
                <input type="hidden" id="frmPoint" name="point" value="" />
                <button id="plus" type="button">+</button>
                <span>포인트</span>
              </td>
            </tr>
            <tr class="last">
              <td class="one bottom">쿠폰</td>
              <td>
                <select name="coupon_FK" id="items2">
                  <option value="0">쿠폰</option>
                  <c:forEach var="coupon" items="${couponList }">
                  	<option value="${coupon.no}">${coupon.disRate}%</option>
                  </c:forEach>
                </select>
              </td>
            </tr>
          </table>
          <div class="right_text">
            * 10,000 포인트부터 이용 가능
            <br />
            (보유 포인트 : <span>${point }</span>원)
            <input type="hidden" id="totPoint" value="${point }">
          </div>
          <div class="total">
            <div class="total_title">
              총 결제금액
            </div>
            <div class="total_text">
              <span id="totalPrice">0,000</span>원
              <input type="hidden" id="allMoney" name="payment" value="" />
            </div>
          </div>

        </div>
      </div>
      <div class="button">
        <a href="#" class="back" id="cancel">이전 으로</a>
        <a href="#" class="next" id="reserve">예매 하기</a>
		<input type="hidden" name="exNo_FK" value="${artDto.exNo }" />
		<input type="hidden" name="reDate" value="20220615" />
		<input type="hidden" name="reTime1" value="${time1}" />
		<input type="hidden" name="reTime2" value="${time2}" />
		<input type="hidden" id="payDate" name="payDate" value="" />
		<input type="hidden" name="id_FK" value="loginId" />
      </div>
      <div class="popup_background">
        <div class="popup_text">
          <div class="title">
            예매가 완료 되었습니다.
          </div>
          <div class="text">
            예매 번호 : <span id="reserveNumber"></span> 
          </div>
          <div class="popup_button">
            <a href="#" class="main">메인으로</a>
            <a href="/mypage/reList" class="content">예약 내역</a>
          </div>
        </div>
      </div>
      </form>
    </div>
  </div>
</body>

</html>