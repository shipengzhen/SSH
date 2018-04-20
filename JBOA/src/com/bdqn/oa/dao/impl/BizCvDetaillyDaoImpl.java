package com.bdqn.oa.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bdqn.oa.dao.IBizCvDetaillyDao;
import com.bdqn.oa.entity.BizClaimVoucher;
import com.bdqn.oa.entity.BizCvDetailly;

public class BizCvDetaillyDaoImpl extends HibernateDaoSupport implements IBizCvDetaillyDao {

	//新增报销单明细表
	@Override
	public void saveCvd(List<BizCvDetailly> cvdList) {
		
		this.getHibernateTemplate().saveOrUpdateAll(cvdList);

	}
	//报销单id查询 明细
	@Override
	public List<BizCvDetailly> findAllBybid(BizClaimVoucher cv) {
		
		return this.getHibernateTemplate().find("from BizCvDetailly cd where cd.bizClaimVoucher=?", cv);
	}
	//通过id删除
	@Override
	public void deleteById(Integer id) {
		System.out.println(id);
		System.out.println("ddddd");
		BizCvDetailly cd=this.getHibernateTemplate().get(BizCvDetailly.class, id);
		
		this.getHibernateTemplate().delete(cd);
	}
	
}
