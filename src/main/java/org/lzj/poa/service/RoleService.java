package org.lzj.poa.service;

import java.util.List;

import org.lzj.poa.entity.Role;

public interface RoleService {

	List<Role> findAll();

	Role findById(Integer id);

	void update(Role role);

	void save(Role model);

	void delete(Role model);

	List<Role> findByIds(Integer[] ids);
	
}
