<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- JSTL  -->
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
 
 
<style type="text/css">
  
  *{ margin: 0; }
   
  #main_box{
  		width: 600px;
  		height: auto;
  		margin: auto;/* 중앙 */
  		/* background: #cccccc; */
  }
  
  h1{
      text-align: center;
      font-size: 25px;
      text-shadow: 1px 1px 1px black;
      color: white;
  }

  table{
      width: 100%; 
  }
  
  td{
     text-align: center; 
  }
</style>


 

<script type="text/javascript">

	function del(idx){
		//alert('삭제할 idx=' + idx);
		
		//삭제 확인 
		if(confirm('정말삭제하시겠습니까?')==false) return;
		
		//삭제(자바스크립트를 이용해서 호출)
		location.href = "delete.do?idx=" + idx;
		
	}

</script>

</head>
<body>
  <div id="main_box">
   	  <h1>::::성적관리::::</h1>
      <div style="text-align: right;">
      	 <input class="btn btn-default" type="button"  value="성적등록"
      	        onclick="location.href='insert_form.do'">	
      </div>
      
      <!-- 성적출력 -->
      <table border="0" class="table   table-hover">
	      	<!-- title -->
	      	<tr class="success">
	      		<th>번호</th>
	      		<th>이름</th>
	      		<th>국어</th>
	      		<th>영어</th>
	      		<th>수학</th>
	      		<th>총점</th>
	      		<th>평균</th>
	      		<th>등수</th>
	      		<th>비고</th>
	      	</tr>
	      	<!-- Data 출력 -->
	      	
	      	<!-- Data가 없는 경우 -->
	      	<c:if test="${ empty requestScope.list }">
	      	   <tr>
	      	   		<td colspan="9" style="text-align: center;">데이터 없습니다</td>
	      	   </tr>
	      	</c:if>
	      	
	      	<!-- Data가 있는 경우 -->
	      	<!--  for(SungVo sung : list) 동일 -->
	      	<c:forEach var="sung"  items="${ list }">
	      		<tr>
					<td>${ sung.idx }</td>
					<td>${ sung.name }</td>
					<td>${ sung.kor }</td>
					<td>${ sung.eng }</td>
					<td>${ sung.mat }</td>
					<td>${ sung.tot }</td>
					<td>${ sung.avg }</td>
					<td>${ sung.rank }</td>
					<td>
					    <input class="btn btn-default" type="button" value="수정" 
					           onclick="location.href='modify_form.do?idx=${sung.idx}'">
					    <input class="btn btn-default" type="button" value="삭제"
					           onclick="del('${ sung.idx}');" >
					    					            
					    
					</td>	      		
	      		</tr>
	      	</c:forEach>
	      	
	      	
	      	
      </table>	  	
  
  </div>
</body>
</html>