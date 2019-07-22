package com.jdc.clinic.service;

import java.util.List;
import java.util.Optional;

import com.jdc.clinic.model.Role;

public interface RoleService {

	public Optional<Role> getOneById(Integer id);

	public List<Role> getAll();

	public Role saveRole(Role role);

	public Role updateRole(Role role);

	public void deleteRole(Integer id);

	public Role getByRoleName(String roleName);

}
