/**
 * 
 */

$(function() {
	// 회원 탈퇴 페이지 회원 탈퇴하기 버튼 클릭
	$("button#deleteUser").click(function() {
		$("#deleteFrm").submit();
	});

	//비밀번호 유효성 검사
	$("#pwInput").keyup(function() {
		let uPw = $(this).val().trim();
		$(this).val(uPw);
		let uPw_Re = $("#pwChkInput").val();

		let regExp = /[^a-z|A-Z|0-9|~!@#$%^&*()_+|<>?:{}]/g;
		let rExpRes = regExp.test(uPw);

		if (uPw == "") {    // 전체 공백 체크

			$("#pwChkMent").text("비밀번호를 입력해주세요.");
			$("#pwChkMent").css("color", "red");
			$("input#pwChk").val("false");
		} else if (uPw.length < 9) {    // 글자수 체크

			$("#pwChkMent").text("비밀번호는 최소 10글자 이상입니다.");
			$("#pwChkMent").css("color", "red");
			$("input#pwChk").val("false");

		} else if (rExpRes) {    // 정규표현식 체크
			$("#pwChkMent").text("비밀번호는 영어대/소문자, 숫자, 특수문자 조합만 가능합니다.");
			$("#pwChkMent").css("color", "red");
			$("input#pwChk").val("false");
		} else {
			$("#pwChkMent").text("");
			$("#pwChkMent").css("color", "black");
			$("input#pwChk").val("true");
		}

		if (uPw_Re != "" && uPw == uPw_Re) {
			$("#pwReChkMent").text("입력한 비밀번호와 일치합니다.");
			$("#pwReChkMent").css("color", "green");
			$("input#pwChk").val("true");
			$("input#pwReChk").val("true");
		} else {
			$("#pwReChkMent").text("입력한 비밀번호와 다릅니다.");
			$("#pwReChkMent").css("color", "red");
			$("input#pwChk").val("false");
			$("input#pwReChk").val("false");
		}

	});

	// 비밀번호 확인 유효성 검사
	$("#pwChkInput").keyup(function() {
		let uPw = $("#pwInput").val();
		let uPw_Re = $(this).val();

		if (uPw != "" && uPw == uPw_Re) {
			$("#pwReChkMent").text("입력한 비밀번호와 일치합니다.");
			$("#pwReChkMent").css("color", "black");
			$("input#pwChk").val("true");
			$("input#pwReChk").val("true");
		} else {
			$("#pwReChkMent").text("입력한 비밀번호와 다릅니다.");
			$("#pwReChkMent").css("color", "red");
			$("input#pwChk").val("false");
			$("input#pwReChk").val("false");
		}
	});

	//이름 유효성 검사
	$("#nameInput").keyup(function() {

		let name = $(this).val().trim();
		$(this).val(name);

		let regExp = /[^ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g;
		let rExpRes = regExp.test(name);
		let regExp2 = /[^가-힣]/g;
		let rExpRes2 = regExp2.test(name);

		if (name == "") {
			$("#nameChkMent").text("이름을 입력해 주세요.");
			$("#nameChkMent").css("color", "red");
			$("input#nameChk").val("false");

		} else if (name.length < 1) {    // 글자수 체크

			$("#nameChkMent").text("이름은 최소 1글자 이상입니다.");
			$("#nameChkMent").css("color", "red");
			$("input#nameChk").val("false");

		} else if (rExpRes) {    // 정규표현식 체크

			$("#nameChkMent").text("이름은 한글만 입력가능합니다.");
			$("#nameChkMent").css("color", "red");
			$("input#nameChk").val("false");

		} else if (rExpRes2) {    // 정규표현식 체크

			$("#nameChkMent").text("이름을 정확하게 입력해주세요.");
			$("#nameChkMent").css("color", "red");
			$("input#nameChk").val("false");

		} else {

			$("#nameChkMent").text("");
			$("#nameChkMent").css("color", "black");
			$("input#nameChk").val("true");

		}

	});





	// 선택된 Email 도메인 자동입력  
	$("select#emailDomain").change(function() {
		let emailDomain = $(this).val().trim();
		$("input#email2").val(emailDomain);
		if (emailDomain == "") {
			$("input#email2").focus();
		} else {
			$("input#email1").focus();
		}
	});

	$("#updateBtn").click(function() {
		let email1 = $("#email1").val();
		let email2 = $("#email2").val();
		$("#emailInput").val(email1 + "@" + email2);
		
		let phone = $("#ph0").val().trim() + $("#ph1").val().trim() + $("#ph2").val().trim();
		$("#phoneInput").val(phone);
		
		let birth_yearInput = $("#birth_yearInput").val();
		let birth_monthInput = $("#birth_monthInput").val();
		if (birth_monthInput.length == 1) {
			birth_monthInput = 0 + birth_monthInput;
		}
		let birth_dayInput = $("#birth_dayInput").val();
		if (birth_dayInput.length == 1) {
			birth_dayInput = 0 + birth_dayInput;
		}

		$("#birthInput").val(birth_yearInput + "-" + birth_monthInput + "-" + birth_dayInput);

		let chkSbmTF = confirm("회원정보를 변경하시겠습니까?");
		if (chkSbmTF) {
			$("#updateFrm").submit();
		}
	});

});