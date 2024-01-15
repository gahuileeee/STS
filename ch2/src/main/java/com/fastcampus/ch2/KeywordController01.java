package com.fastcampus.ch2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		if(user==null) {
			CookieManager cookie = new CookieManager();
			cookie.addCookie(response, "userInfo", "guest", 60*60);
		}else {

			CookieManager cookie = new CookieManager();
			cookie.addCookie(response, "userInfo" , user, 60*60);	
		}
		return "keyword01";
	}
	
	@RequestMapping("/create01")
	public String main2() {
	        return "create01";
}

}