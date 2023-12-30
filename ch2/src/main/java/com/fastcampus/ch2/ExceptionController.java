package com.fastcampus.ch2;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionController {

//	���ܰ� �߻��ϸ� catcher method�� �ޱ� ������ �� method�� catch ���̶�� �����ϸ� ��.
	
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
//	/ex ȣ���ϸ� ���ܰ� �߻��ؼ� catcher��� method�� ���ܸ� ó������.
	
	@RequestMapping("/ex")
	public String main() throws Exception{
			throw new Exception("���ܰ� �߻��߽��ϴ�");
		}
	
	
	@RequestMapping("/ex2")
	public String main2() throws Exception{
			throw new NullPointerException("���ܰ� �߻��߽��ϴ�");
		}
	
}
