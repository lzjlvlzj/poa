package org.lzj.poa.web.action;

import java.lang.reflect.ParameterizedType;

import org.lzj.poa.service.DepartmentService;
import org.lzj.poa.service.ForumManageService;
import org.lzj.poa.service.PrivilegeService;
import org.lzj.poa.service.RoleService;
import org.lzj.poa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("unchecked")
public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	
	private static final long serialVersionUID = 5559932674817472908L;
	protected T model = null;
	
	public BaseAction(){
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
		try {
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		} 
	}
	public void setModel(T model){
		this.model = model;
	}
	public T getModel() {
		return model;
	}
	
	@Autowired
	protected DepartmentService departmentServiceImpl;
	
	@Autowired
	protected RoleService roleServiceImpl;
	
	@Autowired
	protected UserService userServiceImpl;
	
	@Autowired
	protected PrivilegeService privilegeServiceImpl;
	
	@Autowired
	protected ForumManageService forumManageServiceImpl;
	

}
