<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="util_test.MyMap"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<%
	//Spring bean(객체)가 보관된 장소 관리객체정보
	WebApplicationContext wc = 
	   WebApplicationContextUtils.getWebApplicationContext(application);  
    /* 작업순서
       1.Spring Container내의 MyMap정보구하기
       2.MyMap내의 map얻기
       3.map's keySet얻기
       4.pageContext binding(map,set)
       5.EL로 출력
    */
    
    //1
    MyMap  myMap = wc.getBean("myMapBean",MyMap.class);
    
    //2
    Map    map   = myMap.getMap();
    
    //3.
    Set    set   = map.keySet();
    
    //4
    pageContext.setAttribute("map", map);
    pageContext.setAttribute("set", set);
%>

<ul>
	<c:forEach var="key" items="${ set }">
	     <li>${ key } : ${ map[key] }</li>
	</c:forEach>
</ul>






