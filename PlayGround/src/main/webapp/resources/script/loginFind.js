/**
 * 
 */

$(function() {
	// 선택된 Email 도메인 자동입력  
	$("select#email_address1").change(function() {
		let emailDomain = $(this).val().trim();
		$("input#address1").val(emailDomain);
		if (emailDomain == "") {
			$("input#address1").focus();
		} else {
			$("input#id1").focus();
		}
	});
	// 선택된 Email 도메인 자동입력  
	$("select#email_address2").change(function() {
		let emailDomain = $(this).val().trim();
		$("input#address2").val(emailDomain);
		if (emailDomain == "") {
			$("input#address2").focus();
		} else {
			$("input#id2").focus();
		}
	});

	$("#findIdFrm button").click(function() {
		$("#emailInput1").val($("input#id1").val() + "@" + $("input#address1").val());
		let email = $("#emailInput1").val();
		let phone = $("#ph1").val() + $("#ph2").val() + $("#ph3").val();
		$("phoneInput1").val(phone);
		if ($("input#email").is(":checked")) {
			$("#findIdFrm").attr("action", "/Login/Find_email");
		} else {
			$("#findIdFrm").attr("action", "/Login/Find_phone");
		}

		$("#findIdFrm").submit();
	});


	$("#findPwFrm button").click(function() {
		$("#emailInput2").val($("input#id2").val() + "@" + $("input#address2").val());
		let email = $("#emailInput2").val();
		let phone = $("#phone1").val() + $("#phone2").val() + $("#phone3").val();
		$("phoneInput2").val(phone);
		if ($("input#mail").is(":checked")) {
			$("#findPwFrm").attr("action", "/Login/FindPw_email");
		} else {
			$("#findPwFrm").attr("action", "/Login/FindPw_phone");
		}

		$("#findPwFrm").submit();
	});

});