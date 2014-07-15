package org.lzj.poa.web.Interceptor;


import org.lzj.poa.common.Contants;
import org.lzj.poa.entity.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author lzj
 * <p>
 *	权限拦截器
 */
public class Authorityterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 4889835656157722566L;
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		
		//通过ActionContext来获取httpRequest
		//HttpServletRequest request = (HttpServletRequest)ctx.get(StrutsStatics.HTTP_REQUEST);
		
		//也可以通过ServletActionContext来获取httpRequest
		//HttpServletRequest request = ServletActionContext.getRequest();
		//取得用户
		User user = (User)ActionContext.getContext().getSession().get(Contants.SESSION_USER);
		//取得请求的url
		//只拦截action
		String namespace = invocation.getProxy().getNamespace();
		String actionName = invocation.getProxy().getActionName();
		String currentURL = namespace + actionName; // 对应的权限URL
		
		currentURL = currentURL.substring(1);
		/*//放行 登陆
		if(currentURL.startsWith(Contants.LOGIN_URL)){
			return invocation.invoke();
		}
		if(currentURL.startsWith("user_active")){
			return invocation.invoke();
		}*/
		//未登录
		if(null == user){
			if(currentURL.startsWith(Contants.LOGIN_URL)){
				return invocation.invoke();
			}
			return "loginUI";
		}else{
			//检查是否激活
			int status = user.getStatus();
			if(status == 1){
				return "activeUI";
			}
			if(currentURL.startsWith("home_")){
				return invocation.invoke();
			}
			//验证权限
			boolean hasAuthority = user.hasPrivilegeByUrl(currentURL);
			//invocation.
			if(hasAuthority){
				return invocation.invoke();
			}else{
				return "noPrivilegeError";
			}
		}
		
	}



}
