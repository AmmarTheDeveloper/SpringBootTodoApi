package com.firstproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstproject.dto.AllTaskResponseDto;
import com.firstproject.dto.TaskRequestDto;
import com.firstproject.dto.TaskResponseDto;
import com.firstproject.services.TaskService;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@GetMapping("")
	public ResponseEntity<AllTaskResponseDto> getTasks(HttpSession session){
		return this.taskService.getTasks(session);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<TaskResponseDto> getTask(@PathVariable("id") Integer taskId,HttpSession session){
		return this.taskService.getTask(taskId,session);
	}
	
	@PostMapping("")
	public ResponseEntity<TaskResponseDto> addTask(@RequestBody TaskRequestDto task,HttpSession session){
		return this.taskService.addTask(task, session);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<TaskResponseDto> updateTask(@PathVariable("id") Integer id, @RequestBody TaskRequestDto task, HttpSession session){
		return this.taskService.updateTask(id, task, session);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<TaskResponseDto> deleteTask(@PathVariable("id") int id, HttpSession session){
		return this.taskService.deleteTask(id, session);
	}

}
