/**
 * 
 */

$(document).ready(function() {

	$('.agree_wrap').on('click', '#all', function() {
		const checked = $(this).is(':checked');

		if (checked) {
			$(this).parents().parents().parents().find('input').prop('checked', true);
		} else {
			$(this).parents().parents().parents().find('input').prop('checked', false);
		}
	});

	/* 개별 체크박스 항목이 선택 해제 될 때 전체선택 해제 */
	$('.agree_wrap').on('click', '.chkbox_group', function() {
		let is_checked = true;

		$('.chkbox_group').each(function() {
			is_checked = is_checked && $(this).is(':checked');
		});

		$('#all').prop('checked', is_checked);
	});

	// 아이디 입력 내용 유효성 검사 + 중복검사 ajax
	$("#idChkBtn").click(function() {
		let chkId = $("#idInput").val();

		let regExp = /[^a-z|A-Z|0-9]/g;
		let rExpRes = regExp.test(chkId);

		if (chkId == "") {    // 전체 공백 체크
			alert("아이디를 입력해주세요.");
			return;
		} else if (chkId.length < 3) {    // 글자수 체크
			alert("아이디가 너무 짧습니다.");
			return;
		} else if (rExpRes) {    // 정규표현식 체크
			alert("올바르지 않은 형식입니다.");
			return;
		} else {
			let send = { id: chkId };
			$.ajax({
				type: 'POST',       // 요청 메서드
				url: '/Join/idCheck',  // 요청 URI
				headers: { "content-type": "application/json; charset=utf-8" }, // 요청 헤더
				dataType: 'text', // 전송받을 데이터의 타입
				data: JSON.stringify(send),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
				success: function(data) {
					if (data == "Y") {
						alert("사용 가능한 아이디입니다.");
						$("input#idChk").val("true");
					} else {
						alert("중복된 아이디입니다.");
						$("input#idChk").val("false");
					}
				},
				error: function() {
					alert("오류가 발생하였습니다. 다시 시도해주세요.")
				} // 에러가 발생했을 때, 호출될 함수
			}); // $.ajax()
		}
	});


	//아이디 유효성 검사
	$("#idInput").keyup(function() {
		let uId = $(this).val().trim();
		$(this).val(uId);

		// 아이디 입력 중에는 유효성 항상 false
		$("input#idChk").val("false");

		let regExp = /[^a-z|A-Z|0-9]/g;
		let rExpRes = regExp.test(uId);

		if (uId == "") {    // 전체 공백 체크

			$("#idChkMent").text("아이디를 입력해주세요");
			$("#idChkMent").css("color", "red");

		} else if (uId.length < 5) {    // 글자수 체크

			$("#idChkMent").text("아이디는 최소 6글자 이상입니다.");
			$("#idChkMent").css("color", "red");

		} else if (rExpRes) {    // 정규표현식 체크

			$("#idChkMent").text("아이디는 영어대/소문자, 숫자 조합만 가능합니다.");
			$("#idChkMent").css("color", "red");

		} else {

			$("#idChkMent").text("");
			$("#idChkMent").css("color", "black");

		}

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



	// 인증번호 발송 버튼 클릭
	$("#certBtn").click(function() {
		let phone = $("#ph0").val().trim() + $("#ph1").val().trim() + $("#ph2").val().trim();
		$("#phoneInput").val(phone);

		let regExp = /[^0-9]/g;
		let rExpRes = regExp.test(phone);

		if (phone == "") {
			$("input#phoneChk").val("false");

		} else if (phone.length != 11) {    // 글자수 체크
			$("input#phoneChk").val("false");

		} else if (rExpRes) {    // 정규표현식 체크
			$("input#phoneChk").val("false");

		} else {
			$.ajax({
				type: 'POST',       // 요청 메서드
				url: '/Join/certification',  // 요청 URI
				headers: { "content-type": "application/json; charset=utf-8" }, // 요청 헤더
				dataType: 'text', // 전송받을 데이터의 타입
				//data: JSON.stringify(send),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
				success: function(result) {
					$("#certification").val(result);
					$("input#phoneChk").val("true");
					alert("인증번호는 " + result + " 입니다.")
				},
				error: function() { alert("오류가 발생하였습니다. 다시 시도해주세요.") } // 에러가 발생했을 때, 호출될 함수
			}); // $.ajax()
		}
	});

	// 인증 확인 버튼 클릭
	$("#certChkBtn").click(function() {
		let cert = $("#certCode").val();
		let certChk = $("#certification").val();

		if (cert == certChk) {
			$("input#certChk").val("true");
			alert("휴대폰 인증이 확인 되었습니다.");
		} else {
			$("input#certChk").val("false");
			$("#certCode").val();
			$("#certCode").focus();
			alert("인증 번호를 다시 확인해주세요.");
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

	//취소하기 버튼 클릭
	$("button#cancelBtn").click(function() {
		if (confirm("메인 페이지로 돌아가시겠습니까?")) {
			location.href = "/";
		}
	});

	/* 회원가입 버튼 전송 실행 */
	$("#confirmBtn").click(function() {
		let idInput = $("#idInput").val();

		let pwInput = $("#pwInput").val();

		let pwChkInput = $("#pwChkInput").val();

		let nameInput = $("#nameInput").val();

		let email1 = $("#email1").val();
		let email2 = $("#email2").val();
		$("#emailInput").val(email1 + "@" + email2);

		let birth_yearInput = $("#birth_yearInput").val();
		let birth_monthInput = $("#birth_monthInput").val();
		if(birth_monthInput.length == 1) {
			birth_monthInput = 0 + birth_monthInput;
		}
		let birth_dayInput = $("#birth_dayInput").val();
		if(birth_dayInput.length == 1) {
			birth_dayInput = 0 + birth_dayInput;
		}
		$("#birthInput").val(birth_yearInput + "-" + birth_monthInput + "-" + birth_dayInput);
		
		if (!$("#all").is(':checked')) {
			alert("약관 동의를 확인해주세요.");
			return;
		} else if (idInput == "") {
			alert("아이디를 입력해주세요.");
			$("#idInput").focus();
			return;
		} else if (pwInput == "") {
			alert("비밀번호를 입력해주세요.");
			$("#pwInput").focus();
			return;
		} else if (pwChkInput == "" || pwInput != pwChkInput) {
			alert("비밀번호 일치여부를 확인해주세요.");
			$("#pwChkInput").focus();
			return;
		} else if (nameInput == "") {
			alert("이름을 입력해주세요.");
			$("#nameInput").focus();
			return;
		} else if (email1 == "") {
			alert("이메일 주소를 입력해주세요.");
			$("#email1").focus();
			return;
		} else if (email2 == "") {
			alert("이메일 주소를 입력해주세요.");
			$("#email2").focus();
			return;
		} else {
			if ($("input#idChk").val() != "true") {
				alert("아이디 중복 여부를 확인하세요.");
				return;
			} else if ($("input#certChk").val() != "true") {
				alert("휴대폰 인증번호를 확인하세요.");
				return;
			}
		}


		let chkSbmTF = confirm("회원가입 하시겠습니까?");
		if (chkSbmTF) {
			$("#joinForm").submit();
		}
	});

});