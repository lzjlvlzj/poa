package org.lzj.poa.init;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class InstallerTest extends AbstractJUnit4SpringContextTests{
	
	@Autowired
	private TestService testServiceImpl;
	
	@Test
	public void testInstaller(){
		testServiceImpl.addInstaller();
	}
	
}
