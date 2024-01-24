<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Base64" %>
<c:set var="loginOutLink" value="${sessionScope.user==null ? '/bulletin/login01' : '/bulletin/logout01'}"/>
<c:set var="loginOut" value="${sessionScope.user==null ? 'Login' : 'Logout'}"/>
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
       <button type = "submit" class = "button" id='button2'>
       	<h3>home</h3>
       </button>
       
       </form>
          <form action="<c:url value="${loginOutLink}"/>" method= "post" onsubmit="addCurrentPageToSession()" >
       <button type = "submit" class = "button" id='button2'>
       	<h3>${loginOut}</h3>
       </button>
       </form>
       
    </div>
    
   <div id="context">
  
 
    <!-- 이미지를 표시할 공간 -->
     <c:forEach var="print" items="${prints}" varStatus="loop">
        <div class="image-container" >
            <img src="data:image/png;base64,${print}" alt="Print Image"/>
            
            <form action="<c:url value="/bulletin01"/>" method= "post" >
            <input type ="hidden" name="number" value="${numbers[loop.index]}">
            <button type = "sumbit" class ="button" id="button1" >
            <h5 >${names[loop.index]}</h5>
            </button>
            
             </form>
        </div>

  </c:forEach>
  </div>

</body>
</html>