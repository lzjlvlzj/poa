package org.lzj.poa.init;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lzj.poa.init.Test;
import org.springframework.stereotype.Repository;

import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughSingleCache;
@SuppressWarnings("unchecked")
@Repository
public class TestDaoImpl implements TestDao {

	@Resource 
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@ReadThroughSingleCache(namespace = "test", expiration = 3600)
	public Test findTestById(@ParameterValueKeyProvider Integer id) {
		Session s1 = sessionFactory.getCurrentSession();
		System.out.println("第一次查询User");  
		Query q = s1.createQuery("from Test");  
		q.setCacheable(true);  
		List<Object> list  = q.list();  
		System.out.println("放进缓存");  
		
		
		/*Session s2= sessionFactory.getCurrentSession();  
		System.out.println("第二次查询User,将不会发出sql");  
		Query q1 = s2.createQuery("from Test");  
		q1.setCacheable(true);  
		q1.list();*/
		Object o = list.get(0);
		
		return (Test)o;
	}
	
	public List<Test> findTestList(){
		List<Test> list = null;
		
		return list;
	}

}
