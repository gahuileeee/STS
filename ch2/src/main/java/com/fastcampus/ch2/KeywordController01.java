package com.fastcampus.ch2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
			HttpServletRequest request, HttpServletResponse response){
		HttpSession session=  request.getSession();
		if(user==null) {
			CookieManager cookie = new CookieManager();
			cookie.addCookie(response, "user", "guest", 60*60);
		}else {
			CookieManager cookie = new CookieManager();
			cookie.addCookie(response, "user" , user, 60*60);	
			SessionManager session2 = new SessionManager();
			session2.setSessionAttribute("user", user);
		}
		Object currentPageUrl = session.getAttribute("currentPageUrl");
		if (currentPageUrl != null) {
		    session.removeAttribute("currentPageUrl");
		    return "redirect:/bulletin/main01";
		}
		return "keyword01";
	}
	
	@RequestMapping("/create01")
	public String main2() {
	        return "create01";
}

}