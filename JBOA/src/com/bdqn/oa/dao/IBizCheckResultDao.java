package com.bdqn.oa.dao;

import com.bdqn.oa.entity.BizCheckResult;
import com.bdqn.oa.entity.BizClaimVoucher;

//����
public interface IBizCheckResultDao {
	
	/**
	 * 	ͨ�����յ���ѯ���µ� �������
	 * @param id
	 * @return
	 */
	BizCheckResult findCRById(BizClaimVoucher cv);
}
