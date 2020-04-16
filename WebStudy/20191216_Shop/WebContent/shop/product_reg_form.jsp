<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- <script src="https://cdn.ckeditor.com/4.13.1/standard-all/ckeditor.js"></script> -->
<script src="https://cdn.ckeditor.com/4.13.1/full/ckeditor.js"></script>
<!-- <script src="//cdn.ckeditor.com/4.11.2/full/ckeditor.js"></script> -->

<script type="text/javascript">

var regular_number = /^[0-9]+$/;

function checkdata(f)
{
   var category 	= f.category.value;
   var p_num 		= f.p_num.value;
   var p_name 		= f.p_name.value;
   var p_company 	= f.p_company.value;
   var p_price 		= f.p_price.value;
   var p_saleprice 	= f.p_saleprice.value;
   //p_content 	= f.p_content.value;
   var p_image_s 	= f.p_image_s.value;
   var p_image_l 	= f.p_image_l.value;
   
   //CKEditor사용시 내용 읽어오기
   var p_content = CKEDITOR.instances.p_content.getData();
   
     
   //각항목을 일일이 모두 체크...
   if(category==''){
	   alert('카테고리를 선택하세요');
	   return;
   }
   
   if(p_num==''){
	   alert('상품번호를 입력하세요');
	   f.p_num.value='';
	   f.p_num.focus();
	   return;
   }
   
   
   if(p_name==''){
	   alert('상품명을 입력하세요');
	   f.p_name.value='';
	   f.p_name.focus();
	   return;
   }
   
   if(p_company==''){
	   alert('회사명을 입력하세요');
	   f.p_company.value='';
	   f.p_company.focus();
	   return;
   }
   
   if(p_content==''){
	   alert('상품설명을 입력하세요');
	   f.p_content.value='';
	   f.p_content.focus();
	   return;
   }
   
   
   if(regular_number.test(p_price)==false){
	   alert('가격은 숫자만 입력하세요');
	   f.p_price.value='';
	   f.p_price.focus();
	   return;
   }
   
   if(regular_number.test(p_saleprice)==false){
	   alert('가격은 숫자만 입력하세요');
	   f.p_saleprice.value='';
	   f.p_saleprice.focus();
	   return;
   }
   
   if(p_image_s==''){
	   alert('이미지를 선택하세요');
	   return;
   }
   
   if(p_image_l==''){
	   alert('이미지를 선택하세요');
	   return;
   }
   
   
   f.submit();
   
}
</script>
</head>
<body>

<!-- title -->
<jsp:include page="index.jsp"/>
<form name="f" method="post" action="insert.do" 
      enctype="multipart/form-data"> 
<table align="center" width="600" border="1" 
    style="border-collapse:collapse;font-size:8pt" bordercolor="navy"
    cellpadding="2" cellspacing="0">
    <tr>
        <td>제품Category</td>
        <td><select name="category">
        		<option value="">카테고리 선택</option>
        		<option value="com001">컴퓨터</option>
        		<option value="ele002">가전제품</option>
        		<option value="sp003">스포츠</option>
        </select></td>
    </tr>
    <tr>
        <td>제품번호</td>
        <td><input name="p_num" type="text" ></td>
    </tr>
    <tr>
        <td>제품이름</td>
        <td><input name="p_name" type="text" ></td>
    </tr>
    <tr>
        <td>제품 판매사</td>
        <td><input name="p_company" type="text" ></td>
    </tr>
    <tr>
        <td>제품가격</td>
        <td><input name="p_price" type="text" ></td>
    </tr>
    <tr>
        <td>제품할인가격</td>
        <td><input name="p_saleprice" type="text" ></td>
    </tr>    
    <tr>
        <td>제품설명</td>
        <td>
          <TEXTAREA name="p_content" rows="5" cols="50"></TEXTAREA>
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
				{ name: 'document',    groups: [ 'mode', 'document', 'doctools' ] },
				{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
				{ name: 'paragraph',   groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ] },
				/*{ name: 'links' },
				{ name: 'insert' },*/
				'/',
				{ name: 'styles' },
				{ name: 'colors' },
				{ name: 'tools' },
				{ name: 'others' },
				{ name: 'about' }
				]
			});
			
			//이미지 업로드	
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
        <td>제품사진(작은사진)</td>
        <td><input type="file" name="p_image_s">
    </tr>
    <tr>
        <td>제품사진(큰사진)</td>
        <td><input type="file" name="p_image_l">
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="button" value="등록" 
            onclick="javascript:checkdata(this.form);" >
            <input type="reset" value="Clear" >
        </td>
    </tr>    
</table>
</form>
</body>
</html>