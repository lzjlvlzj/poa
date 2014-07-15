package org.lzj.poa.common;

import java.util.concurrent.ExecutorService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.mail.EmailException;
import org.lzj.poa.entity.Email;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailSender {
	private static TaskExecutor taskExecutor = null;// 线程池
	private static ExecutorService executorService = null;

	// private static Semaphore semaphore = null;//信号量 一次5个

	public static ExecutorService getExecutorService() {
		return executorService;
	}

	public static void setExecutorService(ExecutorService executorService) {
		EmailSender.executorService = executorService;
	}

	public void send(Email email) {
		Sender sender = new Sender(email);
		taskExecutor.execute(sender);
	}

	public void init(TaskExecutor executor, ExecutorService executorService) {
		synchronized (this) {
			setTaskExecutor(executor);
			setExecutorService(executorService);
		}
	}

	public static void main(String[] args) {
		Email email = new Email();
		email.setHost("smtp.163.com");
		email.setToCount("1223249224@qq.com");
		email.setFromCount("mxdyxzy@163.com");
		email.setFromPassword("tdt256lzj55");
		email.setSubject(Contants.USER_ACTIVE);
		email.setContent("用户激活测试");

		EmailSender es = new EmailSender();
		es.send(email);

	}

	public static TaskExecutor getTaskExecutor() {
		return taskExecutor;
	}

	public static void setTaskExecutor(TaskExecutor taskExecutor) {
		EmailSender.taskExecutor = taskExecutor;
		
	}

}

class Sender implements Runnable {
	private Email email;

	public Sender(Email email) {
		this.email = email;
	}

	public void run() {
		try {
			doSend(email);
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

	public synchronized void doSend(Email email) throws EmailException {
		/*
		 * System.out.println("333333"); SimpleEmail se = new SimpleEmail();
		 * se.setHostName("smtp.163.com"); // 发送服务器
		 * se.setAuthentication(email.getFromCount(), email.getFromPassword());
		 * // 发送邮件的用户名和密码 se.addTo(email.getToCount()); // 接收邮箱
		 * se.setFrom(email.getFromCount()); // 发送邮箱 se.setSubject("测试主题");// 主题
		 * se.setMsg("这里是邮件内容"); // 内容 se.setCharset("UTF-8"); // 编码 se.send();
		 * System.out.println("0000000000000");
		 */

		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(email.getHost());
		mailSender.setUsername(email.getFromCount());
		mailSender.setPassword(email.getFromPassword());
		MimeMessage msg = mailSender.createMimeMessage();
		MimeMessageHelper helper = null;
		try {
			helper = new MimeMessageHelper(msg, true, "UTF-8");
			helper.setFrom(email.getFromCount());
			helper.setTo(email.getToCount());
			helper.setSubject(email.getSubject());
			helper.setText(email.getContent(),true);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		mailSender.send(msg);

	}

}