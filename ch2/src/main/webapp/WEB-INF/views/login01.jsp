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
        <form class="login-form">
            <div class="form-group">
                <label for="username">ID:</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="button-container">
                <button type="submit" class="button">Login</button>
                <button type="submit" class="button">Sign In</button>
            </div>
        </form>
    </div>
    
	<div>
	<form action="<c:url value="/home01"/>" method="post">
	<button type="submit" class="guest-button" id='button2'>Access as a Guest</button>
	</form>
	</div>

</body>

</html>