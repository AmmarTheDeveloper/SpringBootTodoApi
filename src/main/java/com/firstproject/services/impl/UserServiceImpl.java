package com.firstproject.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.firstproject.dto.ResponseDto;
import com.firstproject.dto.UserDto;
import com.firstproject.dto.UserLoginDto;
import com.firstproject.dto.UserResponseDto;
import com.firstproject.entities.User;
import com.firstproject.enums.Status;
import com.firstproject.repository.UserRepo;
import com.firstproject.services.UserService;

import jakarta.servlet.http.HttpSession;


@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	UserRepo userRepo;
	
	
	@Override
	public ResponseEntity<UserResponseDto> loginUser(UserLoginDto u,HttpSession session) {
		
		User user = this.userRepo.findByEmailAndPassword(u.getEmail(),u.getPassword());
		
		if(user == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid email or password");
		
		session.setAttribute("userId", user.getId());
		return ResponseEntity.ok(new UserResponseDto(Status.SUCCESS, "Logged in successfully", user));
	}
	
	@Override
	public ResponseEntity<UserResponseDto> registerUser(User u) {
		
		User existingUser = this.userRepo.findByEmail(u.getEmail());
		
		if(existingUser != null) throw new ResponseStatusException(HttpStatus.CONFLICT,"User already exist");
		
		User user = this.userRepo.save(u);
		
		return ResponseEntity.ok(new UserResponseDto(Status.SUCCESS, "Registered successfully", user));
	}
	
	@Override
	public ResponseEntity<ResponseDto> logoutUser(HttpSession session) {
		session.invalidate();
		return ResponseEntity.ok(new ResponseDto(Status.SUCCESS, "Logged out successfully"));
	}
	
}
