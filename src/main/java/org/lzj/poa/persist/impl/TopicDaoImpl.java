package org.lzj.poa.persist.impl;

import java.util.List;

import org.hibernate.Query;
import org.lzj.poa.entity.Forum;
import org.lzj.poa.entity.Topic;
import org.lzj.poa.persist.TopicDao;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public class TopicDaoImpl extends BaseDaoImpl<Topic, Integer> implements TopicDao {

	public List<Topic> findByForum(Forum forum) {
		String hql = "FROM Topic t WHERE t.forum=? "
				+ "ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC, "
				+ "t.lastUpdateTime DESC";
		Query q = null;
		q = getSession().createQuery(hql);
		q.setParameter(0, forum);
		List<Topic> list = q.list();
		return  list;
	}

}
