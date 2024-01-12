<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href='/resources/css/login01.css'>
    <title>DraThing</title>

</head>

<body>

    <!-- 로고 이미지 -->
    <div id="img">
        <h1><span class="pink-text">Dra</span><span class="green-text">Thing</span></h1>
    </div>

    <!-- 로그인 폼 -->
    <div class="login-container">
        <form class="login-form" action="<c:url value="/key/key01"/>" method="post">
            <div class="form-group">
                <label for="username">ID(email):</label>
                <input type="text" id="username" name="username">
            </div>
            <div class="form-group">
                <label for="password">password:</label>
                <input type="password" id="password" name="password">
            </div>
            <div class="button-container">
                <button type="submit" class="button">Login</button>
            </div>
        </form>
    </div>
    
	<div>
	<form action="<c:url value="/register/res01"/>" method="post">
	<button type="submit" class="guest-button" id='button2'>Do not have an account?</button>
	</form>
	</div>

</body>

</html>