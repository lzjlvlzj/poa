package org.lzj.poa.service.impl;

import java.io.Serializable;
import java.util.List;

import org.lzj.poa.service.BaseService;
/**
 * 有待研究
 * 
 * */
public class BaseServiceImpl<T extends Object, PK extends Serializable> implements BaseService<T, PK> {

	public List<T> findAll() {
		return null;
	}

	public void save(T t) {
		
	}

	public T findById(PK userId) {
		return null;
	}

	public void update(T t) {
		
	}

	public void delete(T t) {
		
	}

}
