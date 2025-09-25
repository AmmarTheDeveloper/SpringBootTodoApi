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
import com.firstproject.dto.UserRegisterDto;
import com.firstproject.dto.UserResponseDto;
import com.firstproject.entities.User;
import com.firstproject.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
@Tag(name = "User Api",description="All user's api")
public class UserController {
	
	@Autowired
	UserService userService;

	
//	@RequestMapping(name="/register",method = RequestMethod.POST)
//	@ResponseBody
	@Operation(summary = "Register Api",description = "Register api description")
	@PostMapping(path = "/register",consumes={"application/json","application/xml"}, produces = { "application/json", "application/xml" })
	public ResponseEntity<UserResponseDto> register(@RequestBody() UserRegisterDto u) {
		return this.userService.registerUser(u);
	}
	
	@PostMapping("/login")
	@Operation(summary = "Login Api",description = "Login api description")
	public ResponseEntity<UserResponseDto> login(@RequestBody() UserLoginDto u,HttpSession session){
		return this.userService.loginUser(u,session);
	}
	
	@PostMapping("/logout")
	@Operation(summary = "Logout Api",description = "Logout api description")
	public ResponseEntity<ResponseDto> logout(HttpSession session){
		return this.userService.logoutUser(session);
	}

}
