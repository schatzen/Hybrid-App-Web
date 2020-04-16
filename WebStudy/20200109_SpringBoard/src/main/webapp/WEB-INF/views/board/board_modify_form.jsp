<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>수정</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath  }/resources/css/style.css" type="text/css">
<script type="text/javascript">

	function send(f){
		
		var subject = f.subject.value.trim();
		var content = f.content.value.trim();
		
		if(subject==''){
			alert('제목을 입력하세요');
			f.subject.value='';
			f.subject.focus();
			return;
		}
		
		if(content==''){
			alert('내용을 입력하세요');
			f.content.value='';
			f.content.focus();
			return;
		}
		
		//전송
		f.action = "modify.do";
		f.submit();
		
		
		
	}

</script>


</head>


<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="760" align="center">
<tr>
<td>
<table width="690" height="50" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td><img src="${ pageContext.request.contextPath  }/resources/img/title_04.gif"></td>
	</tr>
</table>
<!--타이틀 영역의 끝-->
</td>
</tr>
<tr>
<td>
<form  method="GET"> 
<input type="hidden"  name="idx"    		value="${ vo.idx }">
<input type="hidden"  name="page"    		value="${ param.page }">
<input type="hidden"  name="search"    		value="${ param.search }">
<input type="hidden"  name="search_text"    value="${ param.search_text }">

<table width="750" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="120" height="25" class="td_d">제목</td>
		<td class="td_d_1" colspan="3">
		<input name="subject"  value="${ vo.subject }" type="text" class="search" style="width:250px;"></td>
		
	</tr>
	<tr>
		<td height="25" class="td_d_4">작성자</td>
		<td class="td_d_2" colspan="3">
		<input name="m_name" value="${ user.name }"  readonly="readonly" class="search" style="width:250px;">
		</td>
	</tr>

	<tr>
	<td class="td_d_4">내용</td>
		<td class="td_d_2" colspan="3">
		
		<TEXTAREA NAME='content' rows="9" cols="65">${ vo.content }</TEXTAREA>
		

	</td></tr>
    
    
	
</table>
<table width="750" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="5"></td>
	</tr>
	<tr>
		<td align="center">
		<!-- form요소중 
		     <input type="image">
		     <button onclick="">전송</button>
		     auto submit된다 (onsubmit() call)
		     조치: return false <= auto submit하지 말아라
		-->
		<input type="image" src="${ pageContext.request.contextPath  }/resources/img/btn_modify.gif"  
		     onclick="send(this.form); return false;" 
		     style="cursor:hand;border:none;">
		<img src="${ pageContext.request.contextPath  }/resources/img/btn_back.gif" onclick="location.href='list.do'" style="cursor:hand"></td>
	</tr>
</table>



</form>
</td>
</tr>
</table>
</body>

</html>