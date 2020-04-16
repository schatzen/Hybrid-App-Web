<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!-- JSTL을 사용하려면 lib 등록 -->
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="css/main.css">
<link rel="stylesheet"  href="css/main_menu.css">
<link rel="stylesheet"  href="css/sub_menu.css">

</head>
<body>

	<div id="main_box">
		<div id="header">
		   <!-- 제목 + 메뉴작성  -->
		   <%@include file="header/header.jsp" %>
		   
		</div>
		<div id="aside">
		   <%@include file="menu/submenu_company.jsp" %>
		</div>
		<div id="content">
			<!-- 
			     //               parameter(인자)
			     main_company.jsp   
			     main_company.jsp?menu=intro
			     main_company.jsp?menu=history
			     main_company.jsp?menu=location
			 -->
			 <%-- EL표현 : ${ 변수 } --%>
			 <c:if test="${ empty param.menu  ||  param.menu == 'intro' }">
			 	<%@include file="content/company/intro.jsp" %>
			 </c:if>
			 
			 <c:if test="${ param.menu == 'history' }">
			 	<%@include file="content/company/history.jsp" %>
			 </c:if>
			 
			 <c:if test="${ param.menu == 'location' }">
			 	<%@include file="content/company/location.jsp" %>
			 </c:if>
			 
		</div>
		
		<div id="footer">
		   <%@include file="footer/footer.jsp" %>
		</div>
	</div>

</body>
</html>