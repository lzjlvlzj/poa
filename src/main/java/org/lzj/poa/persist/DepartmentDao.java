package org.lzj.poa.persist;

import java.util.List;

import org.lzj.poa.entity.Department;

public interface DepartmentDao extends BaseDao<Department,Integer>{

	List<Department> findSub(Department parent);

}
