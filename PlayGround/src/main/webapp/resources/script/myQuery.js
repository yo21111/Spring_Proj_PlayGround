$(document).ready(function () {
// 이미지 변경 시작
  // 바로가기 아이콘 이미지 경로 변경
  // var defualtSrc = "";
  // defualtSrc = $(this).children().attr("src");
  var idx;
  // $(".shortcut a").click(function(){
  //     idx = $(this).index();
  //     $(this).children("img").attr("src",$(this).attr("href"));
  //     $(this).css({"background-color":"#0066ad","color":"#fff"});
  //     console.log(idx);
  //     return false;
  // });

  $(".email a").mouseenter(function(){
      idx = $(this).index();
      $(this).children("img").attr("src",$(this).attr("href"));
      $(this).css({"background-color":"#3D725E","color":"#fff"}); 
      // 배경이 투명한 이미지를 사용 했다면 배경색을 변경할 수 있고, 이미지 아래쪽에 텍스트를 작성했다면 텍스트컬러도 변경해줍니다. 단순하게 이미지만 변경할 거라면 이 구문은 필요 없습니다.
      console.log(idx);
  });
  $(".email a").mouseleave(function(){
      $(this).children("img").attr("src","image/icon1-1" +".png");
      $(this).css({"background-color":"transparent","color":""});
  });
  $(".sns a").mouseenter(function(){
    idx = $(this).index();
    $(this).children("img").attr("src",$(this).attr("href"));
    $(this).css({"background-color":"#3D725E","color":"#fff"}); 
    // 배경이 투명한 이미지를 사용 했다면 배경색을 변경할 수 있고, 이미지 아래쪽에 텍스트를 작성했다면 텍스트컬러도 변경해줍니다. 단순하게 이미지만 변경할 거라면 이 구문은 필요 없습니다.
    console.log(idx);
});
$(".sns a").mouseleave(function(){
    $(this).children("img").attr("src","image/icon1-2" +".png");
    $(this).css({"background-color":"transparent","color":""});
});
$(".map a").mouseenter(function(){
  idx = $(this).index();
  $(this).children("img").attr("src",$(this).attr("href"));
  $(this).css({"background-color":"#3D725E","color":"#fff"}); 
  // 배경이 투명한 이미지를 사용 했다면 배경색을 변경할 수 있고, 이미지 아래쪽에 텍스트를 작성했다면 텍스트컬러도 변경해줍니다. 단순하게 이미지만 변경할 거라면 이 구문은 필요 없습니다.
  console.log(idx);
});
$(".map a").mouseleave(function(){
  $(this).children("img").attr("src","image/icon1-3" +".png");
  $(this).css({"background-color":"transparent","color":""});
});
// 이미지 변경 끝
// gnb시작
$(".main_list").hover(function(){
$(".sub_menu" ,this).stop().slideDown(500);
},function(){
  $(".sub_menu" ,this).stop().slideUp(500);
})
// 스크롤 헤더 시 색상 변경
var $header = $('header'); //헤더를 변수에 넣기
var $page = $('#container'); //색상이 변할 부분
var $window = $(window);
var pageOffsetTop = $page.offset().top;//색상 변할 부분의 top값 구하기

$window.resize(function(){ //반응형을 대비하여 리사이즈시 top값을 다시 계산
  pageOffsetTop = $page.offset().top;
});

$window.on('scroll', function(){ //스크롤시
  var scrolled = $window.scrollTop() >= pageOffsetTop; //스크롤된 상태; true or false
  $header.toggleClass('down', scrolled); //클래스 토글
});
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
// 여기로 옮김
function topFunction() {
  var currentScrollPos = window.pageYOffset;
  console.log(`스크롤 했을 때 currentScrollPos의 값:${currentScrollPos}`);
  if (prevScrollpos > currentScrollPos) {
    document.getElementById("top_button").style.bottom = "10px";
  } else {
    document.getElementById("top_button").style.bottom = "-100px";
  }
  prevScrollpos = currentScrollPos;
}
});