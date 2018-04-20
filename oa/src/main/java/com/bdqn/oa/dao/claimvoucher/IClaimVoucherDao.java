/**
 * 
 */
package com.bdqn.oa.dao.claimvoucher;

import java.util.List;

import com.bdqn.oa.entity.BizClaimVoucher;

/**
 * @描述 oa
 * @作者 施鹏振
 * @创建日期 2017年12月27日
 * @创建时间 下午4:58:55
 */
public interface IClaimVoucherDao {

	/**
	 * 查询报销单数量
	 * @param voucher
	 * @return Integer
	 */
	Integer findBizClaimVoucherCount(BizClaimVoucher voucher);
	
	/**
	 * 查询报销单
	 * @param voucher
	 * @param pageNo
	 * @param pageSize
	 * @return List<BizClaimVoucher>
	 */
	List<BizClaimVoucher> findBizClaimVoucherByPaging(BizClaimVoucher voucher,Integer pageNo,Integer pageSize);
}
