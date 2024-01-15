<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
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

    <!-- 회원가입 폼 -->
    <div class="login-container">
        <form class="login-form" action="${pageContext.request.contextPath}/key/key01" onsubmit="return validateForm()" method="post" >
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="form-group">
                <label for="confirm-password">Confirm Password:</label>
                <input type="password" id="confirm-password" name="confirm-password" required>
            </div>
            <div class="button-container">
                <button type="submit" class="button" >Create Account</button>
            </div>
        </form>
    </div>
    
    <!-- 이미 가입한 경우 로그인으로 이동하는 버튼 -->
    <div>
        <form action="c:url value=>" method="get">
            <button type="submit" class="guest-button" id='button2'>Already have an account? Login</button>
        </form>
    </div>

</body>

</html>