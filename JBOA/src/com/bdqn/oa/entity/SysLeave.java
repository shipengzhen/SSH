package com.bdqn.oa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * ��ٱ�
 * @author lizhen
 * @date 2017��12��26��
 */
public class SysLeave implements java.io.Serializable {

	// Fields

	private Integer id;
	private SysEmployee sysEmployeeByProposerEid;
	private SysEmployee sysEmployeeByExecutorEid;
	private Date begindate;
	private Date closuredate;
	private Integer days;
	private String event;
	private String leavetype;
	private String status;
//	private Set sysLeaveResults = new HashSet(0);
	private SysLeaveResult leaveResult;

	// Constructors


	/** default constructor */
	public SysLeave() {
	}

	public SysLeave(Integer id, SysEmployee sysEmployeeByProposerEid, SysEmployee sysEmployeeByExecutorEid,
			Date begindate, Date closuredate, Integer days, String event, String leavetype, String status,
			SysLeaveResult leaveResult) {
		super();
		this.id = id;
		this.sysEmployeeByProposerEid = sysEmployeeByProposerEid;
		this.sysEmployeeByExecutorEid = sysEmployeeByExecutorEid;
		this.begindate = begindate;
		this.closuredate = closuredate;
		this.days = days;
		this.event = event;
		this.leavetype = leavetype;
		this.status = status;
		this.leaveResult = leaveResult;
	}

	public SysLeaveResult getLeaveResult() {
		return leaveResult;
	}

	public void setLeaveResult(SysLeaveResult leaveResult) {
		this.leaveResult = leaveResult;
	}

	/** minimal constructor */
	public SysLeave(Integer id, SysEmployee sysEmployeeByProposerEid, SysEmployee sysEmployeeByExecutorEid) {
		this.id = id;
		this.sysEmployeeByProposerEid = sysEmployeeByProposerEid;
		this.sysEmployeeByExecutorEid = sysEmployeeByExecutorEid;
	}

	/** full constructor */
//	public SysLeave(Integer id, SysEmployee sysEmployeeByProposerEid, SysEmployee sysEmployeeByExecutorEid,
//			Date begindate, Date closuredate, Integer days, String event, String leavetype, String status,
//			Set sysLeaveResults) {
//		this.id = id;
//		this.sysEmployeeByProposerEid = sysEmployeeByProposerEid;
//		this.sysEmployeeByExecutorEid = sysEmployeeByExecutorEid;
//		this.begindate = begindate;
//		this.closuredate = closuredate;
//		this.days = days;
//		this.event = event;
//		this.leavetype = leavetype;
//		this.status = status;
//		this.sysLeaveResults = sysLeaveResults;
//	}

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

	public Date getClosuredate() {
		return this.closuredate;
	}

	public void setClosuredate(Date closuredate) {
		this.closuredate = closuredate;
	}

	public Integer getDays() {
		return this.days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public String getEvent() {
		return this.event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getLeavetype() {
		return this.leavetype;
	}

	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	public Set getSysLeaveResults() {
//		return this.sysLeaveResults;
//	}
//
//	public void setSysLeaveResults(Set sysLeaveResults) {
//		this.sysLeaveResults = sysLeaveResults;
//	}

}