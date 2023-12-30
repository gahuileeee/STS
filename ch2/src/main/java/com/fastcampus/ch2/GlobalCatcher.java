package com.fastcampus.ch2;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice("com.fastcampus.ch2") �ش� ��Ű���� ����
@ControllerAdvice //��� ��Ű���� ����
public class GlobalCatcher {
	@ExceptionHandler(NullPointerException.class)
	public String catcher2(Exception ex, Model m) {
//		m.addAttribute("ex",ex);
//		jsp�� isErorrPage ="true"�ָ� model ���ؼ� ���� ���� �ʾƵ�
//		Exception ��ü ���� �� ����.
		return "error";
	}
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model m) {
		m.addAttribute("ex",ex);
		return "error";
	}
}
