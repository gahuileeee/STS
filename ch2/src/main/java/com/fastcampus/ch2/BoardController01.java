package com.fastcampus.ch2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
            	
        }
        
        rs.close();
        stmt.close();
        conn.close();
		return "bulletin01";
	}
}