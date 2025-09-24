package com.firstproject.dto;

import java.util.ArrayList;
import java.util.List;

import com.firstproject.entities.Task;
import com.firstproject.enums.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllTaskResponseDto  extends ResponseDto{	
	
	List<TaskDto> tasks = new ArrayList<TaskDto>();
	
	public AllTaskResponseDto(Status status,String message, List<Task> tasks) {
		super(status,message);
		
		tasks.forEach((task) ->{
			this.tasks.add(new TaskDto(task.getId(), task.getTitle(), task.getDescription(), task.getStatus()));
		});
	}
}
