<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
  EL
<hr>
[ ${ nation_name } ] 나라의 인사말 
[ ${ requestScope.greet_message } ]

<hr>
  Java Code
<hr>
<%= request.getAttribute("nation_name") %>:
<%= (String)request.getAttribute("greet_message") %>


</body>
</html>