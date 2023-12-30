package com.fastcampus.ch2;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice("com.fastcampus.ch2") 해당 패키지에 적용
@ControllerAdvice //모든 패키지에 적용
public class GlobalCatcher {
	@ExceptionHandler(NullPointerException.class)
	public String catcher2(Exception ex, Model m) {
//		m.addAttribute("ex",ex);
//		jsp에 isErorrPage ="true"주면 model 통해서 전달 받지 않아도
//		Exception 객체 얻을 수 있음.
		return "error";
	}
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model m) {
		m.addAttribute("ex",ex);
		return "error";
	}
}
