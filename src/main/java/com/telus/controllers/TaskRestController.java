package com.telus.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telus.payloads.TaskDto;
import com.telus.service.TaskService;
import com.telus.util.ResponseConstants;

import jakarta.validation.Valid;


@RestController
@RequestMapping(value = "/todos")
public class TaskRestController {

	private static final Logger logger = LoggerFactory.getLogger(TaskRestController.class);

	@Autowired
	private TaskService taskService;

	// POST : create new task
	@PostMapping(value = "/create")
	public ResponseEntity<TaskDto> createNewTask(@Valid @RequestBody TaskDto taskDto)
			throws MethodArgumentNotValidException {
		logger.info("Enter in Create New Task Handler ..");
		TaskDto newTask = this.taskService.createNewTask(taskDto);
		return new ResponseEntity<TaskDto>(newTask, HttpStatus.CREATED);

	}

	// GET: get all task
	@GetMapping(value = "/")
	public ResponseEntity<List<TaskDto>> getAllTask() {
		logger.info("Enter in Get All Task Handler..");
		List<TaskDto> allTask = this.taskService.getAllTask();
		return new ResponseEntity<List<TaskDto>>(allTask, HttpStatus.OK);
	}

	// GET: get task by id
	@GetMapping(value = "/{taskId}")
	public ResponseEntity<TaskDto> getTaskById(@PathVariable long taskId) {
		logger.info("Enter in Get Task By Id Handler..");
		TaskDto taskDto = this.taskService.getTaskById(taskId);
		return new ResponseEntity<TaskDto>(taskDto, HttpStatus.OK);
	}

	// PATCH: update task by id
	@PatchMapping(value = "/{taskId}")
	public ResponseEntity<TaskDto> updateTaskById(@RequestBody TaskDto taskDto, @PathVariable long taskId) {
		logger.info("Enter in Update Task Handler..");
		TaskDto updateTaskById = this.taskService.updateTaskById(taskDto, taskId);
		return new ResponseEntity<TaskDto>(updateTaskById, HttpStatus.OK);
	}

	// DELETE: delete task by id
	@DeleteMapping(value = "/{taskId}")
	public ResponseEntity<String> deleteTask(@PathVariable long taskId) {
		logger.info("Enter into Delete Task Handler..");
		this.taskService.deleteTaskById(taskId);
		return new ResponseEntity<String>(ResponseConstants.TASK_DELETED + taskId, HttpStatus.OK);
	}


}
