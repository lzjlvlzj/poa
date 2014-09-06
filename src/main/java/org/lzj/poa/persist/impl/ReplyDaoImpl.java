package org.lzj.poa.persist.impl;

import java.util.List;

import org.hibernate.Query;
import org.lzj.poa.entity.Reply;
import org.lzj.poa.entity.Topic;
import org.lzj.poa.persist.ReplyDao;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public class ReplyDaoImpl extends BaseDaoImpl<Reply, Integer> implements ReplyDao{

	public List<Reply> findByTopic(Topic topic) {
		
		String hql = "FROM Reply r WHERE r.topic = ? ORDER BY r.postTime ASC";
		Query q = null;
		q = getSession().createQuery(hql);
		q.setParameter(0, topic);
		List<Reply> list = q.list();
		return list;
	}
	
}
