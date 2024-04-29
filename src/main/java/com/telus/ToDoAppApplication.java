package com.telus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author anmol.tomar
 * @version 0.01
 *
 */

@SpringBootApplication
public class ToDoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoAppApplication.class, args);
		System.out.println("Application Running Successfully !!");
		
	}

}
