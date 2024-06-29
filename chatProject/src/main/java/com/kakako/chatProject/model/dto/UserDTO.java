package com.kakako.chatProject.model.dto;

import lombok.Data;

@Data
public class UserDTO {

	// pk
	int idx;

	// 이름
	String name;

	// 나이
	String age;

	// 아아디
	String userId;

	// 패스워드
	String password;
	// 이메일
	String email;

	// 전화번호
	String mobile;

}
