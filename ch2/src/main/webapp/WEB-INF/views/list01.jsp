<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>fastcampus</title>
</head>
<style>
  @import url('https://fonts.googleapis.com/css2?family=Gaegu:wght@300;400&display=swap');
  
    #form{
    text-align: center;
    margin-left: 500px;
    border: 2px solid #000000;
    width: 300px;
    height: 300px;
    padding: 10px;
  }
  
  #font{
    font-family: 'Gaegu', 바탕;
  }
  #header{
    margin-top: 0;
    box-sizing: border-box;
    width: 1300px;
    height: 50px;
    background-color: rgba(10, 59, 87, 0.338);
    text-align: center;
  }

  #nave{
      margin-top: 0;
      list-style: none;
      box-sizing: border-box;
      width:1300px;
      height:50px;
    
  }
  ul,li{
      display: inline-block;
      border: 2px solid #000000;
      padding-left: 50px;
      padding-right: 50px;
      padding-top: 5px;
      box-sizing: border-box;
      background-color: rgb(209, 223, 240);
      text-align: center;
    }
  #section{
    margin-top: 0;
    box-sizing: border-box;
    width: 1300px;
    height: 450px;
    
  }
  #center{
    text-decoration: underline;
    text-align: center;
    
  }
  #footer{
    box-sizing: border-box;
    width: 1300px;
    height: 50px;
    background-color: rgba(10, 59, 87, 0.338);
    text-align: center;
  }
    table{
    margin-left: 330px; 
    margin-top:0px;
      border:1px solid #ccc;
      border-collapse: collapse;
      text-align: center;
    }
    td,th{
      border: 1px solid #ccc;
      padding:10px;
      text-align: center;
    }
    

</style>
<body>
  <div id="header">
    <h1 id="font">도서 고객 및 대여관리 프로그램 ver 1.0</h1>
  </div>

  <nav id="font" >
    <ul id="nave" >
   
      <li><a href="<c:url value="/register/res00"/>" style="text-decoration: none; color: black;" >고객등록</a></li>
      <li><a href="<c:url value="/list/list00"/>" style="text-decoration: none; color: black;">고객 목록조회/수정</a></li>
      <li><a  href="<c:url value="/borrow/borrow00"/>" style="text-decoration: none; color: black;"s>고객대여리스트</a></li>
      <li><a  href="<c:url value="/money/money00"/>" style="text-decoration: none; color: black;">고객대여금액조회</a></li>
      <li><a href="<c:url value="/home"/>" style="text-decoration: none; color: black;"s>홈으로</a></li>
    </ul>
  </nav>

  <div id="section" >
    <h2 id="center">고객정보수정</h2> 
          <%
    List<String> dataList = (List<String>) request.getAttribute("arr");
%>
   <div id="form" >
  
      <form style="margin-top: 70px;" action="<c:url value='/list/list02'/>" method="post" >
      <label>고객번호: <input type="number" name="number" value= "<%= request.getAttribute("number") %>" readonly></label>
        <br>
      <label>고객이름: <input type="text" name="name" value= "<%= dataList.get(0) %>"></lbel>
        <br>
      <label>전화번호: <input type="text" name="tell" value= "<%= dataList.get(1) %>"></label>
        <br>
      <label>이메일: <input type="mail" name="mail" value= "<%= dataList.get(2) %>"></label>   
        <br>
      <label>고객등급(P,G,S): <input type="text" name="grade" value= "<%= dataList.get(3) %>"></label>  
        <br>
        <br>
      <laber ><input type="submit" value="[등록]" ></laber>
    </form>
    <br>
    <br>
     <label><a href="<c:url value='/list/list00'/>"><input type="button" value="[조회]"></a></label>
  </div>
</div>


  <footer id="footer">
    나도 할 수 있는 JAVA & Spirng 웹 개발 종합반 (이가희)
  </footer>
</body>
</html>