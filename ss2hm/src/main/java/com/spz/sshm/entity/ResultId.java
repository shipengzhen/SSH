package com.spz.sshm.entity;

import java.sql.Timestamp;

/**
 * ResultId entity. @author MyEclipse Persistence Tools
 */

public class ResultId implements java.io.Serializable {

	// Fields

	private Student student;
	private Subject subject;
	private Timestamp examDate;

	// Constructors

	/** default constructor */
	public ResultId() {
	}

	/** full constructor */
	public ResultId(Student student, Subject subject, Timestamp examDate) {
		this.student = student;
		this.subject = subject;
		this.examDate = examDate;
	}

	// Property accessors

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Timestamp getExamDate() {
		return this.examDate;
	}

	public void setExamDate(Timestamp examDate) {
		this.examDate = examDate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ResultId))
			return false;
		ResultId castOther = (ResultId) other;

		return ((this.getStudent() == castOther.getStudent()) || (this.getStudent() != null
				&& castOther.getStudent() != null && this.getStudent().equals(castOther.getStudent())))
				&& ((this.getSubject() == castOther.getSubject()) || (this.getSubject() != null
						&& castOther.getSubject() != null && this.getSubject().equals(castOther.getSubject())))
				&& ((this.getExamDate() == castOther.getExamDate()) || (this.getExamDate() != null
						&& castOther.getExamDate() != null && this.getExamDate().equals(castOther.getExamDate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getStudent() == null ? 0 : this.getStudent().hashCode());
		result = 37 * result + (getSubject() == null ? 0 : this.getSubject().hashCode());
		result = 37 * result + (getExamDate() == null ? 0 : this.getExamDate().hashCode());
		return result;
	}

}