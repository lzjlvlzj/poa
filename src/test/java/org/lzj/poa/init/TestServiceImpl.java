package org.lzj.poa.init;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lzj.poa.entity.Privilege;
import org.lzj.poa.entity.Role;
import org.lzj.poa.entity.User;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

	@Resource 
	private SessionFactory sessionFactory;
	@Resource
	private TestDao testDaoImpl;
	
	public void addTest() {
		
		Session session = sessionFactory.getCurrentSession();
		Test t = new Test();
		t.setName("11");
		Test t1 = new Test();
		t1.setName("22");
		session.save(t);
		//int a = 1 / 0; // 这行会抛异常
		session.save(t1);
	}
	public void find() {
		Session s1 = sessionFactory.getCurrentSession();
		 System.out.println("第一次查询User");  
		 Query q = s1.createQuery("from Test");  
		 q.setCacheable(true);  
		 q.list();  
		 System.out.println("放进二级缓存");  
		 
		 
		 Session s2= sessionFactory.getCurrentSession();  
		 System.out.println("第二次查询User,将不会发出sql");  
		 Query q1 = s2.createQuery("from Test");  
		 q1.setCacheable(true);  
		 q1.list();  
		   
		 //如果配置文件打开了generate_statistics性能调解，可以得到二级缓存命中次数等数据  
		 /*Statistics s = HibernateSessionFactoryUtil.getSessionFactory().getStatistics();  
		 System.out.println(s);  
		 System.out.println("put:"+s.getSecondLevelCachePutCount());  
		 System.out.println("hit:"+s.getSecondLevelCacheHitCount());  
		 System.out.println("miss:"+s.getSecondLevelCacheMissCount());*/
		
	}
	public Test findTestById(Integer id) {
		Test t = testDaoImpl.findTestById(id);
		return t;
	}
	public void addInstaller() {
		Session s = sessionFactory.getCurrentSession();
		
		//添加权限
		Privilege menu,menu1,menu2,menu3,menu4,menu5;
		menu = new Privilege("系统设置",null,null,null);
		menu1 = new Privilege("岗位管理","/role_list",menu,"");
		menu2 = new Privilege("部门管理","/dept_list",menu,"");
		menu3 = new Privilege("用户管理","/user_list",menu,"");
		
		s.save(menu);
		s.save(menu1);
		s.save(menu2);
		s.save(menu3);
		
		s.save(new Privilege("岗位列表","/role_list",menu1,""));
		s.save(new Privilege("岗位添加","/role_add",menu1,""));
		s.save(new Privilege("岗位修改","/role_edit",menu1,""));
		s.save(new Privilege("岗位删除","/role_delete",menu1,""));
		
		s.save(new Privilege("部门列表","/dept_list",menu2,""));
		s.save(new Privilege("部门添加","/dept_add",menu2,""));
		s.save(new Privilege("部门修改","/dept_edit",menu2,""));
		s.save(new Privilege("部门删除","/dept_delete",menu2,""));
		
		s.save(new Privilege("用户列表","/user_list",menu3,""));
		s.save(new Privilege("用户添加","/user_add",menu3,""));
		s.save(new Privilege("用户修改","/user_edit",menu3,""));
		s.save(new Privilege("用户删除","/user_delete",menu3,""));
		
		// --------------------
		menu = new Privilege("网上交流", null, null,null);
		menu1 = new Privilege("论坛管理", "/forumManage_list", menu,"");
		menu2 = new Privilege("论坛", "/forum_list", menu,"");
		s.save(menu);
		s.save(menu1);
		s.save(menu2);

		// --------------------
		menu = new Privilege("审批流转", null, null,null);
		menu1 = new Privilege("审批流程管理", "/processDefinition_list", menu,"");
		menu2 = new Privilege("申请模板管理", "/template_list", menu,"");
		menu3 = new Privilege("起草申请", "/flow_templateList", menu,"");
		menu4 = new Privilege("待我审批", "/flow_myTaskList", menu,"");
		menu5 = new Privilege("我的申请查询", "/flow_myApplicationList", menu,"");
		s.save(menu);
		s.save(menu1);
		s.save(menu2);
		s.save(menu3);
		s.save(menu4);
		s.save(menu5);
		
		//添加岗位
		Role role = new Role();
		role.setRoleName("超级管理员");
		role.setRoleValue("0");
		role.setCreateTime(new Date());
		role.setDescription("系统管理员");
		s.save(role);
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		//添加用户
		User user = new User();
		user.setLoginName("admin");
		user.setUserName("超级管理员");
		user.setPassword("123456");
		user.setStatus(0);
		user.setEmail("1223249224@qq.com");
		user.setRoles(roles);
		s.save(user);
		
		
	}

}
