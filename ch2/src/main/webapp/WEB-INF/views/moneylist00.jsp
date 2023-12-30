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
    padding-bottom: 50px;
    
  }
  #footer{
    box-sizing: border-box;
    width: 1300px;
    height: 50px;
    background-color: rgba(10, 59, 87, 0.338);
    text-align: center;
  }
    table{
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
	<div id="section">
    <h2 id="center">고객대여금액조회</h2>
	    <table style="margin-left: 450px;">
        <tr>
          <th>   고객번호 </th>
          <th>   고객이름  </th>
          <th>   고객등급 </th>
          <th>   총대여금액 </th>
        </tr> 
          <%
    List<String> dataList = (List<String>) request.getAttribute("arr");
    int size = dataList.size();
    for (int i = 0; i < size; i += 4) {
%>
    <tr>
        <%
            for (int j = i; j < Math.min(i + 4, size); j++) {
        %>
                <td><%= dataList.get(j) %></td>
        <%
            }
        %>
    </tr>
<%
    }
%>
      </table>
  </div>

  <footer id="footer">
    나도 할 수 있는 JAVA & Spirng 웹 개발 종합반 (이가희)
  </footer>
</body>
</html>