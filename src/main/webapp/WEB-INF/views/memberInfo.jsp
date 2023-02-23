<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>회원 정보 보기</h1>
		<h2>아이디 : ${memberDto.mid }</h2>
		<h2>암호 : ${memberDto.mpw }</h2>
		<h2>이름 : ${memberDto.mname }</h2>
		<h2>이메일 : ${memberDto.memail }</h2>
		<h2>가입일자 : ${memberDto.mdate }</h2>
		
		<a href="loginOk">로그인 OK화면으로 가기</a>
</body>
</html>