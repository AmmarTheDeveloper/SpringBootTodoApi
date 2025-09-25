package com.firstproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserRegisterDto {
	
	String name;
	String email;
	String password;

}
