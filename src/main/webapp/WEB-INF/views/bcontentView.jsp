<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 내용보기</title>
</head>
<body>
	<h2>게시글 내용보기</h2>
	<hr>
	<table border="1" cellpadding="0" cellspacing="0" width="600">
	
		<tr>
			<th>글번호</th>
			<td>${bdto.bid }</td>
		</tr>
		
		<tr>
			<th>등록일</th>
			<td>${bdto.bdate }</td>
		</tr>
		<tr>
			<th>이 름</th>
			<td>${bdto.bmname }</td>
		</tr>
		<tr>
			<th>제 목</th>
			<td>${bdto.btitle }</td>
		</tr>
		<tr>
			<th>내 용</th>
			<td height="100">${bdto.bcontent }</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
			
			<input type="button" value="글수정" onclick="javascript:window.location='modifyView?bid=${bdto.bid }'">
			<input type="button" value="글삭제" onclick="javascript:window.location='delete?bid=${bdto.bid }'">
			<input type="button" value="글목록" onclick="javascript:window.location='list'">
			</td>
		</tr>
	
	</table>	
</body>
</html>