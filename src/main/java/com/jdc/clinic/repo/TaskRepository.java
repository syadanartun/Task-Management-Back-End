package com.jdc.clinic.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdc.clinic.model.Task;

@Repository

public interface TaskRepository extends JpaRepository<Task, Integer> {

	public List<Task> findByTitle(String title);

}
