<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href='/resources/css/index01n.css'>
    <title>DraThing</title>
</head>
<style>
@import url('https://fonts.googleapis.com/css2?family=Finger+Paint&display=swap');


    </style>

<body>

    <!-- 로고 이미지 -->
     <div id="img">
      <h1 ><span class="pink-text">Dra</span> <span class="green-text">Thing</span></h1>
    </div>
    <!-- 버튼 1 -->
    <form action="<c:url value="/login/select01"/>" >
        <button type="submit" class="button">Start</button>
    </form>

    <!-- 버튼 2 -->
    <form action="<c:url value="/bulletin/main01"/>" method="post">
        <button type="submit" class="button">bulletin board</button>
    </form>

</body>
</html>