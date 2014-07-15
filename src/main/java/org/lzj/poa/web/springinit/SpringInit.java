package org.lzj.poa.web.springinit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.lzj.poa.common.EmailSender;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;

public class SpringInit implements InitializingBean {
	@Autowired
	private TaskExecutor taskExecutor;
	public void afterPropertiesSet() throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		EmailSender es = new EmailSender();
		es.init(taskExecutor,executorService);
	}

}
