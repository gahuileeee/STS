package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController01 {
	
	@RequestMapping("/home01")
	public  String main(){
		return "index01";
	}
}