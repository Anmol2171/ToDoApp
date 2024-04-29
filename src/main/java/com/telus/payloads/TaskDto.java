package com.telus.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskDto {
	
	private Long id;

	@NotNull
	@NotBlank(message = "Description can't be Empty !!")
	private String description;
	
	private boolean completionStatus;
}
