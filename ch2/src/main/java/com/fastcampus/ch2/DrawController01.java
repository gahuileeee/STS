package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("draw")
public class DrawController01 {
	
	@RequestMapping("/draw01")
	public  String main(){
		return "drawing01";
	}
}