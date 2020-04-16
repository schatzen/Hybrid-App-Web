<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

  function del_in(idx){
	  
	  if(confirm("정말삭제하시겠습니까?")==false)return;
	  	  
	  location.href="delete_in.do?idx="+idx;
  }


</script>

</head>
<body>

<table>
	<caption>::::입고목록::::</caption>
	<tr>
		<th width="40%">제품명</th>
		<th width="20%">수량</th>
		<th width="40%">입고일자</th>
	</tr>
	
	<c:if test="${ empty map.in_list }">
		<td colspan="3" align="center">
		   입고목록이 없습니다
		</td>
	</c:if>
	
	<c:forEach var="vo" items="${ map.in_list }">
		<tr>
			<td>
			   <input type="button" value="x" 
			          onclick="del_in('${ vo.idx }');">
			   ${ vo.name }
			</td>
			<td>${ vo.cnt }</td>
			
			<!-- 2020-01-07 12:53:31.0 -->
			<td>${ fn:substring(vo.regdate,5,16) }</td>
		</tr>
	</c:forEach>
	
</table>


</body>
</html>