<%@page import="java.util.Set"%>
<%@page import="util_test.MySet"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<%
    //Spring bean(객체)가 보관된 장소 관리객체정보
 	WebApplicationContext wc = 
 	   WebApplicationContextUtils.getWebApplicationContext(application);
 
    //저장되어있는 객체(?) => mySetBean
    MySet mySet = wc.getBean("mySetBean",MySet.class);
    //Set 얻어오기(누가 생성:Spring)
    Set set = mySet.getSet();
    
    //EL사용하려면...
    pageContext.setAttribute("set", set);

%>

<hr>
  Spring이 Constructor Injection을 통해서 생성한 Set
<hr>
	<ul>
	    <!--  for(String fruit : set)  -->
		<c:forEach var="fruit"  items="${ set }">
			<li>${ fruit }</li>
		</c:forEach>
	</ul>



