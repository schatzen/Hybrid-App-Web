<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>목록보기</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath  }/resources/css/style.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html;">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">

	function insert_form(){
		
		//로그인 여부 체크
		if("${ empty user }"=="true"){
			
			if(confirm("글쓰기는 로그인하신후"+
					   "\n사용가능합니다"+
					   "\n로그인 하시겠습니까?")==false)return;
			//로그인폼으로 이동
			location.href="../member/login_form.do";
			return;
		}
		
		
		//입력폼으로 이동
		location.href = "insert_form.do";
	}
	
	function search(){
		
		var search      = $("#search").val();
		var search_text = $("#search_text").val().trim();
		
		//전체검색이 아니면 검색내용이 있어야 함
		if(search !='all' && search_text==''){
			alert("검색내용을 입력하세요");
			 $("#search_text").val("");
			 $("#search_text").focus();
			return;
		}
		//전체검색이면 검색내용 지우기
		if(search=='all') search_text='';
		
		//검색어 붙여서 목록요청
		location.href="list.do?search=" + search + 
				      "&search_text="   + encodeURIComponent(search_text);
	}
	
	//초기화 이벤트
	$(document).ready(function(){
		
		// list.do?search=name
				
		if("${param.search eq 'subject'}" =="true"){
			$("#search").children().eq(1).attr('selected',true);	
		}else if("${param.search eq 'name'}" =="true"){
			$("#search").children().eq(2).attr('selected',true);	
		}else if("${param.search eq 'content'}" =="true"){
			$("#search").children().eq(3).attr('selected',true);	
		}else if("${param.search eq 'subject_name_content'}" =="true"){
			$("#search").children().eq(4).attr('selected',true);	
		} 
		
		
	});
	
	

</script>

</head>

<body>

<!--로케이션 & 로그인끝-->
<!--타이틀 영역-->
<table width="700" align="center">
<tr>
<td>
<table width="690" height="50" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td><img src="${ pageContext.request.contextPath  }/resources/img/title_04.gif"></td>
	</tr>
	
	<tr>
	    <td align="right">
		    <!-- 로그인된 상태 -->
			<c:if test="${ not empty user }">
				${ user.name }님 환영합니다
				<input type="button"  value="로그아웃"
				       onclick="location.href='../member/logout.do'">
			</c:if>
			
			
			<!-- 로그인 안된 상태 -->
			<c:if test="${ empty user }">
			    <input type="button"  value="로그인"
				       onclick="location.href='../member/login_form.do'"> 
			</c:if>
	    </td>	
	</tr>
	
	
</table>
<!--타이틀 영역--끝-->
</td>
</tr>
<tr>
<td>
<!--LIST START-->
<table width="690" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td>
		<table width="690" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="50" class="td_a">번호</td>
				<td width="2" class="td_b"><img src="${ pageContext.request.contextPath  }/resources/img/td_bg_01.gif"></td>
				<td class="td_b" width="300">제목</td>
				<td width="2" class="td_b"><img src="${ pageContext.request.contextPath  }/resources/img/td_bg_01.gif"></td>
				<td width="90" class="td_b">작성자</td>
				<td width="2" class="td_b"><img src="${ pageContext.request.contextPath  }/resources/img/td_bg_01.gif"></td>
				
				<td width="90" class="td_b">작성일</td>
				<td width="2" class="td_b"><img src="${ pageContext.request.contextPath  }/resources/img/td_bg_01.gif"></td>
				<td width="60" class="td_c">조회수</td>
			</tr>

            <!--  for(BoardVo vo : list ) -->
            <c:forEach var="vo"  items="${ list }">
				<tr>
					<td align="center" class="td_a_1">${ vo.idx }(${ vo.no })</td>
					<td class="td_b_1"><img src="${ pageContext.request.contextPath  }/resources/img/td_bg_02.gif"></td>
					<td class="td_b_1 left">
                        
                        <!-- 답글들여쓰기 -->
                        <c:forEach begin="1"  end="${ vo.depth }">
                           &nbsp;&nbsp;
                        </c:forEach>

						<!--답글이면 ㄴ 붙여라  -->
						<c:if test="${ vo.depth ne 0 }">
                          	 ㄴ
                        </c:if>
                        
                        <!-- 사용중인 게시물인경우 -->
                        <c:if test="${ vo.use_yn eq 'y' }">
							<a href="view.do?idx=${ vo.idx }&page=${ (empty param.page) ? 1 : param.page }&search=${ param.search}&search_text=${ param.search_text }" class="num">
								${ vo.subject }
							</a>
							<!-- 댓글의 갯수(댓글이 있으면..) -->
							<c:if test="${ vo.comment_cnt gt 0 }">
							  (${ vo.comment_cnt })
							</c:if>
							
							
						</c:if>
						
						<!-- 삭제된 게시물인경우 -->
						<c:if test="${ vo.use_yn eq 'n' }">
						    <font color="red">(삭제된 게시물) ${ vo.subject }</font>
						</c:if>
					</td>
					<td class="td_b_1"><img src="${ pageContext.request.contextPath  }/resources/img/td_bg_02.gif"></td>
					<td align="center" class="td_b_1">${ vo.m_name }</td>
					<td class="td_b_1"><img src="${ pageContext.request.contextPath  }/resources/img/td_bg_02.gif"></td>
					<td align="center" class="td_b_1">${ fn:substring(vo.regdate,0,10) }</td>
					<td class="td_b_1"><img src="${ pageContext.request.contextPath  }/resources/img/td_bg_02.gif"></td>
					<td align="center" class="td_c_1">${ vo.readhit }</td>
				</tr>
			</c:forEach>

            <!-- 게시물이 없는경우 --> 
            <c:if test="${ empty list }">
				<tr>
					<td align="center" colspan="11" width="100%" height="50" style="border:1 solid #efefef">
						현재 등록된 글이 없습니다.
					</td>
				</tr>
			</c:if>

		</table>
		</td>
	</tr>
	<tr>
		<td height="8"></td>
	</tr>
	<tr>
		<td>
		<table width="690" border="0" cellpadding="0" cellspacing="0" bgcolor="#F1F5F4">
		    <tr>
				<td width="7"><img src="${ pageContext.request.contextPath  }/resources/img/search_bg_01.gif"></td>
				<td class="f11" align="center">
				<!-- 검색 메뉴 -->
                   <select id="search">
                      <option value="all">전체</option>
                      <option value="subject">제목</option>
                      <option value="name">이름</option>
                      <option value="content">내용</option>
                      <option value="subject_name_content">제목+이름+내용</option>
                   </select>
                   <input id="search_text"  value="${ param.search_text }">
                   <input type="button" value="검색"  onclick="search();">
				</td>
			</tr>
			
			<tr>
				<td width="7"><img src="${ pageContext.request.contextPath  }/resources/img/search_bg_01.gif"></td>
				<td class="f11" align="center">
				<!-- Paging 메뉴 -->
                   ${ pageMenu }
				</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td height="5"></td>
	</tr>
	<tr>
		<td>

		<img src="${ pageContext.request.contextPath  }/resources/img/btn_reg.gif" 
		     onClick="insert_form();" style="cursor:hand">

		</td>
	</tr>

</table>
<!--WRITE,MODIFY,REPLY END-->
</td>
</tr>
</table>


</body>

</html>