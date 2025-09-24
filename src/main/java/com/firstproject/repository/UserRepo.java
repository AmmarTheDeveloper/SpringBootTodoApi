package com.firstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.firstproject.entities.User;
import java.util.List;


@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	public User findById(int id);
		
	public User findByEmail(String email);
	
	public User findByEmailAndPassword(String email, String password);
	
}
