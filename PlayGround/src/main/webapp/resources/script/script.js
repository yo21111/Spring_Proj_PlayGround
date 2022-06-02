$(document).ready(function(){
	
	$('ul.tabs li').click(function(){
		var tab_id = $(this).attr('data-tab');

		$('ul.tabs li').removeClass('current');
		$('.tab-content').removeClass('current');

		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
	})
	$(".main_list").hover(function(){
		$(".sub_menu" ,this).stop().slideDown(500);
		},function(){
			$(".sub_menu" ,this).stop().slideUp(500);
		})
		// 탑버튼
		
$(window).scroll(function() {
  if ($(this).scrollTop() > 300) {
      $('#top_button').fadeIn();
  } else {
      $('#top_button').fadeOut();
  }
});

$("#top_button").click(function() {
  $('html, body').animate({
      scrollTop : 0
  }, 400);
  return false;
});
// 생년월일
var now = new Date();
var year = now.getFullYear();
var mon = (now.getMonth() + 1) > 9 ? ''+(now.getMonth() + 1) : '0'+(now.getMonth() + 1); 
var day = (now.getDate()) > 9 ? ''+(now.getDate()) : '0'+(now.getDate());           
//년도 selectbox만들기               
for(var i = 1900 ; i <= year ; i++) {
		$('#year').append('<option value="' + i + '">' + i + '년</option>');    
}

// 월별 selectbox 만들기            
for(var i=1; i <= 12; i++) {
		var mm = i > 9 ? i : "0"+i ;            
		$('#month').append('<option value="' + mm + '">' + mm + '월</option>');    
}

// 일별 selectbox 만들기
for(var i=1; i <= 31; i++) {
		var dd = i > 9 ? i : "0"+i ;            
		$('#day').append('<option value="' + dd + '">' + dd+ '일</option>');    
}
$("#year  > option[value="+year+"]").attr("selected", "true");        
$("#month  > option[value="+mon+"]").attr("selected", "true");    
$("#day  > option[value="+day+"]").attr("selected", "true");    
// 팝업
$(".open").click(function(){
	$(this).parent().parent().parent().parent().parent().parent().next().children().show();
});
$(".close").click(function(){
	$(".popup_background").hide();
});
})