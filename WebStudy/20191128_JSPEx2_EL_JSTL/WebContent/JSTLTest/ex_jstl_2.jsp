<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@taglib prefix="fn"   uri="http://java.sun.com/jsp/jstl/functions" %>    
    
<%
	int money = 120000000;
    
    Date today = new Date();//현재시스템 날짜
    //               01234567890123456789012   
    String str_date="2019-11-29 12:12:12.003";
    
    //JSTL에 들어가는 값은 무조건 EL식으로 표현
    //EL로 표현하려면 scope영역에 저장되어야 함
    pageContext.setAttribute("money", money);
    pageContext.setAttribute("today", today);
    pageContext.setAttribute("str_date", str_date);

%>    

내돈: <fmt:formatNumber  value="${ money }"/> <br>
오늘날짜:<fmt:formatDate value="${ today }"  
                         pattern="YYYY년MM월dd일 HH:mm:ss"/>
<br>
문자열날짜:${ str_date }<br>
문자열날짜:${ fn:substring(str_date,0,0+10) }<br>
문자열시간:${ fn:substring(str_date,11,11+8) }<br>







