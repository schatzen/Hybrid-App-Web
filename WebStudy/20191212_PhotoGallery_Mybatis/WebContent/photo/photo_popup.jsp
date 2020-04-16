<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
   #popup{
        width :300px;
        min-height: 420px;
        height: auto;
        border: 2px solid black; 
        position: absolute;
        background: black; 
        display: none; /* hide */
   }
   
   img#pop_p_filename{
        width : 298px;
        height: 298px;
        border: 1px solid red;
   }
   
   #pop_p_subject{
     border: 1px solid green;
     min-height: 30px;
     color:white;
   }
   
   #pop_p_content{
     border: 1px solid blue;
     min-height: 60px;
     height: auto;
     color:white;
     background: black;
   }
   
</style>

<script type="text/javascript">
	function me_close(){
		document.getElementById("popup").style.display='none';//hide
	}

</script>

</head>
<body>

	<div id="popup">
	   <div style="text-align: right">
	      <input type="button"  value="x" onclick="me_close();">
	   </div>
	   <div>
	      <img  id="pop_p_filename" src="">
	   </div>
	   <div id="pop_p_subject"></div>
	   <div id="pop_p_content"></div>
	</div>
	
	
</body>
</html>