<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<%
		 String loginCheck = request.getAttribute("loginCheck").toString();
		if(loginCheck.equals("0")){	//로그인 실패
	%>
		<script type="text/javascript">
			alert("입력하신 아이디 또는 비밀번호가 일치하지 않습니다. 다시 확인후 로그인하세요");
			history.go(-1);
		</script>
	<%			
		}
	%>
	
	<h2>${memberid }님 로그인을 환영합니다.!!!</h2>
	<a href="logout">로그아웃</a><br>
	<a href="memberInfo">회원정보 보기</a><br>
	<a href="memberDelete">회원탈퇴</a><br>
	<a href="writeForm">게시판글쓰기</a>
</body>
</html>