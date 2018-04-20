package com.bdqn.oa.entity;

import java.util.Date;


/**
 * 报销单审核表
 * @author lizhen
 * @date 2017年12月26日
 */
public class BizCheckResult implements java.io.Serializable {

	// Fields

	private Integer id;
	private BizClaimVoucher bizClaimVoucher;
	private SysEmployee sysEmployee;
	private Date checkDate;	//shijian 
	private String result;	//结果
	private String comm; 	//审批意见

	// Constructors

	/** default constructor */
	public BizCheckResult() {
	}

	/** minimal constructor */
	public BizCheckResult(Integer id, BizClaimVoucher bizClaimVoucher) {
		this.id = id;
		this.bizClaimVoucher = bizClaimVoucher;
	}

	/** full constructor */
	public BizCheckResult(Integer id, BizClaimVoucher bizClaimVoucher, SysEmployee sysEmployee, Date checkDate,
			String result, String comm) {
		this.id = id;
		this.bizClaimVoucher = bizClaimVoucher;
		this.sysEmployee = sysEmployee;
		this.checkDate = checkDate;
		this.result = result;
		this.comm = comm;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BizClaimVoucher getBizClaimVoucher() {
		return this.bizClaimVoucher;
	}

	public void setBizClaimVoucher(BizClaimVoucher bizClaimVoucher) {
		this.bizClaimVoucher = bizClaimVoucher;
	}

	public SysEmployee getSysEmployee() {
		return this.sysEmployee;
	}

	public void setSysEmployee(SysEmployee sysEmployee) {
		this.sysEmployee = sysEmployee;
	}

	public Date getCheckDate() {
		return this.checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getComm() {
		return this.comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}

}