<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html lang="en">
<head>
	<%@ include file="/WEB-INF/include/include-header.jspf" %>
<body>

<div class="container">
	<h2>게시글 작성</h2>
	<form id="frm" enctype="multipart/form-data">
		<table class="table">
			<colgroup>
				<col width="15%"/>
				<col width="*"/>
			</colgroup>
			<tbody>
				<tr>
					<th>제목</th>
					<td><input type="text" name="boardTitle" id="boardTitle" /></td>
					
				<tr>
					<th>작성자</th>
					<td><input type="text" name="boardWriter" id="boardWriter" /></td>
				</tr>
				<tr>
					<td colspan="2"><textarea rows="20" cols="100" title="내용" name="boardContents" id="boardContents" ></textarea></td>
				</tr>
				<tr>
				<th>첨부 파일</th>
					<td style="height:100px;">
						<div id="fileArea">
							<p id="p_0">
								<input type="file" name="file_0" style="display: inline;"/><button type="button" id="delete_0">삭제</button>
							</p>						
						</div>
					
					</td>
				</tr>
			</tbody>
		</table>
		<button type="button" id="addFile">파일추가</button>
		<button type="button" id="write">작성하기</button>
		<button type="button" id="list">목록으로</button>
	</form>

</div>

<%@ include file="/WEB-INF/include/include-body.jspf" %>
<script type="text/javascript">
	var gfv_count = 1;
	
	$(document).ready(function(){
		$("#list").on("click", function(e){
			e.preventDefault();
			fn_openBoardList();
		});
		
		$("#write").on("click", function(e){
			e.preventDefault();
			fn_insertBoard();
		});
		
		$("#addFile").on("click", function(e){
			e.preventDefault();
			fn_addFile();
		});
		
		$("#delete_0").on("click", function(e){
			e.preventDefault();
			fn_deleteFile(0);
		});
	});
	
	function fn_openBoardList(){
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/sample.do' />");
		comSubmit.submit();
	}
	
	function fn_insertBoard(){
		var comSubmit = new ComSubmit("frm");
		comSubmit.setUrl("<c:url value='/insertBoard.do' />");
		comSubmit.submit();
	}
	
	function fn_addFile(){
		var str = "<p id='p_"+gfv_count+"'><input type='file' name='file_"+gfv_count+"' style='display: inline;' /><button type='button' name='delete' id='delete_"+gfv_count+"'>삭제</button>"
		var id = "#delete_"+gfv_count;
		var num = gfv_count;
		$("#fileArea").append(str);
		$(id).on("click", function(e){
			e.preventDefault();
			fn_deleteFile(num);
		});
		gfv_count++;
	}
	
	function fn_deleteFile(num){
		var str = "#p_"+num;
		/* alert(str); */
		$(str).remove();
	}

</script>

</body>
</html>