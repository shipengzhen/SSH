package com.bdqn.oa.service;

import java.util.List;

import com.bdqn.oa.entity.BizClaimVoucher;
import com.bdqn.oa.entity.SysEmployee;
import com.bdqn.oa.util.Paging;

/**
 * 报销单
 * @author lizhen
 * @date 2017年12月27日
 */
public interface IBizClaimVoucherService {
	
	
	/**
	 * 修改
	 */
	void updateCVD(BizClaimVoucher cv);
	/**
	 * 通过id查询
	 * @return
	 */
	BizClaimVoucher findbycv(Integer id);
	/**
	 * 新增报销单
	 * @param cv
	 */
	void addCv(BizClaimVoucher cv);
	
	
	/**
	 * 分页报销单
	 * @param cv
	 * @return
	 */
	List<BizClaimVoucher> findCvfy(Paging<BizClaimVoucher> cv,SysEmployee emp);
}
