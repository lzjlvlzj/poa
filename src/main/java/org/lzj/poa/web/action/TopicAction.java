package org.lzj.poa.web.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.lzj.poa.entity.Forum;
import org.lzj.poa.entity.Reply;
import org.lzj.poa.entity.Topic;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class TopicAction extends BaseAction<Topic>{

	private static final long serialVersionUID = 1406587294646360909L;
	
	private Integer forumId;
	
	/**显示具体主题
	 * @return String
	 */
	public String show(){
		//topic 
		Topic topic = topicServiceImpl.findById(model.getArticleId());
		ActionContext.getContext().put("topic", topic);
		//reply list
		List<Reply> list = replyServiceImpl.findByTopic(topic);
		
		ActionContext.getContext().put("replyList", list);
		return "show";
	}
	
	/**新建主题页面
	 * @return String 
	 */
	public String addUI(){
		//取得板块
		Forum forum = forumServiceImpl.getById(forumId);
		ActionContext.getContext().put("forum", forum);
		return "saveUI";
	}
	/**新建主题
	 * @return String
	 */
	public String add(){
		//取得版块
		Forum forum = forumServiceImpl.getById(forumId);
		model.setForum(forum);
		//初始化默认值
		Date date = new Date();
		model.setPostTime(date);
		String ipAddr = ServletActionContext.getRequest().getRemoteAddr();
		model.setIpAddr(ipAddr);
		model.setReplyCount(0);
		model.setAuthor(getCurrentUser());
		model.setType(Topic.NORMAL);
		
		topicServiceImpl.save(model);
		return "toShow";
	}

	public Integer getForumId() {
		return forumId;
	}

	public void setForumId(Integer forumId) {
		this.forumId = forumId;
	}
	

}
