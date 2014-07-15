package org.lzj.poa.init;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class SpringTest extends AbstractJUnit4SpringContextTests{
	
	//AbstractJUnit4SpringContextTests
	private ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	@Autowired
	private TestService testServiceImpl;
	
	
	// 测试SessionFactory
	@Test
	public void testSessionFactory() throws Exception {
		SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
		System.out.println(sessionFactory);
	}
	
	//测试事务
	@Test
	public void testTransaction() throws Exception {
		testServiceImpl.addTest();
	}
	@Test
	public void testCached(){
		/*每次测试要重启动 memcached server端
		 */
		org.lzj.poa.init.Test t = testServiceImpl.findTestById(1);
		System.out.println("第一次去数据库查询");
		System.out.println(t.getName());
		
		org.lzj.poa.init.Test t1 = testServiceImpl.findTestById(1);
		System.out.println("第二次去memcached查询");
		System.out.println(t1.getName());
	}
}
