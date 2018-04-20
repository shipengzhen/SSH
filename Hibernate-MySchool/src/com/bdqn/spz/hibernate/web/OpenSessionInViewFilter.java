
package com.bdqn.spz.hibernate.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import com.bdqn.spz.hibernate.util.HibernateUtil;

public class OpenSessionInViewFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		Transaction tx = null;
		try {
			// ���󵽴�ʱ����Session����������
			tx = HibernateUtil.currentSession().beginTransaction();
			// ִ����������
			filterChain.doFilter(request, response);
			// ������Ӧʱ���ύ����
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback(); // �ع�����
		}
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
}
