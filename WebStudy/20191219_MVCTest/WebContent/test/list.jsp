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
	   Book List
	<hr>
       <c:forEach var="book"  items="${ requestScope.list }">
           <li>
              <input type="button" value="삭제" 
                     onclick="location.href='delete.do?book=${ book }'">
              <a href="view.do?book=${ book }">${ book }</a>
              
           </li>
       </c:forEach>

<a href="insert_form.do">입력폼으로..</a>


</body>
</html>