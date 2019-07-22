package com.jdc.clinic.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.clinic.model.Role;
import com.jdc.clinic.model.User;
import com.jdc.clinic.repo.UserRepositoy;
import com.jdc.clinic.service.RoleService;
import com.jdc.clinic.service.UserService;

@Service
@Transactional
class UserServiceImpl implements UserService {

	@Autowired
	private UserRepositoy userRepositoy;

	@Autowired
	private RoleService roleService;

	@Override
	public Optional<User> getOneById(Integer id) {

		Optional<User> user = userRepositoy.findById(id);
		if (user == null)
			throw new RuntimeException("Role not found");
		return user;
	}

	@Override
	public List<User> getAll() {
		return userRepositoy.findAll();
	}

	@Override
	public User saveUser(User user) {
		return userRepositoy.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepositoy.save(user);
	}

	@Override
	public void deleteUser(Integer id) {
		User user = userRepositoy.getOne(id);
		userRepositoy.delete(user);

	}

	@Override
	public User getUserByName(String username) {
		User user = userRepositoy.findByUsername(username);
		if (user == null)
			throw new RuntimeException("User not found!");
		return user;
	}

	@Override
	public User addRoleToUser(String username, String roleName) {
		Role role = roleService.getByRoleName(roleName);
		User user = getUserByName(username);
		user.getRole().add(role);

		return user;
	}

}
