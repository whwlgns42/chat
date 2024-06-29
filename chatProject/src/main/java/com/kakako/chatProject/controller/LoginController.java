package com.kakako.chatProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	
	@GetMapping("/loginForm")
	public String loginPage() {
		System.out.println("로그인 페이지");
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String login() {
		System.out.println("로그인 기능");
		
		return null;
	}
	
	
	
	
	
}
