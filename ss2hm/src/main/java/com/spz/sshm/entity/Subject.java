package com.spz.sshm.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Subject entity. @author MyEclipse Persistence Tools
 */

public class Subject implements java.io.Serializable {

	// Fields

	private Integer subjectNo;
	private Grade grade;
	private String subjectName;
	private Integer classHour;
	private Set results = new HashSet(0);

	// Constructors

	/** default constructor */
	public Subject() {
	}

	/** minimal constructor */
	public Subject(Integer subjectNo) {
		this.subjectNo = subjectNo;
	}

	/** full constructor */
	public Subject(Integer subjectNo, Grade grade, String subjectName, Integer classHour, Set results) {
		this.subjectNo = subjectNo;
		this.grade = grade;
		this.subjectName = subjectName;
		this.classHour = classHour;
		this.results = results;
	}

	// Property accessors

	public Integer getSubjectNo() {
		return this.subjectNo;
	}

	public void setSubjectNo(Integer subjectNo) {
		this.subjectNo = subjectNo;
	}

	public Grade getGrade() {
		return this.grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public String getSubjectName() {
		return this.subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Integer getClassHour() {
		return this.classHour;
	}

	public void setClassHour(Integer classHour) {
		this.classHour = classHour;
	}

	public Set getResults() {
		return this.results;
	}

	public void setResults(Set results) {
		this.results = results;
	}

}