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

import com.jdc.clinic.model.Role;
import com.jdc.clinic.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleRestController {
	@Autowired
	private RoleService roleService;

	@GetMapping("")
	public List<Role> getAllRoles() {
		return roleService.getAll();

	}

	@GetMapping("/{id}")
	public Optional<Role> getUser(@PathVariable("id") Integer id) {
		return roleService.getOneById(id);

	}

	@PostMapping
	public Role saveRole(@RequestBody Role role) {
		return roleService.saveRole(role);
	}

	@PutMapping
	public Role updateRole(@RequestBody Role role) {
		return roleService.updateRole(role);
	}

	@DeleteMapping("/{id}")
	public void deleteRole(@PathVariable("id") Integer id) {
		roleService.deleteRole(id);
	}

}
