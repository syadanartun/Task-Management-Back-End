package com.jdc.clinic.service;

import java.util.List;
import java.util.Optional;

import com.jdc.clinic.model.User;

public interface UserService {
	public Optional<User> getOneById(Integer id);

	public List<User> getAll();

	public User saveUser(User user);

	public User updateUser(User user);

	public void deleteUser(Integer id);

	public User getUserByName(String username);

	public User addRoleToUser(String username, String roleName);
}
