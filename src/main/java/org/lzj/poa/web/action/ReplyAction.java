package org.lzj.poa.web.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.lzj.poa.entity.Reply;
import org.lzj.poa.entity.Topic;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class ReplyAction extends BaseAction<Reply>{
	
	private static final long serialVersionUID = -5908956215640653142L;
	
	private Integer topicId;
	/**新建主题页面
	 * @return String 
	 */
	public String addUI(){
		//取得主题
		Topic topic = topicServiceImpl.findById(topicId);
		ActionContext.getContext().put("topic", topic);		
		return "saveUI";
	}
	/**新建主题页面
	 * @return String 
	 */
	public String add(){
		//取得主题
		Topic topic = topicServiceImpl.findById(topicId);
		model.setTopic(topic);
		model.setAuthor(getCurrentUser());
		String ipAddr = ServletActionContext.getRequest().getRemoteAddr();
		model.setIpAddr(ipAddr);
		model.setPostTime(new Date());
		
		replyServiceImpl.save(model);
		
		return "toTopicShow";
	}
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}


}
