<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<link rel="stylesheet" href="${ pageContext.request.contextPath  }/resources/css/style.css" type="text/css">
<script language="JavaScript">
	function del(){
		if(confirm("삭제 하시겠습니까?")){
			
			location.href=
"delete.do?idx=${vo.idx}&page=${ param.page }&search=${ param.search}&search_text=${ param.search_text }";
            
        }
	}
	function modify(){
		
	    if(confirm("정말 수정하시겠습니까?")==false)return;
	    
	    location.href="modify_form.do?idx=${ vo.idx }&page=${ param.page }&search=${ param.search}&search_text=${ param.search_text }";
				
        
    }
	
	
	function reply(){

		//로그인 여부 체크
		if("${ empty user }"=="true"){
			
			if(confirm("답글쓰기는 로그인하신후 사용가능합니다"+
					   "\n로그인 하시겠습니까?")==false)return;
			//로그인폼으로 이동
			location.href="../member/login_form.do?url=" 
					      + encodeURIComponent(location.href);
			return;
		}
        
		//답글폼으로 이동
		location.href="reply_form.do?idx=${ vo.idx }&page=${ param.page }";
		

    }
</script>
</HEAD>

<BODY>
<table width="690" height="50" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td><img src="${ pageContext.request.contextPath  }/resources/img/title_04.gif"></td>
	</tr>
</table>

<form name="f" method="post">
<table width="690" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="120" height="25" class="td_d">제목</td>
		<td class="td_d_1">${ vo.subject }</td>
	</tr>
	<tr>
		<td width="120" height="25" class="td_d_4">작성자</td>
		<td class="td_d_2">${ vo.m_name }</td>
	</tr>
	<tr>
		<td width="120" height="25" class="td_d_4">작성일</td>
		<td class="td_d_2">${ fn:substring(vo.regdate,0,16) }</td>
	</tr>
	<tr>
		<td width="120" class="td_d_4">내용</td>
		<td class="td_d_3" width="570" 
            style="word-wrap:break-word;word-break:break-all">
			<pre>${ vo.content }</pre>
		</td>
	</tr>
</table>

<table width="690" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="5"></td>
	</tr>
	<tr>
		<td>
			<img src="${ pageContext.request.contextPath  }/resources/img/btn_list.gif" 
			         onClick="location.href='list.do?page=${ param.page }&search=${ param.search}&search_text=${ param.search_text }'" style="cursor:hand">
		
		    <!-- 메인글일때만 보여지게 depth eq 0 -->
		    <c:if test="${ (vo.depth eq 0) and (empty param.search or param.search eq 'all') }"> 
				<img src="${ pageContext.request.contextPath  }/resources/img/btn_reply.gif" 
				         onClick="reply();" style="cursor:hand">
			</c:if>         
			         
			<!-- 수정/삭제 권한은 글쓴이 또는 (관리자) -->
			<c:if test="${ user.idx eq vo.m_idx }">         
				<img src="${ pageContext.request.contextPath  }/resources/img/btn_modify.gif" 
				         onClick="modify()" style="cursor:hand">
		        <img src='${ pageContext.request.contextPath  }/resources/img/btn_delete.gif' 
		                 onClick='del()' style='cursor:hand'>
            </c:if>	                 
		</td>
	</tr>
</table>
</form>

<p><br>

<!-- 댓글폼  -->
<%@include file="board_comment_form.jsp" %>








</BODY>
</HTML>