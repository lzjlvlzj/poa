package org.lzj.poa.service.impl;

import java.util.List;

import org.lzj.poa.entity.Department;
import org.lzj.poa.persist.DepartmentDao;
import org.lzj.poa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao departmentDaoImpl;
	
	public List<Department> findAll() {
		List<Department> list = departmentDaoImpl.findAll();
		return list;
	}

	public void delete(Department department) {
		departmentDaoImpl.delete(department);
	}

	public void save(Department department) {
		departmentDaoImpl.save(department);
	}

	public Department findById(Integer deptId) {
		Department dept = departmentDaoImpl.findById(deptId);
		return dept;
	}

	public void update(Department department) {
		departmentDaoImpl.update(department);
	}

	public List<Department> findSub(Department parent) {
		List<Department> list = null;
		list = departmentDaoImpl.findSub(parent);
		return list;
	}

}
