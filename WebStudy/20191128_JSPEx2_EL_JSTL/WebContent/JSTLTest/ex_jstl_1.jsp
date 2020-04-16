<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!-- JSTL을 사용하려면 --> 
<%@taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core"%>    
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn"   uri="http://java.sun.com/jsp/jstl/functions" %>
    
<%--
   JSTL(JSP Standard Tag Library)
   : JSP내에서 사용되는 Tag를 이용한 명령
   
   Core: <c:if>             if forEach  choose ... set 
   Fmt : <fmt:formatNumber> 숫자,날짜 포맷
   Fn  : ${ fn:substring(문자열,0,3) }"substring ....

--%>    

<%
    String [] fruit_array = {"사과","배","참외","딸기","포도"};
	//JSTL(EL)을 사용하려면 scope
	pageContext.setAttribute("fruit_array", fruit_array);
	
%>

<hr>
  과일목록
<hr>
	<ul> <!-- items="배열 or 컬렉션(Set,List)" -->
	   <!--  for(String fruit : fruit_array){
	   
	         }
	    --> 
	   <c:forEach var="fruit" items="${ fruit_array }">
	   		<li>${ fruit }</li>
	   </c:forEach>
	</ul>


<hr>

<!--              시작    끝      증가 -->      
<c:forEach begin="1" end="5" step="1" varStatus="i">  
   <!-- 홀수 -->
   <c:if test="${ i.index%2 == 1 }">  
        <font color=red>${ pageScope.i.index } : 안녕<br></font>
   </c:if>
   <!-- 짝수 -->
   <c:if test="${ i.index mod 2 eq 0 }">
   		<font color=blue>${ i.index } : 안녕<br></font>
   </c:if>
</c:forEach>

<hr>
    
    
    
    
    
    
    
    