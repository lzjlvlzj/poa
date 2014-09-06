package org.lzj.poa.web.action;

import java.util.List;

import org.lzj.poa.entity.Forum;
import org.lzj.poa.entity.Topic;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class ForumAction extends BaseAction<Forum>{
	

	private static final long serialVersionUID = -8081345054414208436L;
	
	/**板块列表
	 * @return String 
	 */
	public String list(){
		List<Forum> list = forumServiceImpl.findAll();
		ActionContext.getContext().put("forumList", list);
		return "list";
	}
	/**显示特定板块下的主题列表
	 * @return String
	 */
	public String show(){
		//根据id查询forum
		Forum forum = forumServiceImpl.getById(model.getForumId());
		ActionContext.getContext().put("forum", forum);
		//取得topics
		List<Topic> topicList = topicServiceImpl.findByForum(forum);
		ActionContext.getContext().put("topicList", topicList);
		
		return "show";
	}

}
