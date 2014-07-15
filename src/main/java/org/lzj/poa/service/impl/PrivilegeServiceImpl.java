package org.lzj.poa.service.impl;

import java.util.Collection;
import java.util.List;

import org.lzj.poa.entity.Privilege;
import org.lzj.poa.persist.PrivilegeDao;
import org.lzj.poa.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

	@Autowired
	private PrivilegeDao privilegeDaoImpl;
	
	public List<Privilege> findAll() {
		return privilegeDaoImpl.findAll();
	}

	public List<Privilege> findByIds(Integer[] privilegeIds) {
		return privilegeDaoImpl.getByIds(privilegeIds);
	}

	public List<Privilege> findTopPrivilegeList() {
		
		return privilegeDaoImpl.findTopPrivilegeList();
	}

	public Collection<String> findAllPrivilegeUrls() {
		return privilegeDaoImpl.findAllPrivilegeUrls();
	}

}
