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
			 String[] parts = drawingData.split(",");
 
			 Connection conn= DBConnector.getConnection();
	        Statement stmt  = conn.createStatement(); 
	        String checkQuery = "SELECT * FROM `print` WHERE `printing` = '" + parts[1] + "'";
	        ResultSet rs = stmt.executeQuery(checkQuery);
	        if(rs.next()) {
	        	  
	        }else {
	        	HttpSession session= request.getSession();	
	        	String b= String.valueOf(session.getAttribute("user"));
	        	if(b.equals("null")) {
	        		b="guest";
	        	}
	        	String query = "insert into `print` (name, printing, user) values"
	        			+ " ('"+key+"','"+parts[1]+"','"+b+"')"; 
		        stmt.execute(query);
	        }
	        DBConnector.close(stmt,rs,conn);
	  
		}
		
		Connection conn= DBConnector.getConnection();
        Statement stmt  = conn.createStatement();
        String query = "select * from print";
        ResultSet rs = stmt.executeQuery(query);
        List<String> Images = new ArrayList<>();
        List<String> keys = new ArrayList<>();
        List<String> numbers = new ArrayList<>();
        while(rs.next()) {
        	String number=rs.getString(1);
        	String name =rs.getString(2);
        	String user= rs.getString(4);
        	keys.add(name);
        	Images.add(rs.getString(3));
        	numbers.add(number);
        }
        model.addAttribute("names",keys);
        model.addAttribute("prints",Images);
        model.addAttribute("numbers",numbers);
        DBConnector.close(stmt,rs,conn);
		return "board01";
	}
}