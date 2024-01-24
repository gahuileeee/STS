<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<style>
#context {
    box-sizing: border-box;
    width: auto;
    height: 1300px;
    background-color: rgb(255, 243, 224);
    text-align: center;
}

.image-container {
    display: flex;
    flex-direction: column;
    align-items: center;
   margin: auto;
    width: 75%;
    height: 60%;
    background-color: white;
    border: 1px solid black;
     justify-content: center;
}

.image-container img {
    width: 90%;
    
    object-fit: cover;
}

.subject, .person {
    font-family: 'Finger Paint', 바탕;
    margin: 5px 0; /* 간격 조절 */
}


</style>
<body>
<body>
    <div id="title">
        <h1><span class="pink-text">Dra</span><span class="green-text">Thing</span></h1>
    </div>

    <div id="nav">
        <form action="<c:url value="/home01"/>" method= "post" >
            <button type="submit" class="button" id='button2'>
                <h3>home</h3>
            </button>
        </form>
        <form action="<c:url value="${loginOutLink}"/>" method="post" onsubmit="addCurrentPageToSession()">
            <button type="submit" class="button" id='button2'>
                <h3>${loginOut}</h3>
            </button>
        </form>
    </div>

    <div id="context">
    <br>
        <h3 class="subject">Subject: <u>${name}</u></h3> 
            <h4 class="person">User Name: <u>${user}</u></h4>
    <br>
        <div class="image-container">
            <img src="data:image/png;base64,${print}" alt="Print Image"/>
        </div>
    </div>
</body>
</html>