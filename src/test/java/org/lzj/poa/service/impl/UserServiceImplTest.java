package org.lzj.poa.service.impl;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lzj.poa.entity.User;
import org.lzj.poa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class UserServiceImplTest extends AbstractJUnit4SpringContextTests{
	@Autowired
	private UserService userServiceImpl;
	
	@Test
	public void testFindAll() {
		
	}

	@Test
	public void testSave() {
		for(int i=0;i<10;i++){
			User user = new User();
			//user.setUserId(2+i);
			user.setLoginName("test" + i);
			user.setPassword("test" + i);
			user.setEmail("abcd_" + i + "@163.com");
			user.setQq("123456" + i);
			user.setUserName("testname" + i);
			user.setBirthDay(new Date());
			user.setCreateTime(new Date());
			user.setPhone("1520151445" + i);
			user.setStatus(1);
			userServiceImpl.save(user);
			
		}
		
	}

	@Test
	public void testFindById() {
		User u = userServiceImpl.findById(1);
		System.out.println(u);
	}

	@Test
	public void testUpdate() {
	}

	@Test
	public void testDelete() {
		System.out.println("111");
	}
	@Test
	public void testSendEmail(){
		User user = new User ();
		user.setEmail("1223249224@qq.com");
		userServiceImpl.sendEmail(user);
		
	}

}
