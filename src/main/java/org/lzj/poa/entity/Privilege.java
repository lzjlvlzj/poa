package org.lzj.poa.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 权限
 * 
 * 
 * */
public class Privilege implements Serializable{
	
	private static final long serialVersionUID = 4936317236086866115L;
	private Integer prid;
	private String privilegeName;
	private String url;
	private Set<Role> roles = new HashSet<Role>();
	private Privilege parent;
	private Set<Privilege> children = new HashSet<Privilege>();;
	private String description;
	public Privilege(){
		
	}
	
	public Privilege(String privilegeName, String url, Privilege parent,
			String description) {
		this.privilegeName = privilegeName;
		this.url = url;
		this.parent = parent;
		this.description = description;
	}
	public Integer getPrid() {
		return prid;
	}
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	public String getPrivilegeName() {
		return privilegeName;
	}
	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Privilege getParent() {
		return parent;
	}
	public void setParent(Privilege parent) {
		this.parent = parent;
	}
	public Set<Privilege> getChildren() {
		return children;
	}
	public void setChildren(Set<Privilege> children) {
		this.children = children;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		
		return privilegeName + " " + url;
	}
}
