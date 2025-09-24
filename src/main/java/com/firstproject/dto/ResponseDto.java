package com.firstproject.dto;

import com.firstproject.enums.Status;

public class ResponseDto {
	
	private Status status;
	private String message;
	
	public ResponseDto(Status status,String message) {
		this.status = status;
		this.message = message;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public  String getMessage() {
		return message;
	}
	
	public  void setMessage(String message) {
		this.message = message;
	}
	
	

}
