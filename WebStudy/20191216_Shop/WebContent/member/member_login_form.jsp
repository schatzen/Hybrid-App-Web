<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

    //현재 html이 로드가 완료되면  
    window.onload = function(){
    	
    	setTimeout(init,100)
    	
    }; 

    function init(){
    	//alert('로드완료');
    	// login_form.do?reason=fail_id
    	if("${ param.reason eq 'fail_id'}" =="true"){
    		alert('아이디가 틀립니다');
    	}		
    	
    	// login_form.do?reason=fail_pwd
    	if("${ param.reason eq 'fail_pwd'}" =="true"){
    		alert('비밀번호가 틀립니다');
    	}
    	
    	// login_form.do?reason=fail_cart
    	if("${ param.reason eq 'fail_cart'}" =="true"){
    		alert('장바구니를 확인하시려면\n로그인 하셔야 합니다');
    	}
    			
    }


	function send(f){
		
		var id  = f.id.value.trim();
		var pwd = f.pwd.value.trim();
		
		if(id==''){
			alert('아이디를 입력하세요');
			f.id.value='';
			f.id.focus();
			return;
		}
		
		if(pwd==''){
			alert('비밀번호를 입력하세요');
			f.pwd.value='';
			f.pwd.focus();
			return;
		}
		
		//
		f.action="login.do";//MemberLoginAction
		f.submit();
		
		
	}

</script>


</head>
<body>
  <br><br><br><br><br><br>
  
  <form>
		<table border="1" align="center">
			<caption>::::로그인::::</caption>
			<tr>
				<th>아이디</th>
				<td><input name="id"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button"  value="로그인"
					       onclick="send(this.form);">
					<input type="button"  value="취소하기"
					       onclick="location.href='../shop/list.do'">
				</td>
			</tr>
		
		</table>
  </form>	

</body>
</html>