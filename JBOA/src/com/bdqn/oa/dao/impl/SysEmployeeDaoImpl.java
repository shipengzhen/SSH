package com.bdqn.oa.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bdqn.oa.dao.ISysEmployeeDao_z;
import com.bdqn.oa.entity.SysDepartment;
import com.bdqn.oa.entity.SysEmployee;
import com.bdqn.oa.entity.SysPosition;

public class SysEmployeeDaoImpl extends HibernateDaoSupport implements ISysEmployeeDao_z {

	//登录
	@Override
	public SysEmployee findempByPwd(String ename, String epassword) {
		String str="from SysEmployee emp where emp.ename=? and emp.epassword=?";
		
		Query query=this.getSessionFactory().getCurrentSession().createQuery(str);	
		query.setParameter(0, ename).setParameter(1, epassword);
		
		return (SysEmployee) query.uniqueResult();
	}
	
	//当前用户的部门经理
	@Override
	public SysEmployee findempJl(SysEmployee emp) {
		
		SysPosition bm=new SysPosition(2,"部门经理");		//部门经理对象
		
		String hql="from SysEmployee emp where emp.sysDepartment=? and emp.sysPosition=?";
		Query query=this.getSessionFactory().getCurrentSession().createQuery(hql);
		query.setParameter(0, emp.getSysDepartment()).setParameter(1, bm);
		
		return (SysEmployee) query.uniqueResult();
	}

}
