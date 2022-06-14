$(function(){
	
	$(".reserve").click(function(){
				
		$(this).next().attr("name","no");
		$(this).next().next().attr("name","time1");
		$(this).next().next().next().attr("name","time2");
		
		if(confirm("선택하신 시간으로 예약하시겠습니까?")){
			$("#reserveFrm").submit();
		}
		
	});
	
	
	
	
});