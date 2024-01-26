package com.fastcampus.ch2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController01 {
	
	@RequestMapping("/bulletin01")
	public  String main(@RequestParam(name = "number")String number, Model model) throws SQLException{
		Connection conn= DBConnector.getConnection("localhost:3306","keyword","root","1234");
        Statement stmt  = conn.createStatement();
        String query = "Select * from print where number='"+number+"'";
        ResultSet rs = stmt.executeQuery(query);
        if(rs.next()) {
        	model.addAttribute("number",rs.getString(1));
            model.addAttribute("name",rs.getString(2));
            model.addAttribute("print",rs.getString(3));
            model.addAttribute("user",rs.getString(4));
        	model.addAttribute("like",rs.getString(5));
        }
        
        rs.close();
        stmt.close();
        conn.close();
		return "bulletin01";
	}
	
	public class Like{
		private String number;
		private String like;
		public Like() {
			
		}
		public Like(String number, String like) {
			this.number=number;
			this.like=like;
		}
	}
	
	@PostMapping("/bulletin02")
	public  List<String>  method1(@RequestBody Map<String, String> paramMap,
			//@RequestParam(name = "number")String number,
			//@RequestParam(name = "like")String like ,
			Model model) throws SQLException{
		List<String> lists = new ArrayList<>();
		try {
			System.out.println("¿¬°á");
			System.out.println(paramMap.get("number"));
			 Connection conn= DBConnector.getConnection("localhost:3306","keyword","root","1234");
		       Statement stmt  = conn.createStatement();
		       int a=Integer.parseInt(paramMap.get("like"))+1; 
		       stmt.executeUpdate("Update print set `like`="+a+" where number="+paramMap.get("number"));
		       String query = "Select * from print where number='"+paramMap.get("number")+"'";
		       ResultSet rs = stmt.executeQuery(query);
		       if(rs.next()) {
		       	model.addAttribute("number",rs.getString(1));
		       }
		       rs.close();
		       stmt.close();
		       conn.close();	
		}catch(Exception e) {
			e.printStackTrace();
		}
		lists.add("true");
		       return lists;
	}	
	

}