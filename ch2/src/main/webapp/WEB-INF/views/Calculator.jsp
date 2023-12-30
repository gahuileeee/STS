<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>더하기 계산기 프로그램</title>
</head>
<body>
	<h1>계산기</h1>
	<form action="/ch2/calculator/view" method="get">
	<lable> <input type="text" name="a" > </lable>
		<br>
		<lable> <input type="radio" name="x" value="1" > + </lable>
		<lable> <input type="radio" name="x" value="2" > - </lable>
		<lable> <input type="radio" name="x" value="3" > / </lable>
		<lable> <input type="radio" name="x" value="4" > x </lable>
	<br>
	<lable> <input type="text" name="b" > </lable>
		<br>
		<br>
	<lable> <input type="submit" value="계산"> </lable>
	</form>
</body>
</html>