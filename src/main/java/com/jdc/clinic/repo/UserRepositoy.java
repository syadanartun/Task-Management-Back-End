package com.jdc.clinic.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.clinic.model.User;

public interface UserRepositoy extends JpaRepository<User, Integer> {

	public User findByUsername(String username);

}
