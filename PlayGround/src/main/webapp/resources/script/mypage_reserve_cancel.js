$(function(){
	
	$(".refundBtn").click(function(){
		if(!$("input:checked[name='check1']").is(":checked")) {
			alert("환불정책에 동의해주세요");
			return;
		}
		if(confirm("정말 환불 하시겠습니까?")){
			$("#refund_form").submit();
		}
	});
	
	$(".cancleBtn").click(function(){
		if(confirm("환불을 취소하시겠습니까?")) {
			location.href="/mypage/myPageHome";
		}
		
	});
	
	
});