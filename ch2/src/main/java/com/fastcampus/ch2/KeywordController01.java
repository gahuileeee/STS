package com.fastcampus.ch2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/key")
public class KeywordController01 {

	@RequestMapping("/key01")
	public  String main(Model model, @RequestParam(name = "user", required = false)String user,
			HttpServletRequest request){
		if(user.equals("null")) {
			user="guest";
		}
		HttpSession session =request.getSession();
		session.setMaxInactiveInterval(60*60);
		session.setAttribute("user", user);
		return "keyword01";
	}
	
	@RequestMapping("/create01")
	public String main2() {
	        return "create01";
}

}