package org.lzj.poa.service.impl;

import java.util.Date;
import java.util.List;

import org.lzj.poa.entity.Forum;
import org.lzj.poa.entity.Reply;
import org.lzj.poa.entity.Topic;
import org.lzj.poa.persist.ForumDao;
import org.lzj.poa.persist.ReplyDao;
import org.lzj.poa.persist.TopicDao;
import org.lzj.poa.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDao replyDaoImpl;
	@Autowired
	private ForumDao forumDaoImpl;
	@Autowired
	private TopicDao topicDaoImpl;

	public List<Reply> findByTopic(Topic topic) {
		List<Reply> list = replyDaoImpl.findByTopic(topic);
		return list;
	}

	public void save(Reply reply) {
		replyDaoImpl.save(reply);
		//-----------维护相关信息
		Topic topic = reply.getTopic();
		Forum forum = topic.getForum();
		//帖子数量
		forum.setTopicCount(forum.getArticleCount() +1);
		//回复数量
		topic.setReplyCount(topic.getReplyCount() + 1);
		//最后回复
		topic.setLastReply(reply);
		//最后发表时间
		topic.setLastUpdateTime(new Date());
		//不保存也可以 因为 topic forum 处于 持久状态 session变化时，会自动更新到数据库
		forumDaoImpl.save(forum);
		topicDaoImpl.save(topic);
	}

}
