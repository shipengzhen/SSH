package com.spz.sshm.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Grade entity. @author MyEclipse Persistence Tools
 */

public class Grade implements java.io.Serializable {

	// Fields

	private Integer gradeId;
	private String gradeName;
	private Set students = new HashSet(0);
	private Set subjects = new HashSet(0);

	// Constructors

	/** default constructor */
	public Grade() {
	}

	/** minimal constructor */
	public Grade(Integer gradeId, String gradeName) {
		this.gradeId = gradeId;
		this.gradeName = gradeName;
	}

	/** full constructor */
	public Grade(Integer gradeId, String gradeName, Set students, Set subjects) {
		this.gradeId = gradeId;
		this.gradeName = gradeName;
		this.students = students;
		this.subjects = subjects;
	}

	// Property accessors

	public Integer getGradeId() {
		return this.gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeName() {
		return this.gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

	public Set getSubjects() {
		return this.subjects;
	}

	public void setSubjects(Set subjects) {
		this.subjects = subjects;
	}

}