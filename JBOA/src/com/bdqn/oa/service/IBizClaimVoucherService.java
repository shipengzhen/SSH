package com.bdqn.oa.service;

import java.util.List;

import com.bdqn.oa.entity.BizClaimVoucher;
import com.bdqn.oa.entity.SysEmployee;
import com.bdqn.oa.util.Paging;

/**
 * ������
 * @author lizhen
 * @date 2017��12��27��
 */
public interface IBizClaimVoucherService {
	
	
	/**
	 * �޸�
	 */
	void updateCVD(BizClaimVoucher cv);
	/**
	 * ͨ��id��ѯ
	 * @return
	 */
	BizClaimVoucher findbycv(Integer id);
	/**
	 * ����������
	 * @param cv
	 */
	void addCv(BizClaimVoucher cv);
	
	
	/**
	 * ��ҳ������
	 * @param cv
	 * @return
	 */
	List<BizClaimVoucher> findCvfy(Paging<BizClaimVoucher> cv,SysEmployee emp);
}
