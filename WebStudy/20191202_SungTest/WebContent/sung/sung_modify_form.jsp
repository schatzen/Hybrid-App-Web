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
		
		//수정확인
        if(confirm("정말 수정하시겠습니까?")==false){
        	return;
        }		
 		
		
		//값체크가 완료되면
		f.action="modify.do";// SungModifyAction
		f.submit();
		
		
	}

</script>


</head>
<body>
	<div id="input_div">
		<form>
		   <table border="1">
		   		<caption>::::성적 수정::::</caption>
		   		<tr>
		   			<th>번호</th>
		   			<td><input name="idx"  value="${ vo.idx }" readonly="readonly"></td>
		   		</tr>
		   		<tr>
		   			<th>이름</th>
		   			<td><input name="name" value="${ vo.name }"></td>
		   		</tr>
		   		<tr>
		   			<th>국어</th>
		   			<td><input name="kor" value="${ vo.kor }"></td>
		   		</tr>
		   		<tr>
		   			<th>영어</th>
		   			<td><input name="eng" value="${ vo.eng }"></td>
		   		</tr>
		   		<tr>
		   			<th>수학</th>
		   			<td><input name="mat" value="${ vo.mat }"></td>
		   		</tr>
		   		<tr>
		   		    <td colspan="2" align="center">
		   		    	<input type="button" value="수정하기" 
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



