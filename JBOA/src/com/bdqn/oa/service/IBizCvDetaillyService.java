package com.bdqn.oa.service;

import java.util.List;

import com.bdqn.oa.entity.BizClaimVoucher;
import com.bdqn.oa.entity.BizCvDetailly;

/**
 * ��������ϸ��
 * @author lizhen
 * @date 2017��12��28��
 * @time ����5:04:24
 */
public interface IBizCvDetaillyService {
	
	
	/**
	 * ɾ��ͨ��id
	 * @param id
	 */
	void delCd(Integer id);
	/**
	 * ͨ��������id��ѯ��ϸ
	 * @return
	 */
	List<BizCvDetailly> findscdByid(BizClaimVoucher cv);
	/**
	 * ���ڱ����� ��ϸ  ���
	 * @User:lizhen
	 * @date:2017��12��28��
	 * @time:����5:05:51
	 * @param cvdList
	 */
	void addCvd(List<BizCvDetailly>cvdList );
}
