package org.lzj.poa.web.action;


import javax.annotation.Resource;

import org.lzj.poa.service.PrivilegeService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class HomeAction extends ActionSupport {

	private static final long serialVersionUID = -3172796269547526185L;
	@Resource
	private PrivilegeService privilegeServiceImpl;
	
	public String index(){
		return  "index";
	}
	public String left(){
		/*List<Privilege> list = privilegeServiceImpl.findTopList();
		ActionContext.getContext().put("topPrivilegeList", list);*/
		return  "left";
	}
	public String right(){
		return  "right";
	}
	public String top(){
		return  "top";
	}
	public String bottom(){
		return  "bottom";
	}
}
