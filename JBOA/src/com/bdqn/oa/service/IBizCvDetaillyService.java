package com.bdqn.oa.service;

import java.util.List;

import com.bdqn.oa.entity.BizClaimVoucher;
import com.bdqn.oa.entity.BizCvDetailly;

/**
 * 报销单明细表
 * @author lizhen
 * @date 2017年12月28日
 * @time 下午5:04:24
 */
public interface IBizCvDetaillyService {
	
	
	/**
	 * 删除通过id
	 * @param id
	 */
	void delCd(Integer id);
	/**
	 * 通过报销单id查询明细
	 * @return
	 */
	List<BizCvDetailly> findscdByid(BizClaimVoucher cv);
	/**
	 * 现在报销单 明细  多个
	 * @User:lizhen
	 * @date:2017年12月28日
	 * @time:下午5:05:51
	 * @param cvdList
	 */
	void addCvd(List<BizCvDetailly>cvdList );
}
