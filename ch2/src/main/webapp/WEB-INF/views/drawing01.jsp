<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Drathing</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Finger+Paint&display=swap');
        #subject {
            text-align: center;
            font-family: 'Finger Paint', 바탕;
            font-size: 20px;
        }
        #container {
            display: flex;
            align-items: center;
            justify-content: center;
            margin-top: 20px;
        }
        #toolsContainer {
            display: flex;
            flex-direction: column;
            margin-right: 10px; /* 수정: margin-right로 변경 */
        }
        #drawingCanvas {
            border: 1px solid rgb(90, 155, 46);
            margin: 10px;
        }
        #eraserButton {
            padding: 8px 15px;
            font-family: 'Finger Paint', 바탕;
            font-size: 16px;
            color: rgb(220, 148, 40);
            background-color: rgb(254, 252, 242);
            border-color: rgb(161, 131, 22);
            border-radius: 5px;
            box-shadow: none;
            transition: background-color 0.3s ease;
            cursor: pointer;
            margin-bottom: 5px;
        }
        #eraserButton:hover {
            background-color: rgb(220, 148, 40);
            color: rgb(254, 252, 242);
        }
        #eraserButton:active {
            background-color: rgb(161, 131, 22);
            color: rgb(254, 252, 242);
        }
             #penButton {
            padding: 8px 10px;
            font-family: 'Finger Paint', 바탕;
            font-size: 16px;
            color: rgb(220, 148, 40);
            background-color: rgb(254, 252, 242);
            border-color: rgb(161, 131, 22);
            border-radius: 5px;
            box-shadow: none;
            transition: background-color 0.3s ease;
            cursor: pointer;
            margin-bottom: 5px;
        }
        #penButton:hover {
            background-color: rgb(220, 148, 40);
            color: rgb(254, 252, 242);
        }
        #penButton:active {
            background-color: rgb(161, 131, 22);
            color: rgb(254, 252, 242);
        }
        #sizeContainer {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-bottom: 5px;
        }
        #lineSizeRange {
            width: 100%;
            margin-bottom: 5px;
        }
        #colorPicker {
            margin-bottom: 10px;
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
            border-color: rgb(161, 131, 22);
            border-radius: 10px;
            box-shadow: none;
        }
    </style>
</head>
<body>
    <div id="subject">
        <h1 style="color: pink;">subject: <span style="font-family:'Finger Paint', 바탕 ; color:rgb(146,231,146)">
            ${key}
            </span></h1>
    </div>

    <div id="container">
        <div id="toolsContainer"> 
            <button id="eraserButton">Eraser</button>
            <button id="penButton">Pen</button>
            <div id="sizeContainer">
                <label for="lineSizeRange"></label>
                <input type="range" id="lineSizeRange" min="1" max="10" step="1" value="5">
            </div>
            <input type="color" id="colorPicker" value="#000000">
        </div>
        <canvas id="drawingCanvas" width="800" height="600"></canvas>
    </div>

    <div id="button-container">
        <!-- 버튼 1 -->
        <form action="<c:url value="/bulletin/main01"/>" method="post" onsubmit="return submitDrawing()">
            <input type="hidden" name="drawingData" id="drawingDataInput">
            <input type="hidden" name="key" value="${key}">
            <button type="submit" class="button" name="print">submit</button>
        </form>

        <!-- 버튼 2 -->
        <form action="<c:url value="/key/key01"/>" method="post">
            <button type="submit" class="button">return to keyward</button>
        </form>
    </div>
    <script type="text/javascript" src="<c:url value="/resources/js/drawing2.js" />"></script>
</body>
</html>