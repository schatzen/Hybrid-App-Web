<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
  [${ title }]입력결과
<hr>
이름:${ requestScope.vo.name }<br>
나이:${ vo.age }<br>
전화:${ vo.tel }<br>
취미:
     <!-- 취미 없는경우 -->
     <c:if test="${ empty vo.hobby }">
         취미없음
     </c:if>  
     
     <!-- 취미있는경우 -->
     <c:forEach var="hobby"  items="${ vo.hobby }">
         ${ hobby } &nbsp;
     </c:forEach>
<br>

<a href="insert_form.do">다시하기</a>


</body>
</html>