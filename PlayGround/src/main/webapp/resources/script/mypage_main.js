$(function(){

	$("#recentRev").click(function(){
		// 3달뒤 날짜 계산
		var now = new Date();
		var startDay = new Date(now.setMonth(now.getMonth() - 3));
		var nowDay = new Date();
		
		nowDay = nowDay.toISOString().slice(0,10);
		now = now.toISOString().slice(0,10);
		startDay = startDay.toISOString().slice(0,10);
		
		location.href = "/mypage/reList?date1="+startDay+"&date2="+nowDay;
	
	});
	
	$(".myRevView").click(function(){
		var exNo = $(this).children().eq(3).val();
		location.href = "/exhibit/listView?exNo=" + exNo;
	});
	
});
