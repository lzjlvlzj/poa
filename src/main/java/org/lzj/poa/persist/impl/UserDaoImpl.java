package org.lzj.poa.persist.impl;

import org.hibernate.Query;
import org.lzj.poa.entity.User;
import org.lzj.poa.persist.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {

	public User findUserByName(User user) {
		String hql = "";
		Query q = null;
		if(null == user){
			return null;
		}
		hql = "SELECT u FROM User u WHERE u.loginName = '" + user.getLoginName() + "'";
		q = getSession().createQuery(hql);
		User u = (User)q.uniqueResult();
		return u;
	}

}
