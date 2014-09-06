package org.lzj.poa.service;

import java.util.List;

import org.lzj.poa.entity.Forum;
import org.lzj.poa.entity.Topic;

public interface TopicService {

	List<Topic> findByForum(Forum forum);

	void save(Topic model);

	Topic findById(Integer articleId);

}
