package com.fastcampus.ch2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("bulletin")
public class BulletinController01 {
	@RequestMapping("/logout01")
	public String main2(HttpServletResponse response, HttpServletRequest request) {
		HttpSession session= request.getSession();			
		CookieManager.deleteCookie(response, "user" , String.valueOf(session.getAttribute("user")));
		session.invalidate();
		return "redirect:/bulletin/main01";
	}
	
	@RequestMapping("/login01")
	public String main3(HttpServletResponse response, HttpServletRequest request) {
		SessionManager se = new SessionManager();
		se.setSessionAttribute("currentPageUrl","Board");
		return "login01";
	}
	
	
	
	@RequestMapping("/main01")
	public  String main(@RequestParam(name = "drawingData", required = false)String drawingData,
			@RequestParam(name = "key", required = false)String key,
			Model model, HttpServletRequest request)throws Exception{
		if(drawingData!=null) {
//			model.addAttribute("drawingData",drawingData);
			 String[] parts = drawingData.split(",");
//			 byte[]imageBytes = Base64.getDecoder().decode(parts[1]);
 
			 Connection conn= DBConnector.getConnection("localhost:3306","keyword","root","1234");
	        Statement stmt  = conn.createStatement(); 
	        String checkQuery = "SELECT * FROM `print` WHERE `printing` = '" + parts[1] + "'";
	        ResultSet resultSet = stmt.executeQuery(checkQuery);
	        if(resultSet.next()) {
	        	  
	        }else {
	        	HttpSession session= request.getSession();	
	        	String b= String.valueOf(session.getAttribute("user"));
	        	if(b.equals("null")) {
	        		b="guest";
	        	}
	        	String query = "insert into `print` (name, printing, user) values ('"+key+"','"+parts[1]+"','"+b+"')"; 
		        stmt.execute(query);
	        }
	        resultSet.close();
	        stmt.close();
	        conn.close();
	  
		}
		
		Connection conn= DBConnector.getConnection("localhost:3306","keyword","root","1234");
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
        rs.close();
        stmt.close();
        conn.close();
		return "board01";
	}
}