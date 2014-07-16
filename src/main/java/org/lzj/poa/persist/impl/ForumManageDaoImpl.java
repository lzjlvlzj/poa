package org.lzj.poa.persist.impl;


import java.util.List;

import org.hibernate.Query;
import org.lzj.poa.entity.Forum;
import org.lzj.poa.persist.ForumManageDao;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class ForumManageDaoImpl extends BaseDaoImpl<Forum, Integer>implements ForumManageDao {

	@Override
	public List<Forum> findAll() {
		String hql = "FROM Forum f ORDER BY f.position";
		Query q = null;
		q = getSession().createQuery(hql);
		List<Forum> list = q.list();
		return list;
	}

}
