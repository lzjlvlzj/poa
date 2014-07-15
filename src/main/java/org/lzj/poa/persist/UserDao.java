package org.lzj.poa.persist;

import org.lzj.poa.entity.User;


public interface UserDao extends BaseDao<User, Integer>{

	User findUserByName(User user);

}
