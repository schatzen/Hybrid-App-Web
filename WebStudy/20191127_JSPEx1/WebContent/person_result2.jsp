<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%
   request.setCharacterEncoding("utf-8");
%> 
    
<!--
  /person_result.jsp?name=홍길동&age=20&addr=서울+마포+노고산동
-->

<!--  Parameter받기 -->
<!--  PersonVo p = new PersonVo(); -->
<jsp:useBean id="p"  class="vo.PersonVo" />
<!-- * : 모든속성값을 받겠다 
         parameter명==속성명 같을경우만 가능   
-->
<jsp:setProperty name="p" property="*"/>


    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
수신된 데이터
<hr>
이름:<jsp:getProperty property="name" name="p"/><br>
나이:<jsp:getProperty property="age"  name="p"/><br>
주소:<jsp:getProperty property="addr" name="p"/><br>

</body>
</html>