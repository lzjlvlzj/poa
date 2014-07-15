package org.lzj.poa.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;

public class User implements Serializable {
	
	private static final long serialVersionUID = -6837907823938991955L;
	
	private Integer userId;
	private String loginName;
	private String password;
	private String userName;
	private Integer gender; //0 :保密    1: 男    2: 女
	private String phone;
	private String email;
	private String qq;
	private int status;// 0: enable 1 disable
	private Date birthDay;
	private Long lastEmailTime;
	private Date createTime;
	private String description;
	private Department department;
	private Set<Role> roles;
	
	
	public boolean hasPrivilegeByName(String privilegeName){
		if(isAdmin()){
			return true;
		}
		if(status == 1){
			return false;
		}
		for(Role role: roles){
			Set<Privilege> set = role.getPrivileges();
			for(Privilege p : set){
				if(privilegeName.equals(p.getPrivilegeName())){
					return true;
				}
			}
			
		}
		return false;
	}
	
	public boolean hasPrivilegeByUrl(String url){
		if(isAdmin()){
			return true;
		}
		if(status == 1){
			return false;
		}
		//user_delete?id=1
		int pos = url.indexOf("?");
		if(pos > -1){
			url = url.substring(0,pos);
		}
		
		//UI
		if(url.endsWith("UI")){
			url = url.substring(0,url.length()-2);
		}
		url = "/" + url;
		//如果数据库里没有的权限表示不需要控制
		@SuppressWarnings("unchecked")
		Collection<Privilege> c = (Collection<Privilege>) ActionContext.getContext().getApplication().get("allPrivilegeUrls");
		if(!c.contains(url)){
			return true;
		}else{
			for(Role role: roles){
				for(Privilege p : role.getPrivileges()){
					if(url.equals(p.getUrl())){
						return true;
					}
				}
				
			}
			return false;
		}
		
	}
	
	
	

	public boolean isAdmin() {
		if("admin".equals(loginName)){
			return true;
		}
		return false;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public Long getLastEmailTime() {
		return lastEmailTime;
	}

	public void setLastEmailTime(Long lastEmailTime) {
		this.lastEmailTime = lastEmailTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	@Override
	public String toString() {
		return "loginName:"+loginName+" userName:" + userName;
	}
}
