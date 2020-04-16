<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 자바스크립트 외부 라이브러리 연결(jQuery) -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script type="text/javascript">
  //초기화 이벤트
  $(document).ready(function(){
	  
	  //검색버튼이 클릭이 되면
	  $("#btn_find").click(function(){
		  
		  //입력된 국가명을 얻어온다
		  var nation = $("#nation").val().trim();
		  if(nation==''){
			  alert('국가명을 입력하세요');
			  $("#nation").val("");
			  $("#nation").focus();
			  return;
		  }
		  
		  //jQuery이용해서 Ajax요청
		  //요청정보 및 결과에 대한 속성이 JSON으로 표기
		  // {'속성명1':'값1' , '속성명2':'값2' }
		  
		  //요청 : hello.do?nation=한국
		  //응답 : success: function(res_data){} 로 전달		  
		  $.ajax({
		      url : 'hello.do',
		      data: {'nation' : nation},
		      success: function(res_data){
                  
		    	  $("#disp").html(res_data);
		    	  
		      }
		  });
		  
	  });
	  	  
  });


</script>

</head>
<body>
국가명:<input id="nation" value="">
<input type="button" value="검색"  id="btn_find">
<hr>
<div id="disp"></div>

</body>
</html>