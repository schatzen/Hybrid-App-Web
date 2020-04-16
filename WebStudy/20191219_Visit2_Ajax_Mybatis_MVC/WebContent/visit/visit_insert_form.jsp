<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>visit_insert_form</title>
<script type="text/javascript">

	function send(f) {
		var name    = f.name.value.trim();
		var content = f.content.value.trim();
		var pwd     = f.pwd.value.trim();
		
		if(name == '') {
			alert('INSERT NAME')
			f.name.value = '';
			f.name.focus();
			return;	
		}
		
		if(content == '') {
			alert('INSERT CONTENT')
			f.content.value = '';
			f.content.focus();
			return;	
		}
		
		if(pwd == '') {
			alert('INSERT PASSWORD')
			f.pwd.value = '';
			f.pwd.focus();
			return;
		}
		//값 체크 완료 후 전송
		f.action = "insert.do"; //VisitInsertAction
		f.submit();
	}
</script>
</head>
<body>
	<form>
		<table border="1" align="center">
			<caption>WRITE ON SHEET</caption>
			<tr>
				<th>NAME</th>
				<th><input name="name"></th>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td>
					<textarea name="content" cols="60" rows="5"></textarea>
				</td>
			</tr>
			<tr>
				<th>PASSWORD</th>
				<td><input type="password" name="pwd" /></td>
			</tr>
			<tr>
				<td>
					<input type="button" value="WRITE"
						onclick="send(this.form);" />
					<input type="button" value="SHOW LIST"
						onclick="location.href='list.do'"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>