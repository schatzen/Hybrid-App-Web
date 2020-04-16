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

	//주민번호 정규식
	var regular_jumin =/\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])-[1-8]\d{6}/;

	$(document).ready(function(){
		
		$("#btn_result").click(function(){

			var jumin_no = $("#jumin_no").val();
			if(regular_jumin.test(jumin_no)==false){
				alert('주민번호 형식이 아닙니다');
				$("#jumin_no").val("");
				$("#jumin_no").focus();
				return;
			}
			
			
			$.ajax({
				url:'jumin.do',
				type:'GET',
				data:{'jumin_no':jumin_no},
				dataType:'json',
				success:function(res_data){
					
					$("#year").html(res_data.year);
					$("#age").html(res_data.age);
					$("#tti").html(res_data.tti);
					$("#gender").html(res_data.gender);
					$("#season").html(res_data.season);
					$("#local").html(res_data.local);
					
				},
			    error: function (request, status, error){        
			        var msg = "ERROR : " + request.status + "\n"
			                  msg +=  + "내용 : " + request.responseText + "\n" + error;
			        alert(msg);
			        console.log(msg);              
			    }


			});
			
			
		});
	});


</script>



</head>
<body>
주민번호:<input id="jumin_no" value="800312-1234560">
         <input type="button" value="결과" id="btn_result">
<hr>

<table border="1">
    <tr>
    	<th>출생년도</th>
    	<td width="120"><span id="year"></span></td>
    </tr>
    <tr>
    	<th>나이</th>
    	<td><span id="age"></span></td>
    </tr>
    <tr>
    	<th>띠</th>
    	<td><span id="tti"></span></td>
    </tr>
    <tr>
    	<th>성별</th>
    	<td><span id="gender"></span></td>
    </tr>
    <tr>
    	<th>출생계절</th>
    	<td><span id="season"></span></td>
    </tr>
    <tr>
    	<th>출생지역</th>
    	<td><span id="local"></span></td>
    </tr>
</table>


          
</body>
</html>