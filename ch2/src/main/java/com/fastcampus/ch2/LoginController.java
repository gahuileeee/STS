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
//		1.session 종료
		session.invalidate();
//		2.home으로 이동
		return "redirect:/login/home";
	}
	
	@PostMapping("/login")
	public String login(String id, String pwd, String toURL,
			boolean rememberId,HttpServletResponse response, HttpServletRequest request )throws Exception {
	
//		1. id와 psw확인
		if(!loginCheck(id,pwd)) {
//			2.-1일치하지 않으면, loginForm으로 이동
			String msg=URLEncoder.encode("id또는 pwd가 일치하지 않습니다.", "utf-8");
			return "redirect:/login/login?msg="+msg;
		}
//		2. 일치하면 쿠키 + session 객체에 id를 저장
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
//		2-2. 일치하면 보낸 경로로 이동
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
