<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    System.out.println("--a.jsp : redirect:b.jsp --");
    //페이지 전환(b.jsp)  
    response.sendRedirect("b.jsp");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
a.jsp
</body>
</html>