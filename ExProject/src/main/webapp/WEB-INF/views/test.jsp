<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html lang="en">
<head>
	<%@ include file="/WEB-INF/include/include-header.jspf" %>
<body>

<div class="container">
	<h2>결과</h2>
	<div>${data.boardWriter }</div>
	<div>${data.boardWriterPw }</div>
</div>

<%@ include file="/WEB-INF/include/include-body.jspf" %>
<script type="text/javascript">
	$(document).ready(function(){
		$("#register").on("click", function(e){
			e.preventDefault();
			fn_openRegister();
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
		comSubmit.setUrl("<c:url value='/register.do' />");
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