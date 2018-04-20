package com.bdqn.oa.dao.impl;

import java.util.Date;
import java.util.List;

import oracle.net.aso.p;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.context.CurrentSessionContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bdqn.oa.dao.IClaimVoucherDao_w;
import com.bdqn.oa.entity.BizCheckResult;
import com.bdqn.oa.entity.BizClaimVoucher;
import com.bdqn.oa.entity.BizCvDetailly;
import com.bdqn.oa.entity.SysEmployee;
import com.bdqn.oa.util.Paging;
/**
 * ����������
 * @author �����
 *
 */
public class ClaimVoucherImpl_w extends HibernateDaoSupport implements IClaimVoucherDao_w {
	//��ѯȫ��������
	@Override
	public List<BizClaimVoucher> findAllVoucher(SysEmployee emp,Paging<BizClaimVoucher> voucher) {
		
		System.out.println(voucher.getT().getBegindate());
		System.out.println(voucher.getT().getStatus()+"-------------");
		
		System.out.println("��ѯ");
		Session session=getSessionFactory().getCurrentSession();
		//��̬hql
		StringBuffer hql=new StringBuffer("from BizClaimVoucher where 1=1");
		if(voucher.getT().getBegindate()!= null){
			hql.append(" and begindate >=:begindate");
		}
		if(voucher.getT().getFinishdate() != null){
			hql.append(" and finishdate <=:finishdate");
		}
		if(voucher.getT().getStatus()!= null){
			if(!voucher.getT().getStatus().equals("")){
				hql.append(" and status =:status");
			}
			
		}
		hql.append(" and sysEmployeeByExecutorEid =:emp  order by id desc");
		//��ҳ
		Query query=session.createQuery(hql.toString());
		query.setFirstResult(voucher.getPageNo());//��ǰҳ��һ����ҳ��С
		query.setMaxResults(voucher.getPageSize());//ҳ��С
		
		query.setParameter("emp", emp);
		query.setProperties(voucher.getT());//ֱ�ӽ�����ֵ
		return query.list();
	}

	//��ѯ������
	@Override
	public int count(SysEmployee emp,Paging<BizClaimVoucher> voucher) {
		Session session=getSessionFactory().getCurrentSession();
		StringBuffer hql=new StringBuffer("select count(id) from BizClaimVoucher where 1=1");
		if(voucher.getT().getBegindate()!= null){
			hql.append(" and begindate >=:begindate");
		}
		if(voucher.getT().getFinishdate() != null){
			hql.append(" and finishdate <=:finishdate");
		}
		if(voucher.getT().getStatus() != null){
			if(!voucher.getT().getStatus().equals("")){
				hql.append(" and status =:status");
			}
		}
		hql.append(" and sysEmployeeByExecutorEid =:emp");
		Query query=session.createQuery(hql.toString());
		
		query.setParameter("emp", emp);
		Long count=(Long)query.setProperties(voucher.getT()).uniqueResult();//���и�ֵ�����ڲ�ѯ���֮ǰ
		
		return count.intValue();
		 
	}

	
	//��id��ѯ������
	@Override
	public BizClaimVoucher findVoucherById(int id) {
		System.out.println("impl");
		
		return this.getHibernateTemplate().get(BizClaimVoucher.class, id);
	}

	//��ѯ��������ϸ
	@Override
	public List<BizCvDetailly> findCvList(int id) {
		
		Session session=getSessionFactory().getCurrentSession();
		String hql="from BizCvDetailly cd where cd.bizClaimVoucher.id =:id";
		Query query=session.createQuery(hql);
		query.setParameter("id", id);
		return query.list();
	}

	
	//���������Ϣ
	@Override
	public void saveCheck(BizCheckResult checkResult) {
		System.out.println(checkResult.getResult());
		
		//��ȡ������
		BizClaimVoucher cv=this.getHibernateTemplate().load(BizClaimVoucher.class, checkResult.getBizClaimVoucher().getId());
		//������
		SysEmployee emp=this.getHibernateTemplate().get(SysEmployee.class,checkResult.getSysEmployee().getEid());
		String ename=emp.getSysPosition().getPname();
		
		String Result=checkResult.getResult();									//��˽��
		
		if(ename.equals("���ž���")){
			if(Result.equals("ͨ��")){
				if(cv.getMoeny()>=2000){	//�ܾ���
					cv.setSysEmployeeByExecutorEid(this.getHibernateTemplate().get(SysEmployee.class,1));//��������
					cv.setStatus("������");
				}else{
					cv.setStatus("������");								//����
					cv.setSysEmployeeByExecutorEid(this.getHibernateTemplate().get(SysEmployee.class,3));//��������
				}
			}else if(Result.equals("�ܾ�")){
				cv.setStatus("����ֹ");
				cv.setSysEmployeeByExecutorEid(null);									//�������Ϊnull
			}else if(Result.equals("���")){
				cv.setStatus("�Ѵ��");													//�Ѵ��
				cv.setSysEmployeeByExecutorEid(cv.getSysEmployeeByProposerEid());		//��������Ϊ�Լ�
			}
		}else if(ename.equals("�ܾ���")){
			
			if(Result.equals("ͨ��")){
				cv.setStatus("������");								//����
				cv.setSysEmployeeByExecutorEid(this.getHibernateTemplate().get(SysEmployee.class,3));//��������Ϊ����
			}else if(Result.equals("�ܾ�")){
				cv.setStatus("����ֹ");
				cv.setSysEmployeeByExecutorEid(null);									//�������Ϊnull
			}else if(Result.equals("���")){
				cv.setStatus("�Ѵ��");													//�Ѵ��
				cv.setSysEmployeeByExecutorEid(cv.getSysEmployeeByProposerEid());		//��������Ϊ�Լ�
			}
			
		}else if(ename.equals("����")){
			
			if(Result.equals("ͨ��")){
				cv.setStatus("�Ѹ���");													//����
				cv.setSysEmployeeByExecutorEid(null);									//��������Ϊnull
			}
		}
		cv.setFinishdate(new Date());							//����ʱ��
		
		this.getHibernateTemplate().save(checkResult);			//������˱�������
	
	}
}
