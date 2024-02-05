package com.fastcampus.ch2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.NamingException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class SignupController01 {
	
	@PostMapping("/signup01")
    public List<String> login(@RequestBody LoginRequest loginRequest) throws SQLException, NamingException {
		 Connection conn= DBConnector.getConnection();
	        Statement stmt  = conn.createStatement(); 
	        
		List<String> lists = new ArrayList<>();
		if (!isValidEmail(loginRequest.getEmail())) {
			lists.add("�ùٸ� �̸����� �Է����ּ���");
		}else {
		        String query1="Select * from `user` where uid='"+loginRequest.getEmail()+"' ";
		         ResultSet rs= stmt.executeQuery(query1);
		         if(rs.next()) {
		        	 lists.add("�̹� ������� �̸����Դϴ�.");
		        	 DBConnector.close(stmt,rs,conn);
			         return lists;
		         }
		}
		
		if(!loginRequest.getPassword().equals(loginRequest.getConfirmPassword())) {
			lists.add("�Է��� ��й�ȣ�� ��й�ȣ Ȯ�� ���ڰ� ��ġ���� �ʽ��ϴ�.");
		}
		
		if(lists.isEmpty()) {
		        	  String query = "INSERT INTO `user` VALUES ('"+loginRequest.getEmail()+"',"
		        	  		+ "'"+loginRequest.getPassword()+"') ";
				        stmt.executeUpdate(query);
		}
		DBConnector.close(stmt,conn,conn);
        return lists;
    }
	
	@PostMapping("/signin01")
    public List<String> login01(@RequestBody LoginRequest loginRequest) {
		List<String> lists = new ArrayList<>();
		 String p="null";
		try {
			 Connection conn= DBConnector.getConnection();
		        Statement stmt  = conn.createStatement(); 
		        String query = "Select `upassword` from user where uid='"+loginRequest.getEmail()+"' ";
		        ResultSet rs= stmt.executeQuery(query);  
		        while(rs.next()) {
		        	p=rs.getString(1);
		        }	
		        DBConnector.close(stmt,rs,conn);
		}catch(Exception e) {
			e.printStackTrace();
		}
		// mysql�� ��ϵ� ���̵�, ��й�ȣ Ȯ�� (��ϵ� �̸����� �����ϴ�)
		if (p.equals("null")) {
			lists.add("��ϵ� �̸����� �����ϴ�.");
		}else if(!p.equals(loginRequest.getPassword())) {
			lists.add("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
		
	
        return lists;
    }
	
	public static boolean isValidEmail(String email) {
	    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
	                        "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	    Pattern pattern = Pattern.compile(emailRegex);
	    Matcher matcher = pattern.matcher(email);
	    return matcher.matches();
	}

}
