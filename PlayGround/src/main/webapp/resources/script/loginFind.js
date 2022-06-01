/**
 * 
 */
 
 $(function(){
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
	
	$("#findIdFrm button").click(function(){
		alert("id");
		$("#emailInput1").val();
	});
	
	
	$("#findPwFrm button").click(function(){
		alert("pw");
		
		
	});
	
});