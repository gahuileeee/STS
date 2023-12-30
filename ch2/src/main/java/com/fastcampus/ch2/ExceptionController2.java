package com.fastcampus.ch2;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

// ����� ���� exception class
// default ���� 500-> 400���� �����
@ResponseStatus(HttpStatus.BAD_REQUEST)
class MyException extends RuntimeException{
	MyException(String msg){
		super(msg);
	}
	
	MyException() {this(""); }
//	�� �⺻ �����ڴ� �ʼ��� ���鷡
}


@Controller
public class ExceptionController2 {

//	MyException �������� �ٲ�
	@RequestMapping("/ex3")
	public String main() throws Exception{
			throw new MyException("���ܰ� �߻��߽��ϴ�");
		}
	
	
	@RequestMapping("/ex4")
	public String main2() throws Exception{
			throw new NullPointerException("���ܰ� �߻��߽��ϴ�");
		}
	
}
