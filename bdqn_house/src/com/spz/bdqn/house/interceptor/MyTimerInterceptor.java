package com.spz.bdqn.house.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class MyTimerInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//1��ִ��Action֮ǰ�Ĺ�������ȡ��ʼִ��ʱ��
		long startTime = System.currentTimeMillis();
		System.out.println("ִ��Action֮ǰ�Ĺ�������ʼʱ��" + startTime);
		//2�� ִ�к�����������ACtion
		String result = invocation.invoke();
		//3��ִ��Action֮��Ĺ��������㲢���ִ��ʱ��
		long endTime = System.currentTimeMillis();
		long execTime = endTime - startTime;
		System.out.println("ִ��Action��ģ�����ʱ��" + endTime);
		System.out.println("�ܹ���ʱ" + execTime);
		//���ؽ���ַ���
		return result;
	}
}
