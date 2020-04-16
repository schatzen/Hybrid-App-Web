<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
  
  td{
    text-align: center;
  }
  
  #title{
      width: 250px;
      margin: 10px;
      text-align: left;
  }

  #author{
     width: 100px;
     /* ellipsis 처리 */
	overflow:hidden;
    text-overflow:ellipsis;
    white-space:nowrap;
  }
  
  a{
     text-decoration: none;
     color: #8888ff;
  }
  
  a:hover{
     color:#1111ff;
  }
  
  

</style>

</head>
<body>
	<table border="1" width="">
		<!-- title -->
		<tr>
		   <th width=80>이미지</th>
		   <th width=250>제목</th>
		   <th width=80>저자</th>
		   <th width=80>정가</th>
		   <th width=80>할인가</th>
		   <th width=100>출판사</th>
		   <th width=100>출판일자</th>
		</tr>
		
		<!-- Data -->
		<!--   for(BookVo book : list)   -->
		<c:forEach var="book"  items="${ list }">
		  <tr>
			   <td>
			      <img src="${ book.image }" width="80" height="100">
			   </td>
			   <td>
			      <div id="title">
			         <a href="${ book.link }">${ book.title }</a>
			      </div> 
			   </td>
			   <td><div id="author">${ book.author }</div></td>
			   <td><fmt:formatNumber value="${ book.price }"  type="currency"/> </td>
			   <td><fmt:formatNumber value="${ book.discount }"  type="currency"/></td>
			   <td>${ book.publisher }</td>
			   <td>${ book.pubdate }</td>
		  </tr> 
		</c:forEach>
			
		
	</table>
	
</body>
</html>