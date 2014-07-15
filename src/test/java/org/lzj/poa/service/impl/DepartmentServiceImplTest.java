package org.lzj.poa.service.impl;


import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lzj.poa.entity.Department;
import org.lzj.poa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class DepartmentServiceImplTest {
	
	@Autowired
	private DepartmentService departmentServiceImpl;
	
	@Test
	public void testSave() {
		Department department = new Department();
		department.setDeptName("tet");
		department.setDeptValue("11");
		department.setCreateTime(new Date());
		department.setDescription("aaaa");
		//department.set
		departmentServiceImpl.save(department);
	}
	@Test
	public void testDelete() {
		Department department = new Department();
		department.setDeptId(17);
		departmentServiceImpl.delete(department);
	}
	@Test
	public void testFindSub(){
		Department department = new Department();
		List<Department> list = departmentServiceImpl.findSub(department.getParent());
		System.out.println(list.size());
		
	}
}
