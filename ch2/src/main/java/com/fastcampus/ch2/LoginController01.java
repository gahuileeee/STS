package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/login")
public class LoginController01 {
		
		@RequestMapping("/login01")
		public  String main(){
			return "login01";
		}
		
		@RequestMapping("/select01")
		public  String main2(){
			return "loginselect01";
		}
}