package com.bdqn.oa.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * 职工表
 * @author lizhen
 * @date 2017年12月26日
 */
public class SysEmployee implements java.io.Serializable {

	// Fields

	private Integer eid;
	private SysPosition sysPosition;
	private SysDepartment sysDepartment;
	private String ename;
	private String epassword;
	private String status;
	private Set sysLeavesForExecutorEid = new HashSet(0);
	private Set bizClaimVouchersForExecutorEid = new HashSet(0);
	private Set bizClaimVouchersForProposerEid = new HashSet(0);
	private Set bizCheckResults = new HashSet(0);
	private Set sysLeavesForProposerEid = new HashSet(0);

	// Constructors

	/** default constructor */
	public SysEmployee() {
	}

	/** minimal constructor */
	public SysEmployee(Integer eid, SysPosition sysPosition, SysDepartment sysDepartment, String ename,
			String epassword) {
		this.eid = eid;
		this.sysPosition = sysPosition;
		this.sysDepartment = sysDepartment;
		this.ename = ename;
		this.epassword = epassword;
	}

	/** full constructor */
	public SysEmployee(Integer eid, SysPosition sysPosition, SysDepartment sysDepartment, String ename,
			String epassword, String status, Set sysLeavesForExecutorEid, Set bizClaimVouchersForExecutorEid,
			Set bizClaimVouchersForProposerEid, Set bizCheckResults, Set sysLeavesForProposerEid) {
		this.eid = eid;
		this.sysPosition = sysPosition;
		this.sysDepartment = sysDepartment;
		this.ename = ename;
		this.epassword = epassword;
		this.status = status;
		this.sysLeavesForExecutorEid = sysLeavesForExecutorEid;
		this.bizClaimVouchersForExecutorEid = bizClaimVouchersForExecutorEid;
		this.bizClaimVouchersForProposerEid = bizClaimVouchersForProposerEid;
		this.bizCheckResults = bizCheckResults;
		this.sysLeavesForProposerEid = sysLeavesForProposerEid;
	}

	// Property accessors

	public Integer getEid() {
		return this.eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public SysPosition getSysPosition() {
		return this.sysPosition;
	}

	public void setSysPosition(SysPosition sysPosition) {
		this.sysPosition = sysPosition;
	}

	public SysDepartment getSysDepartment() {
		return this.sysDepartment;
	}

	public void setSysDepartment(SysDepartment sysDepartment) {
		this.sysDepartment = sysDepartment;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEpassword() {
		return this.epassword;
	}

	public void setEpassword(String epassword) {
		this.epassword = epassword;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set getSysLeavesForExecutorEid() {
		return this.sysLeavesForExecutorEid;
	}

	public void setSysLeavesForExecutorEid(Set sysLeavesForExecutorEid) {
		this.sysLeavesForExecutorEid = sysLeavesForExecutorEid;
	}

	public Set getBizClaimVouchersForExecutorEid() {
		return this.bizClaimVouchersForExecutorEid;
	}

	public void setBizClaimVouchersForExecutorEid(Set bizClaimVouchersForExecutorEid) {
		this.bizClaimVouchersForExecutorEid = bizClaimVouchersForExecutorEid;
	}

	public Set getBizClaimVouchersForProposerEid() {
		return this.bizClaimVouchersForProposerEid;
	}

	public void setBizClaimVouchersForProposerEid(Set bizClaimVouchersForProposerEid) {
		this.bizClaimVouchersForProposerEid = bizClaimVouchersForProposerEid;
	}

	public Set getBizCheckResults() {
		return this.bizCheckResults;
	}

	public void setBizCheckResults(Set bizCheckResults) {
		this.bizCheckResults = bizCheckResults;
	}

	public Set getSysLeavesForProposerEid() {
		return this.sysLeavesForProposerEid;
	}

	public void setSysLeavesForProposerEid(Set sysLeavesForProposerEid) {
		this.sysLeavesForProposerEid = sysLeavesForProposerEid;
	}

}