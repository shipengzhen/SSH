package com.bdqn.oa.dao;

import java.util.List;

import com.bdqn.oa.entity.BizCheckResult;
import com.bdqn.oa.entity.BizClaimVoucher;
import com.bdqn.oa.entity.BizCvDetailly;
import com.bdqn.oa.entity.SysEmployee;
import com.bdqn.oa.util.Paging;

public interface IClaimVoucherDao_w {
	//��ѯ������
	int count(SysEmployee emp,Paging<BizClaimVoucher> voucher);
	//��ѯȫ��������
	List<BizClaimVoucher> findAllVoucher(SysEmployee emp,Paging<BizClaimVoucher> voucher);
	
	//����id��ѯ������
	BizClaimVoucher findVoucherById(int id);
	//��ѯ��������ϸ
	List<BizCvDetailly> findCvList(int id);
	
	//���������Ϣ
	void saveCheck(BizCheckResult checkResult);
}
