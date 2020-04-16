<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>


<style type="text/css">
   #comment_area{
     width: 500px;
  }
  
  #div_content{
     width: 80%;
     float: left;
  }
  
  #div_bt{
  	 width: 20%;
  	 float: left;
  }
  
  #comment_content{
     width: 98%;
     height: 60px;
     resize: none;
  }
  
  #bt_comment{
     width: 100%;
     height: 65px;
  }

</style>

<script type="text/javascript">

   function comment_list(page){
	   
	   $.ajax({
		   url: '../comment/list.do',
		   data: {'b_idx':'${ vo.idx }','page':page},
		   success:function(res_data){
			   $("#disp").html(res_data);
		   },
		   error:function(request,status,error){
			   alert(error);
		   }
	   });
   }

   function write_comment(){
	   
	   //1.로그인 여부
	   if("${ empty user }" =="true"){
		  
		   if(confirm("댓글은 로그인 하신후 사용가능합니다\n"+
				      "로그인 하시겠습니까?")==false)return;
		   
		   //로그인폼으로 이동
		   location.href="../member/login_form.do?url=" + 
				          encodeURIComponent(location.href);
		   return;
	   }
	   
	   //2.입력값 체크
	   var content = $("#comment_content").val().trim();
	   if(content==''){
		   alert("댓글 내용을 작성하세요");
		   $("#comment_content").val("");
		   $("#comment_content").focus();
		   return;
	   }
	   
	   //3.입력내용 전송(Ajax)
	   $.ajax({
		   url:"../comment/insert.do",
		   data:{
			     'content':content,
			     'm_idx':'${ user.idx }',
			     'm_name':'${ user.name }',
			     'b_idx':'${ vo.idx }'
			    },
		   dataType:'json',
		   success:function(res_data){
			   //res_data={'result':'success'}
			   if(res_data.result != 'success'){
				   alert("댓글쓰기 실패!!!");
				   return;
			   }
			   
			   //성공시=> 댓글목록을 다시 가져오기
			   comment_list(1);
			   
			   //이전작성내용 지우기
			   $("#comment_content").val("");
			   
		   },
		   error:function(request,status,error){
			   alert(request.responseText);
		   }
	   });
	   
	   
   }


   $(document).ready(function(){
	   comment_list(1);
	   
	   //댓글쓰기 이벤트
	   $("#bt_comment").click(function(){
		   write_comment();
	   });
	   
	   
   });


</script>



</head>
<body>

<!-- 댓글등록폼 -->
<div id="comment_area">
   <div id="div_content">
     <textarea id="comment_content"></textarea>     
   </div>
   <div id="div_bt">
     <input id="bt_comment" type="button"  value="댓글쓰기"> 
   </div>

   <hr style="clear:both; height : 30px; display: none;">
   <div id="disp"></div>

</div>

</body>
</html>