<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/photo.css" >

<!--jQuery  -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
	
	window.onload = function(){
		
		var popup =document.getElementById("popup");
		
		//body 폭/높이
		var body_w = window.innerWidth;
		var body_h = window.innerHeight;
		
		//popup창의 폭/높이
		var pop_w = 320;
		var pop_h = 420;
		
		
		popup.style.left=(body_w/2 - pop_w/2) + "px";
		popup.style.top =(body_h/2 - pop_h/2) + "px";
		
	};
	
	
	
	
	function photo_upload(){
		
		//로그인 안된 상태 체크
		if("${ empty user }"=="true"){
			
		    if(confirm("로그인하신 후 사진을 올릴수 있습니다\n" + 
		    		   "로그인 하시겠습니까?")==false)return;
			
		    //로그인폼으로 이동
		    location.href="../member/login_form.do";
		    return;
		}
		//로그인이 된상태: /photo/list.do <=현재위치
		location.href="insert_form.do";//PhotoInsertFormAction	
	}
	
	
	function download(filename){
		
		//로그인 안된 상태 체크
		if("${ empty user }"=="true"){
			
		    if(confirm("로그인하신 후 사진을 받으실수  있습니다\n" + 
		    		   "로그인 하시겠습니까?")==false)return;
			
		    //로그인폼으로 이동
		    location.href="../member/login_form.do";
		    return;
		}
		
		//alert(filename);
		//현재 작업경로 : /photo/list.do
		//주의) 요청화일명에 한글또는 특수문자가 들어갔을경우
		//      인코딩해서 요청해야됨(encodeURIComponent(값,"utf-8"))
		location.href="../FileDownload.do?dir=/resources/upload/&filename=" 
				      + encodeURIComponent(filename,"utf-8");
		
	}
	
	function del(p_idx){
		
		if(confirm('정말 삭제하시겠습니까?')==false)return;
		
		location.href="delete.do?p_idx=" + p_idx;
	}
	
	function show_popup(p_idx){
		
		//alert(p_idx);
		//팝업창 보여주기
		//document.getElementById("popup").style.display='block';
		$("#popup").slideDown(10);
		
		$.ajax({
			url:'photo_one.do',//PhotoOneAction
			data:{'p_idx' : p_idx},
			dataType:'json',
			success:function(res_data){
				//res_data={"p_subject":"제목","p_content":"내용","p_filename":"a.jpg"}
				$("#pop_p_filename").attr("src","../resources/upload/"+res_data.p_filename);
				$("#pop_p_subject").html(res_data.p_subject);
				$("#pop_p_content").html(res_data.p_content);
			},
			error:function(request,status,error){
				alert(request.responseText + "/" + error);
			}
		});
		
		
		
	}


</script>

</head>
<body>

    <!-- 상세화면 --> 
    <%@include file="photo_popup.jsp" %>


	<div id="main_box">
		<h1 id="title">::::PhotoGallery::::</h1>
		<div id="login">
		     
		     <!-- 로그인이 안된경우 -->
		     <c:if test="${ empty sessionScope.user }">
			     <input type="button" value="로그인"
			            onclick="location.href='../member/login_form.do'">
			     <input type="button" value="회원가입"
			            onclick="location.href='../member/insert_form.do'">
		     </c:if>  
		     
		     <!-- 로그인이 된경우
		          MemberVo user 
		      -->
		     <c:if test="${ not empty sessionScope.user }">
		     	${ user.name }(${ user.idx })님 환영합니다
		     	<input type="button"  value="로그아웃"
		     	       onclick="location.href='../member/logout.do'">
		     </c:if>     
		            
		</div>
		<div>
		     <input type="button"  value="사진올리기"
		            onclick="photo_upload();">
		</div>
		
		<div id="photo_box">

            <!-- Data가 없는경우  --> 
            <c:if test="${ empty list }">
               <div id="empty_msg">등록된 사진이 없습니다</div>
            </c:if>
            
            
			<!-- Data가 있는경우 -->
            <%-- <c:forEach begin="1" end="20"> --%>
            
            <!--  for(PhotoVo photo: list)  -->
            <c:forEach var="photo" items="${ list }">
	            <!-- 사진 1개 정보 -->   
	            <div class="photo_type"  >
	               <img src="../resources/upload/${ photo.p_filename }" width=100  onclick="show_popup('${ photo.p_idx}');">
	               <div class="subject">(${ photo.m_idx })${ photo.p_subject }</div>
	               <div align="center">
	                   <input type="button"  value="받기"
	                          onclick="download('${ photo.p_filename }');">
	                   <!-- 삭제메뉴는 올린사용자만 보여지도록 설정  -->
	                   <c:if test="${ (photo.m_idx eq user.idx) or(user.grade eq '관리자') }">
	                       <input type="button"  value="삭제" 
	                              onclick="del('${ photo.p_idx }');">
	                   </c:if>
	               </div>
	            </div>		
            </c:forEach>
		
		</div>
	</div>
	
	
</body>
</html>