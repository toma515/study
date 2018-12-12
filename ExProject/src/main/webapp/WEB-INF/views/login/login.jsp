<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>


<!DOCTYPE html>
<html lang="en">
<head>
	<%@ include file="/WEB-INF/include/include-header.jspf" %>
	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<body>

<div class="container">
	<h2>로그인</h2>
	<form id="frm">
		<table class="table">
			<colgroup>
				<col width="15%"/>
				<col width="*"/>
			</colgroup>
			<tbody>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="boardWriter" id="boardWriter" /></td>
					
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="boardWriterPw" id="boardWriterPw" /></td>
				</tr>
			</tbody>
		</table>
		<!-- <button  id="login">로그인</button>
		<button type="button" id="register">ajax로그인</button> -->
	</form>
	<button  id="login">로그인</button>
	<button id="register">ajax로그인</button>
	<%-- <img src="/img/no_image.jpg" />
	<img src='<spring:url value="/img/no_image.jpg" />' />
	<img src='<c:url value="/img/no_image.jpg"/>' /> --%>
		<div id="msg"></div>

</div>

<%@ include file="/WEB-INF/include/include-body.jspf" %>
<script type="text/javascript">
	$(document).ready(function(){
		$("#register").on("click", function(e){
			/* e.preventDefault();
			fn_openRegister(); */
			
			var sendData = {
					"boardWriter" : $("#boardWriter").val(),
					"boardWriterPw" : $("#boardWriterPw").val()
			};
			$.ajax({
				type : "post",
				dataType : "json",
				data : JSON.stringify(sendData),
				contentType : 'application/json',
				url : "<c:url value='/testCheck.do' />",
				success : function(data){
					console.log(data);
					alert(data.msg);
					
					var html = "<p>"+data.msg+"</p>";
					html += "<p>"+data.nVo.boardWriter +"</p>";
					html += "<p>"+data.nVo.boardWriterPw +"</p>"; 
					$("#msg").html(html);
				
				},
				error: function(jqXHR, textStatus, errorThrown) { 
					alert(jqXHR.responseText); 
				}
			});
		});
		
		$("#login").on("click", function(e){
			var boardWriter = $("#boardWriter").val();
			var boardWriterPw = $("#boardWriterPw").val();
			if(boardWriter == ""){
				alert("아이디를 입력해주세요.");
				$("#boardWriter").focus();
				return;
			}
			
			if(boardWriterPw == ""){
				alert("비밀번호를 입력해주세요.");
				$("#boardWriterPw").focus();
				return;
			}
			e.preventDefault();
			fn_login();
		});
	});
	
	function fn_openRegister(){
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/testCheck.do' />");
		comSubmit.submit();
	}
	
	function fn_login(){
		var comSubmit = new ComSubmit("frm");
		comSubmit.setUrl("<c:url value='/loginCheck.do' />");
		comSubmit.submit();
	}

</script>

</body>
</html>