<%@page import="java.util.ArrayList"%>
<%@page import="vo.PersonVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    

<%
      List<PersonVo> p_list = new ArrayList<PersonVo>();
      p_list.add(new PersonVo("일길동",31,"서울 마포 노고산1동"));
      p_list.add(new PersonVo("이길동",32,"서울 마포 노고산2동"));
      p_list.add(new PersonVo("삼길동",33,"서울 마포 노고산3동"));
      p_list.add(new PersonVo("사길동",34,"서울 마포 노고산4동"));
      p_list.add(new PersonVo("오길동",35,"서울 마포 노고산5동"));
      
      pageContext.setAttribute("p_list", p_list);
%>

<table border="1">
   <!-- title -->
   <tr>
   		<th>순번</th>
   		<th>이름</th>
   		<th>나이</th>
   		<th>주소</th>
   </tr>
   
   <!-- data -->
   <!--   for(PersonVo p : p_list) 같다  -->
   <c:forEach var="p" items="${ p_list }"  varStatus="i">
	   <tr>
	   		<td>${ i.index + 1 }</td>
	   		<td>${ p.name }</td>
	   		<td>${ p['age'] }</td>
	   		<td>${ p.addr }</td>
	   </tr>
   </c:forEach>


</table>








    

    
    
    