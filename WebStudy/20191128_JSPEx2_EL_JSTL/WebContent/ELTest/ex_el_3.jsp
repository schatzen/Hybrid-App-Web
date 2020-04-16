<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="vo.PersonVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    //자바객체
	PersonVo p = new PersonVo();
    p.setName("홍길동");
    p.setAge(20);
    p.setAddr("서울 마포 노고산동");
    
    //Map
    Map map = new HashMap();
    //       Key    , Value
    map.put("driver","oracle.jdbc.driver.OracleDriver");
    map.put("url"   ,"jdbc:oracle:thin:@localhost:1521:xe");
    map.put("user"  ,"scott");
    map.put("pwd"   ,"tiger");
       
        
    //EL사용하려면 영역중 1곳에 등록
    pageContext.setAttribute("p", p);
    pageContext.setAttribute("map", map);

%>
<hr>
p's info    
<hr>
<!--           p.getName() call      -->
이름:${ pageScope.p.name }<br>
<!--    p.getAge() call              --> 
나이:${ p.age }<br>
주소:${ p['addr'] }<br>

<hr>
  map's value
<hr>
<%--                영역.map.key   --%>
Driver: ${ pageScope.map.driver }<br>
Url   : ${ map.url }<br>
User  : ${ map['user'] }<br>
Pwd   : ${ map["pwd"] }<br>
    
    
