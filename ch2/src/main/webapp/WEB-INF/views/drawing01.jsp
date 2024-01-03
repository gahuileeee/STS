<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Drathing</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/styles.css" />">
</head>
<body>
    <canvas id="drawingCanvas" width="800" height="600"></canvas>
    <script type="text/javascript" src="<c:url value="/resources/js/drawing.js" />"></script>
</body>
</html>