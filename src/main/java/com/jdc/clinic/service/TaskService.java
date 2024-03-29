package com.jdc.clinic.service;

import java.util.List;
import java.util.Optional;

import com.jdc.clinic.model.Task;

public interface TaskService {

	public Optional<Task> getOneById(Integer id);

	public List<Task> getAll();

	public List<Task> getAllByTitle(String title);

	public Task saveTask(Task task);

	public Task updateTask(Task task);

	public void deleteTask(Integer id);

}
