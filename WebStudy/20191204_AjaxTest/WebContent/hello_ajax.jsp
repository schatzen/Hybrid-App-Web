<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 자바스크립트 외부 라이브러리 연결(Ajax) -->
<script src="js/httpRequest.js" ></script>

<script type="text/javascript">
  function find(){
	  
	  var nation = document.getElementById("nation").value.trim();
      if(nation==''){
    	  alert('국가명을 입력하세요');
    	  document.getElementById("nation").value='';
    	  document.getElementById("nation").focus();
    	  return;
      } 
      
      var url="hello.do"; // hello.do?nation=한국
      //자바스크립트에서 데이터전송시 한글/특수문자는
      //아래와 같이 Encoding해서 전송해야 된다
      //encodeURIComponent("문자열",charset)
      var param = "nation=" + encodeURIComponent(nation,"utf-8");
      
      //alert(nation );
      //alert(encodeURIComponent(nation,"utf-8"));
      
      //Ajax를 통해서 요청
      sendRequest(url,param,resultFn,"POST");
        
  }
  
  //Ajax요청 결과를 받을 함수
  function resultFn(){
	  console.log("xhr.readyState=" + xhr.readyState +
			      " xhr.status=" + xhr.status);
	  
	  if(xhr.readyState==4 && xhr.status==200){
		  //서버->xhr의 임시버퍼로 저장
		  //xhr의 임시버퍼로부터 읽어온다
		  var data = xhr.responseText;
		  
		  //결과출력
		  document.getElementById("disp").innerHTML = data;
	  }
  }
  

</script>

</head>
<body>
국가명:<input id="nation">
<input type="button" value="검색" onclick="find();">
<hr>
<div id="disp"></div>

</body>
</html>