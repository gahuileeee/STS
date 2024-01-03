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
      <h1 style="color: rgb(245, 109, 193);">subject: <span style="font-family:'Finger Paint', 바탕 ; color:rgb(0, 0, 0)">subject</span></h1>
    </div>

    <div>
    <canvas id="drawingCanvas" width="800" height="600"></canvas>
    <script type="text/javascript" src="<c:url value="/resources/js/drawing.js" />"></script>
    </div>

    <div id="button-container">
      <!-- 버튼 1 -->
    <form action="" method="post">
        <button type="submit" class="button">submit</button>
    </form>

    <!-- 버튼 2 -->
    <form action="button2Action.jsp" method="post">
        <button type="submit" class="button">return</button>
    </form>
      </div>
</body>
</html>