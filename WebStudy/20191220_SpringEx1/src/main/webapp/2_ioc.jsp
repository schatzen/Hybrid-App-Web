<%@page import="com.ts.test1.vo.PersonVo"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    //1.Spring Container(bean객체가 저장된 공간)정보 획득
    //  JSP내장객체 : ServletContext application;
    WebApplicationContext wc 
    = WebApplicationContextUtils.getWebApplicationContext(application);
    
    //id=p1인 bean정보 획득
    //                        id		
    PersonVo p1 = (PersonVo)wc.getBean("p1");	
    
    
    // <bean id="p2" scope="prototype"> 이므로 요청시마다 생성됨
    //                        id    Type
    PersonVo p2 = wc.getBean("p2", PersonVo.class);
    

    pageContext.setAttribute("p1", p1);
    pageContext.setAttribute("p2", p2);
    
%>    

<hr>
   spring이 생성한 객체 p1
<hr>    
이름:${ p1.name }<br>
나이:${ p1.age } <br>
주소:${ p1.addr }<br>

<hr>
   spring이 생성한 객체 p2
<hr>    
이름:${ p2.name }<br>
나이:${ p2.age } <br>
주소:${ p2.addr }<br>


