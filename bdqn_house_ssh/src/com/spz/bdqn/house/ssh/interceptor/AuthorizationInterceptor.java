package com.spz.bdqn.house.ssh.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.spz.bdqn.house.ssh.entity.User;

@SuppressWarnings("serial")
public class AuthorizationInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session=invocation.getInvocationContext().getSession();
		User user=(User)session.get("user");
		if(user==null){
			System.out.println("null");
			return Action.LOGIN;
		}else{
			System.out.println("not null");
			return invocation.invoke();
		}
	}
}
