$(function(){
	
	
	$("#1W").click(function(){
		// 7일뒤 날짜 계산
		var now = new Date();
		var startDay = new Date(now.setDate(now.getDate() - 7));
		var nowDay = new Date();
		
		nowDay = nowDay.toISOString().slice(0,10);
		now = now.toISOString().slice(0,10);
		startDay = startDay.toISOString().slice(0,10);
		
		location.href = "/mypage/reList?date1="+startDay+"&date2="+nowDay;
	
	});
	
	$("#1M").click(function(){
		// 1달뒤 날짜 계산
		var now = new Date();
		var startDay = new Date(now.setMonth(now.getMonth() - 1));
		var nowDay = new Date();
		
		nowDay = nowDay.toISOString().slice(0,10);
		startDay = startDay.toISOString().slice(0,10);
		
		location.href = "/mypage/reList?date1="+startDay+"&date2="+nowDay;
	
	});
	
	$("#3M").click(function(){
		// 3달뒤 날짜 계산
		var now = new Date();
		var startDay = new Date(now.setMonth(now.getMonth() - 3));
		var nowDay = new Date();
		
		nowDay = nowDay.toISOString().slice(0,10);
		now = now.toISOString().slice(0,10);
		startDay = startDay.toISOString().slice(0,10);
		
		location.href = "/mypage/reList?date1="+startDay+"&date2="+nowDay;
	
	});
	
	$("#6M").click(function(){
		// 6달뒤 날짜 계산
		var now = new Date();
		var startDay = new Date(now.setMonth(now.getMonth() - 6));
		var nowDay = new Date();
		
		nowDay = nowDay.toISOString().slice(0,10);
		now = now.toISOString().slice(0,10);
		startDay = startDay.toISOString().slice(0,10);
		
		location.href = "/mypage/reList?date1="+startDay+"&date2="+nowDay;
	
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
});