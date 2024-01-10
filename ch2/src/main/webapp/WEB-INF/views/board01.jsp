<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Base64" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href='/resources/css/board01.css'>
    <title>DraThing</title>
</head>

<body>
    <div id="title">
        <h1><span class="pink-text">Dra</span><span class="green-text">Thing</span></h1>
    </div>

    <div id="nav">
       <form action="<c:url value="/home01"/>" method= "post" >
       <button type = "summit" class = "button" id='button2'>
       	<h3>home</h3>
       </button>
       </form>
          <form action="<c:url value="/login/login01"/>" method= "post" >
       <button type = "summit" class = "button" id='button2'>
       	<h3>login</h3>
       </button>
       </form>
    </div>
    
   <div id="context">
  
 
    <!-- 이미지를 표시할 공간 -->
     <c:forEach var="print" items="${prints}" varStatus="loop">
        <div class="image-container" >
            <img src="data:image/png;base64,${print}" alt="Print Image"/>
            
            <form action="<c:url value="/bulletin/main01"/>" method= "post" >
            <input type = "hidden" name = "print" value= "${print}">
            <input type = "hidden" name = "key" value= "${names[loop.index]}">
            <button type = "sumbit" class ="button" id="button1" >
            <h5 >${names[loop.index]}</h5>
            </button>
            
             </form>
        </div>

  </c:forEach>
  </div>

</body>
</html>