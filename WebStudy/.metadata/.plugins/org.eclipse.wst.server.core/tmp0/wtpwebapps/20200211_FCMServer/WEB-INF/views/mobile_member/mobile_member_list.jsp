<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	function send(f){
		
		var title   = f.title.value.trim();
		var content = f.content.value.trim();
		var select_idx = false;//전송대상이 선택되었나?
		
		if(title==''){
			alert('제목을 입력하세요');
			f.title.value='';
			f.title.focus();
			return;
		}
		
		if(content==''){
			alert('내용을 입력하세요');
			f.content.value='';
			f.content.focus();
			return;
		}
		
		//체크박스 선택여부
		
		for(var i=0;i < f.idx.length;i++){
			if(f.idx[i].checked==true){
				select_idx=true;
				break;
			} 
		}
		
		if(select_idx==false){
			alert('전송 대상을 선택하세요');
			return;
		}
		
		//전송     /mobile_member/send_message.do 
		f.action = "send_message.do";
		f.submit();
			
		
		
	}


</script>

</head>
<body>
<form>
    <!-- 메시지 입력창 -->
    <table border="1" width="500">
        <tr>
            <th>제목</th>
            <th><input name="title" ></th>
        </tr>
        <tr>
            <th>내용</th>
            <th><input name="content" ></th>
        </tr>
        <tr>
           <td colspan="2" align="center">
                <input type="button" value="메시지 전송" 
                                     onclick="send(this.form);">
                                     
                <input type="reset"  value="초기화">
           </td>
        </tr>
    </table>

 	<table border="1" width="500">
 		<tr>
 		    <th>번호</th>
 		    <th>이름</th>
 		    <th>아이디</th>
 		    <th>비밀번호</th>
 		    <th>토큰ID</th>
 		</tr>
 		
 		<!-- Data -->
 		<!--  for(MobileMemberVo vo: list) -->
 		<c:forEach var="vo" items="${ list }">
	 		<tr>
	 			<td>
	 			   <input   type="checkbox"  name="idx" value="${ vo.idx }">
	 			   ${ vo.idx }
	 			</td>
	 			<td>${ vo.name }</td>
	 			<td>${ vo.id }</td>
	 			<td>${ fn:substring(vo.pwd,0,2) }**</td>
	 			<td>${ fn:substring(vo.device_token,0,10) }...</td>
	 		</tr>
 		</c:forEach>
 	
 	</table>


</form>


</body>
</html>