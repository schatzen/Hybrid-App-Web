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
   부서별 사원목록
 <hr>
 <table border="1">
 	<tr>
 	    <th>부서번호</th>
 	    <th>부서명</th>
 	    <th>위치</th>
 	</tr>
 	
 	<!-- for(DeptVo dept : list ) -->
 	<c:forEach var="dept"  items="${ list }">
 		<tr>
 			<td>${ dept.deptno }</td>
 			<td>${ dept.dname }</td>
 			<td>${ dept.loc }</td>
 		</tr>
 	</c:forEach>
 
 </table>
 
</body>
</html>


