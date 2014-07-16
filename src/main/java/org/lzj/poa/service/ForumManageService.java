package org.lzj.poa.service;

import java.util.List;

import org.lzj.poa.entity.Forum;

public interface ForumManageService {

	List<Forum> findAll();

	void save(Forum model);

	void update(Forum forum);

	Forum findById(Integer forumId);

	void delete(Forum model);

}
