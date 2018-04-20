package com.bdqn.oa.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bdqn.oa.dao.IBizCvDetaillyDao;
import com.bdqn.oa.entity.BizClaimVoucher;
import com.bdqn.oa.entity.BizCvDetailly;

public class BizCvDetaillyDaoImpl extends HibernateDaoSupport implements IBizCvDetaillyDao {

	//������������ϸ��
	@Override
	public void saveCvd(List<BizCvDetailly> cvdList) {
		
		this.getHibernateTemplate().saveOrUpdateAll(cvdList);

	}
	//������id��ѯ ��ϸ
	@Override
	public List<BizCvDetailly> findAllBybid(BizClaimVoucher cv) {
		
		return this.getHibernateTemplate().find("from BizCvDetailly cd where cd.bizClaimVoucher=?", cv);
	}
	//ͨ��idɾ��
	@Override
	public void deleteById(Integer id) {
		System.out.println(id);
		System.out.println("ddddd");
		BizCvDetailly cd=this.getHibernateTemplate().get(BizCvDetailly.class, id);
		
		this.getHibernateTemplate().delete(cd);
	}
	
}
