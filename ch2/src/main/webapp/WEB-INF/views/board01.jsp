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

    #title{
        text-align: center;
        font-family: 'Finger Paint', 바탕;
        background-color: rgb(255, 243, 224);
    }
    h2 {
      display: inline-block;
      padding: 5px 10px;
    }

    .pink-text {
      color: pink;
    }

    .green-text {
      color: rgb(146, 231, 146);
    }
    #nav{
        font-family: 'Finger Paint', 바탕;
        height: 40px;
        background-color: pink;
        text-align: center;
    }
    #context{
        box-sizing: border-box ;
        width: auto;
        height: 700px;
        background-color: bisque;
        text-align: center;
    }
    </style>

<body>
    <div id="title">
        <h2><span class="pink-text">Dra</span><span class="green-text">Thing</span></h2>
    </div>

    <div id="nav">
        <h4>네비게이션</h4>
    </div>
   <div id="context">
    <h1 style="margin: 0;">내용</h1>
    <!-- 이미지를 표시할 공간 -->
       <img src="data:image/png;base64,${print}" alt="Image">

</body>
</html>