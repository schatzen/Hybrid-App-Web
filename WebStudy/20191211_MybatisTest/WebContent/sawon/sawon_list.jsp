<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@taglib prefix="fn"   uri="http://java.sun.com/jsp/jstl/functions" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<!-- title -->
	<tr>
		<th>사번</th>
		<th>이름</th>
		<th>직위</th>
		<th>성별</th>
		<th>부서번호</th>
		<th>상사번호</th>
		<th>입사일자</th>
		<th>년봉</th>
	</tr>
	<!-- data -->
	<!--  for(SawonVo sawon : list )  -->
	<c:forEach var="sawon" items="${ list }">
	   <tr>
	   		<td>${ sawon.sabun }</td>
	   		<td>${ sawon.saname }</td>
	   		<td>${ sawon.sajob }</td>
	   		<td>${ sawon.sasex }</td>
	   		<td>${ sawon.deptno }</td>
	   		<td>${ sawon.samgr }</td>
	   		<td>${ fn:substring(sawon.sahire,0,10) }</td>
	   		<td><fmt:formatNumber type="currency" 
	   		                      value="${ sawon.sapay }"/></td>
	   </tr> 
	</c:forEach>
	
</table>

</body>
</html>