package org.lzj.poa.entity;

public class Email {
	
	private String host;
	private String fromCount;
	private String fromPassword;
	private String toCount;
	private String subject;
	private String content;
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getFromCount() {
		return fromCount;
	}
	public void setFromCount(String fromCount) {
		this.fromCount = fromCount;
	}
	public String getFromPassword() {
		return fromPassword;
	}
	public void setFromPassword(String fromPassword) {
		this.fromPassword = fromPassword;
	}
	public String getToCount() {
		return toCount;
	}
	public void setToCount(String toCount) {
		this.toCount = toCount;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
