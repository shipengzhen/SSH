package com.bdqn.oa.dao;

import java.util.List;

import com.bdqn.oa.entity.BizClaimVoucher;
import com.bdqn.oa.entity.SysEmployee;
import com.bdqn.oa.util.Paging;

/**
 * ������
 * @author lizhen
 * @date 2017��12��27��
 */
public interface IBizClaimVoucherDao_z {
	
	
	/**
	 * �޸ı��յ� -- ��ϸ
	 * @param cv
	 */
	void updateCvd(BizClaimVoucher cv);
	/**
	 * ͨ��id��ѯ������
	 * @param id
	 * @return
	 */
	BizClaimVoucher findCvById(Integer id);
	
	/**
	 *  ����������
	 */
	void saveCv(BizClaimVoucher cv);
	
	/**
	 * ��¼����
	 * @User:lizhen
	 * @date:2017��12��28��
	 */
	Integer findCount(BizClaimVoucher cv,SysEmployee emp);
	
	
	/**
	 * ��ѯ��ҳ
	 * @User:lizhen
	 * @date:2017��12��28��
	 */
	List<BizClaimVoucher> findAllCv(Paging<BizClaimVoucher> cv,SysEmployee emp);
	
	
}
