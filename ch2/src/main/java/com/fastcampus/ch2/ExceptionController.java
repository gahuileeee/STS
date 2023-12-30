package com.fastcampus.ch2;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionController {

//	예외가 발생하면 catcher method가 받기 때문에 이 method를 catch 블럭이라고 생각하면 됨.
	
	@ExceptionHandler(NullPointerException.class)
	public String catcher2(Exception ex , Model m) {
//		m.addAttribute("ex",ex);
		return "error";
	}

	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String catcher(Exception ex, Model m) {
//		m.addAttribute("ex",ex);
		return "error";
	}
	
	@ExceptionHandler(Exception.class)
	public String catcher3(Exception ex, Model m) {
//		m.addAttribute("ex",ex);
		return "error";
	}
//	/ex 호출하면 예외가 발생해서 catcher라는 method가 예외를 처리해줌.
	
	@RequestMapping("/ex")
	public String main() throws Exception{
			throw new Exception("예외가 발생했습니다");
		}
	
	
	@RequestMapping("/ex2")
	public String main2() throws Exception{
			throw new NullPointerException("예외가 발생했습니다");
		}
	
}
