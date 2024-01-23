package com.fastcampus.ch2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/login")
public class LoginController01 {
		
		@RequestMapping("/login01")
		public  String main(HttpServletRequest request){
			HttpSession session=  request.getSession();
			System.out.println(session.getAttribute("currentPageUrl"));
			return "login01";
		}
		@RequestMapping("/logout01")
		public  String main1(HttpServletResponse response, HttpServletRequest request){
			HttpSession session= request.getSession();			
			CookieManager.deleteCookie(response, "user" , String.valueOf(session.getAttribute("user")));
			session.invalidate();
			return "redirect:/login/select01";
		}
		
		@RequestMapping("/select01")
		public  String main2(){
			return "loginselect01";
		}
}