package org.lzj.poa.init;

import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:spring/applicationContext.xml")
public class Struts2Test {
	private String test;
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public String test() {
		test = "Struts2 i success !";
		return "success";
	}
}
