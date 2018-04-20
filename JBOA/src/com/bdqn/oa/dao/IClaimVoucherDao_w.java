package com.bdqn.oa.dao;

import java.util.List;

import com.bdqn.oa.entity.BizCheckResult;
import com.bdqn.oa.entity.BizClaimVoucher;
import com.bdqn.oa.entity.BizCvDetailly;
import com.bdqn.oa.entity.SysEmployee;
import com.bdqn.oa.util.Paging;

public interface IClaimVoucherDao_w {
	//查询总数据
	int count(SysEmployee emp,Paging<BizClaimVoucher> voucher);
	//查询全部报销单
	List<BizClaimVoucher> findAllVoucher(SysEmployee emp,Paging<BizClaimVoucher> voucher);
	
	//根据id查询报销单
	BizClaimVoucher findVoucherById(int id);
	//查询报销单明细
	List<BizCvDetailly> findCvList(int id);
	
	//新增审核信息
	void saveCheck(BizCheckResult checkResult);
}
