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
@RequestMapping("money")
public class MoneyController00 {
	
//	public static void main (String[] arg) throws Exception{
//		  String DB_URL = "jdbc:mysql://localhost:3306/fast_db?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
//	        String DB_USER = "root";
//	        String DB_PASSWORD = "0000";
//	        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // 데이터베이스의 연결을 얻는다.
//	        Statement stmt  = conn.createStatement(); // Statement를 생성한다.
//	        
//	        String query = "SELECT  distinct cust_no ,  SUM(rent_price) FROM fast_db.rent_tbl GROUP BY cust_no ORDER BY SUM(rent_price) DESC"; 
//	        ResultSet rs = stmt.executeQuery(query); 
//	        
//	        List<String> arr= new ArrayList<>();
//	        while (rs.next()) {
//	        	arr.add(rs.getString(1));
//	        	arr.add(rs.getString(2));
//	        }
//	       int a= arr.size();
//	       List<String> brr= new ArrayList<>();
//	       
//	       for(int i=0; i<a/2; i++) {
//	    	   String aa= arr.get(2*i);
//	    	   brr.add(aa);
//	   	       }
//	       for(int i=0; i<a/2; i++) {
//	    	   String bb= brr.get(i);
//	    	   query="SELECT cust_name, grade FROM fast_db.member_tbl where cust_no = ' "+ bb +" ' ";
//	    	   rs = stmt.executeQuery(query);
//	    	   while(rs.next()) {
//	   	        	int b= arr.indexOf(bb);
//	   	        	arr.add(b+1, rs.getString(1));
//	   	        	arr.add(b+2, rs.getString(2));
//			
//	    	   }
//	       }
//	    	  
//	       
////	       query="SELECT cust_name, grade FROM fast_db.member_tbl where cust_no = ' "+ aa +" ' ";
////    	   rs = stmt.executeQuery(query);
//    	
//	      
//	      }
	
	
	
	@RequestMapping("/money00")
	public  String main(Model model) throws Exception{
		 String DB_URL = "jdbc:mysql://localhost:3306/fast_db?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false";
	        String DB_USER = "root";
	        String DB_PASSWORD = "0000";
	        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // 데이터베이스의 연결을 얻는다.
	        Statement stmt  = conn.createStatement(); // Statement를 생성한다.
	        
	        String query = "SELECT  distinct cust_no ,  SUM(rent_price) FROM fast_db.rent_tbl GROUP BY cust_no ORDER BY SUM(rent_price) DESC"; 
	        ResultSet rs = stmt.executeQuery(query); 
	        
	        List<String> arr= new ArrayList<>();
	        while (rs.next()) {
	        	arr.add(rs.getString(1));
	        	arr.add(rs.getString(2));
	        }
	       int a= arr.size();
	       List<String> brr= new ArrayList<>();
	       
	       for(int i=0; i<a/2; i++) {
	    	   String aa= arr.get(2*i);
	    	   brr.add(aa);
	   	       }
	       for(int i=0; i<a/2; i++) {
	    	   String bb= brr.get(i);
	    	   query="SELECT cust_name, grade FROM fast_db.member_tbl where cust_no = ' "+ bb +" ' ";
	    	   rs = stmt.executeQuery(query);
	    	   while(rs.next()) {
	   	        	int b= arr.indexOf(bb);
	   	        	arr.add(b+1, rs.getString(1));
	   	        	arr.add(b+2, rs.getString(2));
			
	    	   }
	       }
	    	 
	      model.addAttribute("arr", arr);
		
		return "moneylist00";
	}
}