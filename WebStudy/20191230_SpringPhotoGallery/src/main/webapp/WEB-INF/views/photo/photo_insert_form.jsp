<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="//cdn.ckeditor.com/4.11.2/full/ckeditor.js"></script>

<script type="text/javascript">

	function send(f){
		
		var p_subject = f.p_subject.value.trim();
		//var p_content = f.p_content.value.trim();
		var p_content = CKEDITOR.instances.p_content.getData();
		var photo     = f.photo.value;
		
		//체크
		if(p_subject==''){
			alert('제목을 입력하세요');
			f.p_subject.value='';
			f.p_subject.focus();
			return;
		}
		
		if(p_content==''){
			alert('내용을 입력하세요');
			f.p_content.value='';
			f.p_content.focus();
			return;
		}
		
		if(photo==''){
			alert('사진을 선택하세요');
			return;
		}
		
		
		//전송
		f.action="insert.do";//PhotoInsertAction
		f.submit();//
		
	}

</script>

</head>
<body>
  <form method="POST" enctype="multipart/form-data">
      <table border="1" align="center" width="700">
      	<caption>::::사진올리기::::</caption>
      	<tr>
      		<th>제목</th>
      		<td><input name="p_subject"></td>
      	</tr>
      	<tr>
      		<th>내용</th>
      		<td>
      		    <textarea name="p_content" rows="5" cols="50"></textarea>
      		    <script>
					// Replace the <textarea id="editor1"> with a CKEditor
					// instance, using default configuration.
					CKEDITOR.replace( 'p_content', {
					filebrowserUploadUrl: '${pageContext.request.contextPath}/ckeditorImageUpload.do',
					enterMode:CKEDITOR.ENTER_BR,
					shiftEnterMode:CKEDITOR.ENTER_P,
					toolbarGroups : [
						/*
						{ name: 'document', groups: [ 'mode', 'document', 'doctools' ] },
						{ name: 'clipboard', groups: [ 'clipboard', 'undo' ] },
						{ name: 'editing', groups: [ 'find', 'selection', 'spellchecker' ] },
						{ name: 'forms' },
						'/',*/ 
						{ name: 'document', groups: [ 'mode', 'document', 'doctools' ] },
						/*{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
						{ name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ] },
						{ name: 'links' },*/
						{ name: 'insert' },
						'/',
						{ name: 'styles' },
						{ name: 'colors' },
						{ name: 'tools' },
						{ name: 'others' },
						{ name: 'about' }
						]
					});
					
						
					CKEDITOR.on('dialogDefinition', function( ev ){
				           var dialogName = ev.data.name;
				           var dialogDefinition = ev.data.definition;
				         
				           switch (dialogName) {
				               case 'image': //Image Properties dialog
				                   //dialogDefinition.removeContents('info');
				                   dialogDefinition.removeContents('Link');
				                   dialogDefinition.removeContents('advanced');
				                   break;
				           }
				       });
				</script>
      		</td>
      	</tr>
      	<tr>
      		<th>사진</th>
      		<td><input type="file" name="photo"></td>
      	</tr>
      	
      	<tr>
      		<td colspan="2" align="center">
      		    <input type="button"  value="사진올리기"
      		           onclick="send(this.form);" >
      		    <input type="button"  value="목록보기"
      		           onclick="location.href='list.do'"> 
      		</td>
      	</tr>
      	      	
      </table>
  </form>
</body>
</html>