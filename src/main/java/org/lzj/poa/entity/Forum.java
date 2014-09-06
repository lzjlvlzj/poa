package org.lzj.poa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

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
	
	private Set<Topic> Topics;	//主题
	private int topicCount;		//主题数量
	private int articleCount;		//文章数数量(主题 + 回复)	
	private Topic lastTopic;	//最新主题
	
	
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
	public Set<Topic> getTopics() {
		return Topics;
	}
	public void setTopics(Set<Topic> topics) {
		Topics = topics;
	}
	public int getTopicCount() {
		return topicCount;
	}
	public void setTopicCount(int topicCount) {
		this.topicCount = topicCount;
	}
	public int getArticleCount() {
		return articleCount;
	}
	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}
	public Topic getLastTopic() {
		return lastTopic;
	}
	public void setLastTopic(Topic lastTopic) {
		this.lastTopic = lastTopic;
	}
	@Override
	public String toString() {
		
		return this.forumName;
	}
}
