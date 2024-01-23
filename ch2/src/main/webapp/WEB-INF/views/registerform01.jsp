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
    
    // 폼 제출 시 실행되는 함수
    function onSubmitForm() {
        
        var email = document.getElementById("email").value;
        var password = document.getElementById("password").value;
        var confirmPassword = document.getElementById("confirm-password").value;
        var data = {
                email: email,
                password: password,
                confirmPassword: confirmPassword
            };

            // 서버로 데이터 전송
            sendFormData(data);
            return false;
    }
    
 // 서버로 JSON 데이터 전송
    function sendFormData(data) {
        fetch('${pageContext.request.contextPath}/signup01', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        })
        .then(response => response.json())
        .then(errorMessages => {
        // 서버로부터의 응답 처리
        console.log('Error Messages:', errorMessages);

        if (errorMessages.length > 0) {
            errorMessages.forEach(errorMessage => {
            	alert(errorMessage);
                console.error(errorMessage);
            });
        } else {
            // 에러가 없는 경우
        	 document.getElementById("form").submit();
        }
    })
        .catch((error) => {
            console.error('Error:', error);
        });
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
       <form class="login-form" id="form" action="${pageContext.request.contextPath}/login/login01" onsubmit="return onSubmitForm()" method="post">
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