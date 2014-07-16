package org.lzj.poa.web.action;

import java.util.Date;
import java.util.List;

import org.lzj.poa.entity.Forum;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class ForumManageAction extends BaseAction<Forum> {

	private static final long serialVersionUID = 1620180046232162734L;
	
	public String list(){
		List<Forum> list = forumManageServiceImpl.findAll();
		ActionContext.getContext().put("forumList", list);
		return "list";
	}
	
	public String delete(){
		forumManageServiceImpl.delete(model);
		return "toList";
	}
	
	/** 添加页面 */
	public String addUI() {
		return "saveUI";
	}
	
	/** 添加 */
	public String add(){
		model.setCreateTime(new Date());//添加日期
		model.setPosition(0);//位置
		forumManageServiceImpl.save(model);
		return "toList";
	}

	/** 修改页面 */
	public String editUI()  {
		//根据ID查询
		Forum forum = forumManageServiceImpl.findById(model.getForumId());
		//回显数据
		ActionContext.getContext().getValueStack().push(forum);//推到栈顶
		return "saveUI";
	}
	/** 修改 */
	public String edit()  {
		//根据ID查询
		Forum forum = forumManageServiceImpl.findById(model.getForumId());
		//修改数据
		if(null != forum){
			forum.setForumName(model.getForumName());
			forum.setDescription(model.getDescription());
		}
		//更新到数据库
		forumManageServiceImpl.update(forum);
		return "toList";
	}

}
