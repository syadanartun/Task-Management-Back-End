package com.jdc.clinic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jdc.clinic.model.Task;
import com.jdc.clinic.service.TaskService;

@SpringBootApplication
public class AngularExApplication implements CommandLineRunner {
	@Autowired
	TaskService taskService;

	public static void main(String[] args) {
		SpringApplication.run(AngularExApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 1; i <= 5; i++) {
			taskService.saveTask(new Task("title " + i, "decision " + i));

		}

	}

}
