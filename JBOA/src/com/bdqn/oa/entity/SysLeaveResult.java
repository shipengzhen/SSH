package com.bdqn.oa.entity;

import java.util.Date;


/**
 * �����˱�
 * @author lizhen
 * @date 2017��12��26��
 */
public class SysLeaveResult implements java.io.Serializable {

	// Fields

	private Integer id;
	private SysLeave sysLeave;
	private Date shdate;
	private String shsuggestion;
	private Integer leave_id;

	// Constructors

	public Integer getLeave_id() {
		return leave_id;
	}

	public void setLeave_id(Integer leave_id) {
		this.leave_id = leave_id;
	}

	/** default constructor */
	public SysLeaveResult() {
	}

	/** minimal constructor */
	public SysLeaveResult(Integer id, SysLeave sysLeave) {
		this.id = id;
		this.sysLeave = sysLeave;
	}

	/** full constructor */
	public SysLeaveResult(Integer id, SysLeave sysLeave, Date shdate, String shsuggestion) {
		this.id = id;
		this.sysLeave = sysLeave;
		this.shdate = shdate;
		this.shsuggestion = shsuggestion;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SysLeave getSysLeave() {
		return this.sysLeave;
	}

	public void setSysLeave(SysLeave sysLeave) {
		this.sysLeave = sysLeave;
	}

	public Date getShdate() {
		return this.shdate;
	}

	public void setShdate(Date shdate) {
		this.shdate = shdate;
	}

	public String getShsuggestion() {
		return this.shsuggestion;
	}

	public void setShsuggestion(String shsuggestion) {
		this.shsuggestion = shsuggestion;
	}

}