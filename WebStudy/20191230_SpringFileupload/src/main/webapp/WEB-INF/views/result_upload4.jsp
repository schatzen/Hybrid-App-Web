<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
제목:${ vo.title }
<hr>
<img src="resources/upload/${ vo.filename1 }" width="200">
<img src="resources/upload/${ vo.filename2 }" width="200">
<br>

<a href="insert_form2.do">다시하기</a>
</body>
</html>