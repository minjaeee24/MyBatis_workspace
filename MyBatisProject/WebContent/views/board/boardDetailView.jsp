<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td>textarea {
		width : 100%; 
		height : 100%; 
		resize : none; 
		box-sizing : border-box;
	}
</style>
</head>
<body>
	
	<jsp:include page="../common/menubar.jsp" />
	
	<div class="outer">
		<br>
		<h1 align="center">게시판 상세조회</h1>
		<br>

		<table align="center" border="1">
			<!-- (tr>(td*2))*6 -->
			<tr>
				<td width="100">글번호</td>
				<td width="500">${ b.boardNo }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${ b.boardTitle }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${ b.boardWriter }</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${ b.count }</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>${ b.createDate }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td height="100">
					${ b.boardContent }
				</td>
			</tr>
		</table>

		<table align="center" border="1">
			<tr>
				<td width="100">댓글작성</td>
				<td width="400"><textarea></textarea></td>
				<td width="100"><button>등록</button></td>
			</tr>
			<tr>
				<td colspan="3"><b>댓글(${ list.size() })</b></td> <!-- 또는 fn:length(list) -->
			</tr>
			<c:forEach var="r" items="${ list }">
				<tr>
					<td>${ r.replyWriter }</td>
					<td>${ r.replyContent }</td>
					<td>${ r.createDate }</td>
				</tr>
			</c:forEach>
		</table>

		<br>
		<br>
	</div>
</body>
</html>