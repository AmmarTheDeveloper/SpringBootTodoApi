package com.firstproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.firstproject.entities.Task;
import com.firstproject.enums.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskResponseDto extends ResponseDto{
	
	TaskDto task;
	
	public TaskResponseDto(Status status,String message, Task task) {
		super(status,message);
		this.task = task == null? null : new TaskDto(task.getId(), task.getTitle(), task.getDescription(), task.getStatus());
	}

}
