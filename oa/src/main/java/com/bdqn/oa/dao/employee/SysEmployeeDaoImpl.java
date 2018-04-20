package com.bdqn.oa.dao.employee;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.bdqn.oa.entity.SysEmployee;

public class SysEmployeeDaoImpl extends HibernateDaoSupport implements ISysEmployeeDao_z {

	//��¼
	@SuppressWarnings("unchecked")
	@Override
	public SysEmployee findempByPwd(String ename, String epassword) {
		String hql="from SysEmployee emp where emp.ename=? and emp.epassword=?";
		Session session = getSessionFactory().getCurrentSession();
		//Transaction transaction = session.beginTransaction();
		Query<SysEmployee> query=session.createQuery(hql);	
		query.setParameter(0, ename).setParameter(1, epassword);
		SysEmployee employee=query.uniqueResult();
		//transaction.commit();
		return employee;
	}

}
