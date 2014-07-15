package org.lzj.poa.web.listener;

import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.jboss.logging.Logger;
import org.lzj.poa.entity.Privilege;
import org.lzj.poa.service.PrivilegeService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class InitListener implements ServletContextListener {
	
	private static Logger log = Logger.getLogger(InitListener.class);
	

	public void contextInitialized(ServletContextEvent sce) {
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		PrivilegeService privilegeServiceImpl = (PrivilegeService)ac.getBean("privilegeServiceImpl");
		
		List<Privilege> list = privilegeServiceImpl.findTopPrivilegeList();
		sce.getServletContext().setAttribute("topPrivilegeList", list);
		
		System.out.println("init left menu done..");
		log.info("init left menu done..");
		Collection<String> c = privilegeServiceImpl.findAllPrivilegeUrls();
		sce.getServletContext().setAttribute("allPrivilegeUrls", c);
		log.info("init privilege urls done.");
		
	}
	
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
}
