<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="util_test.MyList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<%
    //Spring bean(객체)가 보관된 장소 관리객체정보
 	WebApplicationContext wc = 
 	   WebApplicationContextUtils.getWebApplicationContext(application);

    MyList myList = wc.getBean("myListBean",MyList.class);
    
    //EL사용하려면...
    pageContext.setAttribute("myList", myList);
 
%>

<hr>
  도시목록
<hr>

	<ul>
	   <!--  for(String sido : myList.getList()) -->
	   <c:forEach var="sido"  items="${ myList.list }">
	   		<li>${ sido }</li>
	   </c:forEach>
	</ul>














