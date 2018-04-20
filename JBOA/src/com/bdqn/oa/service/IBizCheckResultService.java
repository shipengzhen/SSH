package com.bdqn.oa.service;

import com.bdqn.oa.entity.BizCheckResult;
import com.bdqn.oa.entity.BizClaimVoucher;

/**
 * 报销单审核
 * @author lizhen
 */
public interface IBizCheckResultService {
	
	//查新增的报销单--id
	BizCheckResult getCrbyid(BizClaimVoucher cv);
}
