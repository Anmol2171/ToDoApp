package com.telus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.telus.mapper.TaskMapper;
import com.telus.models.Task;
import com.telus.payloads.TaskDto;
import com.telus.repositories.TaskRepo;

@SpringBootTest
class ToDoAppApplicationTests {

	@Autowired
	private TaskRepo taskRepo;

//	@Test
//	void contextLoads() {
//	}

	
	// Create Task
	@Test
	public void createTask() {
		TaskDto dto = new TaskDto();
		dto.setId(32l);
		dto.setDescription("My task is Completed with testing..");
		dto.setCompletionStatus(false);
		Task task = TaskMapper.dtoToTask(dto);
		taskRepo.save(task);
		assertNotNull(taskRepo.findById(30l).get());
	}

	// Get All Task 
	@Test
	public void getAllTask() {
		List<Task> list = taskRepo.findAll();
//		list.forEach(t-> System.out.println(t));
		assertThat(list).size().isGreaterThan(0);
	}

	
	// Get Task By Id
	@Test
	public void getTaskByTheirId() {
		Task task = taskRepo.findById(30l).get();
		assertEquals("My task is completed", task.getDescription());
	}

	// Delete Task By Id
	@Test
	public void deleteTask() {
		taskRepo.deleteById(6l);
		assertThat(taskRepo.existsById(6l)).isFalse();
	}

}
