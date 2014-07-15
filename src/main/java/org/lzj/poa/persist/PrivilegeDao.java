package org.lzj.poa.persist;

import java.util.Collection;
import java.util.List;

import org.lzj.poa.entity.Privilege;

public interface PrivilegeDao  extends BaseDao<Privilege, Integer>{

	List<Privilege> findTopPrivilegeList();

	Collection<String> findAllPrivilegeUrls();

}
