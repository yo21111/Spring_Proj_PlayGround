$(function(){
	
	$(".idChk").click(function(){
		
		var id = $("#idChk2").val();
		if(id == null || id == "") {
			alert("로그인이 필요한 서비스 입니다.");
			$(this).attr("href", "#");
			return;
		}
		
	});
	
});