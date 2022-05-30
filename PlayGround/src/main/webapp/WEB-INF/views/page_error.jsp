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
  <title>PLAY GROUND</title>
  <link rel="stylesheet" href="${urlInfo}css/error.css">
  <link rel="stylesheet" href="${urlInfo}css/default.css">
</head>

<body>
  <div id="wrap">
    <div class="container">
      <div class="center">
        <div class="error_page">
          <!-- <div class="error_logo"> -->
            <a href="#" class="logo">
              <span>PLAY</span>
              <span>GROUND</span>
          </a>
          <!-- </div> -->
          <div class="error">
          <div class="error_title">
            <h2>페이지를 찾을 수 없습니다.</h2>
          </div>
          <div class="error_text">
            <p>입력하신 주소를 확인 후 재시도 해보시기 바랍니다.</p>
            <p>지속적으로 페이지 이동이 이루어지지 않는 경우 고객상담실로 문의 주시기 바랍니다. (1234-1234)</p>
          </div>
          </div>

          <div class="error_button">
            <a href="/"><span>PLAY GROUND 홈으로 이동</span></a>
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
  </div>
</body>

</html>