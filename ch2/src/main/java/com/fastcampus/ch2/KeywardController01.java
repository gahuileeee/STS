package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/key")
public class KeywardController01 {

	@RequestMapping("/key01")
	public  String main(){
		return "keyward01";
	}
}
