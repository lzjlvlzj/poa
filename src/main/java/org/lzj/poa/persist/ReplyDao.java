package org.lzj.poa.persist;

import java.util.List;

import org.lzj.poa.entity.Reply;
import org.lzj.poa.entity.Topic;

public interface ReplyDao extends BaseDao<Reply, Integer>{

	List<Reply> findByTopic(Topic topic);

}
