package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController00 {
	
	@RequestMapping("/home")
	public  String main(){
		return "index00";
	}
}