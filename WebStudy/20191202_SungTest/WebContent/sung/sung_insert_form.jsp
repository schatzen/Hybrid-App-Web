<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  #input_div{
      width: 400px;
      height: auto;
      margin: auto;
  }
  
  table {
	  width: 100%;
  }
</style>

<script type="text/javascript">
	
	var regular_jumsu = /^[0-9]{1,3}$/;//0~999
	
	function send(f){
		
		//
		var name = f.name.value.trim();
		var kor  = f.kor.value.trim();
		var eng  = f.eng.value.trim();
		var mat  = f.mat.value.trim();
		
		if(name==''){
			alert('이름을 입력하세요');
			f.name.value='';
			f.name.focus();
			return;
		}
		//점수체크
		if(regular_jumsu.test(kor)==false || kor<0 || kor>100){
			alert('0~100사이의 정수만 입력하세요');
			f.kor.value='';
			f.kor.focus();
			return;
		}
		
		if(regular_jumsu.test(eng)==false || eng<0 || eng>100){
			alert('0~100사이의 정수만 입력하세요');
			f.eng.value='';
			f.eng.focus();
			return;
		}
		
		
		if(regular_jumsu.test(mat)==false || mat<0 || mat>100){
			alert('0~100사이의 정수만 입력하세요');
			f.mat.value='';
			f.mat.focus();
			return;
		}
		
		
		//값체크가 완료되면
		f.action="insert.do";// SungInsertAction
		f.submit();
		
		
	}

</script>


</head>
<body>
	<div id="input_div">
		<form>
		   <table border="1">
		   		<caption>::::성적 입력::::</caption>
		   		<tr>
		   			<th>이름</th>
		   			<td><input name="name"></td>
		   		</tr>
		   		<tr>
		   			<th>국어</th>
		   			<td><input name="kor"></td>
		   		</tr>
		   		<tr>
		   			<th>영어</th>
		   			<td><input name="eng"></td>
		   		</tr>
		   		<tr>
		   			<th>수학</th>
		   			<td><input name="mat"></td>
		   		</tr>
		   		<tr>
		   		    <td colspan="2" align="center">
		   		    	<input type="button" value="등록하기" 
		   		    	       onclick="send(this.form);">
		   		    	<input type="button" value="목록보기"
		   		    	       onclick="location.href='list.do'">
		   		    </td>
		   		</tr>
		   </table>
		</form>    
	</div>
</body>
</html>




