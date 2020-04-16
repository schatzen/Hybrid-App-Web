<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
  function comment_del(idx){
	  //$.ajax() 처리...
	  //alert('Ajax로 삭제 -> insert한것처럼 처리');
	  $.ajax({
		   url:"../comment/delete.do",
		   data:{'idx':idx},
		   dataType:'json',
		   success:function(res_data){
			   //res_data={'result':'success'}
			   if(res_data.result != 'success'){
				   alert("삭제 실패!!!");
				   return;
			   }
			   
			   alert("삭제 완료");
			   //성공시=> 댓글목록을 다시 가져오기
			   comment_list(1);
			   
		   },
		   error:function(request,status,error){
			   alert(request.responseText);
		   }
	   });
	  
	  
  }
</script>

</head>
<body>

<!-- Paging Menu -->
<hr>
  <!-- <a href='#' onclick="comment_list('1');">1</a> &nbsp;
  <a href='#' onclick="comment_list('2');">2</a> &nbsp;
  <a href='#' onclick="comment_list('3');">3</a> &nbsp;
  <a href='#' onclick="comment_list('4');">4</a> &nbsp; -->
  ${ pageMenu }
  

<!--   for(CommentVo vo : list )  -->
<c:forEach var="vo"  items="${ list }">
   <hr>
   작성자:${ vo.m_name }
   
   <!-- 작성자만 삭제 활성화 -->
   <c:if test="${ user.idx eq vo.m_idx }">   
      <input type="button"  value="x" onclick="comment_del('${ vo.idx }');">
   </c:if>   
      
   <br>
   작성일자:${ fn:substring(vo.regdate,0,16) }<br>
          
   내용:<pre>${ vo.content }</pre><br>
   
   
</c:forEach>



</body>
</html>