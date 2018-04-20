package com.bdqn.oa.dao;

import com.bdqn.oa.entity.BizCheckResult;
import com.bdqn.oa.entity.BizClaimVoucher;

//审批
public interface IBizCheckResultDao {
	
	/**
	 * 	通过保险单查询最新的 审批结果
	 * @param id
	 * @return
	 */
	BizCheckResult findCRById(BizClaimVoucher cv);
}
