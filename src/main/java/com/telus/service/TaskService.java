package com.telus.service;

import java.util.List;

import com.telus.payloads.TaskDto;

public interface TaskService {
	
	// Create a ToDo
	public TaskDto createNewTask(TaskDto taskDto);
	
	// Retrive All Task
	public List<TaskDto> getAllTask();
	
	// Retrive Single Task by Id
	public TaskDto getTaskById(long taskId);
	
	// Update Task by Id
	public TaskDto updateTaskById(TaskDto taskDto,long taskId);
	
	// Delete Task by Id
	public void deleteTaskById(long taskId);
	

}
