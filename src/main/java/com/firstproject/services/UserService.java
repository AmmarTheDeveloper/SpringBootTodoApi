package com.firstproject.services;

import org.springframework.http.ResponseEntity;

import com.firstproject.dto.ResponseDto;
import com.firstproject.dto.UserLoginDto;
import com.firstproject.dto.UserResponseDto;
import com.firstproject.entities.User;

import jakarta.servlet.http.HttpSession;

public interface UserService {
	
	ResponseEntity<UserResponseDto> registerUser(User u);
	
	ResponseEntity<UserResponseDto> loginUser(UserLoginDto u,HttpSession session);
	
	ResponseEntity<ResponseDto> logoutUser(HttpSession session);
	
}
