package org.lzj.poa.init;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class HibernateTest extends AbstractJUnit4SpringContextTests{
	@Autowired
	private TestService testServiceImpl;
	@Test
	public void testInsertUser(){
		System.out.println("aaaaaaaaaa");
	}
	
	//测试二级缓存
	@Test
	public void testHibernateSecendCache(){
		testServiceImpl.find();
	}
	
}
