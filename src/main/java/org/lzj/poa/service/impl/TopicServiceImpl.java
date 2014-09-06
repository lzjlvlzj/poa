package org.lzj.poa.service.impl;

import java.util.List;

import org.lzj.poa.entity.Forum;
import org.lzj.poa.entity.Topic;
import org.lzj.poa.persist.ForumDao;
import org.lzj.poa.persist.TopicDao;
import org.lzj.poa.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements TopicService {
	
	@Autowired
	private TopicDao topicDaoImpl;
	
	@Autowired
	private ForumDao forumDaoImpl;
	

	public List<Topic> findByForum(Forum forum) {
		
		List<Topic> topicList = topicDaoImpl.findByForum(forum);
		
		return topicList;
	}

	public void save(Topic topic) {
		
		topicDaoImpl.save(topic);
		//维护相关信息
		Forum forum = topic.getForum();
		forum.setLastTopic(topic);
		forum.setArticleCount(forum.getArticleCount() +1);
		forum.setTopicCount(forum.getTopicCount() + 1);
		
		forumDaoImpl.save(forum);
	}

	public Topic findById(Integer articleId) {
		
		return topicDaoImpl.findById(articleId);
	}

}
