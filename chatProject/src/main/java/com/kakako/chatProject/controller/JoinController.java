package com.kakako.chatProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kakako.chatProject.model.dto.UserDTO;

@Controller
public class JoinController {

	@GetMapping("/joinForm")
	public String joinPage(UserDTO userDTO, Model model) {
		model.addAttribute("userDTO",userDTO);
		System.out.println("회원가입 페이지");
		return "joinForm";
	}
	
	@PostMapping("/join")
	@ResponseBody
	public String join(@ModelAttribute("userDTO") UserDTO userDTO) {
		System.out.println(userDTO);
		System.out.println("회원가입 기능");
		return "개발중";
	}
	
	
}
