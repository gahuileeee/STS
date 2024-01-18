package com.fastcampus.ch2;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller

public class SignupController01 {
	   @PostMapping(value = "/signup", produces = "application/json;charset=UTF-8")
	    @ResponseBody
	    public ResponseEntity <Map<String, Object>> validateSignup(@RequestBody Map<String, Object> validationResult) {
	        // �������� �߰����� ��ȿ�� �˻縦 �����ϰ� ����� ��ȯ
	        // �� ����� Ŭ���̾�Ʈ�� �����Ͽ� �߰����� ���� �޽����� ǥ���� �� �ֵ��� ��
	        // ����: ��й�ȣ�� Ư������, ����, ��ҹ��ڸ� ���� �ϳ� �̻� �����ؾ� ��
	        // ...

	        // ������ ��ȿ�� �˻� ��� ����
	        boolean serverValidationPassed = true;
	        if (!serverValidationPassed) {
	            // ���� ��ȿ�� �˻� ���� �� ���� �޽��� ��ȯ
	            validationResult.put("isValid", false);
	            List<String> serverErrors = List.of("���������� ��ȿ�� �˻� ���� �޽��� 1", "���������� ��ȿ�� �˻� ���� �޽��� 2");
	            validationResult.put("errors", serverErrors);
	        } else {
	            // ���� ��ȿ�� �˻� ��� �� isValid�� ����
	            validationResult.put("isValid", true);
	        }
	        
	        return (ResponseEntity<Map<String, Object>>) validationResult;
	    }
}
