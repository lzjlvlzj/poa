package org.lzj.poa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Department implements Serializable {

	
	private static final long serialVersionUID = 8196565259512185168L;
	private Integer deptId;
	private String deptName;
	private Department parent;
	private String deptValue;
	private Set<Department> children;
	private String description;
	private Set<User> Users;
	private Date createTime;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Department getParent() {
		return parent;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}

	public String getDeptValue() {
		return deptValue;
	}

	public void setDeptValue(String deptValue) {
		this.deptValue = deptValue;
	}

	public Set<Department> getChildren() {
		return children;
	}

	public void setChildren(Set<Department> children) {
		this.children = children;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getUsers() {
		return Users;
	}

	public void setUsers(Set<User> users) {
		Users = users;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
