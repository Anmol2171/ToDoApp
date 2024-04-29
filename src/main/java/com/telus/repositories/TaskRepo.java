package com.telus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telus.models.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {

	
}
