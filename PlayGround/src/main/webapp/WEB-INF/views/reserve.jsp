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
  <title>reserve</title>
  <link rel="stylesheet" href="${urlInfo}css/style.css">
  <!-- <link rel="stylesheet" href="css/calendar.css"> -->
</head>

<body>
  <div id="wrap">
    <div class="center">
      <div class="page">
        <div class="ticket">
          <table>
            <tr>
              <td class="list">지역명</td>
              <td valgn="top" class="top">${artDto.location }</td>
              <td class="list">전시 제목</td>
              <td valgn="top" class="top">${artDto.exName }</td>
            </tr>
          </table>
        </div>
        <!-- 티켓끝 -->
        <!-- 달력시작 -->
        <div class="calendar">
          <div ng-app="app">
            <div ng-controller="MainController">
              <div class="wrapp">
                <flex-calendar options="options" events="events"></flex-calendar>
              </div>
            </div>
          </div>
        </div>
        <!-- partial -->
        <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.4.0/angular.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/angular-translate/2.7.2/angular-translate.js'></script>
        <script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="${urlInfo}script/script_reserve.js"></script>
        <script src="${urlInfo}script/reserve.js"></script>
        <form action="/reserve/pay" id="reserveFrm">
	        <div class="information">
	          <table>
	            <tr>
	              <td class="list" rowspan="3">
	                <span>${artDto.location }</span>
	                <br/>
	                <span>${artDto.exName }</span>
	              </td>
	              <td><span>${artTimeDto.exTime1_1}</span> ~ <span>${artTimeDto.exTime1_2}</span></td>
	              <td>
	                <div class="people">
	                입장 가능 인원 : <span>${artDto.allowNum}명</span> 예약 인원 : <span>${resCnt}명</span> 남은 인원 : <span>${artDto.allowNum-resCnt}명</span>
	              	</div>
	              <c:set var="chkNum" value="${artDto.allowNum-resCnt}"></c:set>
	              <c:choose>
	              	<c:when test="${chkNum eq 0}">
	              		<span>예약 불가</span>              		
	              	</c:when>
	              	<c:otherwise>
	              		<button class="reserve" type="button">예약 하기</button>
	              		<input type="hidden" value="${artDto.exNo}" />
	              		<input type="hidden" value="${artTimeDto.exTime1_1}" />
	              		<input type="hidden" value="${artTimeDto.exTime1_2}" />
	              		<input type="hidden" name="date" value="2022-06-14" />
	              	</c:otherwise>	
	              </c:choose>
	              </td>
	            </tr>
	            <tr>
	              <td><span>${artTimeDto.exTime2_1}</span> ~ <span>${artTimeDto.exTime2_2}</span></td>
	              <td>
	                <div class="people">
	                입장 가능 인원 : <span>${artDto.allowNum}명</span> 예약 인원 : <span>${resCnt}명</span> 남은 인원 : <span>${artDto.allowNum-resCnt}명</span>
	              	</div>
	              <c:set var="chkNum" value="${artDto.allowNum-resCnt}"></c:set>
	              <c:choose>
	              	<c:when test="${chkNum eq 0}">
	              		<span>예약 불가</span>              		
	              	</c:when>
	              	<c:otherwise>
	              		<button class="reserve" type="button">예약 하기</button>
	              		<input type="hidden" value="${artDto.exNo}" />
	              		<input type="hidden" value="${artTimeDto.exTime2_1}" />
	              		<input type="hidden" value="${artTimeDto.exTime2_2}" />
	              	</c:otherwise>	
	              </c:choose>
	              </td>
	            </tr>
	            <tr>
	              <td><span>${artTimeDto.exTime3_1}</span> ~ <span>${artTimeDto.exTime3_2}</span></td>
	              <td>
	                <div class="people">
	                입장 가능 인원 : <span>${artDto.allowNum}명</span> 예약 인원 : <span>${resCnt}명</span> 남은 인원 : <span>${artDto.allowNum-resCnt}명</span>
	              	</div>
				  <c:set var="chkNum" value="${artDto.allowNum-resCnt}"></c:set>
	              <c:choose>
	              	<c:when test="${chkNum eq 0}">
	              		<span>예약 불가</span>              		
	              	</c:when>
	              	<c:otherwise>
	              		<button class="reserve" type="button">예약 하기</button>
	              		<input type="hidden" value="${artDto.exNo}" />
	              		<input type="hidden" value="${artTimeDto.exTime3_1}" />
	              		<input type="hidden" value="${artTimeDto.exTime3_2}" />
	              	</c:otherwise>	
	              </c:choose>
	              </td>
	            </tr>
	          </table>
	        </div>
        </form>
      </div>
    </div>
  </div>
</body>

</html>