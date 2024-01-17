package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

class User2{
	private String name;
	private int age;
	private String nation;
	public User2(String name, int age, String nation) {
		this.name = name;
		this.age = age;
		this.nation = nation;
	}
	
}

@Controller
public class JSONtest {
	@RequestMapping(value = "/json", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public User2 main01(Model model) {
		User2 user = new User2("¡¶¿ÃΩº",3,"«—±π");
		return user;
	}

}
