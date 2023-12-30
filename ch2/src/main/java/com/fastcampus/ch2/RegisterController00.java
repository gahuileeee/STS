package com.fastcampus.ch2;

import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController00 {

	@RequestMapping("/res00")
	public String register(Model model) throws Exception{
		String DB_URL = "jdbc:mysql://localhost:3306/fast_db?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
        String DB_USER = "root";
        String DB_PASSWORD = "0000";

        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // 데이터베이스의 연결을 얻는다.
        Statement stmt  = conn.createStatement(); // Statement를 생성한다.

        String query = "SELECT max(cust_no) FROM fast_db.member_tbl;"; 
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()) {
        	   int num =rs.getInt(1)+1;
        	   model.addAttribute("num",num);
        }
        
        return "register00";
	}


   @PostMapping("/resp00")
   public String pp00(String number, String name, String tell,String mail, String grade,
			HttpServletResponse response, HttpServletRequest request, Model model) throws Exception{
	   
	   String DB_URL = "jdbc:mysql://localhost:3306/fast_db?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
       String DB_USER = "root";
       String DB_PASSWORD = "0000";
       Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // 데이터베이스의 연결을 얻는다.
       Statement stmt  = conn.createStatement();
       String a="SELECT now()";
       ResultSet rs = stmt.executeQuery(a);
       Date b = null;
       while(rs.next()) {
    	   b=rs.getDate(1);
       }
//       유효성 검사
//       JSONObject obj = new JSONObject();
//       obj.put("name", name);
//       obj.put("tell", tell);
//       obj.put("mail", mail);
//       obj.put("grade", grade);
////       NullCheck
//       if(obj.isNull("name")) {
//    	   String msg=URLEncoder.encode("이름을 입력해주세요", "utf-8");
//			return "redirect:/register/res00?msg="+msg;
//       }
       
       String query = "INSERT INTO `fast_db`.`member_tbl` (`cust_no`, `cust_name`, `phone`, `join_date`, `cust_email`, `grade`) VALUES "
       		+ "('"+ number+ "', '"+name+"', '"+tell+"', '"+b+"', '"+mail+"', '"+grade+"')";
       
       stmt.execute(query);
	   return "redirect:/register/res00";
	   }
}
