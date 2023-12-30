package com.fastcampus.ch2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("borrow")
public class BorrowController00 {
	
	@RequestMapping("/borrow00")
	public  String main(Model model) throws Exception {
		 String DB_URL = "jdbc:mysql://localhost:3306/fast_db?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false";
	        String DB_USER = "root";
	        String DB_PASSWORD = "0000";
	        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // �����ͺ��̽��� ������ ��´�.
	        Statement stmt  = conn.createStatement(); // Statement�� �����Ѵ�.
	        String query = "SELECT cust_no, rent_no, book_code, rent_price, date_format(rent_date,'%Y-%m-%d') from fast_db.rent_tbl;"; // �ý����� ���� ��¥�ð��� ����ϴ� ����(query)
	        ResultSet rs = stmt.executeQuery(query); 
	        
	        List<String> arr= new ArrayList<>();
	        while (rs.next()) {
	        	arr.add(rs.getString(1));
	        	arr.add(rs.getString(2));
	        	arr.add(rs.getString(3));
	        	arr.add(rs.getString(4));
	        	arr.add(rs.getString(5));
	            
	        }
	        
	      model.addAttribute("arr", arr);
		return "keyward01";
	}
}