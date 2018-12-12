<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html lang="en">
<head>
	<%@ include file="/WEB-INF/include/include-header.jspf" %>
<body>

<div class="container">
	<h2>샘플 게시판</h2>
	<p>본 화면을 토대로 CRUD가 가능한 게시판을 개발하면 됩니다.</p>
	<p>ITPlanet</p>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th style="width:5%;">No.</th>
				<th style="width:15%;">작성자</th>
				<th style="width:30%;">제목</th>
				<th style="width:45%;">내용</th>
				<th style="width:5%;">조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="list" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${list.boardWriter }</td>
				<td class="test">
				<a href="javascript:fn_openBoardDetail(${list.boardIdx })">${list.boardTitle }</a>
				<input type="hidden" id="boardIdx" value="${list.boardIdx }" />
				</td>
				<td>${list.boardContents }</td>
				<td>${list.boardViewCount }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
			<c:if test="${paging.curRange ne 1}">
				<a href="javascript:fn_goPage(1)">[처음]</a>
			</c:if>
			<c:if test="${paging.curPage ne 1}">
				<a href="javascript:fn_goPage(${paging.curPage-1 })">[이전]</a>
			</c:if>
			<c:forEach var="pageNum" begin="${paging.startRange }" end="${paging.endRange }">
				<c:choose>
					<c:when test="${pageNum eq paging.curPage }">
						<a href="javascript:fn_goPage(${pageNum })" style="font-weight:bold">${pageNum }</a>	
					</c:when>
					<c:otherwise>
						<a href="javascript:fn_goPage(${pageNum })">${pageNum }</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${paging.curPage ne paging.totalPage && paging.totalPage > 0}">
				<a href="javascript:fn_goPage(${paging.curPage+1 })">[다음]</a>
			</c:if>
			<c:if test="${paging.curRange ne paging.totalRange && paging.totalRange > 0}">
				<a href="javascript:fn_goPage(${paging.totalPage })">[끝]</a>
			</c:if>	
	</div>
	<div>
		<button id="write">게시글 작성</button>
	</div>
		
</div>

<%@ include file="/WEB-INF/include/include-body.jspf" %>
<script type="text/javascript">
	$(document).ready(function(){
		$("#write").on("click", function(e){
			e.preventDefault();
			fn_openBoardWrite();
		});
		
		/* $("a[name='title']").on("click", function(e){
			e.preventDefault();
			fn_openBoardDetail($(this));
		});  */
	});
	
	function fn_openBoardWrite(){
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/openBoardWrite.do' />");
		comSubmit.submit();
	}
	
	function fn_openBoardDetail(idx){
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/openBoardDetail.do' />");
		comSubmit.addParam("boardIdx", idx);
		comSubmit.submit();
	}
	
	function fn_goPage(page){
 		var comSubmit = new ComSubmit();
		comSubmit.setUrl("/sam/sample.do?page=" + page);
		comSubmit.submit(); 
		 
		 /* location.href = "/sam/sample.do?page="+page; */ 
	}

</script>

</body>
</html>
