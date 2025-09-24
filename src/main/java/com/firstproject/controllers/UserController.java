package com.firstproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.firstproject.dto.ResponseDto;
import com.firstproject.dto.UserLoginDto;
import com.firstproject.dto.UserResponseDto;
import com.firstproject.entities.User;
import com.firstproject.services.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
//	@RequestMapping(name = "",method = RequestMethod.GET)
//	@ResponseBody
	@GetMapping("")
	public String getUser() {
		System.out.println("working");
		return "working";
	}
	
//	@RequestMapping(name="/register",method = RequestMethod.POST)
//	@ResponseBody
	@PostMapping("/register")
	public ResponseEntity<UserResponseDto> register(@RequestBody() User u) {
		return this.userService.registerUser(u);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserResponseDto> login(@RequestBody() UserLoginDto u,HttpSession session){
		return this.userService.loginUser(u,session);
	}
	
	@PostMapping("/logout")
	public ResponseEntity<ResponseDto> logout(HttpSession session){
		return this.userService.logoutUser(session);
	}

}
