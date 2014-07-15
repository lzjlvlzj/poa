package org.lzj.poa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lzj.poa.entity.Department;
import org.lzj.poa.entity.Privilege;
import org.lzj.poa.service.DepartmentService;
import org.lzj.poa.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class PrivilegeServiceImplTest extends AbstractJUnit4SpringContextTests{
	@Resource
	PrivilegeService privilegeServiceImpl;
	
	@Autowired
	private DepartmentService departmentServiceImpl;
	
	@Test
	public void testGetPrivilegeList(){
		//ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		//PrivilegeService privilegeServiceImpl = (PrivilegeService)ac.getBean("privilegeServiceImpl");
		List<Privilege> list = privilegeServiceImpl.findTopPrivilegeList();
		for(Privilege p : list){
			System.out.println(p); 
		}
	}
	
	@Test
	public void testFindSub(){
		Department department = new Department();
		List<Department> list = departmentServiceImpl.findSub(department.getParent());
		System.out.println(list.size());
		
	}
}
