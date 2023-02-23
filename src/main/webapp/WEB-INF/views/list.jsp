<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글목록</title>
</head>
<body>
		<h2>자유게시판</h2>
		<hr>
		<table border="1" cellspacing="0" cellpadding="0" width="1000">
		<tr>
			<th>번호</th>
			<th>글쓴이</th>
			<th width="500">글제목</th>
			<th>게시일</th>
			
		</tr>
		
			<c:forEach items="${list }" var="bdto">
			<tr>
				<td>${bdto.bid }</td>
				<td>${bdto.bmname }</td>
				<td>
					<a href="bcontentView?bid=${bdto.bid }">${bdto.btitle }</a>
				</td>
				<td>${bdto.bdate }</td>
				
			</tr>
			</c:forEach>
			
			<tr>
				<td>
					<input type="button" value="글쓰기" onclick="javascript:window.location='writeForm'">
				</td>
			</tr>
			
		</table>
</body>
</html>