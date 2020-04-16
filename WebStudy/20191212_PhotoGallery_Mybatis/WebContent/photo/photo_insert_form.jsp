<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	function send(f){
		
		var p_subject = f.p_subject.value.trim();
		var p_content = f.p_content.value.trim();
		var photo     = f.photo.value;
		
		//체크
		if(p_subject==''){
			alert('제목을 입력하세요');
			f.p_subject.value='';
			f.p_subject.focus();
			return;
		}
		
		if(p_content==''){
			alert('내용을 입력하세요');
			f.p_content.value='';
			f.p_content.focus();
			return;
		}
		
		if(photo==''){
			alert('사진을 선택하세요');
			return;
		}
		
		
		//전송
		f.action="insert.do";//PhotoInsertAction
		f.submit();//
		
	}

</script>

</head>
<body>
  <form method="POST" enctype="multipart/form-data">
      <table border="1" align="center" width="400">
      	<caption>::::사진올리기::::</caption>
      	<tr>
      		<th>제목</th>
      		<td><input name="p_subject"></td>
      	</tr>
      	<tr>
      		<th>내용</th>
      		<td>
      		    <textarea name="p_content" rows="5" cols="50"></textarea>
      		</td>
      	</tr>
      	<tr>
      		<th>사진</th>
      		<td><input type="file" name="photo"></td>
      	</tr>
      	
      	<tr>
      		<td colspan="2" align="center">
      		    <input type="button"  value="사진올리기"
      		           onclick="send(this.form);" >
      		    <input type="button"  value="목록보기"
      		           onclick="location.href='list.do'"> 
      		</td>
      	</tr>
      	      	
      </table>
  </form>
</body>
</html>