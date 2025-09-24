package com.firstproject.services;

import org.springframework.http.ResponseEntity;

import com.firstproject.dto.AllTaskResponseDto;
import com.firstproject.dto.TaskRequestDto;
import com.firstproject.dto.TaskResponseDto;

import jakarta.servlet.http.HttpSession;

public interface TaskService {

	public ResponseEntity<TaskResponseDto> getTask(int taskId,HttpSession session);
	
	public ResponseEntity<AllTaskResponseDto> getTasks(HttpSession session);
	
	public ResponseEntity<TaskResponseDto> addTask(TaskRequestDto task,HttpSession session);
	
	public ResponseEntity<TaskResponseDto> updateTask(int taskId, TaskRequestDto task,HttpSession session);
	
	public ResponseEntity<TaskResponseDto> deleteTask(int taskId, HttpSession session);

}
