package com.bdqn.oa.service;

import com.bdqn.oa.entity.BizCheckResult;
import com.bdqn.oa.entity.BizClaimVoucher;

/**
 * ���������
 * @author lizhen
 */
public interface IBizCheckResultService {
	
	//�������ı�����--id
	BizCheckResult getCrbyid(BizClaimVoucher cv);
}
