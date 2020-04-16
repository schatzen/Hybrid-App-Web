<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

    var regular_number = /^[0-9]+$/;
	
    function send(f){
		
		var name = f.name.value.trim();
		var age  = f.age.value.trim();
		var tel  = f.tel.value.trim();
		
		if(name==''){
			alert('이름을 입력하세요');
			f.name.value='';
			f.name.focus();
			return;
		}
		
		if(tel==''){
			alert('전화번호를 입력하세요');
			f.tel.value='';
			f.tel.focus();
			return;
		}
		
		if(regular_number.test(age)==false){
			alert('나이는 숫자만 입력하세요');
			f.age.value='';
			f.age.focus();
			return;
		}
		
		f.action="insert.do";
		f.submit();
	}
	
	function send1(f){
		
		var name = f.name.value.trim();
		var age  = f.age.value.trim();
		var tel  = f.tel.value.trim();
		
		if(name==''){
			alert('이름을 입력하세요');
			f.name.value='';
			f.name.focus();
			return;
		}
		
		if(tel==''){
			alert('전화번호를 입력하세요');
			f.tel.value='';
			f.tel.focus();
			return;
		}
		
		if(regular_number.test(age)==false){
			alert('나이는 숫자만 입력하세요');
			f.age.value='';
			f.age.focus();
			return;
		}
		
		f.action="insert1.do";
		f.submit();
	}
	
	function send2(f){
		
		var name = f.name.value.trim();
		var age  = f.age.value.trim();
		var tel  = f.tel.value.trim();
		
		if(name==''){
			alert('이름을 입력하세요');
			f.name.value='';
			f.name.focus();
			return;
		}
		
		if(tel==''){
			alert('전화번호를 입력하세요');
			f.tel.value='';
			f.tel.focus();
			return;
		}
		
		if(regular_number.test(age)==false){
			alert('나이는 숫자만 입력하세요');
			f.age.value='';
			f.age.focus();
			return;
		}
		
		f.action="insert2.do";
		f.submit();
	}

</script>

</head>
<body>
  <form>
  	<table border="1">
  	    <caption>::::입력폼::::</caption>
  	    <tr>
  	        <th>이름</th>
  	        <td><input name="name" value="홍길동"></td>
  	    </tr>
  	    <tr>
  	        <th>나이</th>
  	        <td><input name="age"  value="20"></td>
  	    </tr>
  	    <tr>
  	        <th>전화</th>
  	        <td><input name="tel"  value="010-111-1234" ></td>
  	    </tr>
  	    <tr>
  	        <th>취미</th>
  	        <td>
  	           <input type="checkbox" name="hobby"  value="독서" >독서
  	           <input type="checkbox" name="hobby"  value="영화" >영화
  	           <input type="checkbox" name="hobby"  value="운동" >운동
  	           <input type="checkbox" name="hobby"  value="낚시" >낚시
  	        </td>
  	    </tr>
  	    
  	    <tr>
  	    	<td align="center" colspan="2">
  	    	    <input type="button" value="직접받기" 
  	    		                     onclick="send(this.form);">
  	    		<input type="button" value="낱개로받기" 
  	    		                     onclick="send1(this.form);">
  	    	    <input type="button" value="객체로받기" 
  	    	                         onclick="send2(this.form);">
  	    	</td>
  	    </tr>
  	</table>
  </form>


</body>
</html>