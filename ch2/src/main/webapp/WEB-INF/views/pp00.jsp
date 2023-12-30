<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나는 그저 연습할 뿐</title>
</head>
<body>
	<p> 이름은 바로 <%= request.getAttribute("name") %> 입니다.</p>
	<p> 회원번호는 바로 <%= request.getAttribute("number") %> 입니다.</p>
	<p> 전화번호는 바로 <%= request.getAttribute("tell") %> 입니다.</p>
	
</body>
</html>