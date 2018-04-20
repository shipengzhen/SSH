package com.spz.sshm.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields

	private Integer teacherId;
	private String teacherName;
	private Integer age;
	private Integer teacherYear;
	private Integer gradeId;
	private Set students = new HashSet(0);

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(Integer teacherId, String teacherName, Integer age, Integer teacherYear, Integer gradeId) {
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.age = age;
		this.teacherYear = teacherYear;
		this.gradeId = gradeId;
	}

	/** full constructor */
	public Teacher(Integer teacherId, String teacherName, Integer age, Integer teacherYear, Integer gradeId,
			Set students) {
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.age = age;
		this.teacherYear = teacherYear;
		this.gradeId = gradeId;
		this.students = students;
	}

	// Property accessors

	public Integer getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getTeacherYear() {
		return this.teacherYear;
	}

	public void setTeacherYear(Integer teacherYear) {
		this.teacherYear = teacherYear;
	}

	public Integer getGradeId() {
		return this.gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

}