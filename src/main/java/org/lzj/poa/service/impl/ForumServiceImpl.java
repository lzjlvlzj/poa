package org.lzj.poa.service.impl;

import java.util.List;

import org.lzj.poa.entity.Forum;
import org.lzj.poa.persist.ForumDao;
import org.lzj.poa.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForumServiceImpl implements ForumService {
	
	@Autowired
	private ForumDao forumDaoImpl;
	
	public List<Forum> findAll() {
		List<Forum> list = forumDaoImpl.findAll();
		return list;
	}

	public Forum getById(Integer forumId) {
		Forum forum = forumDaoImpl.findById(forumId);
		return forum;
	}

}
