package com.bdqn.oa.service;

import java.util.List;

import com.bdqn.oa.entity.BizCheckResult;
import com.bdqn.oa.entity.BizClaimVoucher;
import com.bdqn.oa.entity.BizCvDetailly;
import com.bdqn.oa.entity.SysEmployee;
import com.bdqn.oa.util.Paging;

public interface ClaimVoucherService_w {
	//查询报销单
	List<BizClaimVoucher> getFingVouByVou(SysEmployee emp,Paging<BizClaimVoucher> voucher);
	//查询总数据
	int getCount(SysEmployee emp,Paging<BizClaimVoucher> voucher);
	//按id查询报销单
	BizClaimVoucher getFindVouById(int id);
	//查询明细报销单
	List<BizCvDetailly> getFindAllByVouId(int id);
	//新增审核
	void saveCheckResult(BizCheckResult checkResult);
}
