package org.lzj.poa.persist;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T extends Object, PK extends Serializable> {
	/**
	 * 保存实体
	 * 
	 * @param entity
	 */
	public void save(T entity);

	/**
	 * 修改实体
	 * 
	 * @param entity
	 */
	public void update(T entity);

	/**
	 * 根据id删除
	 * 
	 * @param k
	 */
	public void deleteById(PK k);

	/**
	 *  根据实体删除
	 * 
	 * @param entity
	 */
	public void delete(T entity);

	/**
	 * 根据id查找
	 * 
	 * @param k
	 * @return T
	 */
	public T findById(PK k);
	/**
	 * 按id查询
	 * 
	 * @param ids
	 * @return List<T>
	 */
	List<T> getByIds(PK[] ids);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<T> findAll();
	


}
