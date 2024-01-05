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
      <div id="drawingImage">
            <!-- 이미지를 표시할 공간 -->
            <img src="<%= request.getParameter("drawingData") %>" alt="Drawing">
        </div>
    <div>
       <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script>
        // 서버에서 받은 이미지 데이터를 표시
        $(document).ready(function() {
            var drawingData = '<%= request.getParameter("drawingData") %>';
            if (drawingData.trim() !== '') {
                $('#drawingImage img').attr('src', drawingData);
            } else {
                $('#drawingImage').hide(); // 데이터가 없을 경우 이미지 공간을 숨김
            }
        });
    </script>
    </div>
       
   </div>

</body>
</html>