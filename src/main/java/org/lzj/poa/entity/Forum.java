package org.lzj.poa.entity;

import java.io.Serializable;
import java.util.Date;

public class Forum implements Serializable {

	/**
	 * 论坛实体
	 */
	private static final long serialVersionUID = 5433590586403636760L;
	
	private Integer forumId;
	private String forumName;
	private String description;
	private Integer position;
	private Date createTime;
	public Integer getForumId() {
		return forumId;
	}
	public void setForumId(Integer forumId) {
		this.forumId = forumId;
	}
	public String getForumName() {
		return forumName;
	}
	public void setForumName(String forumName) {
		this.forumName = forumName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		
		return this.forumName;
	}
}
