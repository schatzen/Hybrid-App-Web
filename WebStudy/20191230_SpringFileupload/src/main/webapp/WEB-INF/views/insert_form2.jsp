<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	function send1(f) {
		var title = f.title.value.trim();
		var photo1 = f.photo[0].value;
		var photo2 = f.photo[1].value;
		
		if(title==''){
			alert('제목을 입력하세요');
			f.title.value='';
			f.title.focus();
			return;
		}
		
		if(photo1==''){
			alert('사진을 선택하세요');
			return;
		}
		
		if(photo2==''){
			alert('사진을 선택하세요');
			return;
		}
		
		f.action="upload3.do";
		f.submit();
	}
	
	function send2(f) {
		var title = f.title.value.trim();
		var photo1 = f.photo[0].value;
		var photo2 = f.photo[1].value;
		
		if(title==''){
			alert('제목을 입력하세요');
			f.title.value='';
			f.title.focus();
			return;
		}
		
		if(photo1==''){
			alert('사진을 선택하세요');
			return;
		}
		
		if(photo2==''){
			alert('사진을 선택하세요');
			return;
		}
		
		f.action="upload4.do";
		f.submit();
	}

</script>

</head>
<body>

<!-- 
     화일업로시 체크 
     method="POST" 
     enctype="multipart/form-data"
-->
<form method="POST" enctype="multipart/form-data">
   제목:<input name="title"><br>
   <!-- spring에서 복수화일업로드시 이름을 동일하게 해야된다 -->
   사진1:<input type="file" name="photo"><br>
   사진2:<input type="file" name="photo"><br>
   <input type="button"  value="업로드(방법1:낱개)" 
                         onclick="send1(this.form);">
   <input type="button"  value="업로드(방법2:객체)"
                         onclick="send2(this.form);">
</form>


</body>
</html>