<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  #disp{
     
     width: 300px;
     min-height: 200px;
     height: auto;
     background: black;
     color: white;
  }
</style>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script type="text/javascript">
   var g_visit_array;
   
   function del(i){
	   var visit = g_visit_array[i];
	   //비번체크
	   var c_pwd = prompt("비밀번호:");
	   if(c_pwd=='')return;
	   
	   if(visit.pwd != c_pwd){
		   alert('삭제 비밀번호가 틀립니다');
		   return;
	   }
	   
	   // visit/20
	   $.ajax({
		   type:'DELETE',
		   url:'visit/' + visit.idx,
		   /* data:{'idx': visit.idx }, */
		   dataType: 'json',
		   success:function(res_data){
			  //res_data = {"result":1};
			  if(res_data.result==1){
				  
				  //ul tag 자식요소 li요소를 모두 삭제
				  $("#visit_list").children().remove();
				  
				  $("#disp").html("");
				  
				  //전체내용 갱신
				  read_visit_list('all','all');
				  
				  alert('삭제성공');
			  }
		   }
	   });		   
			      
   }
   
   function show(i){
	   var visit = g_visit_array[i];
	   $("#disp").html( visit.name +"<hr>" + visit.content );
	   
   }
   
   function read_visit_list(search,search_text){
	   //http://localhost:9090/db2/visit_test.jsp
	   
	   //jQuery Ajax
	   $.ajax({
		   //    visits/{search}/{search_text} 
		   //    visits/all/all
		   url:"visits/" + search +"/" +  search_text,
		   /* data:{'search':search,'search_text':search_text}, */
		   type: 'GET',
		   dataType:'json',
		   success:function(res_data){
			   //res_data = {"list": [ {"idx":20,"name":"길동",...} ]}
			   var visit_array = g_visit_array = res_data.list;
			   
			   //alert(visit_array.length);
			   for(var i=0;i< visit_array.length;i++){
				   var visit = visit_array[i];
				   var li = "<li>"+ (visit.name)  
				        +"<input type='button'" 
				        +"value='보기' onclick='show("+ i +");'>"
				        +"<input type='button'" 
				        +"value='삭제' onclick='del("+ i +");'>"
				        + visit.pwd
				        +"</li>";
				       
				   $("#visit_list").append(li);				   
			   }
		   },
		   error:function(request,status,error){
			   alert(error);
			   alert(request.responseText);
		   }
		   
	   });
	   
   }
   
   
   $(document).ready(function(){
	   
	   read_visit_list('all','all');
   });

   
   //글쓰기
   function send(){
	   
	   var name 	= $("#name").val();
	   var content 	= $("#content").val();
	   var pwd 		= $("#pwd").val();
	   
	   if(name==''){
		   alert('이름을 입력하세요');
		   $("#name").val("");
		   $("#name").focus();
		   reutrn;
	   }
	   
	   if(content==''){
		   alert('내용을 입력하세요');
		   $("#content").val("");
		   $("#content").focus();
		   reutrn;
	   }
	   
	   if(pwd==''){
		   alert('비밀번호를 입력하세요');
		   $("#pwd").val("");
		   $("#pwd").focus();
		   reutrn;
	   }
	   
	   $.ajax({
		   url:'visit',
		   //전송데이터 정보
		   type:'POST',
		   headers: {
			      'Content-Type': 'application/json'
			    },
		   data:JSON.stringify({
					name : name,
					content : content,
					pwd : pwd
			    }),
			//수신데이터 정보
			dataType : 'json',
			success : function(res_data) {
				if (res_data.result == 0) {
					alert('입력실패');
					return;
				}

				//입력값 지우기
				$("#name").val("");
				$("#content").val("");
				$("#pwd").val("");

				//ul tag 자식요소 li요소를 모두 삭제
				$("#visit_list").children().remove();
				//전체내용 갱신
				read_visit_list('all', 'all');

				alert('추가 성공');
			}
		});

	}
</script>

</head>
<body>
<hr>
  방명록 목록
<hr>
<ul id="visit_list">

</ul>
<hr>
<div id="disp"></div> 
<hr>
<table border="1" width=300>
   <tr>
      <th width="100">이름</th>
      <td><input id="name"></td>
   </tr>
   <tr>
      <th>내용</th>
      <td><textarea id="content" cols="30" rows="5"></textarea></td>
   </tr>
   <tr>
      <th>비번</th>
      <td><input type="password" id="pwd"></td>
   </tr>
   <tr>
   	 <td colspan="2" align="center">
   	     <input type="button"  value="글쓰기" onclick="send();">
   	 </td>
   </tr>
</table>



</body>
</html>