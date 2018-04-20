package com.spz.sshm.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Integer studentNo;
	private Grade grade;
	private String loginPwd;
	private String studentName;
	private String sex;
	private String phone;
	private String address;
	private Date bornDate;
	private String email;
	private String identityCard;
	private Set teachers = new HashSet(0);
	private Set results = new HashSet(0);

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(Integer studentNo, String loginPwd, String studentName, String sex) {
		this.studentNo = studentNo;
		this.loginPwd = loginPwd;
		this.studentName = studentName;
		this.sex = sex;
	}

	/** full constructor */
	public Student(Integer studentNo, Grade grade, String loginPwd, String studentName, String sex, String phone,
			String address, Date bornDate, String email, String identityCard, Set teachers, Set results) {
		this.studentNo = studentNo;
		this.grade = grade;
		this.loginPwd = loginPwd;
		this.studentName = studentName;
		this.sex = sex;
		this.phone = phone;
		this.address = address;
		this.bornDate = bornDate;
		this.email = email;
		this.identityCard = identityCard;
		this.teachers = teachers;
		this.results = results;
	}

	// Property accessors

	public Integer getStudentNo() {
		return this.studentNo;
	}

	public void setStudentNo(Integer studentNo) {
		this.studentNo = studentNo;
	}

	public Grade getGrade() {
		return this.grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public String getLoginPwd() {
		return this.loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBornDate() {
		return this.bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentityCard() {
		return this.identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public Set getTeachers() {
		return this.teachers;
	}

	public void setTeachers(Set teachers) {
		this.teachers = teachers;
	}

	public Set getResults() {
		return this.results;
	}

	public void setResults(Set results) {
		this.results = results;
	}

}