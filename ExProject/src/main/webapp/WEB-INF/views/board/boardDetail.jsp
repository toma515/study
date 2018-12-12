<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html lang="en">
<head>
	<%@ include file="/WEB-INF/include/include-header.jspf" %>
<body>

<div class="container">
	<h2>상세 게시글</h2>
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
				<td>${result.boardIdx }<input type="hidden" id="boardIdx" value="${result.boardIdx }" /></td>
				<th >조회수</th>
				<td>${result.boardViewCount }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${result.boardWriter }</td>
				<th>제목</th>
				<td>${result.boardTitle }</td>
			</tr>
			<tr>
				<td colspan="4" style="height:100px;">${result.boardContents }</td>
			</tr>
			<tr>
				<th>첨부 파일</th>
				<td style="height:100px;">
					<c:forEach items="${list }" var="list" varStatus="status" >
						<a style="display: block;" href="javascript:fn_downloadFile(${list.fileIdx })">${list.fileOriginalName }</a>
					</c:forEach>
				</td>
			</tr>
		</tbody>
	</table>
	
	<button id="update">수정하기</button>
	<button id="list">목록으로</button>
</div>

<%@ include file="/WEB-INF/include/include-body.jspf" %>
<script type="text/javascript">
	$(document).ready(function(){
		$("#list").on("click", function(e){
			e.preventDefault();
			fn_openBoardList();
		});
		
		$("#update").on("click", function(e){
			e.preventDefault();
			fn_openBoardUpdate();
		});
	});
	
	function fn_openBoardList(){
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/sample.do' />");
		comSubmit.submit();
	}

	function fn_openBoardUpdate(){
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/openBoardUpdate.do' />");
		comSubmit.addParam("boardIdx", $("#boardIdx").val());
		comSubmit.submit();
	}
	
	function fn_downloadFile(idx){
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/downloadFile.do' />");
		comSubmit.addParam("fileIdx",idx);
		comSubmit.submit();
	}
	
</script>

</body>
</html>
