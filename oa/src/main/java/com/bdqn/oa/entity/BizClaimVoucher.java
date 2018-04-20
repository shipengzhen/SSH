package com.bdqn.oa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * 报销单表
 * @author lizhen
 * @date 2017年12月26日
 */
public class BizClaimVoucher implements java.io.Serializable {

	// Fields

	private Integer id;
	private SysEmployee sysEmployeeByProposerEid;
	private SysEmployee sysEmployeeByExecutorEid;
	private Date begindate;
	private Date finishdate;
	private String event;
	private Double moeny;
	private String status;
	private Set bizCheckResults = new HashSet(0);
	private Set bizCvDetaillies = new HashSet(0);

	// Constructors

	/** default constructor */
	public BizClaimVoucher() {
	}

	/** minimal constructor */
	public BizClaimVoucher(Integer id, SysEmployee sysEmployeeByProposerEid, SysEmployee sysEmployeeByExecutorEid,
			Date begindate) {
		this.id = id;
		this.sysEmployeeByProposerEid = sysEmployeeByProposerEid;
		this.sysEmployeeByExecutorEid = sysEmployeeByExecutorEid;
		this.begindate = begindate;
	}

	/** full constructor */
	public BizClaimVoucher(Integer id, SysEmployee sysEmployeeByProposerEid, SysEmployee sysEmployeeByExecutorEid,
			Date begindate, Date finishdate, String event, Double moeny, String status, Set bizCheckResults,
			Set bizCvDetaillies) {
		this.id = id;
		this.sysEmployeeByProposerEid = sysEmployeeByProposerEid;
		this.sysEmployeeByExecutorEid = sysEmployeeByExecutorEid;
		this.begindate = begindate;
		this.finishdate = finishdate;
		this.event = event;
		this.moeny = moeny;
		this.status = status;
		this.bizCheckResults = bizCheckResults;
		this.bizCvDetaillies = bizCvDetaillies;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SysEmployee getSysEmployeeByProposerEid() {
		return this.sysEmployeeByProposerEid;
	}

	public void setSysEmployeeByProposerEid(SysEmployee sysEmployeeByProposerEid) {
		this.sysEmployeeByProposerEid = sysEmployeeByProposerEid;
	}

	public SysEmployee getSysEmployeeByExecutorEid() {
		return this.sysEmployeeByExecutorEid;
	}

	public void setSysEmployeeByExecutorEid(SysEmployee sysEmployeeByExecutorEid) {
		this.sysEmployeeByExecutorEid = sysEmployeeByExecutorEid;
	}

	public Date getBegindate() {
		return this.begindate;
	}

	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}

	public Date getFinishdate() {
		return this.finishdate;
	}

	public void setFinishdate(Date finishdate) {
		this.finishdate = finishdate;
	}

	public String getEvent() {
		return this.event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Double getMoeny() {
		return this.moeny;
	}

	public void setMoeny(Double moeny) {
		this.moeny = moeny;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set getBizCheckResults() {
		return this.bizCheckResults;
	}

	public void setBizCheckResults(Set bizCheckResults) {
		this.bizCheckResults = bizCheckResults;
	}

	public Set getBizCvDetaillies() {
		return this.bizCvDetaillies;
	}

	public void setBizCvDetaillies(Set bizCvDetaillies) {
		this.bizCvDetaillies = bizCvDetaillies;
	}

}