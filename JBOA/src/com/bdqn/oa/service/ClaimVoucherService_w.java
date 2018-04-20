package com.bdqn.oa.service;

import java.util.List;

import com.bdqn.oa.entity.BizCheckResult;
import com.bdqn.oa.entity.BizClaimVoucher;
import com.bdqn.oa.entity.BizCvDetailly;
import com.bdqn.oa.entity.SysEmployee;
import com.bdqn.oa.util.Paging;

public interface ClaimVoucherService_w {
	//��ѯ������
	List<BizClaimVoucher> getFingVouByVou(SysEmployee emp,Paging<BizClaimVoucher> voucher);
	//��ѯ������
	int getCount(SysEmployee emp,Paging<BizClaimVoucher> voucher);
	//��id��ѯ������
	BizClaimVoucher getFindVouById(int id);
	//��ѯ��ϸ������
	List<BizCvDetailly> getFindAllByVouId(int id);
	//�������
	void saveCheckResult(BizCheckResult checkResult);
}
