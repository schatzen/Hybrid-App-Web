<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- JSTL 사용 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>visit_list</title>
<!-- CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/visit.css" />
<!-- 자바스크립트 외부 라이브러리 연결(jQuery) -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
	function del(f) {
		
		var c_pwd = f.c_pwd.value; // 입력한 비번
		var idx   = f.idx.value;   // 게시물 번호
		
		// Ajax를 이용해서 비번 체크
		// check_pwd.do?idx=10&c_pwd=1234 => 요청
		$.ajax({
			url      : 'check_pwd.do', // VisitCheckPwdAction
			data     : {'idx' : idx, 'c_pwd' : c_pwd}, // ?idx=9&c_pwd=1234
			dataType : 'json', // 수신데이터 타입을 지정(안하면 string으로 인식하여 undefined)
			success  : function(res_data) {
				// res_data={"result":"same"}
				// 비밀번호가 다른 경우
				if (res_data.result == 'diff') {
					alert("WRONG PASSWORD");
					f.c_pwd.value = "";
					f.c_pwd.focus();
					return;
				}			
				// 삭제유무 확인
				if(confirm('DELETE CONFIRM') == false) return;
				
				// 자바스크립트를 이용하여 삭제 정보를 전달
				location.href = 'delete.do?idx=' + f.idx.value;
			},error:function(request,status,error){
				alert(error);
				alert("[" + request.responseText + "]");
			}
		});
	}
	
	function modify(f) {
		// 비밀번호 체크
		var c_pwd = f.c_pwd.value;
		var idx = f.idx.value;
		
		$.ajax({
			url  : 'check_pwd.do',
			data : {'idx' : idx, 'c_pwd' : c_pwd},
			dataType : 'json',
			success : function(res_data) {
				if(res_data.result == 'diff') {
					alert("WRONG PASSWORD");
					f.c_pwd.value = '';
					f.c_pwd.focus();
					return;
				}	
				// 자바스크립트를 이용하여 수정폼 띄우기
				location.href = 'modify_form.do?idx=' + f.idx.value;
			}
		});
	}
	
	function search() {
		
		var search = $("#search").val();
		var search_text = $("#search_text").val().trim();
		
		if (search != 'all' && search_text == '') {
			alert('INSERT TEXT');
			$("#search_text").val('');
			$("#search_text").focus();
			return;
		}
				
		if (search == 'all') {
			$("#search_text").val('');
		}
			
		// list.do 호출
		location.href="list.do?search=" + search +
						  "&search_text=" + encodeURIComponent(search_text, "utf-8");
	}
	
	// html배치가 완료되면 초기화되기 때문 검색 값 남겨두는 방법
	$(document).ready(function() {
		
		if ("${param.search eq 'name'}" == "true") {		
			//id=search
			$("#search").children().eq(1).attr("selected", true);
			
		} else if ("${param.search eq 'content'}" == "true") {
			
			$("#search").children().eq(2).attr("selected", true);
			
		} else if ("${param.search eq 'name_content'}" == "true") {
			
			$("#search").children().eq(3).attr("selected", true);
			
		} else { // showall이면 빈칸으로 만든다
			
			$("#search_text").val("");
		
		}
	});
	
</script>
</head>
<body>
<%-- WebContext 경로: ${pageContext.request.contextPath} --%>
	<div id="main_box">
		<h1>VISIT LIST</h1>
		<div style="text-align: right;">
			<input type="button" value="WRITE" style="cursor: pointer;"
				onclick="location.href='insert_form.do'" />
		</div>
		<!-- SEARCH Menu -->
		<div id="search_area">
			<select id="search" class="search">
				<option value="all">SHOW ALL</option>
				<option value="name">NAME</option>
				<option value="content">CONTENT</option>
				<option value="name_content">NAME+CONTENT</option>
			</select>
			<input id="search_text" class="search" value="${param.search_text}"/>
			<input type="button" value="SEARCH" class="search" onclick="search();"/>
		</div>
		<!-- DATA NULL -->
		<c:if test="${empty list}">
			<div id="empty_message">
				<p>NO VALUE</p>
			</div>
		</c:if>
		<!-- DATA EXIST -->
		<!-- for(visitVo visit : list) {} -->
		<c:forEach var="visit" items="${list}">
		<div class="content_box">
			<div class="content">${visit.content}</div>
			<div class="name">WRITER: ${visit.name}(${visit.ip})</div>
			<div class="regdate">DATE: ${fn:substring(visit.regdate, 0 ,16)}</div>
			<div class="pwd">
				<form>
					<input type="hidden" name="idx" value="${visit.idx}" />
					<span>PASSWORD(${visit.pwd}): </span>
					<input type="password" name="c_pwd" placeholder="Insert Password"/>
					<input type="button" value="DELETE" onclick="del(this.form);" />
					<input type="button" value="MODIFY" onclick="modify(this.form);" />
				</form>
			</div>
		</div>
		</c:forEach>
	</div>
</body>
</html>