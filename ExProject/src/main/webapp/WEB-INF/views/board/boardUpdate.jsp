<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html lang="en">
<head>
	<%@ include file="/WEB-INF/include/include-header.jspf" %>
	<link href="<c:url value='/css/style.css' />" rel="stylesheet" type="text/css">

<body>

<div class="container">
	<h2>게시글 수정</h2>
	<form id="frm" enctype="multipart/form-data">
		<table class="table">
			<colgroup>
				<col width="15%"/>
				<col width="35%"/>
				<col width="15%"/>
				<col width="35%"/>
			</colgroup>
			<tbody>
				<tr>
					<th>글 번호</th>
					<td>${result.boardIdx }<input type="hidden" name="boardIdx" id="boardIdx" value="${result.boardIdx }" /></td>
					<th >조회수</th>
					<td>${result.boardViewCount }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${result.boardWriter }</td>
					<th>제목</th>
					<td><input type="text" name="boardTitle" id="boardTitle" value="${result.boardTitle }"/></td>
				</tr>
				<tr>
					<td colspan="4" style="height:100px;">
						<textarea rows="20" cols="100" title="내용" name="boardContents" id="boardContents" >${result.boardContents }</textarea>
					</td>
				</tr>
				<tr>
				<th>첨부 파일</th>
					<td colspan="3" style="height:100px;">
						<div id="fileArea">
							<c:forEach items="${list }" var="list" varStatus="status" >
								<div id="div_${status.index }">
									<input type="hidden" id="IDX" name="IDX_${status.index }" value="${list.fileIdx }" /> 
									<input type="text" id="fileName_${status.index }" value="${list.fileOriginalName }" disabled="disabled" /> 
									<div class="filebox" style="display: inline;">
										<label for="file_${status.index }" >업로드</label>
										<input type="file" id="file_${status.index }" name="file_${status.index }" onchange="fn_selectFile(${status.index})" style="display: inline;"/>
										<button type="button" onclick="fn_deleteFile(${status.index})">삭제</button>					
									</div>
								</div>
							</c:forEach>
						</div>
						
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<button id="addFile">파일추가</button>
	<button id="update">저장하기</button>
	<button id="delete">삭제하기</button>
	<button id="list">목록으로</button>
</div>

<%@ include file="/WEB-INF/include/include-body.jspf" %>


<script type="text/javascript">
	var gfv_count = '${fn:length(list)}'; 

	$(document).ready(function(){
		$("#list").on("click", function(e){
			e.preventDefault();
			fn_openBoardList();
		});
		
		$("#update").on("click", function(e){
			e.preventDefault();
			fn_updateBoard();
		});
		
		$("#delete").on("click", function(e){
			e.preventDefault();
			fn_deleteBoard();
		});
		/* for (var i = 0; i < gfv_count; i++) {
			var id = "#file_"+i;
			var num = i;
			$(id).on("change", function(e){
				e.preventDefault();
				fn_selectFile(num);
			});
		} */
		$("#addFile").on("click", function(e){
			e.preventDefault();
			fn_addFile();
			/* console.log(gfv_count);
			gfv_count++; */
		});
	});
	
	function fn_openBoardList(){
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/sample.do' />");
		comSubmit.submit();
	}

	function fn_updateBoard(){
		var comSubmit = new ComSubmit("frm");
		comSubmit.setUrl("<c:url value='/updateBoard.do' />");
		comSubmit.submit();
	}
	
	function fn_deleteBoard(){
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/deleteBoard.do' />");
		comSubmit.addParam("boardIdx", $("#boardIdx").val());
		comSubmit.submit();
	}
	
	function fn_selectFile(num){
		var sFile = "#file_"+num;
		var fName = "#fileName_"+num;
		var str = $(sFile).val();
		var arrStr = str.split("\\");
		/* alert(arrStr[2]); */
		$(fName).val(arrStr[2]);
	}
	
	function fn_addFile(){
		var num = gfv_count;
		var fileId = "file_"+num; 
		var str = "<div id='div_"+num+"'><input type='text' id='fileName_"+num+"' value='"+$(fileId).val()+"' disabled='disabled' /><div class='filebox' style='display: inline;'> <label for='"+fileId+"' >업로드</label><input type='file' id='"+fileId+"' name='"+fileId+"' onchange='fn_selectFile("+num+")' style='display: inline;'/> <button type='button' onclick='fn_deleteFile("+num+")'>삭제</button></div></div>";
		var id = "#delete_"+num;
		$("#fileArea").append(str);
		$(id).on("click", function(e){
			e.preventDefault();
			fn_deleteFile(num);
		});
		gfv_count++;
	}
	
	function fn_deleteFile(num){
		var str = "#div_"+num;
		/* alert(str); */
		$(str).remove();
	}
	
</script>

</body>
</html>
