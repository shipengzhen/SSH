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
 * 报销单管理
 * @author 张婉君
 *
 */
public class ClaimVoucherImpl_w extends HibernateDaoSupport implements IClaimVoucherDao_w {
	//查询全部报销单
	@Override
	public List<BizClaimVoucher> findAllVoucher(SysEmployee emp,Paging<BizClaimVoucher> voucher) {
		
		System.out.println(voucher.getT().getBegindate());
		System.out.println(voucher.getT().getStatus()+"-------------");
		
		System.out.println("查询");
		Session session=getSessionFactory().getCurrentSession();
		//动态hql
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
		//分页
		Query query=session.createQuery(hql.toString());
		query.setFirstResult(voucher.getPageNo());//当前页减一乘以页大小
		query.setMaxResults(voucher.getPageSize());//页大小
		
		query.setParameter("emp", emp);
		query.setProperties(voucher.getT());//直接将对象赋值
		return query.list();
	}

	//查询总数据
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
		Long count=(Long)query.setProperties(voucher.getT()).uniqueResult();//所有赋值都放在查询语句之前
		
		return count.intValue();
		 
	}

	
	//按id查询报销单
	@Override
	public BizClaimVoucher findVoucherById(int id) {
		System.out.println("impl");
		
		return this.getHibernateTemplate().get(BizClaimVoucher.class, id);
	}

	//查询报销单明细
	@Override
	public List<BizCvDetailly> findCvList(int id) {
		
		Session session=getSessionFactory().getCurrentSession();
		String hql="from BizCvDetailly cd where cd.bizClaimVoucher.id =:id";
		Query query=session.createQuery(hql);
		query.setParameter("id", id);
		return query.list();
	}

	
	//新增审核信息
	@Override
	public void saveCheck(BizCheckResult checkResult) {
		System.out.println(checkResult.getResult());
		
		//获取报销单
		BizClaimVoucher cv=this.getHibernateTemplate().load(BizClaimVoucher.class, checkResult.getBizClaimVoucher().getId());
		//处理人
		SysEmployee emp=this.getHibernateTemplate().get(SysEmployee.class,checkResult.getSysEmployee().getEid());
		String ename=emp.getSysPosition().getPname();
		
		String Result=checkResult.getResult();									//审核结果
		
		if(ename.equals("部门经理")){
			if(Result.equals("通过")){
				if(cv.getMoeny()>=2000){	//总经理
					cv.setSysEmployeeByExecutorEid(this.getHibernateTemplate().get(SysEmployee.class,1));//待处理人
					cv.setStatus("待审批");
				}else{
					cv.setStatus("已审批");								//财务
					cv.setSysEmployeeByExecutorEid(this.getHibernateTemplate().get(SysEmployee.class,3));//待处理人
				}
			}else if(Result.equals("拒绝")){
				cv.setStatus("已终止");
				cv.setSysEmployeeByExecutorEid(null);									//待审核人为null
			}else if(Result.equals("打回")){
				cv.setStatus("已打回");													//已打回
				cv.setSysEmployeeByExecutorEid(cv.getSysEmployeeByProposerEid());		//待处理人为自己
			}
		}else if(ename.equals("总经理")){
			
			if(Result.equals("通过")){
				cv.setStatus("已审批");								//财务
				cv.setSysEmployeeByExecutorEid(this.getHibernateTemplate().get(SysEmployee.class,3));//待处理人为财务
			}else if(Result.equals("拒绝")){
				cv.setStatus("已终止");
				cv.setSysEmployeeByExecutorEid(null);									//待审核人为null
			}else if(Result.equals("打回")){
				cv.setStatus("已打回");													//已打回
				cv.setSysEmployeeByExecutorEid(cv.getSysEmployeeByProposerEid());		//待处理人为自己
			}
			
		}else if(ename.equals("财务")){
			
			if(Result.equals("通过")){
				cv.setStatus("已付款");													//财务
				cv.setSysEmployeeByExecutorEid(null);									//待处理人为null
			}
		}
		cv.setFinishdate(new Date());							//结束时间
		
		this.getHibernateTemplate().save(checkResult);			//保存审核报销单表
	
	}
}
