package com.bdqn.oa.entity;

/**
 * 报销单详细信息
 * @author lizhen
 * @date 2017年12月26日
 */
public class BizCvDetailly implements java.io.Serializable {

	// Fields

	private Integer id;
	private BizClaimVoucher bizClaimVoucher;
	private String item;
	private Double acount;
	private String des;

	// Constructors

	/** default constructor */
	public BizCvDetailly() {
	}

	/** minimal constructor */
	public BizCvDetailly(Integer id, BizClaimVoucher bizClaimVoucher, String item, Double acount) {
		this.id = id;
		this.bizClaimVoucher = bizClaimVoucher;
		this.item = item;
		this.acount = acount;
	}

	/** full constructor */
	public BizCvDetailly(Integer id, BizClaimVoucher bizClaimVoucher, String item, Double acount, String des) {
		this.id = id;
		this.bizClaimVoucher = bizClaimVoucher;
		this.item = item;
		this.acount = acount;
		this.des = des;
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

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Double getAcount() {
		return this.acount;
	}

	public void setAcount(Double acount) {
		this.acount = acount;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

}