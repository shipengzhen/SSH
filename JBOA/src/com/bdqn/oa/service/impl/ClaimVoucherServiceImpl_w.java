package com.bdqn.oa.service.impl;

import java.util.List;

import com.bdqn.oa.dao.IClaimVoucherDao_w;
import com.bdqn.oa.entity.BizCheckResult;
import com.bdqn.oa.entity.BizClaimVoucher;
import com.bdqn.oa.entity.BizCvDetailly;
import com.bdqn.oa.entity.SysEmployee;
import com.bdqn.oa.service.ClaimVoucherService_w;
import com.bdqn.oa.util.Paging;
/**
 * 报销单业务逻辑层
 * @author 张婉君
 *
 */
public class ClaimVoucherServiceImpl_w implements ClaimVoucherService_w {
	IClaimVoucherDao_w vouDao;
	public IClaimVoucherDao_w getVouDao() {
		return vouDao;
	}
	public void setVouDao(IClaimVoucherDao_w vouDao) {
		this.vouDao = vouDao;
	}
	//查询报销单
	@Override
	public List<BizClaimVoucher> getFingVouByVou(SysEmployee emp,Paging<BizClaimVoucher> voucher) {
		
		return vouDao.findAllVoucher(emp, voucher);
	}
	//查询总数据
	@Override
	public int getCount(SysEmployee emp,Paging<BizClaimVoucher> voucher) {
		
		return vouDao.count(emp, voucher);
	}
	//按id查询报销单
	@Override
	public BizClaimVoucher getFindVouById(int id) {
		return vouDao.findVoucherById(id);
	}
	//查询报销单明细
	@Override
	public List<BizCvDetailly> getFindAllByVouId(int id) {
		
		return vouDao.findCvList(id);
	}
	//新增审核信息
	@Override
	public void saveCheckResult(BizCheckResult checkResult) {
		
		vouDao.saveCheck(checkResult);
	}
}
