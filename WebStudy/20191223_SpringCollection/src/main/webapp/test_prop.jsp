<%@page import="java.util.Set"%>
<%@page import="java.util.Properties"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="util_test.MyProp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<%
	//Spring bean(객체)가 보관된 장소 관리객체정보
	WebApplicationContext wc = 
	   WebApplicationContextUtils.getWebApplicationContext(application);
     
    //myPropBean
    MyProp  myProp = wc.getBean("myPropBean",MyProp.class);
    
    Properties prop = myProp.getProp();
    
    Set        set  = prop.keySet(); 
    
    pageContext.setAttribute("prop", prop);
    pageContext.setAttribute("set", set);
  
    pageContext.setAttribute("myProp", myProp);
    
 
 %>
 
 <hr>
    Properties는 Map의 자식이므로 표현방법은 동일하다
 <hr>
 
 <c:forEach var="key"  items="${ set }">
 	key:${ key } => ${ prop[key] } <br>
 </c:forEach>
 
 
 
 
 
 