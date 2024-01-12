package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController01 {

	@RequestMapping("/res01")
	public String main() {
		return "registerform01";
	}
}
