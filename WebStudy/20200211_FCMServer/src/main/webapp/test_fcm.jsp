<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script type="text/javascript">

  //jQuery초기화
  $(document).ready(function(){
	  
	  //전송버튼 클릭하면
	  $("#bt_send").click(function(){
		  
		  var title   = $("#title").val().trim();
		  var content = $("#content").val().trim();
		  
		  if(title==''){
			  alert("제목 입력하세요");
			  
			  $("#title").val("");
			  $("#title").focus();
			  return;
		  }
		  
		  if(content==''){
			  alert("내용 입력하세요");
			  
			  $("#content").val("");
			  $("#content").focus();
			  return;
		  }
		  
		  $.ajax({
			  url:'send_fcm_all.do',
			  data:{'title':title,'content':content},
			  success:function(res_data){
				  
				  if(res_data=='success'){
					  //alert('메시지 전송 성공');
				  }else{
					  //alert('메시지 전송 실패');
				  }
				  
			  }
		  });
		  
		  
	  });
	  
	  
  });



</script>

</head>
<body>


제목:<input id="title" value="제목1"><br>
내용:<textarea id="content" rows="5" cols="40">내용작성</textarea><br>
<input type="button"  id="bt_send" value="메시지 보내기"> 

</body>
</html>