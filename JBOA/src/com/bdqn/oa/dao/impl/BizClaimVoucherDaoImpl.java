package com.bdqn.oa.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bdqn.oa.dao.IBizClaimVoucherDao_z;
import com.bdqn.oa.entity.BizClaimVoucher;
import com.bdqn.oa.entity.BizCvDetailly;
import com.bdqn.oa.entity.SysEmployee;
import com.bdqn.oa.entity.SysPosition;
import com.bdqn.oa.util.Paging;

public class BizClaimVoucherDaoImpl extends HibernateDaoSupport implements IBizClaimVoucherDao_z {

	
	//��ı����� -- ��ϸ
	@Override
	public void updateCvd(BizClaimVoucher cv) {

		BizClaimVoucher cv2=this.getHibernateTemplate().load(BizClaimVoucher.class, cv.getId());		//�����
		String struts=cv.getStatus();
		if(struts.equals("���ύ")){	
			SysEmployee emp=new SysEmployee();
			emp.setEid(2);
			cv2.setSysEmployeeByExecutorEid(emp);
		}
		cv2.setMoeny(cv.getMoeny()); 		//���
		cv2.setStatus(cv.getStatus());		//״̬
		cv2.setEvent(cv.getEvent()); 		//˵��
		cv2.setBizCvDetaillies(null);
		
		Iterator<BizCvDetailly> it=cv.getBizCvDetaillies().iterator();
		while(it.hasNext()){
			BizCvDetailly cd=it.next();
			cd.setBizClaimVoucher(cv2);
		}
		cv2.setBizCvDetaillies(cv.getBizCvDetaillies());
	}
	
	//ͨ��id��ѯ 
	@Override
	public BizClaimVoucher findCvById(Integer id) {
		return this.getHibernateTemplate().load(BizClaimVoucher.class, id);
	}
	
	
	
	//����
	@Override
	public void saveCv(BizClaimVoucher cv) {
		
		this.getHibernateTemplate().save(cv);
	}
	
	//��ѯ ��ҳ

	@Override
	public List<BizClaimVoucher> findAllCv(Paging<BizClaimVoucher> cv,SysEmployee emp) {
		
		StringBuilder bu=new StringBuilder("from BizClaimVoucher cv where 1=1 ");
		if(cv.getT().getStatus()!=null){
			if(!cv.getT().getStatus().equals("")){
				bu.append(" and cv.status=:status ");	
			}	
		}
		if(cv.getT().getBegindate()!=null){
			bu.append(" and cv.begindate>=:begindate ");	
		}
		if(cv.getT().getFinishdate()!=null){
			bu.append(" and cv.finishdate<=:finishdate");
		}
		bu.append(" and cv.sysEmployeeByProposerEid=:emp  order by id desc");
		
		Query query=this.getSessionFactory().getCurrentSession().createQuery(bu.toString());
		
		query.setFirstResult(cv.getPageNo());
		query.setMaxResults(cv.getPageSize());
		query.setParameter("emp", emp);
		query.setProperties(cv.getT());
		
		return query.list();
	}
	
	
	//��¼����
	@Override
	public Integer findCount(BizClaimVoucher cv,SysEmployee emp) {
		StringBuilder bu=new StringBuilder("select count(id) from BizClaimVoucher cv where 1=1 ");
	
		if(cv.getStatus()!=null){
			if(!cv.getStatus().equals("")){
				bu.append(" and cv.status=:status ");	
			}
		}
		if(cv.getBegindate()!=null){
			bu.append(" and cv.begindate>:begindate ");	
		}
		if(cv.getFinishdate()!=null){
			bu.append(" and cv.finishdate<:finishdate ");
		}
		bu.append(" and cv.sysEmployeeByProposerEid=:emp ");
		
		
		Query query=this.getSessionFactory().getCurrentSession().createQuery(bu.toString());
		
		Long count=(Long) query.setProperties(cv).setParameter("emp",emp).uniqueResult();
		
		System.out.println("count:"+count);
		
		return count.intValue();
	}




	



}
