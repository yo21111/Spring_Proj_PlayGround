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
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <!-- <link rel="stylesheet" href="css/default.css"> -->
  <link rel="stylesheet" href="../css/default.css">
  <link rel="stylesheet" href="../css/index.css">
  <!-- <link rel="stylesheet" href="css/index.css"> -->
  <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js'></script>
  <script src="../script/script.js"></script>
</head>

<body>
  <div id="wrap">
    <header>
      <div class="center">
        <!-- <div class="header_fix"> -->
        <!-- <div class="logo"> -->
        <a href="../index.html#container" class="logo">
          <span>PLAY</span>
          <span>GROUND</span>
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
            <li><a href="#">LOGIN</a></li>
            <li><a href="#">MY PAGE</a></li>
          </ul>
        </div>
      </div>
      <!-- </div> -->
    </header>
    <!-- 전시회 예매하기 -->
    <div class="section01">
      <div class="center">
        <div class="exhibition_box">
          <div class="exhibition_img">
            <img src="../image/poster1.jpg" alt="exhibition_img01">
          </div>
          <div class="exhibition_text">
            <div class="good_button">
              <!-- 평점이랑 찜하기 아이콘으로 변경할에정 -->
              <div class="heart">
                <a href="#"><img src="  " alt="heart01"></a>
              </div>
              <div class="star">
                <span>평점</span>
              </div>
            </div>
            <div class="title_text">
              <h4>플레이그라운드</h4>
              <h2>레드룸</h2>
            </div>
            <div class="exhibition_notice">
              <table>
                <tr>
                  <td>장르</td>
                  <td>장르장르장르장르장르</td>
                </tr>
                <tr>
                  <td>등급</td>
                  <td>등급등급등급등급등급</td>
                </tr>
                <tr>
                  <td>전시 시간</td>
                  <td>전시 시간 ~ 전시 마감</td>
                </tr>
              </table>
            </div>
            <div class="advance_button">
              <a href="#">예매 하기</a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- 전시회 예매하기 끝-->
    <!-- 전시회 탭메뉴-->
    <div class="section02">
      <div class="center">
        <!-- 탭먼저 넣기 -->
        <div class="container">
          <ul class="tabs">
            <li class="tab-link current" data-tab="tab-1">전시 소개</li>
            <li class="tab-link" data-tab="tab-2">관람 안내</li>
            <li class="tab-link" data-tab="tab-3">예약/취소 안내</li>
            <li class="tab-link" data-tab="tab-4">후기</li>
            <!-- <li class="tab-link" data-tab="tab-5">tab5</li> -->
          </ul>

          <div id="tab-1" class="tab-content current">
            <!-- <img src="../image/tab_img02.jpg" alt="tab_img01"> -->
            <img src="../image/tab_img02.jpg" alt="tab_img01">
          </div>
          <div id="tab-2" class="tab-content">
            <table>
              <tr>
                <td>관람요금</td>
                <td>성인(20세 이상) 15,000원 | 아동청소년(36개월~19세) 12,000원</td>
              </tr>
              <tr>
                <td>관람시간</td>
                <td>
                  <p>오전 10시 ~ 오후 7시 (입장마감 : 오후 6시)</p>
                  <p>*매월 첫째 주 월요일 휴관 | 공휴일 정상개관</p>
                </td>
              </tr>
              <tr>
                <td>입장마감</td>
                <td>오후 6시</td>
              </tr>
              <tr>
                <td>유의사항</td>
                <td>
                  <p>*종료일이 7/24(일)로 연장되었습니다.</p>
                  <p>*전시장 현장 매표소에서 티켓을 발권한 이후에는 취소 및 환불이 불가합니다.</p>
                  <p>*전시장 현장 상황에 따라 전시 입장까지 대기 시간이 발생할 수 있습니다.</p>
                  <p>*티켓 발권 후 조기에 입장이 마감될 경우, 훼손되지 않은 상태의 티켓은 전시 종료일까지는 언제든 사용 가능합니다.</p>
                </td>
              </tr>
              <tr>
                <td>오시는길</td>
                <td>
                  서울특별시 성동구 아차산로17길 49 A동 지하1층
                </td>
              </tr>
            </table>
            <div class="map">
              <img src="http://via.placeholder.com/600x300" alt="map">
            </div>
          </div>
          <div id="tab-3" class="tab-content">
            <!--예약/취소 안내  -->
            <div class="reservation">
              <div class="reservation_left">
                <strong>예매</strong>
              </div>
              <div class="reservation_right">
                <div class="right_text">
                  예매는 PC, 모바일, 고객센터 를 통해 신용카드, 가상계좌(무통장 입금), YES머니, YES상품권, 예치금 등으로 예매하실 수 있습니다. <br>
                  (단, 상품마다 사용 가능한 결제 수단이 다르게 적용될 수 있으니 상품 상세페이지 안내 사항을 확인해주세요.) <br>
                  <span class="bottom_line">무통장입금 결제 선택 시 입금 마감시간은 예매일 익일 밤 11시 29분까지</span>입니다. 입금 마감시간 내 미입금 된 경우 예매가
                  자동 취소됩니다. <br>
                  (단, 상품에 따라 예매 당일 밤 11시 29분에 마감되는 경우가 있으니 예매 전후 반드시 확인해주시기 바랍니다.) <br>
                  예매수수료는 다음과 같습니다. <br>
                </div>
                <div class="right_table">
                  <table>
                    <tr>
                      <td>장르</td>
                      <td>PC/모바일</td>
                      <td>전화예매</td>
                    </tr>
                    <tr>
                      <td>전시</td>
                      <td>장당 : 1,000원</td>
                      <td>장당 : 2,000원</td>
                    </tr>
                  </table>
                </div>
              </div>
            </div>
            <div class="sale">
              <div class="reservation_left">
                <strong>티켓 수령 방법</strong>
              </div>
              <div class="reservation_right">
                <div class="right_text">
                  <strong>현장수령</strong> <br>
                  티켓은 예매자 본인 수령이 기본 원칙입니다. <br>
                  공연 당일 예매확인서와 예매자의 신분증 을 지참하신 후 공연장 매표소에서 티켓을 수령하시면 됩니다. <br>

                  <strong>배송</strong> <br>
                  배송을 선택하신 경우 예매완료(결제익일) 기준 5~7일 이내에 예매 시 입력하신 주소로 배송됩니다.(영업일 기준) <br>
                  일괄배송의 경우 각 상품의 지정된 배송일자 기준으로 배송이 시작됩니다. 배송 시작일은 상세정보 및 예매공지사항에서 확인할 수 있습니다. <br>
                  지역 및 배송 서비스 사정에 따라 배송사가 변경될 수 있으며, 배송일이 추가적으로 소요될 수 있습니다.(CJ대한통운, 우체국 외 1개 업체) <br>
                  * 티켓 수령과 관련된 정책은 상품별로 상이하니 자세한 내용은 각 상품 상세정보에서 확인 부탁드립니다. <br>
                </div>
              </div>
            </div>
            <div class="cancel">
              <div class="reservation_left">
                <strong>취소 마감 시간</strong>
              </div>
              <div class="reservation_right">

                <div class="right_table">
                  <table>
                    <tr>
                      <td>공연 관람일</td>
                      <td>취소 마감일</td>
                    </tr>
                    <tr>
                      <td>화요일 ~ 토요일</td>
                      <td>관람일 전일 평일 오후 5시</td>
                    </tr>
                    <tr>
                      <td>일요일 ~ 월요일 </td>
                      <td>토요일 오전 11시</td>
                    </tr>
                    <tr>
                      <td>공휴일 및 공휴일 익일</td>
                      <td>
                        공휴일 전일이 평일인 경우 - 오후 5시 <br>
                        공휴일 전일이 토요일, 일요일인 경우 - 토요일 오전 11시 <br>
                        공휴일에는 예매 취소 불가 <br>
                      </td>
                    </tr>

                  </table>
                </div>
                <div class="right_text">
                  관람일 당일 예매하신 건은 취소, 변경, 환불 불가합니다. <br>
                  배송이 시작된 티켓의 경우 티켓이 예스24 공연 고객센터로 취소마감시간 이전까지 반송되어야 취소 가능합니다.(취소수수료는 도착일 기준으로 부과됩니다.) <br>
                  결제수단을 복수로 선택한 경우 인터넷으로 부분취소가 불가하오니, 고객센터로 문의해주시기 바랍니다. <br>
                  <span class="red">
                    ※ 일부 공연에 한해, 취소 마감 정책이 달라질 수 있습니다. <br>
                    각 상품 상세페이지에 안내되어 있는 취소 정책이 우선 적용되오니, 반드시 예매 전 확인해주시기 바랍니다. <br>
                  </span>
                </div>
              </div>
            </div>
            <div class="cancel charge">
              <div class="reservation_left">
                <strong>취소 수수료</strong>
              </div>
              <div class="reservation_right">

                <div class="right_table">
                  <table>
                    <tr>
                      <td>취소일</td>
                      <td>취소 수수료</td>
                    </tr>
                    <tr>
                      <td>예매 후 7일 이내</td>
                      <td>없음</td>
                    </tr>
                    <tr>
                      <td>예매 후 8일 ~ 관람일 10일 전까지</td>
                      <td>전시 : 장당 2,000원(단, 티켓 금액의 10% 이내)</td>
                    </tr>
                    <tr>
                      <td>관람일 9일 전 ~ 관람일 7일 전까지</td>
                      <td>티켓 금액의 10%</td>

                    </tr>
                    <tr>
                      <td>관람일 6일 전 ~ 관람일 3일 전까지</td>
                      <td>티켓 금액의 20%</td>

                    </tr>
                    <tr>
                      <td>관람일 2일 전 ~ 취소마감일시까지</td>
                      <td>티켓 금액의 30%</td>

                    </tr>
                  </table>
                </div>
                <div class="right_text">
                  예매 후 7일 이내라도 취소시점이 관람일로부터 10일 이내라면 그에 해당하는 취소수수료가 부과됩니다. <br>
                  관람일 당일 취소 가능한 상품의 경우 관람일 당일 취소 시 티켓금액의 90%가 부과됩니다. <br>

                  <span class="red">
                    상품의 특성에 따라 취소수수료 정책이 달라질 수 있습니다.(각 상품 예매 시 취소수수료 확인)<br>
                  </span>
                </div>
              </div>
            </div>
            <div class="refund">
              <div class="reservation_left">
                <strong>환불</strong>
              </div>
              <div class="reservation_right">
                <div class="right_text">
                  예매수수료는 예매 당일 밤 12시 이전까지 환불되며, 그 이후 기간에는 환불되지 않습니다. <br>
                  배송 및 반송처리 된 티켓의 배송비는 환불되지 않습니다. <br>

                </div>
                <div class="right_table">
                  <table>
                    <tr>
                      <td>결제수단</td>
                      <td>환불안내</td>
                    </tr>
                    <tr>
                      <td>신용카드</td>
                      <td>

                        일반적으로 취소완료 되고 4~5일(토, 공휴일 제외) 후 카드 승인 취소가 확인됩니다. <br>
                        취소시점에 따라 취소수수료와 예매수수료, 배송 받으신 경우 배송비를 제외한 금액만큼 환불 처리 됩니다. <br>
                        (부분 취소 시에는 잔여 티켓 금액 + 수수료 등을 제외하고 환불 처리 됩니다.) <br>
                        각 카드사의 취소 정책에 따라 승인취소 및 환급일에 차이가 있을 수 있습니다. <br>
                        자세한 사항은 카드사로 문의 바랍니다. <br>
                      </td>
                    </tr>
                    <tr>
                      <td>무통장입금</td>
                      <td>
                        예매 취소 시 반드시 환불 받으실 계좌번호와 은행명을 입력하세요. <br>
                        취소수수료,예매수수료와 배송 받으신 경우 배송비를 제외한 후 환불 처리됩니다. <br>
                        취소 후 환불 처리는 영업일 기준 3~5일 정도 소요됩니다. <br>
                        환불진행상태는 MY공연>예매확인/취소 상세내역에서 확인할 수 있습니다. <br>
                        <span class="red">
                          배송 받은 티켓의 취소를 위해 고객센터로 발송하실 때, 환불 받으실 계좌 정보를 기입하여 보내주시면 보다 빠른 환불 처리가 가능합니다.<br>
                        </span>
                      </td>
                    </tr>

                  </table>
                </div>
              </div>
            </div>
            <!--예약/취소 안내 끝 -->
          </div>
          <div id="tab-4" class="tab-content">tab content4</div>
        </div>
      </div>
    </div>
    <!-- 전시회 탭메뉴 끝-->
    <footer class="footer">
      <div class="center">
        <span>본 페이지는 상업적 목적이 아닌 개인 포트폴리오로 제작되었습니다.</span>
        <span class="copyright">Copyright ⓒ 2022.PLAY GROUND ALL rights reserved.</span>
      </div>
    </footer>
  </div>
</body>

</html>