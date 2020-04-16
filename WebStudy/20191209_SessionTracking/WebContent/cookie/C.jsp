<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    //C.jsp방문기록을 쿠키에 담는다
    //                          key  value
    Cookie  cookie = new Cookie("C","C.jsp");

    //시간설정
    cookie.setMaxAge(60*10);//second단위

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

C.jsp입니다<br>
<a href="A.jsp">A로 이동</a>

</body>
</html>