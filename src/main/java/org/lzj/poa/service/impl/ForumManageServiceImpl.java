package org.lzj.poa.service.impl;

import java.util.List;

import org.lzj.poa.entity.Forum;
import org.lzj.poa.persist.ForumManageDao;
import org.lzj.poa.service.ForumManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForumManageServiceImpl implements ForumManageService {
	@Autowired
	ForumManageDao forumManageDaoImpl;
	
	public List<Forum> findAll() {
		
		return forumManageDaoImpl.findAll();
	}

	public void save(Forum forum) {
		forumManageDaoImpl.save(forum);
	}

	public void update(Forum forum) {
		
		forumManageDaoImpl.update(forum);
	}

	public Forum findById(Integer forumId) {
		
		return forumManageDaoImpl.findById(forumId);
	}

	public void delete(Forum forum) {
		
		forumManageDaoImpl.delete(forum);
	}

}
