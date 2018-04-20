package com.bdqn.oa.dao.impl;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bdqn.oa.dao.IBizCheckResultDao;
import com.bdqn.oa.entity.BizCheckResult;
import com.bdqn.oa.entity.BizClaimVoucher;

public class BizCheckResultDaoImpl extends HibernateDaoSupport implements IBizCheckResultDao {

	//通过报销单查询最新的 审批结果
	@Override
	public BizCheckResult findCRById(BizClaimVoucher cv) {
		
		System.out.println("------------");
		
		String hql="from BizCheckResult cr where cr.bizClaimVoucher=? and cr.checkDate = (select max(cr2.checkDate) from BizCheckResult cr2 )";
		//from Emp where sal<(select avg(e.sal) from Emp e) order by sal desc
		Query query=this.getSessionFactory().getCurrentSession().createQuery(hql);
		query.setParameter(0, cv);
		
		
		return (BizCheckResult) query.uniqueResult();
	}

}
