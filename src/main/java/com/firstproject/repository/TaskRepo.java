package com.firstproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firstproject.entities.Task;
import com.firstproject.entities.User;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer > {
	
	public Optional<Task> findById(Integer id);
	
	public List<Task> findAll();
	
	public List<Task> findByUser(User user);
	
	public void deleteById(Integer id);
	
}
