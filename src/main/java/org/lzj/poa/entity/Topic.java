package org.lzj.poa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**主题
 * @author lzj
 */
public class Topic extends Article implements Serializable {

	private static final long serialVersionUID = 6659963002314741478L;
	
	public static final int NORMAL = 0;		//普通
	public static final int BEST = 1;		//精华
	public static final int TOP = 2;		//置顶
	
	private Forum forum;
	private int type;
	private Set<Reply> Replys = new HashSet<Reply>();
	private Reply lastReply;
	private int replyCount;
	private Date lastUpdateTime;
	
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Set<Reply> getReplys() {
		return Replys;
	}
	public void setReplys(Set<Reply> replys) {
		Replys = replys;
	}
	public Reply getLastReply() {
		return lastReply;
	}
	public void setLastReply(Reply lastReply) {
		this.lastReply = lastReply;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}
