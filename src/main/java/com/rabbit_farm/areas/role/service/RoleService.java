package com.rabbit_farm.areas.role.service;


import com.rabbit_farm.areas.role.entity.Role;

import java.util.List;

public interface RoleService {
	void createRole(Role role);

	List<Role> findAllRole();
}
