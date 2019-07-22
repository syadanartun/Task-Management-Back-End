package com.jdc.clinic.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.clinic.model.User;
import com.jdc.clinic.service.UserService;

@RestController
@RequestMapping("/users")
public class UserRestController {

	@Autowired
	private UserService userService;

	@GetMapping("")
	public List<User> getAllUsers() {
		return userService.getAll();

	}

	@GetMapping("/{id}")
	public Optional<User> getUser(@PathVariable("id") Integer id) {
		return userService.getOneById(id);

	}

	@PostMapping
	public User saveRole(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@PutMapping
	public User updateRole(@RequestBody User user) {
		return userService.updateUser(user);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		userService.deleteUser(id);
	}

}
