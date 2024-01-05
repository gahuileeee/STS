package com.fastcampus.ch2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

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
			Model model)throws Exception{
		if(drawingData!=null) {
			model.addAttribute("drawingData",drawingData);
			String DB_URL = "jdbc:mysql://127.0.0.1:3306/keyward?useUnicode=true&"
					+ "characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
	        String DB_USER = "root";
	        String DB_PASSWORD = "1234";
	        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); 
	        Statement stmt  = conn.createStatement(); 
	        
	        String query = "insert into `print` values ('"+key+"','"+drawingData+"')"; 
	        stmt.execute(query); // query ½ð´Ù.
		}
		
		
		return "board01";
	}
}