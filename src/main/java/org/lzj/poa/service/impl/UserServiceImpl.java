package org.lzj.poa.service.impl;

import java.util.List;

import org.lzj.poa.common.Contants;
import org.lzj.poa.common.EmailSender;
import org.lzj.poa.entity.Email;
import org.lzj.poa.entity.User;
import org.lzj.poa.persist.UserDao;
import org.lzj.poa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	//private Logger log = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao userDaoImpl;
	public List<User> findAll() {
		List<User> list = userDaoImpl.findAll();
		return list;
	}

	public void save(User user) {
		userDaoImpl.save(user);
	}

	public User findById(Integer userId) {
		User user = userDaoImpl.findById(userId);
		return user;
	}

	public void update(User user) {
		userDaoImpl.update(user);
	}

	public void delete(User user) {
		userDaoImpl.delete(user);
	}

	public User findUserByName(User user) {
		User u = userDaoImpl.findUserByName(user);
		return u;
	}

	public void sendEmail(User user) {
		//取得用户邮箱
		String toCount = user.getEmail();
		if(null == toCount || toCount.length() == 0){
			//log.warn(user.getLoginName() + "'s email is null");
			return ;
		}
		//组装发送邮件内容
		Email email = new Email();
		email.setHost("smtp.163.com");
		email.setToCount(toCount);
		email.setFromCount("mxdyxzy@163.com");
		email.setFromPassword("tdt256lzj55");
		email.setSubject(Contants.USER_ACTIVE);
		String content = "";
		String url = "http://127.0.0.1:8080/poa/user_active.action?"
				+ "userId="+ user.getUserId()
				+ "&timeStamp=" + System.currentTimeMillis();
		content = "<html><head></head><body>"
				+ "亲爱的"+user.getLoginName()+"你好！<br/>"
				+ "欢迎加入XXXXXX的大家庭，为了以后办公方便请点击下面链接激活你的账户<br/>"
				+ "<a href= '"+url+"'>"+url+"</a>"
				+ "</body></html>";
		email.setContent(content);
		//邮件发送工具发送
		EmailSender emailSender = new EmailSender();
		emailSender.send(email);
		
	}

}
