<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
  도시목록
<hr>
	<ul>
	  <c:forEach var="sido" items="${ map.sido_list }"> 
	     <li>${ sido }</li>
	  </c:forEach>
	</ul>
	
<hr>
  과일목록
<hr>
	<ul>
	  <c:forEach var="fruit" items="${ map.fruit_list }"> 
	     <li>${ fruit }</li>
	  </c:forEach>
	</ul>	



</body>
</html>

