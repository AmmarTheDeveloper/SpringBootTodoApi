package com.firstproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TaskDto {
	
	private int id;
	private String title;
	private String description;
	private String status;

}
