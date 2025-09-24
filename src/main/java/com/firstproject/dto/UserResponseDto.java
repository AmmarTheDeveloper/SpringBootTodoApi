package com.firstproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.firstproject.entities.User;
import com.firstproject.enums.Status;

//it will be applied to this dto only if wnt it globally configure in application.properties
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseDto extends ResponseDto {
	
	private UserDto user;
	
	public UserResponseDto(Status status,String message, User user) {
			super(status,message);
			this.user = user == null? null :  new UserDto(user.getId(), user.getName(), user.getEmail());
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}
	
}
