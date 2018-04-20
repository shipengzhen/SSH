package com.bdqn.oa.interceptor;

import java.util.Map;

import com.bdqn.oa.entity.SysEmployee;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class AuthorizationInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		SysEmployee employee = (SysEmployee) session.get("User");
		if (employee == null) {
			System.out.println("null");
			return Action.LOGIN;
		} else {
			System.out.println("not null");
			return invocation.invoke();
		}
	}
}
