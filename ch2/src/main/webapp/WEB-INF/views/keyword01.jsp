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
        #img {
        	 padding-top: 50px;
        	 padding-bottom: 40px;
           font-family: 'Finger Paint', 바탕;
           text-align: center;
            font-size: 60px;
            height: auto;
        }
        .pink-text {
            color: pink;
        }

        .green-text {
            color: rgb(146, 231, 146);
        }
         .button-container {
            display: flex;
            justify-content: center;
            margin-top: 20px;
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
 <div id="img">
      <h1 ><span class="pink-text">Key</span>
        <span class="green-text">Word</span></h1>
    </div>
 <div class="button-container">
    <!-- 버튼 1 -->
    <form action="<c:url value="/draw/draw01"/>" method="post">
        <button type="submit" class="button">RAMDOM</button>
    </form>

    <!-- 버튼 2 -->
    <form action="<c:url value="/key/create01"/>" method="post">
        <button type="submit" class="button">CREATE</button>
    </form>
     <form action="<c:url value="/home01"/>" method="post">
        <button type="submit" class="button">HOME</button>
    </form>
</div>
</body>
</html>