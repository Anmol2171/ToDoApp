package com.telus.mapper;

import com.telus.models.Task;
import com.telus.payloads.TaskDto;

public class TaskMapper {

	public static Task dtoToTask(TaskDto taskDto) {
		Task task=new Task();
		task.setId(taskDto.getId());
		task.setDescription(taskDto.getDescription());
		task.setComletionStatus(taskDto.isCompletionStatus());
		return task;
	}
	
	public static TaskDto taskToDto(Task task) {
		TaskDto taskDto=new TaskDto();
		taskDto.setId(task.getId());
		taskDto.setDescription(task.getDescription());
		taskDto.setCompletionStatus(task.isComletionStatus());
		return taskDto;
	}
	
}
