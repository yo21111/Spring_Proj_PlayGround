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
})