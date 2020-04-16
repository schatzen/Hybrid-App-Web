<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 자바스크립트 외부 라이브러리 연결(jQuery) -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script type="text/javascript">

    var regular_id = /^[a-zA-Z0-9]{3,8}$/;
    var regular_zipcode = /^[0-9]{5}$/;
    
    //jQuery 초기화 이벤트
	$(document).ready(function(){
		
		//중복체크 클릭하면
		$("#btn_id_check").click(function(){
			
			var id = $("#id").val().trim();
			
			if(regular_id.test(id)==false){
				alert('3자리 이상의 값을 입력하세요');
				$("#id").val('');
				$("#id").focus();
				return;
			}
			
			//Ajax을 이용해서 중복ID체크
			$.ajax({
				url:'check_id.do',//MemberCheckIdAction
				data:{'id': id},
				dataType:'json',
				success:function(res_data){
					// res_data={"result":true}
					if(res_data.result==false){
						alert('이미 사용중인 아이디입니다');
						return;
					}
					
					alert('사용가능한 아이디입니다');
					//가입버튼 활성화
					$("#btn_reg").attr("disabled",false);
					//id항목 읽기전용
					$("#id").attr("readonly",true);
				
				},
				error:function(request,status,error){
					alert(resquest.responseText);
				}
			});
		});
	});
    
    function find_addr(){
    	
    	new daum.Postcode({
    		/* theme:{ bgColor:'#ff0000'}, */ 
            oncomplete: function(data) {
                //검색된 주소를 선택했을때
                // data={"zonecode":"12345","address":"서울시 마포구 노고산동",....}
                var zipcode = data.zonecode;
                var addr    = data.address;
                
                //선택된주소를 우편번호/주소입력창에 넣는다
                $("#zipcode").val(zipcode);
                $("#addr").val(addr);
                
            }
        }).open();
    		
    }
    
    
    //회원가입
    function send(f){
    	
    	var name 	= f.name.value.trim();
    	var pwd  	= f.pwd.value.trim();
    	var zipcode = f.zipcode.value.trim();
    	var addr	= f.addr.value.trim();
    	
    	//입력값 체크
    	if(name==''){
    		alert('이름을 입력하세요');
    		f.name.value='';
    		f.name.focus();
    		return;
    	}
    	
    	if(pwd==''){
    		alert('비밀번호를 입력하세요');
    		f.pwd.value='';
    		f.pwd.focus();
    		return;
    	}
    	
    	if(regular_zipcode.test(zipcode)==false){
    		alert('우편번호 5자리를 입력하세요');
    		f.zipcode.value='';
    		f.zipcode.focus();
    		return;
    	}
    	
    	if(addr==''){
    		alert('주소를 입력하세요');
    		f.addr.value='';
    		f.addr.focus();
    		return;
    	}
    	
   	
    	f.action="insert.do";//MemberInsertAction
    	f.submit();//전송
    	
    }
    
    
</script>

</head>
<body>
	<form>
	   <table border="1" align="center" width="500">
	       <caption>::::회원가입::::</caption>
	       <!-- 1번째줄 -->
	       <tr>
	       		<th>이름</th>
	       		<td><input name="name" ></td>
	       </tr>
	       <!-- 2번째줄 -->
	       <tr>
	       		<th>아이디</th>
	       		<td>
	       		   <input name="id" id="id">
	       		   <input id="btn_id_check" type="button" value="중복체크">
	       		</td>
	       </tr>
	       <!-- 3번째줄 -->
	       <tr>
	       		<th>비밀번호</th>
	       		<td><input type="password" name="pwd"></td>
	       </tr>
	       <!-- 4번째줄 -->
	       <tr>
	       		<th>우편번호</th>
	       		<td>
	       		  <input name="zipcode" id="zipcode">
	       		  <input type="button"  value="주소찾기" onclick="find_addr();">
	       		</td>
	       </tr>
	       <!-- 5번째줄 -->
	       <tr>
	       		<th>주소</th>
	       		<td><input style="width:99%;" name="addr" id="addr"></td>
	       </tr>
	       <!-- 6번째줄 -->
	       <tr>
	       		<th>회원구분</th>
	       		<td>
	       		    <input type="radio" name="grade" value="일반" checked="checked">일반
	       		    <input type="radio" name="grade" value="관리자" >관리자
	       		</td>
	       </tr>
	       <!-- 7번째줄 -->
	       <tr>
	       		<td colspan="2" align="center">
	       		    <input id="btn_reg"   type="button" value="가입하기" onclick="send(this.form);" disabled="disabled">
	       		    <input type="button"  value="취소하기" 
	       		           onclick="location.href='../photo/list.do';">
	       		    <!-- location.href='' : 자신의 페이지로 이동 -->       
	       		</td>
	       </tr>
	       
	       
	   </table>
	</form>
</body>
</html>