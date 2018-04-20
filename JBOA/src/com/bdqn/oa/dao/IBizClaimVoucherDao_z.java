package com.bdqn.oa.dao;

import java.util.List;

import com.bdqn.oa.entity.BizClaimVoucher;
import com.bdqn.oa.entity.SysEmployee;
import com.bdqn.oa.util.Paging;

/**
 * 报销单
 * @author lizhen
 * @date 2017年12月27日
 */
public interface IBizClaimVoucherDao_z {
	
	
	/**
	 * 修改保险单 -- 明细
	 * @param cv
	 */
	void updateCvd(BizClaimVoucher cv);
	/**
	 * 通过id查询报销单
	 * @param id
	 * @return
	 */
	BizClaimVoucher findCvById(Integer id);
	
	/**
	 *  新增报销单
	 */
	void saveCv(BizClaimVoucher cv);
	
	/**
	 * 记录总算
	 * @User:lizhen
	 * @date:2017年12月28日
	 */
	Integer findCount(BizClaimVoucher cv,SysEmployee emp);
	
	
	/**
	 * 查询分页
	 * @User:lizhen
	 * @date:2017年12月28日
	 */
	List<BizClaimVoucher> findAllCv(Paging<BizClaimVoucher> cv,SysEmployee emp);
	
	
}
