package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bulletin")
public class BulletinController01 {
	
	@RequestMapping("/main01")
	public  String main(){
		return "board01";
	}
}