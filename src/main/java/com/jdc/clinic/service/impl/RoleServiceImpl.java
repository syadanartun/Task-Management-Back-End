package com.jdc.clinic.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.clinic.model.Role;
import com.jdc.clinic.repo.RoleRepository;
import com.jdc.clinic.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Optional<Role> getOneById(Integer id) {
		Optional<Role> role = roleRepository.findById(id);
		if (role == null)
			throw new RuntimeException("Role not found");
		return role;
	}

	@Override
	public List<Role> getAll() {

		return roleRepository.findAll();
	}

	@Override
	public Role saveRole(Role role) {

		return roleRepository.save(role);
	}

	@Override
	public Role updateRole(Role role) {

		return roleRepository.save(role);
	}

	@Override
	public void deleteRole(Integer id) {
		Role role = roleRepository.getOne(id);
		roleRepository.delete(role);
	}

	@Override
	public Role getByRoleName(String roleName) {
		Role role = roleRepository.findByRoleName(roleName);
		if (role == null)
			throw new RuntimeException("Role no found");
		return role;
	}

}
