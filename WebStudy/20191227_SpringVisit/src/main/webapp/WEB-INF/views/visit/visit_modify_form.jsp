<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>visit_modify_form</title>
<style type="text/css">
.head {
	display: none;
}

textarea {
	resize: none;
}
</style>
<script type="text/javascript">

	function send(f) {
		var content = f.content.value.trim();
		var name = f.name.value.trim();
		
		if (content == '') {
			alert('INSERT CONTENT');
			f.content.value = '';
			f.content.focus();
			return;
		}
		
		if (name == '') {
			alert('INSERT WRITER');
			f.name.value = '';
			f.name.focus();
			return;
		}
		
		f.action = "modify.do"; //VisitModifyAction
		f.submit();
	}

</script>
</head>
<body>
	<div id="input_div">
		<form>
		<input type="hidden"  name="idx" value="${ vo.idx }">
			<table align="center" border="1">
				<caption>MODIFY</caption>
				<%-- <tr>
					<th class="head">IDX</th>
					<td><input name="idx" type="hidden" value="${vo.idx}" /></td>
				</tr> --%>
				<tr>
					<th>CONTENT</th>
					<td>
						<textarea name="content"
							cols="60" rows="10">${vo.content}</textarea>
					</td>
				</tr>
				<tr>
					<th>WRITER</th>
					<td>
						<input name="name" value="${vo.name}" />
					</td>
				</tr>
				<tr>
					<th class="head">DATE</th>
					<td>
						<input name="regdate" type="hidden" value="${vo.regdate}" />
					</td>
				</tr>
				<tr>
					<th>PASSWORD</th>
					<td>
						<input name="pwd" type="password" value="${vo.pwd}" />
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="MODIFY" style="cursor: pointer;"
							onclick="send(this.form);" />
						<input type="button" value="SHOW LIST" style="cursor: pointer;"
							onclick="location.href='list.do'" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>