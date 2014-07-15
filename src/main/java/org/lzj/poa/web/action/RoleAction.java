package org.lzj.poa.web.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.lzj.poa.entity.Privilege;
import org.lzj.poa.entity.Role;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	
	private static final long serialVersionUID = 5254885288605085907L;
	private Integer[] privilegeIds;
	
	public String list(){
		List<Role> list = roleServiceImpl.findAll();
		ActionContext.getContext().put("roleList", list);
		return "list";
	}
	
	public String delete(){
		Role role = roleServiceImpl.findById(model.getId());
		if(null != role){
			roleServiceImpl.delete(model);
		}
		return "toList";
	}
	
	/** 添加页面 */
	public String addUI() {
		return "saveUI";
	}
	
	/** 添加 */
	public String add(){
		roleServiceImpl.save(model);
		return "toList";
	}

	/** 修改页面 */
	public String editUI()  {
		Role r = roleServiceImpl.findById(model.getId());
		ActionContext.getContext().getValueStack().push(r);
		return "saveUI";
	}
	/** 修改 */
	public String edit()  {
		// 1，从数据库中获取原对象
		Role role = roleServiceImpl.findById(model.getId());
		if(role !=null){
			// 2，设置要修改的属性
			role.setRoleName(model.getRoleName());
			role.setRoleValue(model.getRoleValue());
			role.setDescription(model.getDescription());
			
			roleServiceImpl.update(role);
		}
		return "toList";
	}
	/**
	 * 权限页面
	 * */
	public String setPrivilegeUI(){
		//回显当前岗位的权限信息
		Role role = roleServiceImpl.findById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		Set<Privilege> privileges = role.getPrivileges();
		if(null != privileges){
			int index = 0;
			privilegeIds = new Integer[privileges.size()];
			for(Privilege p : privileges){
				privilegeIds[index++] = p.getPrid();
			}
		}
		/*//所有岗位信息
		List<Privilege> privilegeList = privilegeServiceImpl.findAll(); 
		privilegeServiceImpl.findTopPrivilegeList();
		ActionContext.getContext().put("privilegeList", privilegeList);*/
		return "setPrivilegeUI";
	}
	/**
	 * 设置权限
	 * */
	public String setPrivilege(){
		//取得新的权限
		List<Privilege> privilegeList = privilegeServiceImpl.findByIds(privilegeIds);
		Role role = roleServiceImpl.findById(model.getId());
		role.setPrivileges(new HashSet<Privilege>(privilegeList));
		//更新数据库
		roleServiceImpl.update(role);
		
		return "toList";
	}

	public Integer[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(Integer[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}
	
}
