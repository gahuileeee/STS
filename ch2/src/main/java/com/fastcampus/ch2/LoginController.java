package com.fastcampus.ch2;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
//		1.session ����
		session.invalidate();
//		2.home���� �̵�
		return "redirect:/login/home";
	}
	
	@PostMapping("/login")
	public String login(String id, String pwd, String toURL,
			boolean rememberId,HttpServletResponse response, HttpServletRequest request )throws Exception {
	
//		1. id�� pswȮ��
		if(!loginCheck(id,pwd)) {
//			2.-1��ġ���� ������, loginForm���� �̵�
			String msg=URLEncoder.encode("id�Ǵ� pwd�� ��ġ���� �ʽ��ϴ�.", "utf-8");
			return "redirect:/login/login?msg="+msg;
		}
//		2. ��ġ�ϸ� ��Ű + session ��ü�� id�� ����
		HttpSession session =request.getSession();
		session.setAttribute("id", id);
		if(rememberId) {
			Cookie cookie = new Cookie("id",id);
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
			}else {
				Cookie cookie = new Cookie("id",id);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
//		2-2. ��ġ�ϸ� ���� ��η� �̵�
		toURL= toURL==null || toURL.equals("") ?  "index" :toURL;
		return "redirect:"+toURL;
		
	}
	@GetMapping("/home")
	public String home(){
		return "index";
	}
	private boolean loginCheck(String id, String pwd) {
		return "asdf".equals(id)&&"1234".equals(pwd);
	}
}
