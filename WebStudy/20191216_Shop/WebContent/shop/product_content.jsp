<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script type="text/javascript">

	function add_cart(){
		
		//로그인 여부 체크
		if('${ empty user }' =='true'){
			alert('장바구니 담기는 로그인 하신후 사용가능합니다');
			return;
		}
		
		var m_idx = '${ user.idx }';
		var p_idx = '${ vo.idx }';
		
		//alert(m_idx + "/" +p_idx);
		
		$.ajax({
			url:'cart_insert.do',//CartInsertAction
			data:{'p_idx':p_idx,'m_idx':m_idx},
			dataType:'json',
			success:function(res_data){
				// res_data = {"result": true}
				if(res_data.result){//성공
					alert("장바구니에 담았습니다");
					if(confirm("장바구니보기로 이동하시겠습니까?")==false)return;
				    location.href="cart_list.do";
				}else{//실패
					alert('이미 장바구니에 등록된 상품입니다');
					if(confirm("장바구니보기로 이동하시겠습니까?")==false)return;
		            location.href="cart_list.do";
				}
				
			},
			error:function(request,status,error){
				alert(request.responseText);
			}
		});
		
		
	}


</script>


</head>
<body>

<jsp:include page="index.jsp"/>

<table align="center" width="600" border="1"
 style="border-collapse:collapse;font-size:8pt"
 bordercolor="navy" cellpadding="4" cellspacing="0">
		<tr>
			<td width="40%">제품분류</td>
			<td width="60%">${ vo.category }</td>
		</tr>
		<tr>
			<td width="40%">제품번호</td>
			<td width="60%">${ vo.p_num }</td>
		</tr>
		<tr>
			<td width="40%">제품명</td>
			<td width="60%">${ vo.p_name }</td>
		</tr>
		<tr>
			<td width="40%">제조사</td>
			<td width="60%">${ vo.p_company }</td>
		</tr>
		<tr>
			<td width="40%">제품가격</td>
			<td width="60%">
				<fmt:formatNumber type="currency" value="${ vo.p_price }"/>
				(할인가:<fmt:formatNumber type="currency" value="${ vo.p_saleprice }"/>)
			</td>
		</tr>
		<tr>
			<td colspan="2">제품설명</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
		<img src="../images/${ vo.p_image_l }" width=580 >
			</td>
		</tr>
		<tr>
			<td colspan="2">${ vo.p_content }</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" 
				       value="장바구니에 담기"
                       onclick="add_cart();"/>
			</td>
		</tr>
	</table>
</body>
</html>