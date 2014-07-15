package org.lzj.poa.service;

import java.util.Collection;
import java.util.List;

import org.lzj.poa.entity.Privilege;

public interface PrivilegeService {

	List<Privilege> findAll();

	List<Privilege> findByIds(Integer[] privilegeIds);

	List<Privilege> findTopPrivilegeList();

	Collection<String> findAllPrivilegeUrls();

}
