package com.fastcampus.ch2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("draw")
public class DrawController01 {
	
	@RequestMapping("/draw01")
	public  String main(String key, Model model) throws Exception{
		if(key!=null) {
			model.addAttribute("key",key);
			String DB_URL = "jdbc:mysql://127.0.0.1:3306/keyward?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
	        String DB_USER = "root";
	        String DB_PASSWORD = "0000";
	        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); 
	        Statement stmt  = conn.createStatement(); 
//	        String query = "SELECT now()"; // �ý����� ���� ��¥�ð��� ����ϴ� ����(query)
	        String query = "insert into `key` values ('"+key+"')"; 
	        ResultSet rs = stmt.executeQuery(query); // query�� ������ ����� rs�� ��´�

		}
		return "drawing01";
	}
	
}