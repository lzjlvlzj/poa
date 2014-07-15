package org.lzj.poa.service.impl;

import java.util.Date;
import java.util.List;

import org.lzj.poa.entity.Role;
import org.lzj.poa.persist.RoleDao;
import org.lzj.poa.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDaoImpl;
	
	public List<Role> findAll() {
		List<Role> list = roleDaoImpl.findAll();
		return list;
	}

	public Role findById(Integer id) {
		Role role = roleDaoImpl.findById(id);
		return role;
	}

	public void update(Role role) {
		roleDaoImpl.update(role);
	}

	public void save(Role role) {
		Date date = new Date();
		role.setCreateTime(date);
		roleDaoImpl.save(role);
	}

	public void delete(Role role) {
		roleDaoImpl.delete(role);
	}

	public List<Role> findByIds(Integer[] ids) {
		List<Role> roleList = roleDaoImpl.getByIds(ids);
		return roleList;
	}

}
