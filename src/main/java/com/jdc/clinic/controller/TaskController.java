package com.jdc.clinic.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.clinic.model.Task;
import com.jdc.clinic.service.TaskService;

@RequestMapping("/tasks")
@RestController

@CrossOrigin(origins = "*")
public class TaskController {
	@Autowired
	private TaskService taskService;

	@GetMapping()
	public List<Task> tasks() {
		return taskService.getAll();
	}

	/*
	 * @GetMapping("{/title}") public List<Task> tasksByTitle(@PathVariable("title")
	 * String title) { return taskService.getAllByTitle(title); }
	 */

	@GetMapping("/{id}")
	public Optional<Task> task(@PathVariable("id") Integer id) {
		return taskService.getOneById(id);
	}

	@PostMapping
	public Task save(@RequestBody Task task) {
		return taskService.saveTask(task);
	}

	@PutMapping
	public Task put(@RequestBody Task task) {
		return taskService.updateTask(task);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		taskService.deleteTask(id);

	}

}
