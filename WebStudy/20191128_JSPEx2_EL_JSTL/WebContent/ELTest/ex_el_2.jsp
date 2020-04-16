<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   String name = "홍길동";

   //EL표현식으로 name을 사용하려면
   pageContext.setAttribute("name", name);
   
   
   //4개영역에 값을 Binding
   pageContext.setAttribute("page_value", "pageScope에 저장된값");
   request.setAttribute("request_value", "requestScope에 저장된값");
   session.setAttribute("session_value", "sessionScope에 저장된값");
   application.setAttribute("application_value", "applicationScope에 저장된값");
%>
<%--         ${ 영역이름.Key         }  
     영역명 생략가능 : 참조순서
     pageScope->requestScope->sessionScope->applicationScope 
 --%>
pageScope    : ${ pageScope.page_value }<br>
requestScope : ${ request_value }<br>   
sessionScope : ${ session_value }<br>
applicationScope : ${ application_value }<br> 
<!-- /ex_el_2.jsp?value=나파라메터야 -->
parameter: ${ param.value }<br>

이름을 EL로 출력: ${ pageScope.name }<br>





