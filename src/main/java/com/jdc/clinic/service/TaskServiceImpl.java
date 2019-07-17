package com.jdc.clinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.clinic.model.Task;
import com.jdc.clinic.repo.TaskRepository;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public Task getOneById(Integer id) {
		return taskRepository.getOne(id);
	}

	@Override
	public List<Task> getAll() {
		return taskRepository.findAll();
	}

	@Override
	public List<Task> getAllByTitle(String title) {
		return taskRepository.findByTitle(title);
	}

	@Override
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public Task updateTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public void deleteTask(Integer id) {
		Task task = this.getOneById(id);
		taskRepository.delete(task);

	}

}
