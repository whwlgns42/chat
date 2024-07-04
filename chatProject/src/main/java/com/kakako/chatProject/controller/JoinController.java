package com.kakako.chatProject.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kakako.chatProject.model.dto.UserDTO;
import com.kakako.chatProject.model.entity.UserEntity;
import com.kakako.chatProject.service.UserService;

@Controller
public class JoinController {
	
	
	@Autowired
	private UserService userService;

	@GetMapping("/joinForm")
	public String joinPage(UserDTO userDTO, Model model) {
		model.addAttribute("userDTO",userDTO);
		System.out.println("회원가입 페이지");
		return "joinForm";
	}
	
	@PostMapping("/join")
	@ResponseBody
	public String join(@RequestBody UserDTO userDTO ) {
	System.out.println( " [로그 확인 ] : " + userDTO);
		UserEntity userData =  userService.getUserByUserId(userDTO.getUserId());
		System.out.println( " [로그 확인 ] : " + userData);
		if(userData != null) {
			System.out.println( " [로그 확인 ] : " + userData);
			return userData.getUserId();
		}
		userService.registerUser(userDTO);
		System.out.println(userDTO);
		System.out.println("회원가입 기능");
		return null;
	}
	
	
	
	

	
}
