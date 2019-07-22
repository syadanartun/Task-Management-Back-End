package com.jdc.clinic.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.clinic.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	public Role findByRoleName(String roleName);

}
