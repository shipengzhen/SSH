package com.bdqn.oa.dao;

import java.util.List;

import com.bdqn.oa.entity.BizClaimVoucher;
import com.bdqn.oa.entity.BizCvDetailly;

/**
 * ��������ϸ��
 * @author lizhen
 * @date 2017��12��28��
 * @time ����11:52:19
 */
public interface IBizCvDetaillyDao {
	
	
	/**
	 * ͨ��id ɾ��
	 * @param id
	 */
	void deleteById(Integer id);
	/**
	 * ͨ��������id��ѯ
	 * @return
	 */
	List<BizCvDetailly> findAllBybid(BizClaimVoucher cv);
	
	
	
	/**
	 * ������������ϸ��
	 * @User:lizhen
	 * @date:2017��12��28��
	 * @time:����11:53:28
	 * @param cvdList
	 */
	void saveCvd(List<BizCvDetailly>cvdList);
}
