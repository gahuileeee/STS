package com.fastcampus.ch2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

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
			@RequestParam(name = "key", required = false)String key,
			Model model, HttpServletRequest request)throws Exception{
		if(drawingData!=null) {
//			model.addAttribute("drawingData",drawingData);
			 String[] parts = drawingData.split(",");
//			 byte[]imageBytes = Base64.getDecoder().decode(parts[1]);
 
			 Connection conn= DBConnector.getConnection(request.getRemoteAddr(),"keyword","test","1234");
	        Statement stmt  = conn.createStatement(); 
	        String checkQuery = "SELECT * FROM `print` WHERE `printing` = '" + parts[1] + "'";
	        ResultSet resultSet = stmt.executeQuery(checkQuery);
	        if(resultSet.next()) {
	        	  
	        }else {
	        	String query = "insert into `print` (name, printing) values ('"+key+"','"+parts[1]+"')"; 
		        stmt.execute(query);
	        }
	        
	        conn.close();
	  
		}
		
		Connection conn= DBConnector.getConnection(request.getRemoteAddr(),"keyword","test","1234");
        Statement stmt  = conn.createStatement();
        String query = "select * from print";
        ResultSet rs = stmt.executeQuery(query);
        List<String> Images = new ArrayList<>();
        List<String> keys = new ArrayList<>();
        while(rs.next()) {
        	String name =rs.getString(2);
        	keys.add(name);
//        	String base64Image = java.util.Base64.getEncoder().encodeToString(rs.getBytes(2));
        	Images.add(rs.getString(3));
        }
        model.addAttribute("names",keys);
        model.addAttribute("prints",Images);
        conn.close();
		return "board01";
	}
}