<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    //B.jsp방문기록을 쿠키에 담는다
    //                          key  value
    Cookie  cookie = new Cookie("B","B.jsp");

    response.addCookie(cookie); 
    
%>        
   
<%@include file="pop.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

B.jsp입니다<br>
<a href="C.jsp">C로 이동</a>


</body>
</html>