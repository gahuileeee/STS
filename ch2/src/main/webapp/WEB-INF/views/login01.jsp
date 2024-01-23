<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

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
        var data = {
                email: email,
                password: password,
            };
            // 서버로 데이터 전송
            sendFormData(data);
            console.log("아?");
            return false;
    }
    
 // 서버로 JSON 데이터 전송
    function sendFormData(data) {
        fetch('${pageContext.request.contextPath}/signin01', {
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

    <!-- 로그인 폼 -->
    <div class="login-container">
        <form class="login-form" id ="form" action="<c:url value="/key/key01"/>"  onsubmit="return onSubmitForm()"  method="post">
            <div class="form-group">
                <label for="username">ID(email):</label>
                <input type="text" id="email" name="user">
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