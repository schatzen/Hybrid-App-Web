<%@ page import="java.util.Random"%>
<%@ page import="java.util.Calendar"%>
<%@ page language="java" 
    contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"
%>

<%!
   //JSP선언부
   int a;
   Calendar c = Calendar.getInstance();
   Random rand = new Random();
   public void sub(){}
%>


<%
   //Scriptlet
   //이부분이 어디에 기록되지?=> _jspService()에 기록
   String name="홍길동";
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1><%= name %>님 안녕하세요...</h1>
<h2>반갑습니다</h2>

</body>
</html>