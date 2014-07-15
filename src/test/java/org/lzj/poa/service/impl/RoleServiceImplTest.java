package org.lzj.poa.service.impl;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lzj.poa.entity.Role;
import org.lzj.poa.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class RoleServiceImplTest extends AbstractJUnit4SpringContextTests{
	@Autowired
	private RoleService roleServiceImpl;
	
	@Test
	public void testFindByIds() {
		Integer[] ids = {2};
		List<Role> list = roleServiceImpl.findByIds(ids);
		System.out.println(list.size());
	}
	@Test
	public void testTransanction(){
		/*Role role = new Role();
		role.setRoleName("aa");
		
		Role role1 = new Role();
		role1.setRoleName("bb");
		roleServiceImpl.save(role);
		int a = 1 / 0; 
		roleServiceImpl.save(role1);*/
	}


}
