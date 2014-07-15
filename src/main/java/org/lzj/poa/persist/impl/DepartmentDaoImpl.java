package org.lzj.poa.persist.impl;


import java.util.List;

import org.hibernate.Query;
import org.lzj.poa.entity.Department;
import org.lzj.poa.persist.DepartmentDao;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class DepartmentDaoImpl extends BaseDaoImpl<Department, Integer> implements
		DepartmentDao {

	public List<Department> findSub(Department parent) {
		String hql = "";
		Query q = null;
		if(null == parent){
			hql = "FROM Department d WHERE d.parent IS NULL";
			q = getSession().createQuery(hql);
		}else{
			hql = "FROM Department d WHERE d.parent.id=?";
			q = getSession().createQuery(hql);
			q.setParameter(0, parent.getDeptId());
		}
		List<Department> list= q.list();
		return list;
	}


}
