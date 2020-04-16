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

<table border="1">
  <tr>
  	 <th>이름</th>
  	 <th>별명</th>
  	 <th>나이</th>
  	 <th>전화(휴대)</th>
  	 <th>전화(집)</th>
  </tr>

  <!--  for(PersonVo p : list)   --> 
  <c:forEach var="p"  items="${ list }">
      <tr>
          <td>${ p.name }</td>
          <td>${ p.nickname }</td>
          <td>${ p.age }</td>
          <td>${ p.tel }</td>
          <td>${ p.hometel }</td>      
      </tr>
  </c:forEach>



</table>

</body>
</html>