package com.fastcampus.ch2;

import java.sql.*;

public class DBConnectionTest {
    public static void main(String[] args) throws Exception {
        // 스키마의 이름(springbasic)이 다른 경우 알맞게 변경해야 함
        String DB_URL = "jdbc:mysql://localhost:3306/fast_db?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";

        // DB의 userid와 pwd를 알맞게 변경해야 함
        String DB_USER = "root";
        String DB_PASSWORD = "0000";

        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // 데이터베이스의 연결을 얻는다.
        Statement stmt  = conn.createStatement(); // Statement를 생성한다.

//        String query = "SELECT now()"; // 시스템의 현재 날짜시간을 출력하는 쿼리(query)
        String query = "SELECT * FROM fast_db.member_tbl"; // 시스템의 현재 날짜시간을 출력하는 쿼리(query)
        ResultSet rs = stmt.executeQuery(query); // query를 실행한 결과를 rs에 담는다.
//        DB에다 쿼리를 쏨 -> 쿼리에 대한 결과가resultSet에 담겨줌 ->
        
        // 실행결과가 담긴 rs에서 한 줄씩 읽어서 출력
        while (rs.next()) {
            int number = rs.getInt(1);  // 읽어온 행의 첫번째 컬럼의 값을 String으로 읽어서 curDate에 저장
            String name = rs.getString(2);  // 읽어온 행의 첫번째 컬럼의 값을 String으로 읽어서 curDate에 저장
            String phone = rs.getString(3);  // 읽어온 행의 첫번째 컬럼의 값을 String으로 읽어서 curDate에 저장
            String date = rs.getString(4);  // 읽어온 행의 첫번째 컬럼의 값을 String으로 읽어서 curDate에 저장
            String email = rs.getString(5);  // 읽어온 행의 첫번째 컬럼의 값을 String으로 읽어서 curDate에 저장
            System.out.println(number+name+phone+date+email);       // 2022-01-11 13:53:00.0
        
        }

    
    
    } // main()
}
