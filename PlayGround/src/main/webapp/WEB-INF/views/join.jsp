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
<title>mypage</title>

<!-- font awesome -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<!-- css -->
<link rel="stylesheet" href="${urlInfo}css/default.css">
<link rel="stylesheet" href="${urlInfo}css/join.css">
<!-- js -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="${urlInfo}script/script.js"></script>
<script src="${urlInfo}script/sub_Query.js"></script>
<script src="${urlInfo}script/join.js"></script>

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
						<li class="main_list">PLAY GROUND
							<ul class="sub_menu">
								<li class="sub_list"><a href="/exhibit/list?exState=N">현재 전시</a></li>
								<li class="sub_list"><a href="/exhibit/listexState=B">지난 전시</a></li>
								<li class="sub_list"><a href="/exhibit/listexState=A">예정 전시</a></li>
							</ul>
						</li>
						<li class="main_list"><a href="#">STORE</a> <!-- <ul class="sub_menu">
                <li class="sub_list"><a href="#"></a></li>
              </ul> --></li>
						<li class="main_list">BOARD
							<ul class="sub_menu">
								<li class="sub_list"><a href="#">공지사항</a></li>
								<li class="sub_list"><a href="#">FAQ</a></li>
								<li class="sub_list"><a href="#">1:1문의</a></li>
							</ul>
						</li>
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
		<div class="join_container">
			<div class="center">
				<div class="join_title">
					<h2>회원가입</h2>
				</div>

				<div class="join_center">
					<form id="joinForm" action="/Join/page" method="post">
						<input type="hidden" id="idChk" value="false"> <input
							type="hidden" id="pwChk" value="false"> <input
							type="hidden" id="pwReChk" value="false"> <input
							type="hidden" id="nameChk" value="false"> <input
							type="hidden" id="phoneChk" value="false"> <input
							type="hidden" id="certChk" value="false">
						<div class="agree_wrap">
							<h3>약관동의</h3>
							<ul class="all">
								<li><input type="checkbox" id="all"> <label
									for="all">모든 약관에 동의합니다.</label></li>
							</ul>
							<ul>
								<li><input type="checkbox" class="chkbox_group" id="age">
									<label for="age">[필수] 만 14세 이상 입니다.</label></li>
							</ul>
							<ul>
								<li><input type="checkbox" class="chkbox_group" id="use">
									<label for="use">[필수] 이용약관 동의</label></li>
								<li id="popup_1">[전문보기] ></li>
							</ul>
							<ul>
								<li><input type="checkbox" class="chkbox_group"
									id="persnal"> <label for="persnal">[필수] 개인정보 수집
										및 이용에 대한 동의</label></li>
								<li id="popup_2">[전문보기] ></li>
							</ul>
						</div>

						<div class="login_info_wrap">
							<div class="title login">
								<h3>로그인 정보</h3>
								<span class="caution">* 표시는 필수 입력 항목입니다.</span>
							</div>
							<div class="login_wrap">
								<ul class="label">
									<li>아이디 <span style="color: #f30c0c;">*</span></li>

									<li>비밀번호 <span style="color: #f30c0c;">*</span></li>

									<li>비밀번호 확인 <span style="color: #f30c0c;">*</span></li>
								</ul>
								<ul class="txt_form">
									<li><input type="text" placeholder="사용하실 아이디를 입력해 주세요."
										name="id" id="idInput">
										<button id="idChkBtn" type="button">중복확인</button>
										<ul class="hint">
											<li>6~12자의 영문 혹은 영문과 숫자를 조합하여 입력해 주세요.</li>
											<li id="idChkMent"></li>
										</ul></li>
									<li><input type="password"
										placeholder="사용하실 비밀번호를 입력해 주세요." name="pw" id="pwInput">
										<ul class="hint">
											<li>10~14자 이상 영문, 숫자, 특수문자를 조합하여 입력해 주세요.</li>
											<li id="pwChkMent"></li>
										</ul></li>
									<li><input type="password" placeholder="비밀번호를 재입력해 주세요."
										id="pwChkInput">
										<ul class="hint">
											<li>10~14자 이상 영문, 숫자, 특수문자를 조합하여 입력해 주세요.</li>
											<li id="pwReChkMent"></li>
										</ul></li>
								</ul>
							</div>
						</div>
						<div class="persnal_info_wrap">
							<div class="title login">
								<h3>개인 정보</h3>
								<span class="caution">* 표시는 필수 입력 항목입니다.</span>
							</div>
							<div class="persnal_wrap">
								<ul class="label">
									<li>이름 <span style="color: #f30c0c;">*</span></li>

									<li>생년월일 <span style="color: #f30c0c;">*</span></li>

									<li>휴대폰 번호 <span style="color: #f30c0c;">*</span></li>
									<li>이메일 <span style="color: #f30c0c;">*</span></li>
								</ul>
								<ul class="txt_form">
									<li><input class="name" type="text"
										placeholder="이름을 입력해 주세요." name="name" id="nameInput">
										<span id="nameChkMent"></span></li>


									<li class="birth"><input type="hidden" name="birth"
										id="birthInput"> <select id="birth_yearInput"
										class="year">
											<c:forEach var="i" begin="1930" end="2022">
												<option value="${i}">${i}년</option>
											</c:forEach>
									</select> <select id="birth_monthInput" class="month">
											<c:forEach var="i" begin="1" end="12">
												<option value="${i}">${i}월</option>
											</c:forEach>
									</select> <select id="birth_dayInput" class="day">
											<c:forEach var="i" begin="1" end="31">
												<option value="${i}">${i}일</option>
											</c:forEach>
									</select></li>

									<li class="phone"><input type="hidden" name="phone"
										id="phoneInput"> <input type="hidden"
										id="certification"> <input type="text" class="ph"
										id="ph0" placeholder="010"> <span>-</span> <input
										type="text" class="ph" id="ph1" placeholder="0000"> <span>-</span>
										<input type="text" class="ph" id="ph2" placeholder="0000">
										<button type="button" id="certBtn">인증번호 발송</button>

										<ul class="code">
											<li><input type="text" class="code" id="certCode"
												placeholder="인증번호를 입력해주세요.">
												<button type="button" id="certChkBtn">인증확인</button></li>
										</ul></li>

									<li class="email"><input type="hidden" name="email"
										id="emailInput"> <input type="text" class="id"
										id="email1" placeholder="이메일"> <span>@</span> <input
										type="text" class="address" id="email2"> <select
										name="" id="emailDomain">
											<option value="">직접입력</option>
											<option value="naver.com">naver.com</option>
											<option value="nate.com">nate.com</option>
											<option value="google.com">google.com</option>
											<option value="daum.net">daum.net</option>
									</select></li>
								</ul>
							</div>

						</div>
						<div class="add_info_wrap">
							<span class="title">추가정보 입력 (선택)</span> <span class="sub_title">마케팅
								수신 동의</span>
							<p class="txt">
								* 마케팅 정보 수신 및 활용 동의를 하시면 미술관에 관한 소식을 뉴스레터로 받아 보실 수 있습니다.</span>
							<div class="check_box">
								<label for="agree"><input type="checkbox" id="agree">
									[선택] 마케팅 목적에 따른 개인정보 수집 및 이용 동의</label> <span id="popup_3">[전문보기]
									></span>
							</div>
						</div>
						<div class="btn_wrap">
							<!-- 취소하기 눌렀을 때 어디로 이동할 것?-->
							<button type="button" id="cancelBtn" class="cencel">취소하기</button>
							<!-- 오류페이지처럼 가입을 축하합니다 페이지-->
							<button type="button" id="confirmBtn" class="confirm">가입하기</button>
						</div>
					</form>
					<!-- 회원 가입 폼 끝 -->
				</div>
			</div>
		</div>
		<!-- popup1-->
		<div id="bglayer" class="bg">
			<div class="overlayer">
				<div class="top">
					<span>전문보기</span>
					<div class="close">X</div>
				</div>
				<div class="law_box">
					<span class="title">[필수] 이용약관 동의</span>
					<h3>제 1장 총칙</h3>
					<strong class="sub_title">제 1 조 [ 목적 ]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">이 약관은
							재단법인 대림문화재단(이하 ‘재단’)이 운영하는 미술관 사이트 및 모바일 어플리케이션(이하 ‘사이트’)의 회원(이하
							‘회원’) 가입, 혜택, 전자상거래 등 사이트를 통하여 제공하는 모든 서비스(이하 ‘서비스’)의 이용조건 및 절차,
							이용자와 재단의 권리, 의무, 책임사항과 기타 필요한 사항을 규정함을 목적으로 합니다.</li>
					</ul>
					<strong class="sub_title">제 2 조 [ 공지 ]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">1. 본
							약관은 재단이 사이트의 화면 또는 기타의 방법으로 이용자에게 공지하고 회원이 동의함으로써 효력이 발생하며, 서비스
							제공 행위 및 이용자의 서비스 사용 행위에 본 약관이 우선적으로 적용됩니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">2. 재단은
							필요에 따라 본 약관을 개정할 수 있으며, 개정된 약관은 적용일자 및 개정사유를 명시하여 현행약관과 함께 사이트의
							초기화면에 그 적용일자 7일 이전부터 적용일자 전일까지 공지합니다. 다만, 회원 또는 이용자에게 불리하게 약관내용을
							변경하는 경우에는 최소한 30일 이상의 사전 유예기간을 두고 공지합니다. 이 경우 사이트는 개정 전 내용과 개정 후
							내용을 명확하게 비교하여 이용자가 알기 쉽도록 표시합니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">3. 개정된
							약관은 그 적용일자 이후에 체결되는 계약에만 적용되고 그 이전에 이미 체결된 계약에 대해서는 개정 전의 약관조항이
							그대로 적용됩니다. 다만 이미 계약을 체결한 이용자가 개정된 약관 조항의 적용을 받기를 원하는 뜻을 제2항에서 정하는
							공지기간 내에 재단 측에 알려서 재단의 동의를 받은 경우에는 개정된 약관 조항이 적용됩니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">4. 개정된
							약관의 효력 발생일 이후에도 계속적으로 서비스를 이용하는 경우 개정된 약관에 동의하는 것으로 간주됩니다.</li>
					</ul>
					<strong class="sub_title">제 3 조 [ 약관외 준칙 ]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">본 약관에서
							정하지 아니한 내용과 이 약관의 해석에 관하여는 『전자상거래 등에서의 소비자보호에 관한 법률』, 『약관의 규제에 관한
							법률』, 공정거래위원회가 정하는 『전자상거래 등에서의 소비자보호지침』 및 관계법령 또는 상관례가 적용됩니다.</li>
					</ul>
					<strong class="sub_title">제 4 조 [ 용어의 정의 ]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">본 약관에서
							사용하는 용어의 정의는 다음과 같습니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">1. 상품:
							도록, 아트상품 등 재단이 사이트을 통하여 판매하는 물품.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">2. 전시등:
							전시, 교육∙문화 프로그램, 공연, 기타 행사 등 재단이 제공하는 용역.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">3. 이용자:
							본 약관에 따라 사이트가 제공하는 서비스를 이용하는 회원 및 이용자.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">4. 가입:
							이용자가 재단이 제공하는 서비스를 받고자 재단에서 제공하는 신청서 양식에 해당 정보를 기입하고, 본 약관에 동의하는
							등 서비스 이용계약을 체결하기 위한 절차.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">5. 회원:
							가입을 통하여 재단과 서비스 이용계약을 체결한 자</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">6. 회원
							ID: 회원 식별과 회원의 서비스 이용을 위하여 회원이 선정하고 재단이 승인하는 문자, 숫자 또는 특수문자의 조합.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">7.
							비밀번호: 회원과 회원 ID가 일치하는지 확인하고 통신상의 자신의 비밀을 보호하기 위하여 회원 자신이 선정한 문자,
							숫자 또는 특수문자의 조합.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">8. 해지:
							재단 또는 회원이 서비스 이용계약을 해약하는 것.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">9. 운영자:
							서비스의 전반적인 관리와 원활한 운영을 위하여 재단에서 선정한 자.</li>
					</ul>
					<h3>제 2 장 재단의 서비스</h3>
					<strong class="sub_title">제 5 조 [서비스의 제공 및 변경]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">1. 재단은
							사이트를 통하여 다음과 같은 서비스를 제공합니다.
							<ul>
								<li style="line-height: 1.7; padding-left: 0.9375rem">1)
									상품에 대한 정보의 제공 및 구매계약의 체결</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">2)
									전시등에 대한 정보의 제공 및 티켓 예매서비스 제공</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">3)
									구매계약이 체결된 상품 또는 예매가 완료된 티켓의 배송</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">4) 기타
									재단이 정하는 업무</li>
							</ul>
						</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">2. 재단은
							상품이 품절되거나 기술적 사양의 변경 등으로 더 이상 제공할 수 없는 경우 또는 티켓이 품절된 경우에는 장차 체결되는
							구매계약에서 제공할 상품 또는 예매서비스에서 제공할 전시등의 내용을 변경할 수 있습니다. 이 경우에는 변경된 상품 및
							전시등의 내용 및 제공일자를 명시하여 현재의 내용을 게시한 곳에 즉시 공지합니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">3. 재단이
							회원에게 제공하기로 계약을 체결한 서비스의 내용을 상품 또는 전시 등의 품절 또는 기술적 사양의 변경 등의 사유로
							변경할 경우에는 그 사유를 회원에게 통지 가능한 방법으로 즉시 통지합니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">4. 전항의
							경우 재단은 이로 인하여 회원이 입은 손해를 배상합니다. 다만, 재단이 고의 또는 과실이 없음을 입증한 경우에는
							아무런 책임을 부담하지 않습니다.</li>
					</ul>
					<strong class="sub_title">제 6 조 [서비스 이용시간]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">1. 서비스의
							이용은 재단의 업무상 또는 기술상 특별한 지장이 없는 한 1일 24시간, 연중무휴서비스를 원칙으로 합니다. 다만,
							시스템 점검, 교체, 보수 등과 같은 필요가 있는 경우는 그러하지 않습니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">2. 재단은
							서비스를 일정범위로 분할하여 각 범위 별로 이용가능시간을 별도로 정할 수 있습니다.</li>
					</ul>
					<strong class="sub_title">제 7 조 [서비스 제공의 중지]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">1. 재단은
							다음 각 호에 해당하는 경우 서비스 제공을 전부 또는 일부 중지할 수 있습니다.
							<ul>
								<li style="line-height: 1.7; padding-left: 0.9375rem">1)
									서비스용 설비의 보수 등 재단에 필요한 사정이 있는 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">2)
									『전기통신사업법』에 의한 기간통신사업자가 전기통신서비스를 중지하는 등 부득이한 사유가 있는 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">3) 기타
									불가항력적 사유가 있는 경우</li>
							</ul>
						</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">2. 재단은
							국가비상사태, 정전, 서비스 설비의 장애 또는 서비스 이용의 폭주 등으로 인하여 정상적인 서비스 이용이 어려운 사정이
							있는 때에는 서비스의 전부 또는 일부를 제한하거나 중단할 수 있습니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">3. 재단은
							본조 제 1항 또는 제2항에 의하여 서비스 제공을 중지하거나 서비스의 이용을 제한한 때에는 그 사유 및 제한기간 등을
							지체없이 회원에게 알려야 합니다. 이로 인하여 이용자 또는 제3자가 입은 손해에 대하여 재단에게 고의 또는 과실이
							없는 경우에는 배상하지 아니합니다.</li>
					</ul>

					<h3>제 3 장 서비스 이용계약</h3>
					<strong class="sub_title">제 8 조 [이용계약의 성립]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">1. 이용자가
							본 약관을 읽고 "동의" 버튼을 클릭하면 이 약관에 동의하는 것으로 간주합니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">2.
							이용계약은 서비스 이용을 희망하는 이용자가 이용약관에 동의하고 이용자의 이용신청에 대하여 재단이 승낙함으로써
							성립합니다.</li>
					</ul>
					<strong class="sub_title">제 9 조 [이용신청 및 승낙]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">1. 이용자는
							재단이 요청하는 소정의 가입신청 양식에서 요구하는 사항을 기재하여 이용신청을 합니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">2. 가입신청
							양식에 기재하는 모든 이용자의 정보는 사실인 것으로 간주하며 실명이나 실제 정보를 입력하지 않은 회원은 서비스 사용의
							제한을 받을 수 있습니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">3. 재단은
							이용자가 본조 제 1 항과 제 2 항에서 정한 바에 따라 모든 사항을 정확히 기재하여 가입신청을 하였을 때 특별한
							사정이 없는 한 승낙하며, 그 승낙이 이용자에게 도달한 시점에 이용계약이 성립하고, 그때부터 이용자는 회원의 자격을
							가집니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">4. 재단은
							다음 각 호의 사유에 해당되는 경우 그 사유가 해소될 때까지 승낙을 유보할 수 있습니다.
							<ul>
								<li style="line-height: 1.7; padding-left: 0.9375rem">1)
									서비스 관련 설비에 여유가 없는 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">2)
									기술상 장애 사유가 있는 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">3) 기타
									재단의 사정상 이용승낙이 곤란한 경우</li>
							</ul>
						</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">5. 재단은
							다음 각 호의 사유에 해당되는 경우 그 승낙을 취소할 수 있습니다.
							<ul>
								<li style="line-height: 1.7; padding-left: 0.9375rem">1)
									성명이 본인의 실명이 아닌 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">2) 다른
									사람의 명의를 사용하여 신청한 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">3) 이용
									신청 시 필요 내용을 허위로 기재한 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">4)
									사회의 안녕질서 또는 미풍양속을 저해할 목적으로 신청한 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">5) 본
									약관에 정한 사항을 위반한 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">6) 기타
									재단이 필요하다고 인정하는 경우</li>
							</ul>
						</li>
					</ul>
					<strong class="sub_title">제 10 조 [정보 사항의 변경]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">회원은
							개인정보수정을 통해 언제든지 개인정보를 열람하고 수정할 수 있습니다. 회원은 이용신청 시 기재한 사항이 변경되었을
							경우에는 즉시 사이트에서 수정을 해야 하고 변경하지 않음으로 인하여 발생되는 문제의 책임은 회원에게 있습니다.</li>
					</ul>
					<strong class="sub_title">제 11 조 [서비스에 대한 안내, 고충처리 및 분쟁해결
						등]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">1. 재단은
							각 서비스 이용에 필요한 사항에 대해 개별 사항 마다 적절한 방법으로 공지합니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">2. 이용자는
							각 서비스 이용 시 재단이 공지하는 사항을 충분히 숙지하신 후 서비스를 이용하여야 합니다. 이를 숙지하지 않아 발생한
							불이익에 대해서 재단은 책임을 지지 않습니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">3. 재단은
							이용자의 편의를 고려하여 이용자의 의견이나 불만을 제시하는 방법을 사이트에서 안내합니다.</li>
					</ul>
					<strong class="sub_title">제 12 조 [이용자의 폭언 등 금지]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">이용자는
							재단의 임직원 또는 재단의 협력회사의 임직원에 대해 폭언, 폭행, 그 밖에 적정 범위를 벗어난 신체적·정신적 고통을
							유발하는 행위를 하여서는 아니됩니다. 해당 행위가 발생할 경우 재단은 『산업안전보건법』을 비롯하여 관계 법령에 따라
							모든 조치를 취할 수 있습니다.</li>
					</ul>
					<strong class="sub_title">제 13 조 [서비스의 이용 제한]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">재단은 회원
							모두에게 기본적으로 동일한 내용의 서비스를 제공합니다. 다만, 『청소년보호법』 등 관련 법령 또는 개별 서비스 제공과
							관련한 특별한 사정에 따라 연령 또는 일정한 등급을 기준으로 회원을 구분하여 서비스를 제공하거나 서비스의 내용, 이용
							시간, 이용 횟수 등을 다르게 하는 등 서비스의 이용을 제한할 수 있습니다. 이와 관련한 자세한 내용은 각 서비스상의
							안내, 공지사항 등에서 확인할 수 있습니다.</li>
					</ul>

					<h3>제 4 장 상품 구매계약 및 대금 결제</h3>
					<strong class="sub_title">제 14 조 [구매신청]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">1. 회원은
							재단의 사이트에서 다음 또는 이와 유사한 방법에 의하여 상품의 구매를 신청하며, 재단은 회원이 구매신청을 함에 있어서
							다음의 내용을 알기 쉽게 제공하여야 합니다.
							<ul>
								<li style="line-height: 1.7; padding-left: 0.9375rem">1)
									상품의 검색 및 선택</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">2)
									성명, 주소, 전화번호(휴대전화번호 포함. 이하 ‘전화번호’), 이메일 주소 등의 입력</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">3)
									약관내용, 청약 철회권의 제한, 배송료 등의 비용부담과 관련한 내용에 대한 확인</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">4)
									상품의 구매신청 및 이에 관한 확인 또는 재단의 확인에 대한 동의</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">5) 결제
									방법의 선택</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">6) 기타
									사이트가 별도로 정하는 절차</li>
							</ul>
						</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">2. 재단은
							제3자에게 상품을 구매하는 회원의 개인정보를 제공•위탁할 필요가 있는 경우 그 회원의 동의를 받아야 하며, 이 때
							제공되는 개인정보 항목, 제공받는 자, 제공받는 자의 개인정보 이용 목적 및 보유‧이용 기간 등을 해당 회원에게
							명시하여야 합니다. 다만 『개인정보 보호법』 제26조 제1항에 의한 개인정보의 처리 위탁의 경우 등 관련 법령에 달리
							정함이 있는 경우에는 그에 따릅니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">3. 회원은
							재단의 사전승낙 없이는 서비스를 이용하여 영업활동을 할 수 없으며, 그 영업활동으로 인하여 발생된 결과에 대하여
							재단은 어떠한 책임도 지지 않습니다. 다만, 다음과 같은 경우에는 예외로 합니다.
							<ul>
								<li style="line-height: 1.7; padding-left: 0.9375rem">①
									전자메일을 이용한 수신자의 의사에 반하지 않는 일반적인 문서교환</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">② 법인
									및 일반회원이 재단이 지정한 홍보용 게시판을 통해 활동하는 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">③ 재단과
									별도의 계약/합의에 의해서 활동하는 경우</li>
							</ul>
						</li>
						<strong class="sub_title">제 15 조 [구매계약의 성립]</strong>
						<ul>
							<li style="line-height: 1.7; padding-left: 0.9375rem">1. 재단은
								다음 각 호의 사유가 있는 경우 회원의 구매 신청을 승낙하지 않을 수 있습니다.
								<ul>
									<li style="line-height: 1.7; padding-left: 0.9375rem">1)
										구매신청 내용에 허위, 기재누락, 오기가 있는 경우</li>
									<li style="line-height: 1.7; padding-left: 0.9375rem">2)
										기타 구매신청을 승낙하는 것이 재단의 기술상 현저히 지장이 있다고 판단하는 경우</li>
									<li style="line-height: 1.7; padding-left: 0.9375rem">3)
										기타 제반 법령 및 정부의 가이드라인에 위반되는 경우</li>
								</ul>
							</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">2. 재단의
								승낙이 제17조 제1항의 수신확인통지형태로 회원에게 도달한 시점에 구매계약이 성립한 것으로 봅니다.</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">3. 재단의
								승낙의 의사표시에는 회원의 구매신청에 대한 확인 및 판매가능 여부, 구매신청의 정정 취소 등에 관한 정보 등을
								포함하여야 합니다.</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">4. 회원이
								미성년자임에도 불구하고, 법정대리인의 동의 없이 구매계약을 체결한 경우, 미성년자 또는 법정대리인은 구매계약을
								취소할 수 있으나, 미성년자가 법정대리인으로부터 처분을 허락 받은 재산의 범위 내인 경우 또는 미성년자가 사술 등을
								사용하여 성년자로 믿게 한 경우에는 그 취소가 제한됩니다.</li>
						</ul>
						<strong class="sub_title">제 16 조 [대금의 지급방법]</strong>
						<ul>
							<li style="line-height: 1.7; padding-left: 0.9375rem">1.
								사이트에서 구매신청한 상품에 대한 대금지급방법은 다음 각 호의 방법 중 가능한 방법으로 할 수 있습니다. 단,
								재단은 회원의 지급방법에 대하여 상품의 대금에 어떠한 명목의 수수료도 추가하여 징수하지 않습니다.
								<ul>
									<li style="line-height: 1.7; padding-left: 0.9375rem">1)
										폰뱅킹, 인터넷뱅킹 등의 각종 계좌이체</li>
									<li style="line-height: 1.7; padding-left: 0.9375rem">2)
										선불카드, 직불카드, 신용카드 등의 각종 카드 결제</li>
									<li style="line-height: 1.7; padding-left: 0.9375rem">3)
										온라인 무통장입금</li>
									<li style="line-height: 1.7; padding-left: 0.9375rem">4)
										전자 화폐에 의한 결제</li>
									<li style="line-height: 1.7; padding-left: 0.9375rem">5)
										재단이 지급한 쿠폰에 의한 결제</li>
									<li style="line-height: 1.7; padding-left: 0.9375rem">6)
										기타 전자적 지급 방법에 의한 대금 지급 등</li>
								</ul>
							</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">2.
								구매대금의 결제와 관련하여 회원이 입력한 정보 및 그와 관련된 책임은 회원에게 있으며, 상품의 구매신청 후 합리적인
								기간 내에 결제가 이루어 지지 않는 경우 재단은 이에 해당하는 주문을 취소할 수 있습니다.</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">3. 재단은
								구매자의 결제수단에 대하여 정당한 사용권한 보유 여부를 확인할 수 있으며, 필요한 경우 해당 거래 진행의 정지 및
								소명자료의 제출을 요청할 수 있습니다.</li>
						</ul>
						<strong class="sub_title">제 17 조 [수신확인통지·구매신청 변경 및 취소]</strong>
						<ul>
							<li style="line-height: 1.7; padding-left: 0.9375rem">1. 재단은
								회원의 구매신청이 있는 경우 회원에게 수신확인통지를 사이트, 또는 회원의 전자우편주소, 전화번호 등 전자적 방법으로
								통지합니다.</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">2.
								수신확인통지를 받은 회원은 자신이 구매신청한 내용과 다른 사실이 있는 경우에는 수신확인통지를 받은 후 즉시 구매신청
								변경 및 취소를 요청할 수 있고, 재단은 배송 전에 회원의 요청이 있는 경우에는 지체 없이 그 요청에 따라
								처리하여야 합니다.</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">3.
								수신확인통지를 받은 회원이 이미 대금을 지불한 경우에는 제 20조의 청약철회 및 반품에 관한 규정에 따릅니다.</li>
						</ul>
						<strong class="sub_title">제 18 조 [상품의 공급]</strong>
						<ul>
							<li style="line-height: 1.7; padding-left: 0.9375rem">1. 재단은
								회원과 상품의 공급시기에 관하여 별도의 약정이 없는 이상, 회원이 청약을 한 날로부터 7일 이내, 그리고 소비자가
								그 대금을 전부 또는 일부를 지급한 날부터 3영업일 이내에 상품을 배송할 수 있도록 주문제작, 포장 등 필요한
								조치를 취합니다. 이때 재단은 회원이 상품의 공급 절차와 진행 사항을 확인할 수 있도록 적절한 조치를 합니다.</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">2. 공휴일
								및 기타 휴무일 또는 천재지변 등의 불가항력적 사유가 발생하는 경우 해당 기간은 배송기간에서 제외합니다.</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">3. 재단은
								회원이 구매한 상품에 대해 배송수단, 수단별 배송비용 부담자, 수단별 예상 배송기간 등을 명시합니다. 만약 재단이
								예상 배송기간을 초과하여 회원에게 그로 인한 손실이 발생한 경우, 그 손해를 배상하여야 합니다. 다만 재단이
								고의∙과실이 없음을 입증한 경우에는 그러하지 아니합니다.</li>
						</ul>
						<strong class="sub_title">제 19 조 [상품의 공급]</strong>
						<ul>
							<li style="line-height: 1.7; padding-left: 0.9375rem">1. 재단은
								회원이 구매신청한 상품이 품절 등의 사유로 인도 또는 제공을 할 수 없을 때에는 지체 없이 그 사유를 회원에게
								통지하고 사전에 상품의 대금을 받은 경우에는 대금을 받은 날부터 3영업일 이내에 환급하거나 환급에 필요한 조치를
								취합니다. 다만, 결제방법이 수기거래로 이루어진 등의 사유로 3영업일 이내에 환급이 어려운 경우, 재단은 상품의
								구매 신청 전에 환급기간을 별도로 고지하기로 합니다. 재단은 회원에게 상품의 환급을 지연한 때에는 그 지연 기간에
								대하여 『전자상거래 등에서의 소비자보호에 관한 법률』 제18조 제2항 단서에서 정하는 지연배상금을 지급합니다.</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">2. 재단은
								대금을 환급함에 있어서 회원이 신용카드 또는 『전자금융거래법』 등이 정하는 결제수단으로 상품의 대금을 지급한 때에는
								지체 없이 당해 결제수단을 제공한 사업자로 하여금 상품의 대금의 청구를 정지 또는 취소하도록 요청할 수 있습니다.
							</li>
						</ul>
						<strong class="sub_title">제 20 조 [청약 철회 및 반품]</strong>
						<ul>
							<li style="line-height: 1.7; padding-left: 0.9375rem">1. 재단과
								상품의 구매계약을 체결한 회원은 상품을 수령한 날로부터 7일 이내에 청약 철회를 할 수 있습니다. 회원은 재단의
								사이트를 통해서만 청약 철회를 신청할 수 있으며, 구매한 상품의 일부에 대한 부분 청약 철회는 불가합니다. 재단은
								회원의 청약 철회 요청에 대해서 관련 법령을 준수하여 환불 절차를 진행합니다. 청약 철회에 관한 구체적인 규정은
								상품의 특성에 따라 달라질 수 있으며 해당 상품을 구매할 당시 고지된 조건에 따릅니다.</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">2. 상품의
								배송이 완료된 이후에는, 다음 각호에 해당하는 경우 상품의 반품 및 교환을 할 수 없습니다.
								<ul>
									<li style="line-height: 1.7; padding-left: 0.9375rem">1)
										상품을 수령한 날로부터 7일을 경과한 이후 회원의 단순 변심으로 교환/반품 요청을 하는 경우</li>
									<li style="line-height: 1.7; padding-left: 0.9375rem">2)
										회원이 수령한 상품을 전부 또는 일부 사용한 경우</li>
									<li style="line-height: 1.7; padding-left: 0.9375rem">3)
										시간의 경과에 의하여 재판매가 곤란할 정도로 상품의 가치가 현저히 감소한 경우</li>
									<li style="line-height: 1.7; padding-left: 0.9375rem">4)
										같은 성능을 지닌 상품으로 복제가 가능한 경우 그 원본인 상품의 포장을 훼손한 경우</li>
									<li style="line-height: 1.7; padding-left: 0.9375rem">5)
										배송된 상품이 하자 없음을 확인한 후 설치가 완료된 상품의 경우</li>
									<li style="line-height: 1.7; padding-left: 0.9375rem">6)
										주문에 따라 개별적으로 생산되는 상품 등 재단에게 회복할 수 없는 피해가 예상되는 경우로서 사전에 해당 거래에
										대하여 별도로 그 사실을 고지하고 회원의 서면(전자문서를 포함)에 의한 동의를 받은 경우</li>
									<li style="line-height: 1.7; padding-left: 0.9375rem">7) 그
										밖에 거래의 안전을 위하여 대통령령이 정하는 경우</li>
								</ul>
							</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">3. 회원은
								다음 각호의 경우에는 회원이 상품을 공급받은 날로부터 3개월 이내, 그 사실을 안 날 또는 알 수 있었던 날로부터
								30일 이내에 반품을 신청할 수 있습니다. 단, 배송완료일로부터 7일이 경과한 날(구매 확정) 이후에는 사이트를
								통하여 반품 처리가 이루어지지 않고 재단과 별도로 협의하여 진행됩니다.
								<ul>
									<li style="line-height: 1.7; padding-left: 0.9375rem">1)
										배송된 상품이 주문내용과 상이하거나 재단이 직접 판매하는 상품(위탁판매 등 제외)에 대해서 재단이 제공한
										표시·광고 내용과 상이할 경우</li>
									<li style="line-height: 1.7; padding-left: 0.9375rem">2)
										『전자상거래법』 제13조에 의하여 광고에 표시하여야 할 사항을 표시하지 아니한 상태에서 상품 구매계약이 체결된
										경우</li>
								</ul>
							</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">4. 회원이
								반품을 신청한 상품이 본 조 제2항에 해당하는 경우 재단은 구매 회원의 청약 철회 요청에 대하여 접수를 거부하거나
								보류할 수 있으며, 이 경우 회원에게 별도로 고지(사이트를 통한 안내 포함)합니다.</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">5. 재단의
								반품 접수 거부나 보류에 대해 회원은 다시 반품을 신청할 수 있으며, 반품 신청 시에 구매 확정이 연기됩니다. 구매
								확정 연기의 횟수 및 기간은 재단의 정책에 따라 제한될 수 있습니다.</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">6. 재단과
								회원이 반품 수거에 대하여 별도로 약속한 기일을 경과하거나 회원의 반품 신청 요청에 재단이 3영업일 이내에 응답하지
								않은 경우, 해당 상품의 반품 신청은 자동으로 접수되고, 재단은 환불에 필요한 조치를 이행합니다.</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">7. 반품에
								관한 일반적인 사항은 『전자상거래법』 등 관련 법령이 재단이 제시한 조건보다 우선합니다.</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">8. 반품에
								소요되는 비용은 반품에 대한 귀책사유가 있는 자에게 일반적으로 귀속됩니다(예. 단순 변심의 경우 구매회원부담,
								상품의 하자의 경우 재단 부담 등). 단 당사자간에 별도의 약정이 있었던 때에는 그 약정에 따라 부담합니다.</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">9. 반품
								신청 시 반품 사유에 관하여 재단에게 정확히 통보(구두 또는 서면으로)하지 않고 상품을 반환하거나 회원 부담의 반품
								배송비를 지불하지 않는 등의 사유가 발생하면 반품처리 및 환불이 지연될 수 있습니다.</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">10.반품
								상품의 배송방법은 상품의 종류, 부피 등을 고려하여 처리 가능한 방식에 따라 진행하여야 합니다.</li>
						</ul>
						<strong class="sub_title">제 21 조 [청약철회의 효과]</strong>
						<ul>
							<li style="line-height: 1.7; padding-left: 0.9375rem">1. 재단은
								회원으로부터 상품을 반환받은 경우 3영업일 이내에 이미 지급 받은 상품의 대금을 환급하거나 환급에 필요한 조치를
								취합니다. 다만, 결제방법이 수기거래로 이루어진 등의 사유로 3영업일 이내에 환급이 어려운 경우, 재단은 상품의
								구매 신청 전에 환급기간을 별도로 고지하기로 합니다. 재단이 회원에게 대금의 환급을 지연한 때에는 그 지연 기간에
								대하여 『전자상거래 등에서의 소비자보호에 관한 법률』 제18조 제2항 단서에서 정하는 지연배상금을 지급합니다.</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">2. 재단은
								위 대금을 환급함에 있어서 회원이 신용카드 또는 전자화폐 등의 결제수단으로 대금을 지급한 때에는 지체 없이 당해
								결제수단을 제공한 사업자로 하여금 상품의 대금 청구를 정지 또는 취소하도록 요청합니다.</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">3.
								청약철회 등의 경우 공급받은 상품의 반환에 필요한 비용은 회원이 부담합니다. 재단은 회원에게 청약철회 등을 이유로
								위약금 또는 손해배상을 청구하지 않습니다. 다만 상품의 내용이 표시∙광고 내용과 다르거나 계약내용과 다르게 이행되어
								청약철회 등을 하는 경우 상품의 반환에 필요한 비용은 재단이 부담합니다.</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">4. 회원이
								상품을 제공받을 때 배송비를 부담한 경우에 재단은 청약철회 시 그 비용을 누가 부담하는지 회원이 알기 쉽도록
								명확하게 표시합니다.</li>
						</ul>
						<strong class="sub_title">제 22 조 [할인쿠폰] </strong>
						<ul>
							<li style="line-height: 1.7; padding-left: 0.9375rem">1. 재단은
								회원이 지정된 상품을 구매하거나 티켓을 예매하는 경우 일정액 또는 일정비율을 할인 받을 수 있는 할인쿠폰을 발급할
								수 있습니다.</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">2.
								할인쿠폰은 발급된 계정을 통해 회원 본인 또는 재단이 그 사용 권한을 부여한 자에 한해서만 사용할 수 있으며,
								어떠한 경우에도 이를 타인에게 실질적으로 매매 또는 양도할 수 없습니다.</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">3. 계정간
								할인쿠폰의 합산 및 이동이 불가하며 쿠폰이 발급된 계정을 통해서만 사용 가능합니다.</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">4.
								할인쿠폰은 일부 품목이나 금액 또는 회원별 사용가능 수량에 따라 사용이 제한될 수 있으며, 유효기간이 지난 후에는
								사용할 수 없습니다.</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">5.
								할인쿠폰을 사용하여 상품을 구매하거나 티켓을 예매한 후 취소나 반품으로 인하여 환불이 이루어진 경우에는 원칙적으로
								할인쿠폰의 재사용이 가능하나, 일부 쿠폰은 재단의 운영정책에 따라 재사용이 불가할 수 있습니다</li>
							<li style="line-height: 1.7; padding-left: 0.9375rem">6. 회원을
								탈퇴할 경우 할인쿠폰은 즉시 소멸됩니다.</li>
						</ul>
					</ul>

					<h3>제 5 장 티켓 예매서비스</h3>
					<strong class="sub_title">제 23 조 [티켓의 예매]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">1. 재단은
							본 사이트를 통하여 전시등의 티켓 예매서비스를 제공합니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">2. 티켓은
							개인 티켓과 단체 티켓으로 구분되며, 단체 티켓은 기업단체, 학교단체, 개인단체로 구분됩니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">3. 개인
							티켓과 단체 티켓 중 학교단체, 개인단체 티켓은 예매 시 날짜가 지정되며, 기업단체 티켓은 날짜가 지정되지 않습니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">4. 예약가능
							기간, 결제 방법, 배송방법은 예매하려는 티켓의 종류에 따라 달라질 수 있으며, 구체적인 사항은 해당 티켓의
							예매서비스 이용안내에 명시된 내용을 따릅니다.</li>
					</ul>
					<strong class="sub_title">제 24 조 [예매수수료]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">재단은 본
							사이트에서 제공되는 예매 서비스에 대하여 예매 수수료를 부과하지 않습니다.</li>
					</ul>
					<strong class="sub_title">제 25 조 [티켓의 취소 및 환불]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">1. 예매한
							티켓의 취소 또는 환불은 본 사이트를 통하거나 재단을 방문하여 하실 수 있습니다. 다만, 단체 티켓의 경우 개별
							계약과 약정에 따라 환불이 불가할 수 있으며, 단체 티켓의 결제 방법이 수기거래로 이루어진 등의 사유로 3영업일
							이내에 환급이 어려운 경우, 재단은 티켓의 예매 전에 환급기간을 별도로 고지하기로 합니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">2. 예매의
							취소는 예매 당시 지정한 날짜의 전일 오후 5시까지 미사용된 티켓에 한하여 가능하며, 이후에는 취소가 불가능합니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">3. 예매의
							취소 시점과 결제 방법의 환불처리기준에 따라 취소 금액의 환급 방법과 환급일은 다소 차이가 있을 수 있습니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">4. 예매한
							티켓의 부분 취소(인원 변경)는 불가능하며, 전체 티켓을 예매 취소 후에 다시 예매하여야 합니다.</li>
					</ul>
					<strong class="sub_title">제 26 조 [구매계약에 관한 규정의 준용]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">상품의
							구매계약에 관한 제14조부터 제19조 및 제21조부터 제22조의 규정은 티켓 예매서비스에 관한 본 장에 적용이 가능한
							범위에서 준용됩니다.</li>
					</ul>

					<h3>제 6 장 계약당사자의 의무</h3>
					<strong class="sub_title">제 27 조 [개인정보보호 및 이용]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">1. 재단은
							이용자의 정보수집 시 아래와 같이 서비스의 제공에 필요한 최소한의 정보를 수집합니다. 다만 관련 법령상 의무이행을
							위하여 본인확인이 필요한 경우 해당 개인정보를 수집합니다.
							<ul>
								<li style="line-height: 1.7; padding-left: 0.9375rem">1) 성명</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">2)
									생년월일</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">3)
									전화번호</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">4) 회원
									ID(회원의 경우)</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">5)
									비밀번호(회원의 경우)</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">6)
									이메일주소</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">7) 소속</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">8) 기타
									이용자가 입력하는 정보</li>
							</ul>
						</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">2. 재단은
							이용자의 개인 식별이 가능한 개인정보를 수집하는 때에는 반드시 당해 이용자의 동의를 받습니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">3. 제공된
							개인정보는 당해 이용자의 동의 없이 목적 외의 이용이나 제3자에게 제공할 수 없으며, 이에 대한 모든 책임은 재단이
							집니다. 다만, 다음의 경우는 예외로 합니다.
							<ul>
								<li style="line-height: 1.7; padding-left: 0.9375rem">1) 법률
									규정에 따른 의무이행 또는 법률에 의하여 필요한 불가피한 사유가 있는 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">2)
									통계작성, 학술연구 또는 시장조사를 위하여 필요한 경우로서 특정 개인을 식별할 수 없는 형태로 제공하는</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">3)
									도용방지를 위하여 본인확인에 필요한 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">4) 배송
									업무상 배송업체에게 배송에 필요한 최소한의 이용자의 정보(성명, 주소, 전화번호)를 알려주는 경우</li>
							</ul>
						</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">4. 상품의
							거래에 따른 대금 정산을 위하여 필요한 경우 재단이 제2항과 제3항에 의해 이용자의 동의를 받아야 하는 경우에는
							개인정보관리 책임자의 신원, 정보의 수집 목적 및 이용 목적, 제3자에 대한 정보 제공 관련 사항(제공 받은자, 제공
							목적 및 제공할 정보의 내용) 등 『개인정보보호법』 제17조 등에서 규정한 사항을 미리 명시하거나 고지해야 하며
							이용자는 언제든지 이 동의를 철회할 수 있습니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">5. 이용자는
							언제든지 재단이 가지고 있는 자신의 개인정보에 대해 열람 및 오류 정정을 요구할 수 있으며 재단은 이에 대해 지체
							없이 필요한 조치를 취할 의무를 집니다. 이용자가 오류의 정정을 요구한 경우에는 재단은 그 오류를 정정할 때까지 당해
							개인정보를 이용하지 않습니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">6. 재단은
							개인정보 보호를 위하여 관리자를 한정하여 이용자의 개인정보 처리하는 자를 최소한으로 제한하여야 하며 신용카드,
							은행계좌 등을 포함한 이용자의 개인정보의 분실, 도난, 유출, 변조 등으로 인한 이용자의 손해에 대하여 재단에게 고의
							또는 과실이 있는 경우 모든 책임을 집니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">7. 재단
							또는 그로부터 개인정보를 제공받는 제3자는 개인정보의 수집 목적 또는 제공받은 목적을 달성한 때에는 당해 개인정보를
							지체 없이 파기합니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">8. 재단이
							이용자의 개인정보를 수집, 이용, 제공 등을 할 경우에는 『개인정보보호법』에 따라 이용자의 동의를 받습니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">9. 이용자는
							원하는 경우 언제든 재단에 제공한 개인정보의 수집과 이용에 대한 동의를 철회할 수 있으며, 그가 회원 가입을 한 경우
							동의의 철회는 회원 탈퇴를 하는 것으로 이루어 집니다.</li>
					</ul>
					<strong class="sub_title">제 28 조 [재단의 의무]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">1. 재단은
							본 약관이 정하는 바에 따라 지속적이고, 안정적으로 서비스를 제공하는데 최선을 다합니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">2. 재단은
							서비스 이용계약의 체결, 계약사항의 변경 및 해지 등 회원의 계약 관련 절차 및 내용 등에 있어 회원의 편의를
							제공하도록 노력합니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">3. 재단은
							이용자가 안전하게 서비스를 이용할 수 있도록 이용자의 개인정보(신용정보 포함) 보호를 위한 보안 시스템을 갖추어야
							합니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">4. 재단은
							판매하는 상품 또는 전시등의 티켓 예매에 대하여 『표시·광고의 공정화에 관한 법률』 제3조의 규정에 위반하는
							표시·광고행위를 함으로써 이용자가 손해를 입은 때에는 이를 배상할 책임을 부담합니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">5. 재단은
							수신거절의 의사를 명백히 표시한 이용자에 대해서는 영리목적의 광고성 이메일을 발송하지 않습니다.</li>
					</ul>
					<strong class="sub_title">제 29 조 [회원의 정보 보안에 대한 의무]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">1. 회원
							ID와 비밀번호에 관한 모든 관리 책임은 회원에게 있습니다. 회원 ID와 비밀번호의 관리 소홀, 부정사용 등에 의하여
							발생하는 모든 결과에 대한 책임은 회원에게 있습니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">2. 자신의
							회원 ID, 비밀번호가 부정하게 사용되고 있음을 발견한 회원은 즉시 재단에 그 사실을 통보해야 합니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">3. 회원은
							온라인을 통한 서비스 사용 종료 시마다 정확히 접속을 종료해야 하며, 정확히 종료하지 아니함으로써 제3자가 회원에
							대한 정보를 이용하게 되는 등의 결과로 인해 발생하는 손해 및 손실에 대해서 재단은 책임을 부담하지 않습니다.</li>
					</ul>
					<strong class="sub_title">제 30 조 [회원의 의무]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">1. 회원은
							서비스 이용 시 다음 각 호의 행위를 하지 않아야 합니다.
							<ul>
								<li style="line-height: 1.7; padding-left: 0.9375rem">1) 다른
									회원의 회원 ID를 부정하게 사용하는 행위</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">2)
									서비스에서 얻은 정보를 재단의 사전승낙 없이 회원의 이용 외의 목적으로 복제하거나 출판 및 방송 등에 사용하거나
									제3자에게 제공하는 행위</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">3)
									제3자의 저작권 등 기타 권리를 침해하는 행위</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">4)
									공공질서 및 미풍양속에 위반되는 내용의 정보, 문장, 도형 등을 타인에게 유포하는 행위</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">5)
									범죄와 결부된다고 객관적으로 판단되는 행위</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">6)
									타인의 명예를 훼손하거나 불이익을 주는 행위</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">7) 기타
									관계법령 및 본 약관을 위반하는 행위</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">8)
									구매의사 없는 반복적인 비정상적 구매 행위로 재단의 영업을 방해하는 행위</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">9)
									타인의 명의, 카드정보, 계좌정보, 주소정보 등 제3자 정보를 도용하여 재단이 제공하는 서비스를 이용하는 행위</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">10)
									고객응대근로자에게 폭언 욕설을 하는 행위</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">11)
									기타 공서양속에 위배되는 불법적이거나 부당한 행위</li>
							</ul>
						</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">2. 회원은
							본 약관에서 규정하는 사항과 서비스 이용안내 또는 주의사항 등 재단이 공지하는 사항을 준수하여야 합니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">3. 회원은
							재단의 사전승낙 없이는 서비스를 이용하여 영업활동을 할 수 없으며, 그 영업활동으로 인하여 발생된 결과에 대하여
							재단은 어떠한 책임도 지지 않습니다. 다만, 다음과 같은 경우에는 예외로 합니다.
							<ul>
								<li style="line-height: 1.7; padding-left: 0.9375rem">1)
									전자메일을 이용한 수신자의 의사에 반하지 않는 일반적인 문서교환</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">2) 법인
									및 일반회원이 재단이 지정한 홍보용 게시판을 통해 활동하는 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">3)
									재단과 별도의 계약/합의에 의해서 활동하는 경우</li>
							</ul>
						</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">4. 회원은
							재단의 명시적인 동의가 없는 한 서비스의 이용권한, 기타 이용계약상 지위를 타인에게 양도, 증여할 수 없으며 이를
							담보로 제공할 수 없습니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">5. 회원은
							다음 각호의 1에 해당하는 통신을 하여서는 아니되며, 이를 위반함을 이유로 방송통신심의위원회, 중앙선거관리위원회,
							과학기술정보통신부 등 법령에 의하여 권한이 인정되는 관계기관이 적법한 절차에 따라 요청하는 경우 또는 저작권 침해,
							명예훼손 등 권리침해의 주장이 있고, 그 주장을 존중하는 것이 필요하다고 재단이 인정하는 경우 재단은 게시물을
							삭제하거나 서비스의 전부 또는 일부의 이용을 제한할 수 있습니다. 다만, 제 1호 또는 제 4호에 해당하는 경우에는
							재단은 위와 같은 관계기관의 요청 또는 권리침해의 주장이 없어도 해당 게시물을 삭제하거나 서비스의 전부 또는 일부의
							이용을 제한할 수 있습니다.
							<ul>
								<li style="line-height: 1.7; padding-left: 0.9375rem">1)
									범죄행위를 목적으로 하거나 범죄행위를 교사하는 행위</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">2)
									반국가적 행위의 수행을 목적으로 하는 행위</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">3)
									선량한 풍속, 기타 사회질서를 해하는 행위</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">4)
									타인의 명예를 손상시키거나 불이익을 주는 행위</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">5)
									정보통신설비의 오동작이나 정보 등의 파괴를 유발시키는 해킹, 컴퓨터 바이러스 프로그램등의 유포행위</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">6) 다른
									회원 또는 제 3자의 지적재산권을 침해하는 행위</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">7)
									수신자의 의사에 반하여 광고성 정보를 지속적으로 전송하거나 서비스의 안정적 운영에 지장을 초래하는 다량의 자료
									송수신, 게시물 등록, 기타 건전한 서비스 이용에 반하는 행위</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">8)
									『전기통신기본법』, 『전기통신사업법, 『청소년보호법』 등 관련 법률에 위배되는 행위</li>
							</ul>
						</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">6. 회원이
							본조 제 5항 제 1호 또는 제 4호에 해당하는 행위 또는 약관에 위반한 영업활동 및 이와 유사한 행위를 함으로
							인하여 발생한 결과에 대해 재단은 책임을 지지 않으며, 회원은 이와 같은 영업활동에 의해 재단에 발생한 손해에 대해
							손해배상의무를 집니다.</li>
					</ul>

					<h3>제 7 장 계약 해지 및 이용 제한</h3>
					<strong class="sub_title">제 31 조 [계약해지(탈퇴) 및 이용제한]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">1. 회원이
							서비스 이용계약을 해지하고자 하는 때에는 본인이 사이트를 통해 재단에 탈퇴신청을 하여야 합니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">2. 진행
							중인 주문이 있는 경우에는 탈퇴할 수 없으며, 이미 결제가 완료된 건은 탈퇴로 취소되지 않으므로 취소 및 환불 등의
							처리 절차가 모두 완료된 다음에 탈퇴할 수 있습니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">3. 회원
							재가입은 회원이 가입 후 탈퇴, 재가입 등을 반복함으로써 재단이 제공하는 쿠폰, 이벤트 혜택 등 경제상의 이익을
							취하거나 기타 명의도용 등의 불법적인 행위 등을 방지하기 위하여, 회원 탈퇴를 한 날로부터 30일이 경과한 경우에
							가능합니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">4. 한 번
							탈퇴한 아이디는 다시 사용할 수 없습니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">5. 회원
							탈퇴와 동시에 회원 정보는 즉시 삭제됩니다. 이에 따라 회원이 보유하고 있었던 쿠폰 등 모든 혜택의 이용 및 환불이
							불가하며, 다른 계정으로 양도 또는 이관할 수 없습니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">6. 탈퇴 시
							법령에 따라 보관해야 하는 항목은 관련 법령에 따라 일정 기간 보관하며 다른 목적으로 이용하지 않습니다. 탈퇴 시
							보관 또는 유지되는 항목은 다음을 포함합니다.
							<ul>
								<li style="line-height: 1.7; padding-left: 0.9375rem">1)
									『전자상거래 등에서의 소비자보호에 관한 법률』에 의거하여 대금결제 및 상품의 공급에 관한 기록 5년동안 보관</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">2) 계약
									또는 청약철회 등에 관한 기록 5년동안 보관</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">3)
									소비자의 불만 또는 분쟁처리에 관한 기록은 3년동안</li>
							</ul>
						</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">7. 회원이
							작성한 각종 게시판의 게시글, 댓글 등의 데이터는 삭제되지 않습니다. 탈퇴 후에는 회원정보가 삭제되어 본인 여부를
							확인할 수 없으므로 게시글을 임의로 삭제해드릴 수 없으며, 탈퇴 전 회원이 직접 삭제해야 합니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">8. 재단은
							회원이 다음 각호에 해당하는 행위를 하였을 경우 사전통지 없이 이용계약을 해지하거나 또는 기간을 정하여 서비스 이용을
							중지할 수 있습니다. 또한, 해지된 회원에 대하여는 재가입을 제한할 수 있습니다.
							<ul>
								<li style="line-height: 1.7; padding-left: 0.9375rem">1)
									타인의 회원 ID 및 비밀번호를 도용한 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">2)
									서비스 운영을 고의로 방해한 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">3)
									가입한 성명이 실명이 아닌 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">4) 같은
									사용자가 다른 회원 ID로 이중등록을 한 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">5)
									공공질서 및 미풍양속에 저해되는 내용을 고의로 유포시킨 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">6)
									회원이 국익 또는 사회적 공익을 저해할 목적으로 서비스이용을 계획 또는 실행하는 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">7)
									타인의 명예를 손상시키거나 불이익을 주는 행위를 한 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">8)
									서비스의 안정적 운영을 방해할 목적으로 다량의 정보를 전송하거나 광고성 정보를 전송하는 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">9)
									정보통신설비의 오작동이나 정보 등의 파괴를 유발시키는 컴퓨터 바이러스 프로그램 등을 유포하는 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">10)
									재단, 다른 회원 또는 제 3자의 지적재산권을 침해하는 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">11)
									타인의 개인정보, 회원 ID 및 비밀번호를 부정하게 사용하는 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">12)
									재단의 서비스 정보를 이용하여 얻은 정보를 재단의 사전 승낙 없이 복제 또는 유통시키거나 상업적으로 이용하는 경우
								</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">13)
									회원이 재단의 사이트 또는 게시판에 음란물을 게재하거나 음란사이트 링크하는 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">14)
									구매한 상품을 정당한 이유 없이 상습적으로 구매 취소 또는 반품(환불)하는 등의 방법으로 재단의 업무를 현저히
									방해하는 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">15)
									재판매 목적으로 상품을 대량으로 중복 구매하여 다른 이용자의 구매 기회를 제한하는 등 공정한 거래질서를 현저히
									방해하는 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">16)
									상품 이용 시 정상적인 거래 범위를 현저히 이탈하여 오남용하는 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">17)
									회원이 부정적립, 부정사용 등 쿠폰 및 멤버십 혜택을 부정한 방법 또는 목적으로 이용한 경우</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">18) 본
									약관을 포함하여 기타 재단이 정한 이용조건에 위반한 경우</li>
							</ul>
						</li>
					</ul>

					<h3>제 8 장 기타</h3>
					<strong class="sub_title">제 32 조 [서비스 이용관련 게시물의 저작권]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">1. 게시물에
							대한 권리와 책임은 원칙적으로 그 게시자에게 있습니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">2. 그러나,
							서비스를 통하여 제출된 회원의 아이디어, 원고, 사진 등에 대한 저작권, 초상권 등은 재단에 귀속됩니다.</li>
					</ul>
					<strong class="sub_title">제 33 조 [회원의 게시물]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">재단은 회원이
							게시하거나 등록하는 서비스 내의 내용물이 다음 각호에 해당한다고 판단되는 경우에는 사전 동의 없이 삭제할 수
							있습니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">1. 다른
							회원 또는 제 3자를 비방하거나 중상모략으로 명예를 손상시키는 내용인 경우</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">2. 공공질서
							및 미풍양속에 위반되는 내용인 경우</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">3. 범죄적
							행위에 결부된다고 인정되는 내용일 경우</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">4. 재단의
							저작권, 제 3 자의 저작권 등 기타 권리를 침해하는 내용인 경우</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">5. 회원이
							게시판에 음란물을 게재하거나 음란사이트를 링크하는 경우</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">6. 게시판의
							성격에 부합하지 않는 게시물의 경우</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">7. 기타
							관계법령에 위반된다고 판단되는 경우</li>
					</ul>
					<strong class="sub_title">제 34 조 [게시물의 저작권]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">서비스 내에
							게재된 자료에 대한 권리는 다음 각 호와 같습니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">게시물에 대한
							권리와 책임은 게시자에게 있으며 재단은 게시자의 동의 없이는 이를 서비스 내 게재하는 것 이외에 영리적 목적으로
							사용하지 않습니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">1. 회원은
							서비스를 이용하여 얻은 정보를 가공, 판매하는 행위 등 서비스에 게재된 자료를 상업적으로 사용할 수 없습니다.
							<ul>
								<li style="line-height: 1.7; padding-left: 0.9375rem">1)
									재단이 작성한 게시물 또는 저작물에 대한 저작권 기타 지적재산권은 재단에 귀속합니다. 그러므로, 회원은 서비스를
									이용하여 얻은 정보를 가공, 판매하는 행위 등 서비스에 게재된 자료를 본인 또는 제 3자의 영리 목적으로 무단
									도용, 변형, 직접 사용할 수 없습니다.</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">2)
									회원이 서비스 내에 게시한 게시물의 저작권은 해당 게시물의 저작자에게 귀속됩니다. 단, 재단은 서비스의 운영,
									전시, 전송, 배포, 홍보의 목적으로 회원의 별도의 허락 없이 무상으로 『저작권법』에서 규정하는 공정한 관행에
									합치되게 합리적인 범위 내에서 다음과 같이 회원이 등록한 게시물을 사용할 수 있습니다.
									<ul>
										<li style="line-height: 1.7; padding-left: 0.9375rem">-
											서비스 내에서 회원 게시물의 복제, 수정, 개조, 전시, 전송, 배포 및 저작물성을 해치지 않는 범위 내에서의
											편집 저작물 작성</li>
										<li style="line-height: 1.7; padding-left: 0.9375rem">-
											미디어, 통신사 등 서비스 제휴 파트너에게 회원의 게시물 내용을 제공, 전시 혹은 홍보하게 하는 것. 단, 이
											경우 재단은 별도의 동의 없이 회원의 회원ID 외에 회원의 개인정보를 제공하지 않습니다.</li>
									</ul>
								</li>
							</ul>
						</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">3) 재단은
							전항 이외의 방법으로 회원의 게시물을 이용하고자 하는 경우, 전화, 팩스, 전자우편 등의 방법을 통해 사전에 회원의
							동의를 얻어야 합니다.</li>
					</ul>
					<strong class="sub_title">제 35 조 [손해 배상]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">1. 재단은
							서비스 요금이 무료인 서비스 이용과 관련하여 재단의 고의, 과실에 의한 것이 아닌 한 회원에게 발생한 어떠한 손해에
							관하여도 책임을 지지 않습니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">2. 회원이
							이 약관에서 규정한 의무사항을 위반하여 재단에 손해를 끼친 경우 재단은 해당 회원에 대해 손해 배상을 청구할 수
							있습니다.</li>
					</ul>
					<strong class="sub_title">제 36 조 [면책조항]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">1. 재단은
							천재지변 또는 이에 준하는 불가항력으로 인하여 서비스를 제공할 수 없는 경우에는 서비스 제공에 관한 책임이
							면제됩니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">2. 재단은
							회원의 귀책사유로 인한 서비스 이용의 장애에 대하여 책임을 지지 않습니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">3. 재단은
							서비스에서 제공하는 자료로 인해 회원이 입은 손해에 대하여 책임을 지지 않습니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">4. 재단은
							회원이 서비스에 게재한 정보, 자료, 사실의 신뢰도, 정확성 등 내용에 관하여는 책임을 지지 않습니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">5. 재단은
							회원 상호간 또는 회원과 제 3자 상호간에 서비스를 매개로 하여 물품거래 등을 한 경우에는 책임을 지지 아니합니다.</li>
					</ul>
					<strong class="sub_title">제 37 조 [관할 법원]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">서비스 이용과
							관련하여 발생한 분쟁에 대해 소송이 제기될 경우 『민사소송법』 및 관련 법령에서 정하는 관할법원에 의합니다.</li>
					</ul>
					<strong class="sub_title">[부칙]</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">1. 이
							약관은 2022년 03월 01일부터 시행합니다.</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">2. 이
							약관은 이용자가 회원에 가입함과 동시에 효력을 발생합니다.</li>
					</ul>

				</div>
				<div class="btn" id="close2">확인</div>
			</div>
		</div>

		<!-- //popup -->
		<!-- popup2 -->
		<div class="bg" id="bglayer2">
			<div class="overlayer">
				<div class="top">
					<span>전문보기</span>
					<div class="close">X</div>
				</div>
				<div class="law_box">
					<span class="title">[필수] 개인정보 수집 및 이용에 대한 동의</span>
					<ul>
						<li style="line-height: 2; color: #606060; padding: 10px 0;">
							* 만 14세 미만은 회원가입이 불가합니다.</li>
					</ul>

					<strong class="sub_title">1. 개인정보 수집목적 및 이용목적</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">1) 서비스
							제공에 관한 계약 이행 및 서비스 제공에 따른 요금정산<br> 콘텐츠 제공, 구매 및 요금 결제, 물품배송
							또는 청구지 등 발송, 금융거래 본인 인증 및 금융 서비스, 재단에서 진행하는 프로그램 참가자의 본인 확인, 사고
							발생 시 응급 처치
						</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">2) 회원
							관리<br> 회원제 서비스 이용에 따른 본인확인, 개인 식별, 불량회원의 부정 이용 방지와 비인가 사용
							방지, 가입 의사 확인, 연령확인, 불만처리 등 민원처리, 고지사항 전달
						</li>
					</ul>

					<strong class="sub_title">2. 수집하는 개인정보 항목</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">- 회원가입시
							<ul>
								<li style="line-height: 1.7; padding-left: 0.9375rem">∙
									필수항목: 이름, 생년월일, 로그인ID, 비밀번호, 전화번호, 이메일, 소속</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">∙
									선택항목: 성별, 자택 주소, 자녀유무</li>
							</ul>
						</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">- 소셜
							회원을 통한 회원 가입 시(카카오, 네이버, 애플, 구글)
							<ul>
								<li style="line-height: 1.7; padding-left: 0.9375rem">∙
									필수항목: 로그인 정보 식별값, 성별, 생년월일, 전화번호, 이메일</li>
							</ul>
						</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">- 상품 구매
							또는 티켓 예매 시
							<ul>
								<li style="line-height: 1.7; padding-left: 0.9375rem">∙
									필수항목: 구매자 정보(이름, 이메일, 전화번호), 수령자 정보(성명, 전화번호, 주소), 프로그램 참여
									아동∙청소년의 이름, 연령, 프로그램 참가자의 소속</li>
								<li style="line-height: 1.7; padding-left: 0.9375rem">∙
									선택항목 : 프로그램 참여 아동∙청소년의 연령, 프로그램 참가자의 소속</li>
							</ul>
						</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">- 서비스
							이용과정에서 자동 수집 정보 : IP정보, 디바이스 또는 브라우저 정보, 쿠키, 방문 일시, 서비스 이용 기록, 불량
							이용 기록</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">- 본인인증
							시
							<ul>
								<li style="line-height: 1.7; padding-left: 0.9375rem">∙
									필수항목: 이름, 성별, 생년월일, 전화번호</li>
							</ul>
						</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">- 간편
							로그인 시(카카오, 네이버, 애플, 구글) : 당사는 이용자의 편의를 위해 간편로그인 방식을 제공하고 있습니다. 이와
							같은 로그인 시 당사가 이용자의 개인정보를 추가 수집하지 않으며, 다만 로그인 정보 식별값만 비교하고 있습니다.</li>
					</ul>


					<strong class="sub_title">3. 개인정보의 보유기간 및 이용기간</strong>
					<p style="line-height: 1.7; margin-bottom: 1rem">원칙적으로, 개인정보 수집
						및 이용목적이 달성된 후에는 해당 정보를 지체 없이 파기합니다. 단, 다음의 정보에 대해서는 아래의 이유로 명시한 기간
						동안 보존합니다.</p>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">1) 재단
							내부 방침에 의한 정보 보유 사유
							<ul>
								<li style="line-height: 1.7; padding-left: 0.9375rem">○
									부정거래 방지 및 쇼핑몰 운영방침에 따른 보관 : 5년</li>
							</ul>
						</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">2) 관련
							법령에 의한 정보보유 사유
							<ul>
								<li style="line-height: 1.7; padding-left: 0.9375rem">○ 계약
									또는 청약철회 등에 관한 기록
									<ul>
										<li style="line-height: 1.7; padding-left: 0.9375rem">-
											보존이유 : 전자상거래등에서의소비자보호에관한법률</li>
										<li style="line-height: 1.7; padding-left: 0.9375rem">-
											보존기간 : 5년</li>
									</ul>
								</li>
							</ul>
							<ul>
								<li style="line-height: 1.7; padding-left: 0.9375rem">○ 대금
									결제 및 상품의 공급에 관한 기록
									<ul>
										<li style="line-height: 1.7; padding-left: 0.9375rem">-
											보존이유 : 전자상거래등에서의소비자보호에관한법률</li>
										<li style="line-height: 1.7; padding-left: 0.9375rem">-
											보존기간 : 5년</li>
									</ul>
								</li>
							</ul>
							<ul>
								<li style="line-height: 1.7; padding-left: 0.9375rem">○ 소비자
									불만 또는 분쟁처리에 관한 기록
									<ul>
										<li style="line-height: 1.7; padding-left: 0.9375rem">-
											보존이유 : 전자상거래등에서의소비자보호에관한법률</li>
										<li style="line-height: 1.7; padding-left: 0.9375rem">-
											보존기간 : 3년</li>
									</ul>
								</li>
							</ul>
							<ul>
								<li style="line-height: 1.7; padding-left: 0.9375rem">○ 로그
									기록
									<ul>
										<li style="line-height: 1.7; padding-left: 0.9375rem">-
											보존이유 : 통신비밀보호법</li>
										<li style="line-height: 1.7; padding-left: 0.9375rem">-
											보존기간 : 3개월</li>
									</ul>
								</li>
							</ul>
							<ul>
								<li style="line-height: 1.7; padding-left: 0.9375rem">○ 표시,
									광고에 관한 기록
									<ul>
										<li style="line-height: 1.7; padding-left: 0.9375rem">-
											보존이유 : 전자상거래등에서의소비자보호에관한법률</li>
										<li style="line-height: 1.7; padding-left: 0.9375rem">-
											보존기간 : 6개월</li>
									</ul>
								</li>
							</ul>
							<ul>
								<li style="line-height: 1.7; padding-left: 0.9375rem">○
									전자금융 거래에 관한 기록
									<ul>
										<li style="line-height: 1.7; padding-left: 0.9375rem">-
											보존이유 : 전자금융거래법</li>
										<li style="line-height: 1.7; padding-left: 0.9375rem">-
											보존기간 : 5년</li>
									</ul>
								</li>
							</ul>
						</li>
					</ul>

					<strong class="sub_title">※ 동의 거부권 및 동의 거부에 따른 불이익</strong>

					<p style="line-height: 1.7; margin-bottom: 1rem">
						고객님은 위와 같이 개인정보를 수집, 이용하는데 동의를 거부할 권리가 있습니다.<br> 다만, 동의를 거부하는
						경우 회원가입이 제한됩니다.
					</p>


				</div>
				<div class="btn" id="close3">확인</div>
			</div>
		</div>
		<!-- // popup2 -->
		<!-- popup3 -->
		<div class="bg" id="bglayer3">
			<div class="overlayer">
				<div class="top">
					<span>전문보기</span>
					<div class="close">X</div>
				</div>
				<div class="law_box">
					<span class="title">[선택] 마케팅 목적에 따른 개인정보 수집 및 이용 동의</span> <strong
						class="sub_title">1. 개인정보 수집목적 및 이용목적</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">1) 전시
							개발</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">2)
							전시소식, 뉴스레터, 이벤트 등의 광고성 정보 전달</li>
						<p style="line-height: 1.7; padding-left: 0.9375rem">* 정보 제공을
							위해 전자적 전송 매체를 이용하여 고객님께 연락드릴 수 있습니다.</p>
					</ul>

					<strong class="sub_title">2. 수집∙이용 항목</strong>
					<ul>
						<li style="line-height: 1.7; padding-left: 0.9375rem">1)
							필수항목: 이름 , 생년월일 , 로그인ID , 비밀번호 , 휴대전화번호 , 이메일, 소속</li>
						<li style="line-height: 1.7; padding-left: 0.9375rem">2)
							선택항목: 성별, 자택 주소, 자녀유무 및 자녀 생년월일</li>
					</ul>
					<strong class="sub_title">3. 개인정보의 보유기간 및 이용기간</strong>
					<p style="line-height: 1.7; padding-left: 0.9375rem">개인정보 변경에서
						마케팅 동의 철회 혹은 회원 탈퇴 시까지</p>

					<strong class="sub_title">※ 동의 거부권 및 동의 거부에 따른 불이익</strong>
					<p style="line-height: 1.7; padding-left: 0.9375rem">
						고객님은 위와 같이 개인정보를 수집, 이용하는데 동의를 거부할 권리가 있습니다.<br> 다만, 동의를 거부하는
						경우 회원가입이 제한됩니다.
					</p>

					<strong class="sub_title"">※ 기타 고지사항</strong> <strong
						class=" sub_title ">개인정보 처리업무 위탁에 대한 안내</strong>
					<table border=" 0 " cellpadding=" 0 " cellspacing=" 0 "
						style="width: 100%; padding: 0; margin: 0; border-top: 1px solid #414040; margin-top: 10px; margin-bottom: 20px;">
						<colgroup>
							<col style="width: 25%">
							<col style="width: 25%">
							<col style="width: 25%">
							<col style="width: 25%">
						</colgroup>
						<thead>
							<tr>
								<th
									style="color: #666; font-size: 0.75rem; line-height: 1.5; font-weight: normal; text-align: center; background-color: #f5f5f5; border-top: 0; border-bottom: 1px solid #ddd; border-right: 1px solid #ddd; padding: 12px 5px">제공받는
									자<br>(수탁자)
								</th>
								<th
									style="color: #666; font-size: 0.75rem; line-height: 1.5; font-weight: normal; text-align: center; background-color: #f5f5f5; border-top: 0; border-bottom: 1px solid #ddd; border-right: 1px solid #ddd; padding: 12px 5px">제공하는
									항목</th>
								<th
									style="color: #666; font-size: 0.75rem; line-height: 1.5; font-weight: normal; text-align: center; background-color: #f5f5f5; border-top: 0; border-bottom: 1px solid #ddd; border-right: 1px solid #ddd; padding: 12px 5px">제공
									목적<br>(위탁업무)
								</th>
								<th
									style="color: #666; font-size: 0.75rem; line-height: 1.5; font-weight: normal; text-align: center; background-color: #f5f5f5; border-top: 0; border-bottom: 1px solid #ddd; padding: 12px 5px">보유기간</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td
									style="color: #222; font-size: 0.75rem; line-height: 1.5; border-top: 0; border-bottom: 1px solid #ddd; border-right: 1px solid #ddd; padding: 12px 5px">스타일랩</td>
								<td
									style="color: #222; font-size: 0.75rem; line-height: 1.5; border-top: 0; border-bottom: 1px solid #ddd; border-right: 1px solid #ddd; padding: 12px 5px">성명,
									아이디, 비밀번호, 전화번호, 주소, 이메일, 소속기관, 직책, 부서, 팩스번호</td>
								<td
									style="color: #222; font-size: 0.75rem; line-height: 1.5; border-top: 0; border-bottom: 1px solid #ddd; border-right: 1px solid #ddd; padding: 12px 5px">주문/배송(제3자
									물류 대행), 고객상담 및 CS 업무 처리</td>
								<td
									style="color: #222; font-size: 0.75rem; line-height: 1.5; border-top: 0; border-bottom: 1px solid #ddd; padding: 12px 5px">회원
									탈퇴시 또는 이용목적 달성시까지</td>
							</tr>
							<tr>
								<td
									style="color: #222; font-size: 0.75rem; line-height: 1.5; border-top: 0; border-bottom: 1px solid #ddd; border-right: 1px solid #ddd; padding: 12px 5px">스티비
									주식회사</td>
								<td
									style="color: #222; font-size: 0.75rem; line-height: 1.5; border-top: 0; border-bottom: 1px solid #ddd; border-right: 1px solid #ddd; padding: 12px 5px">성명,
									아이디, 이메일</td>
								<td
									style="color: #222; font-size: 0.75rem; line-height: 1.5; border-top: 0; border-bottom: 1px solid #ddd; border-right: 1px solid #ddd; padding: 12px 5px">이메일
									발송 업무</td>
								<td
									style="color: #222; font-size: 0.75rem; line-height: 1.5; border-top: 0; border-bottom: 1px solid #ddd; padding: 12px 5px">회원
									탈퇴시 또는 이용목적 달성시까지</td>
							</tr>
							<tr>
								<td
									style="color: #222; font-size: 0.75rem; line-height: 1.5; border-top: 0; border-bottom: 1px solid #ddd; border-right: 1px solid #ddd; padding: 12px 5px">비즈톡
									주식회사</td>
								<td
									style="color: #222; font-size: 0.75rem; line-height: 1.5; border-top: 0; border-bottom: 1px solid #ddd; border-right: 1px solid #ddd; padding: 12px 5px">성명,
									전화번호</td>
								<td
									style="color: #222; font-size: 0.75rem; line-height: 1.5; border-top: 0; border-bottom: 1px solid #ddd; border-right: 1px solid #ddd; padding: 12px 5px">회원가입,
									예매, 예약, 상품 구매, 현장 대기 고각 입장 순서 알림 등의 알람톡, 문자 발송 관련 업무</td>
								<td
									style="color: #222; font-size: 0.75rem; line-height: 1.5; border-top: 0; border-bottom: 1px solid #ddd; padding: 12px 5px">서비스
									제공 기간<br> (고객 정보 등록 시부터 고객 순서 호출 된 후 등록 정보 자동삭제)
								</td>
							</tr>
							<tr>
								<td
									style="color: #222; font-size: 0.75rem; line-height: 1.5; border-top: 0; border-bottom: 1px solid #ddd; border-right: 1px solid #ddd; padding: 12px 5px">(주)이비즈엔시스템</td>
								<td
									style="color: #222; font-size: 0.75rem; line-height: 1.5; border-top: 0; border-bottom: 1px solid #ddd; border-right: 1px solid #ddd; padding: 12px 5px">전화번호</td>
								<td
									style="color: #222; font-size: 0.75rem; line-height: 1.5; border-top: 0; border-bottom: 1px solid #ddd; border-right: 1px solid #ddd; padding: 12px 5px">문자
									발송 서비스 업무</td>
								<td
									style="color: #222; font-size: 0.75rem; line-height: 1.5; border-top: 0; border-bottom: 1px solid #ddd; padding: 12px 5px">회원
									탈퇴시 또는 이용목적 달성시까지</td>
							</tr>
							<tr>
								<td
									style="color: #222; font-size: 0.75rem; line-height: 1.5; border-top: 0; border-bottom: 1px solid #ddd; border-right: 1px solid #ddd; padding: 12px 5px">㈜케이지이니시스</td>
								<td
									style="color: #222; font-size: 0.75rem; line-height: 1.5; border-top: 0; border-bottom: 1px solid #ddd; border-right: 1px solid #ddd; padding: 12px 5px">성명,
									주민등록번호, 주소, 휴대폰번호, 전화번호 또는 가입 통신사, 아이디, 비밀번호, 이메일, 결제기록, 결제정보,
									정산계좌정보, 상품 또는 용역 거래 정보, 접속 IP, IP Address, 쿠키, 서비스 접속 일시, 서비스
									이용기록, 불량 혹은 비정상 이용기록</td>
								<td
									style="color: #222; font-size: 0.75rem; line-height: 1.5; border-top: 0; border-bottom: 1px solid #ddd; border-right: 1px solid #ddd; padding: 12px 5px">전자금융거래서비스
									업무(결제/정산)</td>
								<td
									style="color: #222; font-size: 0.75rem; line-height: 1.5; border-top: 0; border-bottom: 1px solid #ddd; padding: 12px 5px">이용목적
									달성 시까지</td>
							</tr>
						</tbody>
					</table>
					<p style="line-height: 1.7; padding-left: 0.9375rem">* 상기 업무
						위탁의 내용이 변경될 경우, 재단은 변경된 내용을 서면 또는 이메일, 재단 사이트 게시의 방법을 통해 고지할
						예정입니다. 다만, 귀하의 연락처 불명 등 위 사실의 고지가 불가능한 경우에는 관련 법령에 의거하여 당사 사이트 또는
						사업장에 게시된 개인정보처리방침을 통해 변경 내용을 공개 합니다.</p>
				</div>
				<!-- 여기 버튼 쿼리만 작동하지 않습니다. -->
				<div class=" btn " id=" close4 ">확인</div>
			</div>
		</div>
		<!-- // popup3 -->
		<footer class=" footer ">
			<div class=" center ">
				<span>본 페이지는 상업적 목적이 아닌 개인 포트폴리오로 제작되었습니다.</span> <span
					class=" copyright ">Copyright ⓒ 2022.PLAY GROUND ALL rights
					reserved.</span>
			</div>
		</footer>
	</div>
</body>


</html>