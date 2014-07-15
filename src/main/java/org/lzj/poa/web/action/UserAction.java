package org.lzj.poa.web.action;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.lzj.poa.common.Contants;
import org.lzj.poa.entity.Department;
import org.lzj.poa.entity.Role;
import org.lzj.poa.entity.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	/**
	 */
	private static final long serialVersionUID = 854464604688387248L;
	private Integer deptId;
	private Integer[] ids;
	private String timeStamp;//邮件时间戳

	public String list() {
		List<User> list = userServiceImpl.findAll();
		ActionContext.getContext().put("userList", list);
		return "list";
	}

	public String delete() {
		User user = userServiceImpl.findById(model.getUserId());
		if (null != user) {
			userServiceImpl.delete(user);
		}
		return "toList";
	}

	/** 添加页面 */
	public String addUI() {
		// 准备部门信息
		List<Department> deptList = departmentServiceImpl.findAll();
		ActionContext.getContext().put("deptList", deptList);
		// 准备岗位信息
		List<Role> roleList = roleServiceImpl.findAll();
		ActionContext.getContext().put("roleList", roleList);

		return "saveUI";
	}

	/** 添加 */
	public String add() {
		// 封装没有添加的属性
		model.setPassword("123456");
		// 部门
		model.setDepartment(departmentServiceImpl.findById(deptId));
		// 角色
		List<Role> roleList = roleServiceImpl.findByIds(ids);
		if (null != roleList) {
			Set<Role> set = new HashSet<Role>();
			set.addAll(roleList);
			model.setRoles(set);
		}
		// 设置默认密码
		model.setPassword("123456");
		// 设置默认激活状态
		model.setStatus(1);// 未激活
		// 设置添加日期
		model.setCreateTime(new Date());
		// 保存用户
		userServiceImpl.save(model);
		return "toList";
	}

	/** 修改页面 */
	public String editUI() {
		// 准备部门信息
		List<Department> deptList = departmentServiceImpl.findAll();
		ActionContext.getContext().put("deptList", deptList);
		// 准备岗位信息
		List<Role> roleList = roleServiceImpl.findAll();
		ActionContext.getContext().put("roleList", roleList);
		// 回显
		User user = userServiceImpl.findById(model.getUserId());
		ActionContext.getContext().getValueStack().push(user);

		if (null != user.getDepartment()) {
			deptId = user.getDepartment().getDeptId();
		}
		Set<Role> set = user.getRoles();
		if (null != set) {
			ids = new Integer[set.size()];
			int index = 0;
			for (Role role : set) {
				ids[index++] = role.getId();
			}
		}
		return "saveUI";
	}

	/** 修改 */
	public String edit() {
		// 查询数据库
		User user = userServiceImpl.findById(model.getUserId());
		if (null != user) {
			user.setUserName(model.getUserName());
			user.setLoginName(model.getLoginName());
			user.setEmail(model.getEmail());
			user.setPhone(model.getPhone());
			user.setQq(model.getQq());
			user.setStatus(model.getStatus());// 默认非激活状态
			user.setCreateTime(new Date());
			// 修改部门
			Department dept = departmentServiceImpl.findById(deptId);
			user.setDepartment(dept);
			// 修改权限
			List<Role> roleList = roleServiceImpl.findByIds(ids);
			Set<Role> set = new HashSet<Role>();
			set.addAll(roleList);
			user.setRoles(set);

			userServiceImpl.update(user);
		}

		return "toList";
	}

	public String initPassword() {
		User user = userServiceImpl.findById(model.getUserId());
		if (null != user) {
			user.setPassword(Contants.INIT_PASSWORD);
		}
		userServiceImpl.update(user);

		return "toList";
	}

	public String loginUI() {
		return "loginUI";
	}

	public String login() {
		User user = new User();
		user.setLoginName(model.getLoginName());
		// 检查用户登录
		User u = this.userServiceImpl.findUserByName(user);
		if (null == u) {
			if(null != model.getLoginName() || model.getLoginName().length() > 0){
				addFieldError("count", "无此用户" + model.getLoginName());
			}
			return "loginUI";
		} else {
			String activeMsg = "账号未激活点击<a href='user_activeUI.action?userId="+u.getUserId()
					+"&email="+u.getEmail()
					+"'>这里激活</a>";
			if(u.getStatus() == 1){
				addFieldError("active", activeMsg);
				return "loginUI";
			}
			if (!u.getPassword().equals(model.getPassword())) {
				addFieldError("password", "密码不正确");
				return "loginUI";
			}
		}
		// 将用户保存到seesion
		ActionContext.getContext().getSession().put(Contants.SESSION_USER, u);

		return "toHome";
	}

	public String logout() {
		ActionContext.getContext().getSession().remove(Contants.SESSION_USER);
		return "logout";
	}

	public String activeUI() {
		
		User user = userServiceImpl.findById(model.getUserId());
		if(null == user){
			addFieldError("count", "无此用户" + model.getLoginName() );
			return "loginUI";
		}else{
			if(user.getEmail().equals(model.getEmail())){
				Long currentTime = System.currentTimeMillis();
				Long lastEmailTime = user.getLastEmailTime();
				boolean flag = (null == lastEmailTime ? true:((currentTime - lastEmailTime) > Contants.EMAIL_SEND_INTERVAL));
				if(flag){
					// 发送邮件
					userServiceImpl.sendEmail(user);
					//更新时间到数据库 ?不考虑发送失败
					user.setLastEmailTime(currentTime);
					userServiceImpl.update(user);
				}else{
					
					addFieldError("emailTimeout","邮件发送时间间隔为" + Contants.EMAIL_SEND_INTERVAL/(1000 * 60) + "分钟。");
				}
			}else{
				addFieldError("counNotMatchEmail", "账号和email不匹配" + model.getLoginName() );
				return "loginUI";
			}
		}
		return "activeUI";
	}
	
	public String active(){
		User user = userServiceImpl.findById(model.getUserId());
		Long emaiTime = Long.parseLong(timeStamp);
		Long currentTime = System.currentTimeMillis();
		if(currentTime-emaiTime>Contants.EMAIL_SEND_TIME_OUT){
			addFieldError("emailTimeout","邮件链接已过期");
		}
		else{
			//更新状态
			user.setStatus(0);
			//更新到数据库
			userServiceImpl.update(user);
		}
		return "active";
	}
	/*
	 * private void encapsulateUser(User user) {
	 * user.setUserName(model.getUserName());
	 * user.setLoginName(model.getLoginName()); user.setEmail(model.getEmail());
	 * user.setPhone(model.getPhone()); user.setQq(model.getQq());
	 * user.setStatus(1);//默认非激活状态 user.setCreateTime(new Date()); //set
	 * department //user.setDepartment(dept); //TODO set role
	 * 
	 * }
	 */

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

}
