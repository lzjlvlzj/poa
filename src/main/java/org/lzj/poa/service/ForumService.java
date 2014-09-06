package org.lzj.poa.service;

import java.util.List;

import org.lzj.poa.entity.Forum;

public interface ForumService {

	List<Forum> findAll();

	Forum getById(Integer forumId);

}
