<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
	<h2>회원 로그인</h2>
	<hr>
	<form action="loginOk" mathod="post">
		아이디 : <input type="text" name="mid"><br><br>
		비밀번호 : <input type="password" name="mpw"><br><br>
		<input type="submit" value="로그인">
		<input type="button" value="회원가입" onclick="javascript:window.location='join'">
	</form>
</body>
</html>