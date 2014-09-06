package org.lzj.poa.persist;

import java.util.List;

import org.lzj.poa.entity.Forum;
import org.lzj.poa.entity.Topic;

public interface TopicDao extends BaseDao<Topic,Integer>{

	List<Topic> findByForum(Forum forum);

}
