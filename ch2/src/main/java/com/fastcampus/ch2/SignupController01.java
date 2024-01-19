package com.fastcampus.ch2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller

public class SignupController01 {
	   @PostMapping(value = "signup", produces = "application/json;charset=UTF-8")
	    @ResponseBody
	    public ResponseEntity <Map<String, String>> singup(@RequestBody Map<String, String> user) throws SQLException {
	        // 서버에서 추가적인 유효성 검사를 수행하고 결과를 반환
	        // 이 결과를 클라이언트에 전송하여 추가적인 오류 메시지를 표시할 수 있도록 함
	        // 예시: 비밀번호는 특수문자, 숫자, 대소문자를 각각 하나 이상 포함해야 함
	        // ...

	        // 가상의 유효성 검사 결과 생성
			Connection conn= DBConnector.getConnection("localhost:3306","keyword","root","1234");
	        Statement stmt  = conn.createStatement();
	        String query = "insert into values ";
	        
		 user.put("error", "제대로해");
		
//	       	 boolean serverValidationPassed =false;
//	       
//	        if (!serverValidationPassed) {
//	            // 서버 유효성 검사 실패 시 오류 메시지 반환
//	            validationResult.put("isValid", false);
//	            List<String> serverErrors = List.of("서버에서의 유효성 검사 오류 메시지 1", "서버에서의 유효성 검사 오류 메시지 2");
//	            validationResult.put("errors", serverErrors);
//	        } else {
//	            // 서버 유효성 검사 통과 시 isValid만 설정
//	            validationResult.put("isValid", true);
//	        }
	        
	        return (ResponseEntity<Map<String, String>>) user;
	    }
}
