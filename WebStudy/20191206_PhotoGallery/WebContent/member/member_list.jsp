<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
 *{ margin: 0;}
 
 #main_box{
 	width: 1000px;
 	margin: auto;
 }

 table{
    width: 100%;
 }
 
 td{
 	text-align: center;
 } 
 
 #main_box > h1{
 	text-align: center;
 }
</style>

<script type="text/javascript">

	function del(f){
		
		if(confirm("정말 삭제하시겠습니까?")==false)return;
		
		//삭제
		location.href="delete.do?idx=" + f.idx.value;
	}
	
	
	function modify(f){
		
		//수정폼 띄우기
		location.href="modify_form.do?idx=" + f.idx.value;
	}
	

</script>


</head>
<body>
	<div id="main_box">
	   <h1>::::회원목록::::</h1>
	   <div style="text-align: right">
	       <input type="button"  value="회원가입"
	              onclick="location.href='insert_form.do'">
	       
	       <input type="button"  value="회원가입2"
	              onclick="location.href='insert_form2.do'">       
	   </div>
	   
	   <table border="1">
	      <tr>
	      	<th>번호</th>
	      	<th>이름</th>
	      	<th>ID</th>
	      	<th>비밀번호</th>
	      	<th>우편번호</th>
	      	<th>주소</th>
	      	<th>아이피</th>
	      	<th>가입일자</th>
	      	<th>수정일자</th>
	      	<th>구분</th>
	      	<th>비고</th>
	      </tr>
	      
	      <!-- Data가 없을경우 -->
	      <c:if test="${ empty list }">
	      	<tr>
	      	   <td align="center" colspan="11">
	      	      등록된 회원이 없습니다
	      	   </td>
	      	</tr>
	      </c:if>
	   
	      <!-- Data가 있을경우 -->
	      <!--  for(MemberVo member : list ) -->
	      <c:forEach  var="member"  items="${ list }">
		      <tr>
		        <td>${ member.idx }</td>
		        <td>${ member.name }</td>
		        <td>${ member.id }</td>
		        <td>${ fn:substring(member.pwd,0,1) }***</td>
		        <td>${ member.zipcode }</td>
		        <td>${ member.addr }</td>
		        <td>${ member.ip }</td>
		        <td>${ fn:substring(member.regdate,0,10) }</td>
		        <td>${ fn:substring(member.modifydate,0,10) }</td>
		        <td>${ member.grade }</td>
		        <td>
		          <form> 
		             <input type="hidden"  name="idx" value="${ member.idx }">
			            <input type="button"  value="수정" 
			                   onclick="modify(this.form);">
			            <input type="button"  value="삭제" 
			                   onclick="del(this.form);">
		          </form>  
		        </td>
		      </tr>
	      </c:forEach>
	      
	      
	   </table>
	   
	   
	   
	   
	   
	
	</div>
</body>
</html>