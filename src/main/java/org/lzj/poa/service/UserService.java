package org.lzj.poa.service;

import java.util.List;

import org.lzj.poa.entity.User;

public interface UserService {

	List<User> findAll();

	void save(User model);

	User findById(Integer userId);

	void update(User user);

	void delete(User model);

	User findUserByName(User user);

	void sendEmail(User user);

}
