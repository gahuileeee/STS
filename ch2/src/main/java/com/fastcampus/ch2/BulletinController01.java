package com.fastcampus.ch2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("bulletin")
public class BulletinController01 {
	
	@RequestMapping("/main01")
	public  String main(@RequestParam(name = "drawingData", required = false)String drawingData,
			@RequestParam(name = "drawingData", required = false)String key,
			Model model, HttpServletRequest request)throws Exception{
		if(drawingData!=null) {
			model.addAttribute("drawingData",drawingData);
			String a = request.getRemoteAddr();
			String DB_URL = "jdbc:mysql://"+a+"/keyward?useUnicode=true&"
					+ "characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
	        String DB_USER = "test";
	        String DB_PASSWORD = "1234";
	        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); 
	        Statement stmt  = conn.createStatement(); 
	        
	        String query = "insert into `print` values ('"+key+"','"+drawingData+"')"; 
	        stmt.execute(query); // query ½ð´Ù.
		}
		
		
		return "board01";
	}
}