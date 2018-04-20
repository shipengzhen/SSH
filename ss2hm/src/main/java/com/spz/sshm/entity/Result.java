package com.spz.sshm.entity;

/**
 * Result entity. @author MyEclipse Persistence Tools
 */

public class Result implements java.io.Serializable {

	// Fields

	private ResultId id;
	private Integer studentResult;

	// Constructors

	/** default constructor */
	public Result() {
	}

	/** full constructor */
	public Result(ResultId id, Integer studentResult) {
		this.id = id;
		this.studentResult = studentResult;
	}

	// Property accessors

	public ResultId getId() {
		return this.id;
	}

	public void setId(ResultId id) {
		this.id = id;
	}

	public Integer getStudentResult() {
		return this.studentResult;
	}

	public void setStudentResult(Integer studentResult) {
		this.studentResult = studentResult;
	}

}