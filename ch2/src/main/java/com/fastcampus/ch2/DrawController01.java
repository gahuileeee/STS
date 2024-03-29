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
			Connection conn= DBConnector.getConnection();
	        Statement stmt  = conn.createStatement();
	        
	        String checkQuery = "SELECT * FROM `keywords` WHERE `name` = '" + key + "'";
	        ResultSet rs = stmt.executeQuery(checkQuery);
	        if(rs.next()) {
	        	  
	        }else {
	        	 String query = "insert into `keywords` (`name`) values ('"+key+"')"; 
	  	         stmt.execute(query);
	        }
	        DBConnector.close(stmt,rs,conn);
	        
		}else {
			Connection conn= DBConnector.getConnection();
	        Statement stmt  = conn.createStatement(); 
	        String query = "select `name` from keywords order by rand() limit 1";
	        ResultSet rs = stmt.executeQuery(query); 
	        while(rs.next()) {
	        	 key = rs.getString(1);
	        	 model.addAttribute("key",key);
	        }
	        DBConnector.close(stmt,rs,conn);
		}
		return "drawing01";
	}
	
}