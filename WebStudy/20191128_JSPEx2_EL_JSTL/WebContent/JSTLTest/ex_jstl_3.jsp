<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>

<%
     List<String> sido_list = new ArrayList<String>();
     sido_list.add("서울");
     sido_list.add("경기");
     sido_list.add("인천");
     sido_list.add("대전");
     sido_list.add("부산");
     sido_list.add("목포");
     
     //왜?
     request.setAttribute("sido_list", sido_list);
%>
<hr>
  도시목록
<hr>
  <ul>
     <!-- for(String sido:sido_list) 동일함 -->
     <c:forEach var="sido"  items="${ sido_list }">
         <li>${ sido }</li>
     </c:forEach>
  </ul>







