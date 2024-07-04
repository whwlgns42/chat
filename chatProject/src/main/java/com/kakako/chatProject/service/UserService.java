package com.kakako.chatProject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakako.chatProject.mapper.Appconfig;
import com.kakako.chatProject.model.dto.UserDTO;
import com.kakako.chatProject.model.entity.UserEntity;
import com.kakako.chatProject.repository.IUserRepository;

@Service
public class UserService {
	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private Appconfig appconfig;

	// 회원저장
	public UserEntity registerUser(UserDTO userDTO) {
		System.out.println(" [로그 확인 회원유저 저장 sercivce] : " + userDTO);
		UserEntity userEntity = appconfig.modelMapper().map(userDTO, UserEntity.class);
		System.out.println(" [로그 확인 ] : " + userEntity);
		return userRepository.save(userEntity);
	}

	public Optional<UserEntity> getUserByUserId(UserDTO userDTO) {
//    	System.out.println( " [로그 확인 getUserByUserId] : " + userRepository.findByUserId(userId));
		return userRepository.findByUserId(userDTO.getUserId());
	}

	public UserEntity login(UserDTO userDTO) {
		Optional<UserEntity> optionalUser = userRepository.findByUserId(userDTO.getUserId());
		if (optionalUser.isPresent() && optionalUser.get().getPassword().equals(userDTO.getPassword())) {
			return optionalUser.get();
		} else {
			throw new IllegalArgumentException("Invalid username or password");
		}
	}
}