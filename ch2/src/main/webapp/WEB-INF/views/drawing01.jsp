<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Drathing</title>
  
</head>
<style>
  @import url('https://fonts.googleapis.com/css2?family=Finger+Paint&display=swap');
    #subject{
      text-align: center;
      font-family: 'Finger Paint', 바탕;
      font-size: 20px;

    }
    #drawingCanvas{
      border: 1px solid rgb(90, 155, 46);
      display: block;
      margin: auto;
    }
    #button-container {
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
       <div id="subject">
      <h1 style="color: pink;">subject: <span style="font-family:'Finger Paint', 바탕 ; color:rgb(146,231,146)">subject</span></h1>
    </div>

    <div>
    <canvas id="drawingCanvas" width="800" height="600"></canvas>
    <script type="text/javascript" src="<c:url value="/resources/js/drawing.js" />"></script>
    </div> 

    <div id="button-container">
      <!-- 버튼 1 --> 
    <form action = "<c:url value="/bulletin/main01"/>"  onclick="submitDrawing()" >
        <button type="submit" class="button" >submit</button>
    </form>

    <!-- 버튼 2 -->
    <form action="<c:url value="/key/key01"/>" method="post">
        <button type="submit" class="button" >return</button>
    </form>
      </div>
</body>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
    function submitDrawing() {
        var canvas = document.getElementById('drawingCanvas');
        var drawingData = canvas.toDataURL();

        $.ajax({
            type: 'POST',
            url: 'board01.jsp',
            data: { drawingData: drawingData },
            success: function(response) {
                // 서버 응답을 콘솔에 출력
                console.log('Server response:', response);

                // 응답을 받아 처리하는 추가적인 로직을 여기에 추가
                // 예: 다른 페이지로 이동하거나, 현재 페이지의 내용 갱신 등
                window.location.href = "<c:url value='/bulletin/main01'/>";
            },
            error: function(error) {
                console.error('Error submitting drawing:', error);
            }
        });
    }
</script>
</html>