package com.bdqn.oa.service.impl;

import java.util.Date;
import java.util.List;

import com.bdqn.oa.dao.IBizClaimVoucherDao_z;
import com.bdqn.oa.dao.ISysEmployeeDao_z;
import com.bdqn.oa.entity.BizClaimVoucher;
import com.bdqn.oa.entity.SysEmployee;
import com.bdqn.oa.service.IBizClaimVoucherService;
import com.bdqn.oa.util.Paging;

public class BizClaimVoucherServiceImpl implements IBizClaimVoucherService {

	private IBizClaimVoucherDao_z bizClaimVoucherDao_z;
	
	private ISysEmployeeDao_z sysEmployeeDao_z;
	
	

	//修改
	@Override
	public void updateCVD(BizClaimVoucher cv) {
		
		bizClaimVoucherDao_z.updateCvd(cv);
	}

	
	//通过id查询
	@Override
	public BizClaimVoucher findbycv(Integer id) {
		
		return bizClaimVoucherDao_z.findCvById(id);
	}
	
	//新增报销单
	@Override
	public void addCv(BizClaimVoucher cv) {
		
		String struts=cv.getStatus();
		
		if(struts.equals("新创建")){
			cv.setSysEmployeeByExecutorEid(cv.getSysEmployeeByProposerEid());//处理人为自己
		}else{
			cv.setSysEmployeeByExecutorEid(sysEmployeeDao_z.findempJl(cv.getSysEmployeeByProposerEid()));//处理人
		}
		cv.setBegindate(new Date());
		bizClaimVoucherDao_z.saveCv(cv);
	}
	//分页查询
	@Override
	public List<BizClaimVoucher> findCvfy(Paging<BizClaimVoucher> cv,SysEmployee emp) {

		cv.setTotalCount(bizClaimVoucherDao_z.findCount(cv.getT(),emp));
		
		return bizClaimVoucherDao_z.findAllCv(cv,emp);
	}

	public IBizClaimVoucherDao_z getBizClaimVoucherDao_z() {
		return bizClaimVoucherDao_z;
	}
	public void setBizClaimVoucherDao_z(IBizClaimVoucherDao_z bizClaimVoucherDao_z) {
		this.bizClaimVoucherDao_z = bizClaimVoucherDao_z;
	}
	public ISysEmployeeDao_z getSysEmployeeDao_z() {
		return sysEmployeeDao_z;
	}
	public void setSysEmployeeDao_z(ISysEmployeeDao_z sysEmployeeDao_z) {
		this.sysEmployeeDao_z = sysEmployeeDao_z;
	}


	
	
	
}
