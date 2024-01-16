<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href='/resources/css/login01.css'>
    <title>DraThing</title>
    
        <script>
        function validateForm() {
            // 이메일 형식 검증
            var email = document.getElementById("email").value;
            var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailRegex.test(email)) {
                alert("올바른 이메일 주소를 입력하세요.");
                return false;
            }

            // 비밀번호 일치 여부 확인
            var password = document.getElementById("password").value;
            var confirmPassword = document.getElementById("confirm-password").value;
            if (password !== confirmPassword) {
                alert("비밀번호와 확인 비밀번호가 일치하지 않습니다.");
                return false;
            }

            // 모든 유효성 검사를 통과하면 true 반환
            return true;
        }
    </script>
</head>


<body>

    <!-- 로고 이미지 -->
    <div id="img">
        <h1><span class="pink-text">Dra</span><span class="green-text">Thing</span></h1>
    </div>

    <!-- 회원가입 폼 -->
    <div class="login-container">
        <form class="login-form" action="${pageContext.request.contextPath}/login/login01" onsubmit="return validateForm()" method="post" >
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
        <form action="${pageContext.request.contextPath}/login/login01"" method="get">
            <button type="submit" class="guest-button" id='button2'>Already have an account? Login</button>
        </form>
    </div>

</body>

</html>