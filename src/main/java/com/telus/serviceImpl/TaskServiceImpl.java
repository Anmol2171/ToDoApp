package com.telus.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telus.exceptions.TaskNotFoundException;
import com.telus.mapper.TaskMapper;
import com.telus.models.Task;
import com.telus.payloads.TaskDto;
import com.telus.repositories.TaskRepo;
import com.telus.service.TaskService;
import com.telus.util.ResponseConstants;

@Service
public class TaskServiceImpl implements TaskService {

	private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

	@Autowired
	private TaskRepo taskRepo;

	
	// Create New Task
	@Override
	public TaskDto createNewTask(TaskDto taskDto) {
		logger.info("Enter in createNewTask Method..");
		Task task = TaskMapper.dtoToTask(taskDto);
		Task savedTask = this.taskRepo.save(task);
		TaskDto taskToDto = TaskMapper.taskToDto(savedTask);
		return taskToDto;
	}

	// Get All Task
	@Override
	public List<TaskDto> getAllTask() {
		logger.info("Enter in getAllTask Method ..");
		List<Task> allTask = this.taskRepo.findAll();
		List<TaskDto> taskDtoList = allTask.stream().map((task) -> TaskMapper.taskToDto(task))
				.collect(Collectors.toList());
		return taskDtoList;
	}

	// Get Task By Id
	@Override
	public TaskDto getTaskById(long taskId) {
		logger.info("Enter in getTaskById Method..");
		Task task = this.taskRepo.findById(taskId)
				.orElseThrow(() -> new TaskNotFoundException(ResponseConstants.TASK_NOT_FOUND + taskId));
		return TaskMapper.taskToDto(task);
	}

	// Update Task By Id
	@Override
	public TaskDto updateTaskById(TaskDto taskDto, long taskId) {
		logger.info("Enter in updateTaskById Method..");
		Task task = this.taskRepo.findById(taskId)
				.orElseThrow(() -> new TaskNotFoundException(ResponseConstants.TASK_NOT_FOUND + taskId));
		task.setDescription(taskDto.getDescription());
		task.setComletionStatus(taskDto.isCompletionStatus());
		Task updatedTask = this.taskRepo.save(task);
		return TaskMapper.taskToDto(updatedTask);
	}

	// Delete Task By Their Id
	@Override
	public void deleteTaskById(long taskId) {
		logger.info("Enter in deleteTaskById Method..");
		Task task = this.taskRepo.findById(taskId)
				.orElseThrow(() -> new TaskNotFoundException(ResponseConstants.TASK_NOT_FOUND + taskId));
		this.taskRepo.delete(task);
	}

}
