package org.lzj.poa.persist.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.lzj.poa.entity.Privilege;
import org.lzj.poa.persist.PrivilegeDao;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege,Integer> implements PrivilegeDao{

	public List<Privilege> findTopPrivilegeList() {
		
		String hql = "";
		Query q = null;
		hql = "FROM Privilege p WHERE p.parent IS NULL";
		q = getSession().createQuery(hql);
		List<Privilege> list= q.list();
		return list;
	}

	public Collection<String> findAllPrivilegeUrls() {
		String hql = "";
		Query q = null;
		hql = "SELECT DISTINCT p.url FROM Privilege p WHERE p.url IS NOT NULL";
		q = getSession().createQuery(hql);
		Collection<String> c = q.list();
		return c;
	}

}
