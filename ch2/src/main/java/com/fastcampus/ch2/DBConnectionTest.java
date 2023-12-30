package com.fastcampus.ch2;

import java.sql.*;

public class DBConnectionTest {
    public static void main(String[] args) throws Exception {
        // ��Ű���� �̸�(springbasic)�� �ٸ� ��� �˸°� �����ؾ� ��
        String DB_URL = "jdbc:mysql://localhost:3306/fast_db?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";

        // DB�� userid�� pwd�� �˸°� �����ؾ� ��
        String DB_USER = "root";
        String DB_PASSWORD = "0000";

        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // �����ͺ��̽��� ������ ��´�.
        Statement stmt  = conn.createStatement(); // Statement�� �����Ѵ�.

//        String query = "SELECT now()"; // �ý����� ���� ��¥�ð��� ����ϴ� ����(query)
        String query = "SELECT * FROM fast_db.member_tbl"; // �ý����� ���� ��¥�ð��� ����ϴ� ����(query)
        ResultSet rs = stmt.executeQuery(query); // query�� ������ ����� rs�� ��´�.
//        DB���� ������ �� -> ������ ���� �����resultSet�� ����� ->
        
        // �������� ��� rs���� �� �پ� �о ���
        while (rs.next()) {
            int number = rs.getInt(1);  // �о�� ���� ù��° �÷��� ���� String���� �о curDate�� ����
            String name = rs.getString(2);  // �о�� ���� ù��° �÷��� ���� String���� �о curDate�� ����
            String phone = rs.getString(3);  // �о�� ���� ù��° �÷��� ���� String���� �о curDate�� ����
            String date = rs.getString(4);  // �о�� ���� ù��° �÷��� ���� String���� �о curDate�� ����
            String email = rs.getString(5);  // �о�� ���� ù��° �÷��� ���� String���� �о curDate�� ����
            System.out.println(number+name+phone+date+email);       // 2022-01-11 13:53:00.0
        
        }

    
    
    } // main()
}
