package org.lzj.poa.common;

import java.io.Serializable;

public class Contants implements Serializable{

	private static final long serialVersionUID = 1204910268079179837L;
	
	/**
	 * 保存session 中user 的key
	 */
	public static final String SESSION_USER = "user";
	
	public static final String LOGIN_URL = "user_login";
	
	public static final String INIT_PASSWORD = "123456";
	
	//public static final Long EMAIL_SEND_INTERVAL = 1000 * 60 * 30L; //30min
	public static final Long EMAIL_SEND_INTERVAL = 1000 * 60L; //30min
	
	//public static final Long EMAIL_SEND_TIME_OUT = 1000 * 60 * 60 * 48L;//48hour
	public static final Long EMAIL_SEND_TIME_OUT = 1000 * 60L;//48hour

	public static final String USER_ACTIVE = "用户激活";
	
	
	
}
