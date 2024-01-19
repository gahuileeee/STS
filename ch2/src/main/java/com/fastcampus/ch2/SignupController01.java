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
	        // �������� �߰����� ��ȿ�� �˻縦 �����ϰ� ����� ��ȯ
	        // �� ����� Ŭ���̾�Ʈ�� �����Ͽ� �߰����� ���� �޽����� ǥ���� �� �ֵ��� ��
	        // ����: ��й�ȣ�� Ư������, ����, ��ҹ��ڸ� ���� �ϳ� �̻� �����ؾ� ��
	        // ...

	        // ������ ��ȿ�� �˻� ��� ����
			Connection conn= DBConnector.getConnection("localhost:3306","keyword","root","1234");
	        Statement stmt  = conn.createStatement();
	        String query = "insert into values ";
	        
		 user.put("error", "�������");
		
//	       	 boolean serverValidationPassed =false;
//	       
//	        if (!serverValidationPassed) {
//	            // ���� ��ȿ�� �˻� ���� �� ���� �޽��� ��ȯ
//	            validationResult.put("isValid", false);
//	            List<String> serverErrors = List.of("���������� ��ȿ�� �˻� ���� �޽��� 1", "���������� ��ȿ�� �˻� ���� �޽��� 2");
//	            validationResult.put("errors", serverErrors);
//	        } else {
//	            // ���� ��ȿ�� �˻� ��� �� isValid�� ����
//	            validationResult.put("isValid", true);
//	        }
	        
	        return (ResponseEntity<Map<String, String>>) user;
	    }
}
