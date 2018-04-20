package com.bdqn.oa.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bdqn.oa.dao.ILeaveDao;
import com.bdqn.oa.entity.SysLeave;
import com.bdqn.oa.util.Paging;

/**
 * @描述 Dao层请假实现类
 * @作者 施鹏振
 * @创建日期 2017年12月26日
 * @创建时间 下午2:34:54
 */
public class LeaveDaoImpl extends HibernateDaoSupport implements ILeaveDao {

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bdqn.oa.dao.leave.ILeaveDao#saveOrUpdateLeave(com.bdqn.oa.entity.
	 * SysLeave)
	 */
	@Override
	public boolean saveOrUpdateLeave(SysLeave leave) {
		boolean b = true;
		try {
			getHibernateTemplate().save(leave);
		} catch (Exception e) {
			e.printStackTrace();
			b = false;
		}
		return b;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bdqn.oa.dao.leave.ILeaveDao#findLeaveCount(com.bdqn.oa.entity.
	 * SysLeave)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Integer findLeaveCount(SysLeave leave) {
		Session session = getSessionFactory().getCurrentSession();
		StringBuilder hql = new StringBuilder("select count(id) from SysLeave lve where 1=1");
		if (leave.getSysEmployeeByProposerEid() != null) {
			if (leave.getSysEmployeeByProposerEid().getEid() != null) {
				hql.append(" and lve.sysEmployeeByProposerEid =:sysEmployeeByProposerEid");
			}
		}
		if (leave.getSysEmployeeByExecutorEid() != null) {
			if (leave.getSysEmployeeByExecutorEid().getEid() != null) {
				hql.append(" and lve.sysEmployeeByExecutorEid =:sysEmployeeByExecutorEid");
			}
		}
		if (leave.getStatus() != null && !leave.getStatus().equals("")) {
			hql.append(" and lve.status=:status");
		}
		if (leave.getBegindate() != null) {
			hql.append(" and lve.begindate>=:begindate");
		}
		if (leave.getClosuredate() != null) {
			hql.append(" and lve.closuredate<=:closuredate");
		}
		// 第一种方法：
		// Long long1 = (Long)
		// getHibernateTemplate().find(hql.toString(),objects).listIterator().next();

		// 第二种方法：
		// Object[] objects={4,"新创建",new Date()};
		// Long long1 = (Long) getHibernateTemplate().iterate(hql.toString(),
		// objects).next();

		// 第三种方法：
		System.out.println(hql);
		Query query = session.createQuery(hql.toString());
		query.setProperties(leave);
		
		Long l=(Long) query.uniqueResult();
		
		return l.intValue();
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bdqn.oa.dao.leave.ILeaveDao#findLeavesByPaging(com.bdqn.oa.util.
	 * Paging)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SysLeave> findLeavesByPaging(Paging<SysLeave> paging) {
		SysLeave leave = paging.getT();
		Session session = getSessionFactory().getCurrentSession();
		StringBuilder hql = new StringBuilder("from SysLeave lve where 1=1");
		if (leave.getSysEmployeeByProposerEid() != null) {
			if (leave.getSysEmployeeByProposerEid().getEid() != null) {
				hql.append(" and lve.sysEmployeeByProposerEid =:sysEmployeeByProposerEid");
			}
		}
		if (leave.getSysEmployeeByExecutorEid() != null) {
			if (leave.getSysEmployeeByExecutorEid().getEid() != null) {
				hql.append(" and lve.sysEmployeeByExecutorEid =:sysEmployeeByExecutorEid");
			}
		}
		if (leave.getStatus() != null && !leave.getStatus().equals("")) {
			hql.append(" and lve.status=:status");
		}
		if (leave.getBegindate() != null) {
			hql.append(" and lve.begindate>=:begindate");
		}
		if (leave.getClosuredate() != null) {
			hql.append(" and lve.closuredate<=:closuredate");
		}
		hql.append(" order by lve.begindate desc");
		System.out.println(hql);
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(paging.getPageNo()).setMaxResults(paging.getPageSize());
		query.setProperties(leave);
		return query.list();

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bdqn.oa.dao.leave.ILeaveDao#findEmployee(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object[] findEmployeeIsDepartmentManager(Integer departmentId) {
		String hql = "select eid,ename from SysEmployee emp where emp.sysPosition.pid=2 and emp.sysDepartment.did=?";
		Iterator<Object[]> iterator = (Iterator<Object[]>) getHibernateTemplate().iterate(hql, departmentId);
		return iterator.next();
	}

	/* （非 Javadoc）
	 * @see com.bdqn.oa.dao.leave.ILeaveDao#findLeaveInformation(java.lang.Integer)
	 */
	@Override
	public SysLeave findLeaveInformation(Integer leaveId) {
		return getHibernateTemplate().load(SysLeave.class,leaveId);
	}
}
