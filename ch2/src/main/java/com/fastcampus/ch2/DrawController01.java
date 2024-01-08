package com.fastcampus.ch2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("draw")
public class DrawController01 {
	
	@RequestMapping("/draw01")
	public  String main(@RequestParam(name = "key", required = false)String key, 
			Model model,  HttpServletRequest request) throws Exception{
		if(key!=null) {
			model.addAttribute("key",key);
			String a = request.getRemoteAddr();
			String DB_URL = "jdbc:mysql://"+a+"/keyward?useUnicode=true&"
					+ "characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
	        String DB_USER = "test";
	        String DB_PASSWORD = "1234";
	        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); 
	        Statement stmt  = conn.createStatement();
	        
	        String checkQuery = "SELECT * FROM `keywards` WHERE `name` = '" + key + "'";
	        ResultSet resultSet = stmt.executeQuery(checkQuery);
	        
	        if(resultSet.next()) {
	        	  
	        }else {
	        	 String query = "insert into `keywards` (`name`) values ('"+key+"')"; 
	  	         stmt.execute(query);
	        }
	      
	        
		}else {
			String b = request.getRemoteAddr();
			String DB_URL = "jdbc:mysql://"+b+"/keyward?useUnicode=true&"
					+ "characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
	        String DB_USER = "test";
	        String DB_PASSWORD = "1234";
	        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); 
	        Statement stmt  = conn.createStatement(); 
	      
	        String query = "select count(`seq`) from keywards";
	        ResultSet rs = stmt.executeQuery(query); // query를 실행한 결과를 rs에 담는다
	        int a=0;
	        while(rs.next()) {
	        	 a= Integer.parseInt(rs.getString(1));   
	       }
	    
	        query = "call TEST_PROC(floor(rand()*"+a+")+1)";
	        rs = stmt.executeQuery(query);
	        while(rs.next()) {
	        	 key = rs.getString(2);
	        	 model.addAttribute("key",key);
	        }
	       
	 
		}
		return "drawing01";
	}
	
}