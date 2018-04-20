package com.bdqn.oa.dao;

import java.util.List;

import com.bdqn.oa.entity.BizClaimVoucher;
import com.bdqn.oa.entity.BizCvDetailly;

/**
 * 报销单明细表
 * @author lizhen
 * @date 2017年12月28日
 * @time 上午11:52:19
 */
public interface IBizCvDetaillyDao {
	
	
	/**
	 * 通过id 删除
	 * @param id
	 */
	void deleteById(Integer id);
	/**
	 * 通过报销单id查询
	 * @return
	 */
	List<BizCvDetailly> findAllBybid(BizClaimVoucher cv);
	
	
	
	/**
	 * 新增报销单明细表
	 * @User:lizhen
	 * @date:2017年12月28日
	 * @time:上午11:53:28
	 * @param cvdList
	 */
	void saveCvd(List<BizCvDetailly>cvdList);
}
