package com.edu.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/home")
	public String home(){
		return "spring security home";
	}
	
	@GetMapping("/admin")
	public String admin(){
		return "spring security admin";
	}
}
