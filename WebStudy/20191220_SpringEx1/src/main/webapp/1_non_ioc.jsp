<%@page import="com.ts.test1.vo.PersonVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
      //1.방법
      PersonVo p1 = new PersonVo("일길동",30,"서울 마포 창천동");

      //2.방법 
      PersonVo p2 = new PersonVo();
      p2.setName("이길동");
      p2.setAge(20);
      p2.setAddr("서울 마포 노고산동");
      
      //EL사용하려면 영역에 등록
      pageContext.setAttribute("p1", p1);
      pageContext.setAttribute("p2", p2);
      
%>

<hr>
  p1's info
<hr>    
이름:${ pageScope.p1.name } <br>
나이:${ p1.age } <br>
주소:${ p1.addr }<br>


<hr>
  p2's info
<hr>    
이름:${ p2.name } <br>
나이:${ p2.age } <br>
주소:${ p2.addr }<br>


    
