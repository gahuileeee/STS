package com.fastcampus.ch2;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

// 사용자 정의 exception class
// default 값인 500-> 400으로 변경됨
@ResponseStatus(HttpStatus.BAD_REQUEST)
class MyException extends RuntimeException{
	MyException(String msg){
		super(msg);
	}
	
	MyException() {this(""); }
//	꼭 기본 생성자는 필수로 만들래
}


@Controller
public class ExceptionController2 {

//	MyException 던지도록 바꿈
	@RequestMapping("/ex3")
	public String main() throws Exception{
			throw new MyException("예외가 발생했습니다");
		}
	
	
	@RequestMapping("/ex4")
	public String main2() throws Exception{
			throw new NullPointerException("예외가 발생했습니다");
		}
	
}
