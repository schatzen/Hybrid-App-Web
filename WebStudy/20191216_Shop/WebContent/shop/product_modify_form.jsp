<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script src="https://cdn.ckeditor.com/4.13.1/full/ckeditor.js"></script>

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
      
   
   f.submit();
   
}

//초기화 함수
window.onload = function(){
	
	var category = document.getElementById("category");
	
	if('${ vo.category eq "com001"}' == 'true'){
	    category[1].selected = true;
	    //cf) jQuery
	    //  $("#category").children().eq(1).attr('selected',true);
	    
	}else if('${ vo.category eq "ele002"}' == 'true'){
	    category[2].selected = true;
	}else if('${ vo.category eq "sp003"}' == 'true'){
		category[3].selected = true;
	}
	
};


$(document).ready(function(){
	//작은이미지 미리보기
	$("#p_image_s").change(function(){
		readSmallURL(this);
	});
	
	
	//큰이미지 미리보기
	$("#p_image_l").change(function(){
		readLargeURL(this);
	});
	
	
	//작은이미지 수정클릭
	$("#btn_small").click(function(){
		
		if($('#p_image_s').val()==''){
			alert('수정할 이미지를 선택하세요');
			return;
		}
		
		var data = new FormData();
		// parameter정보 넣는다
		data.append("idx", '${ vo.idx }');
		data.append("image_size", 'small');
		data.append("p_image_s", $('#p_image_s').prop('files')[0]);

		$.ajax({
	        url: "modify_image.do",
	        type: "POST",
	        dataType: 'json',
	        data: data,
	        contentType: false,
	        processData: false,
	        cache: false,
	        timeout:5000,
	        success:function(res_data){
	        	//res_data = {"result": true};
	        	if(res_data.result){
	        		alert('이미지 수정완료!!');
	        	}
	        },
	        error:function(request,status,error){
	        	alert(request.responseText);
	        }
		});
	});
	
	//큰이미지 수정
	$("#btn_large").click(function(){
		
		if($('#p_image_l').val()==''){
			alert('수정할 이미지를 선택하세요');
			return;
		}
		
		var data = new FormData();
		// parameter정보 넣는다
		data.append("idx", '${ vo.idx }');
		data.append("image_size", 'large');
		data.append("p_image_l", $('#p_image_l').prop('files')[0]);

		$.ajax({
	        url: "modify_image.do",
	        type: "POST",
	        dataType: 'json',
	        data: data,
	        contentType: false,
	        processData: false,
	        cache: false,
	        timeout:5000,
	        success:function(res_data){
	        	//res_data = {"result": true};
	        	if(res_data.result){
	        		alert('이미지 수정완료!!');
	        	}
	        },
	        error:function(request,status,error){
	        	alert(request.responseText);
	        }
		});
	});
	
	
});
	    

//작은이미지 미리보기
function readSmallURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function(e) {
            $('#img_small').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}

//큰이미지 미리보기
function readLargeURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function(e) {
            $('#img_large').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}



</script>
</head>
<body>

<!-- title -->
<jsp:include page="index.jsp"/>
<form name="f" method="get" action="modify.do"> 
<input type="hidden"  name="idx"  value="${ vo.idx }">
<table align="center" width="600" border="1" 
    style="border-collapse:collapse;font-size:8pt" bordercolor="navy"
    cellpadding="2" cellspacing="0">
    <tr>
        <td>제품Category</td>
        <td><select name="category" id="category">
        		<option value="">카테고리 선택</option> <!-- 0 -->
        		<option value="com001">컴퓨터</option>  <!-- 1 -->
        		<option value="ele002">가전제품</option><!-- 2 -->
        		<option value="sp003">스포츠</option>   <!-- 3 -->
        </select></td>
    </tr>
    <tr>
        <td>제품번호</td>
        <td><input name="p_num" value="${ vo.p_num }" type="text" ></td>
    </tr>
    <tr>
        <td>제품이름</td>
        <td><input name="p_name" value="${ vo.p_name }" type="text" ></td>
    </tr>
    <tr>
        <td>제품 판매사</td>
        <td><input name="p_company" value="${ vo.p_company }" type="text" ></td>
    </tr>
    <tr>
        <td>제품가격</td>
        <td><input name="p_price"  value="${ vo.p_price }" type="text" ></td>
    </tr>
    <tr>
        <td>제품할인가격</td>
        <td><input name="p_saleprice" value="${ vo.p_saleprice }" type="text" ></td>
    </tr>    
    <tr>
        <td>제품설명</td>
        <td>
        <TEXTAREA name="p_content" rows="5" cols="50">${ vo.p_content }</TEXTAREA>
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
        <td>
             <img id="img_small" src="../images/${ vo.p_image_s }" width="100" height="100">
             <br>
             <input type="file"  id="p_image_s">
             <br>
             <input type="button" value="수정" id="btn_small">
        </td>
    </tr>
    <tr>
        <td>제품사진(큰사진)</td>
        <td>
            <img id="img_large" src="../images/${ vo.p_image_l }" width="100" height="100">
            <br>
            <input type="file"  id="p_image_l">
            <br>
            <input type="button" value="수정" id="btn_large">
        </td>    
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="button" value="수정" 
            onclick="javascript:checkdata(this.form);" >
            <input type="reset" value="Clear" >
        </td>
    </tr>    
</table>
</form>
</body>
</html>