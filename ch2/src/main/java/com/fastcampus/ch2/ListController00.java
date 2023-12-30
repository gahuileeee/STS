package com.fastcampus.ch2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("list")
public class ListController00 {
	
	@RequestMapping("/list00")
	public  String main(Model model) throws Exception{
		  String DB_URL = "jdbc:mysql://localhost:3306/fast_db?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
	        String DB_USER = "root";
	        String DB_PASSWORD = "0000";
	        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // 데이터베이스의 연결을 얻는다.
	        Statement stmt  = conn.createStatement(); // Statement를 생성한다.
	        String query = "SELECT cust_no, cust_name, phone, date_format(join_date,'%Y-%m-%d'), cust_email, grade FROM fast_db.member_tbl"; // 시스템의 현재 날짜시간을 출력하는 쿼리(query)
	        ResultSet rs = stmt.executeQuery(query); 
	        
	        List<String> arr= new ArrayList<>();
	        while (rs.next()) {
	        	arr.add(rs.getString(1));
	        	arr.add(rs.getString(2));
	        	arr.add(rs.getString(3));
	        	arr.add(rs.getString(4));
	        	arr.add(rs.getString(5));
	        	arr.add(rs.getString(6));
	            
	        }
	        
	      model.addAttribute("arr", arr);
		return "list00";
		
		
	}
	@RequestMapping("/list01")
	public  String main2(Model model, String number,HttpServletResponse response, HttpServletRequest request) throws Exception{
		  model.addAttribute("number", number);
		  
		  String DB_URL = "jdbc:mysql://localhost:3306/fast_db?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
	        String DB_USER = "root";
	        String DB_PASSWORD = "0000";
	        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // 데이터베이스의 연결을 얻는다.
	        Statement stmt  = conn.createStatement(); // Statement를 생성한다.
	        String query = "SELECT  cust_name, phone, cust_email, grade FROM fast_db.member_tbl "
	        		+ "where cust_no='"+number+"'";
	        ResultSet rs = stmt.executeQuery(query); 
	        
	        List<String> arr= new ArrayList<>();
	        while (rs.next()) {
	        	arr.add(rs.getString(1));
	        	arr.add(rs.getString(2));
	        	arr.add(rs.getString(3));
	        	arr.add(rs.getString(4));
	            
	        }
	        model.addAttribute("arr", arr);
		return "list01";
		
	}
	
	@RequestMapping("/list02")
	   public String main3(String number, String name, String tell,String mail, String grade,
				HttpServletResponse response, HttpServletRequest request, Model model) throws Exception{
	        
	        String DB_URL = "jdbc:mysql://localhost:3306/fast_db?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC/Seoul&useSSL=false";
	        String DB_USER = "root";
	        String DB_PASSWORD = "0000";
	        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // 데이터베이스의 연결을 얻는다.
	        Statement stmt  = conn.createStatement(); 
	        String query = "UPDATE `fast_db`.`member_tbl` SET `cust_name`='"+name+"', "
	      	+ "`phone` = '"+tell+"', "
	      			+ "`cust_email` = '"+mail+"', "
	      					+ "`grade` = '"+grade+"' "
	        		+ "WHERE (`cust_no` = '"+number+"');";
	        
	        stmt.executeUpdate(query);


		return "redirect:/list/list00";
	}
	
//	   public static void main(String[]args) throws Exception{
//	        
//	        String DB_URL = "jdbc:mysql://localhost:3306/fast_db?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
//	        String DB_USER = "root";
//	        String DB_PASSWORD = "0000";
//	        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // 데이터베이스의 연결을 얻는다.
//	        Statement stmt  = conn.createStatement(); 
//	        String number="100006";
//	        		String name="이";
//	        String tell="이";
//	        String mail="이";
//	        String grade="이";
//	        String query = "UPDATE `fast_db`.`member_tbl` SET `cust_name`='"+name+"', "
//	      	+ "`phone` = '"+tell+"', "
//	      			+ "`cust_email` = '"+mail+"', "
//	      					+ "`grade` = '"+grade+"' "
//	        		+ "WHERE (`cust_no` = '"+number+"');";
//	        
//	        stmt.executeUpdate(query);
//	        System.out.println("성공");
//		
//	}
	
}

