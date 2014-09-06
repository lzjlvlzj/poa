package org.lzj.poa.service;

import java.util.List;

import org.lzj.poa.entity.Reply;
import org.lzj.poa.entity.Topic;

public interface ReplyService {

	List<Reply> findByTopic(Topic topic);

	void save(Reply model);

}
