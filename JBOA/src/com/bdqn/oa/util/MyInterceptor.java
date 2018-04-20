package com.bdqn.oa.util;

import java.util.Map;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("½øÈëÀ¹½ØÆ÷-----");
		
		Map<String,Object> session=invocation.getInvocationContext().getSession();
		
		if(session.get("User")==null) {
			return "404";
		}else{
			System.out.println("³ö-----");
			return invocation.invoke();
		}
		
	
	}
	
}
