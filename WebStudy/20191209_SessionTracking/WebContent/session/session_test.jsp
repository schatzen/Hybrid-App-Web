<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
     String id = session.getId();
     long session_time = session.getCreationTime();
     Date  d = new Date(session_time);
     
     //세션시간 설정(유휴시간) : IDLE Time
     session.setMaxInactiveInterval(60);
     

     System.out.println(id);
%>    
    
세션 ID : <%= id %> <br>
생성시간: <%= d.toString() %>
