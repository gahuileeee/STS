<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DraThing</title>
</head>
<style>
@import url('https://fonts.googleapis.com/css2?family=Finger+Paint&display=swap');

        body {
            text-align: center;
            margin: 20px;
        }
        img {
        	 padding-top: 50px;
        	 padding-bottom: 40px;
        	 
            width: 65%;
             margin-left: 8%;
            height: auto;
        }
        .button {
            padding: 10px 20px;
            font-family: 'Finger Paint', 바탕;
            font-size: 20px;
            color: rgb(220, 148, 40);
            margin: 10px;
            background-color: rgb(254, 252, 242);
            border-color: rgb(161, 131, 22) ;
            border-radius: 10px;
            box-shadow: none;
        }
    </style>

<body>

    <!-- 로고 이미지 -->
    <img src="/ch2/img/logo.jpg" alt="Logo">
    <!-- 버튼 1 -->
    <form action="<c:url value="/key/key01"/>" >
        <button type="submit" class="button">Start</button>
    </form>

    <!-- 버튼 2 -->
    <form action="button2Action.jsp" method="post">
        <button type="submit" class="button">bulletin board</button>
    </form>

</body>
</html>