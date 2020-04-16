<%@page import="service.DBService"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%! int count = 0; %>

<%
   Connection conn = DBService.getInstance().getConnection();
   count++;
   //BasicDataSource에 반환
   conn.close();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
연결성공(<%= count %>)

</body>
</html>