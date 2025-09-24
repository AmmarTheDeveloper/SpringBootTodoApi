package com.firstproject.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.firstproject.dto.AllTaskResponseDto;
import com.firstproject.dto.TaskRequestDto;
import com.firstproject.dto.TaskResponseDto;
import com.firstproject.entities.Task;
import com.firstproject.entities.User;
import com.firstproject.enums.Status;
import com.firstproject.repository.TaskRepo;
import com.firstproject.repository.UserRepo;
import com.firstproject.services.TaskService;

import jakarta.servlet.http.HttpSession;


@Service
public class TaskServiceImpl implements TaskService{
	
	
	@Autowired
	TaskRepo taskRepo;
	
	@Autowired
	UserRepo userRepo;
	
	public void validateTaskOwnership(Task existingTask, int userId) {
		if(existingTask == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Task not found");	
		if(existingTask.getUser().getId() != userId) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Unauthorized access");
	}

	@Override
	public ResponseEntity<TaskResponseDto> getTask(int taskId,HttpSession session) {
		
		Integer userId = (Integer) session.getAttribute("userId");
			
		Task task = taskRepo.findById(taskId).orElse(null);
		
		//if task doesn't exist or user is not owner then it will throw exception
		validateTaskOwnership(task,userId);
		
		return ResponseEntity.ok(new TaskResponseDto(Status.SUCCESS, "Task found successfully", task));
	}

	@Override
	public ResponseEntity<AllTaskResponseDto> getTasks(HttpSession session) {
		
		Integer userId = (Integer) session.getAttribute("userId");
		
		User user = userRepo.findById(userId).orElse(null);
		
		List<Task> tasks = taskRepo.findByUser(user);
		
		return ResponseEntity.ok(new AllTaskResponseDto(Status.SUCCESS, "All tasks found", tasks));
	}

	@Override
	public ResponseEntity<TaskResponseDto> addTask(TaskRequestDto task,HttpSession session) {
		
		Integer userId = (Integer) session.getAttribute("userId");
		User user = userRepo.findById(userId).orElse(null);
		
		Task task2 = new Task();
		task2.setTitle(task.getTitle());
		task2.setDescription(task.getDescription());
		task2.setStatus(task.getStatus());
		task2.setUser(user);
		
		Task insertedTask = taskRepo.save(task2);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(new TaskResponseDto(Status.SUCCESS, "Task inserted successfully", insertedTask));
	}

	@Override
	public ResponseEntity<TaskResponseDto> updateTask(int taskId,TaskRequestDto task,HttpSession session) {

		Integer userId = (Integer) session.getAttribute("userId");
		Task existingTask = taskRepo.findById(taskId).orElse(null);
		
		//if task doesn't exist or user is not owner then it will throw exception
		validateTaskOwnership(existingTask,userId);
		
		
		if(task.getTitle() != null && !task.getTitle().isEmpty()) {
			existingTask.setTitle(task.getTitle());
		}
		
		if(task.getDescription() != null && !task.getDescription().isEmpty()) {
			existingTask.setDescription(task.getDescription());
		}
		
		if(task.getStatus() != null && !task.getStatus().isEmpty()) {
			existingTask.setStatus(task.getStatus());
		}
		
		Task updatedTask = taskRepo.save(existingTask);
		
		return ResponseEntity.ok(new TaskResponseDto(Status.SUCCESS, "Task updated successfully", updatedTask));
	}

	@Override
	public ResponseEntity<TaskResponseDto> deleteTask(int taskId,HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		
		Task existingTask = taskRepo.findById(taskId).orElse(null);

		//if task doesn't exist or user is not owner then it will throw exception
		validateTaskOwnership(existingTask,userId);
		
		taskRepo.deleteById(taskId);
		
		return ResponseEntity.ok(new TaskResponseDto(Status.SUCCESS, "Task deleted successfully", null));
	}

}
