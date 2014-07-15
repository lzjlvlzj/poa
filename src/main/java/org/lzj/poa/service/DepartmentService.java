package org.lzj.poa.service;

import java.util.List;

import org.lzj.poa.entity.Department;

public interface DepartmentService {

	List<Department> findAll();

	void delete(Department model);

	void save(Department model);

	Department findById(Integer deptId);

	void update(Department dept);

	List<Department> findSub(Department parent);

}
