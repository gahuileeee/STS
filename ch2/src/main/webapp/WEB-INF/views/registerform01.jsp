<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href='/resources/css/login01.css'>
    <title>DraThing</title>
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
   <script type="text/javascript" src="/resources/js/jquery.serialize-Object.min.js"></script>

            <script>
    function validateForm() {
        var email = document.getElementById("email").value;
        var password = document.getElementById("password").value;
        var confirmPassword = document.getElementById("confirm-password").value;

        // 클라이언트 측에서 유효성 검사
        var validationResult = {
            isValid: true,
            errors: {}
        };
        
        // 이메일 형식 검증
        var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailRegex.test(email)) {
            validationResult.isValid = false;
            validationResult.errors.email = "올바른 이메일 주소를 입력하세요.";
        }
	console.log("here1");
        // 비밀번호 일치 여부 확인
        if (password !== confirmPassword) {
            validationResult.isValid = false;
            validationResult.errors.confirmPassword = "비밀번호와 확인 비밀번호가 일치하지 않습니다.";
        }
        

        // 서버로 JSON 데이터 전송
        if (!validationResult.isValid) {
            for (var key in validationResult.errors) {
                if (validationResult.errors.hasOwnProperty(key)) {
                    alert(validationResult.errors[key]);
                }
            }
            return false;
        }
     // 서버로 유효성 검사 요청
      console.log("아ㅏㅏㅏ아");
       var user = $("form").serializeObject();
        $.ajax({
            type: "POST",
            url: "signup",
            contentType: "application/json;charset=UTF-8",
            data: user,
            dataType: "json",
            success: function (response) {
                if (response.error !==  null) {
                   alert(response.error);
                } else {
                    // 서버의 유효성 검사 통과 시, 폼 제출
                    $("form").submit();
                }
            }
            error : function(error) {
            	alert("처리 실패");
            }
        });
        console.log("아ㅏㅏㅏ아???ㄴ");
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
        <form class="login-form" id = "form" action="${pageContext.request.contextPath}/login/login01" onsubmit="return validateForm()" method="post" >
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