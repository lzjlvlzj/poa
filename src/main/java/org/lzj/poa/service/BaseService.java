package org.lzj.poa.service;

import java.io.Serializable;
import java.util.List;


public interface BaseService <T extends Object, PK extends Serializable> {
	
	List<T> findAll();

	void save(T t);

	T findById(PK userId);

	void update(T t);

	void delete(T t);
}
