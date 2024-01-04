package com.fastcampus.ch2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/key")
public class KeywardController01 {

	@RequestMapping("/key01")
	public  String main(){
		return "keyward01";
	}
	
	@RequestMapping("/create01")
	public String main2() {
	        return "create01";
}

}