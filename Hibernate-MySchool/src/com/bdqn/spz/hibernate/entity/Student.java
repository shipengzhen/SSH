package com.bdqn.spz.hibernate.entity;

import java.util.Date;
import java.util.List;

/**
 * student(学生表)实体类
 * Wed Nov 08 11:32:15 CST 2017 施鹏振
 */ 
public class Student{

	//学号
	private Integer studentNo;

	//密码
	private String loginPwd;

	//学生姓名
	private String studentName;

	//性别
	private String sex;

	//年纪对象
	private Grade grade;
	
	//教师集合
	private List<Teacher> teachers;

	//联系电话
	private String phone;

	//地址
	private String address;

	//出生日期
	private Date bornDate;

	//电子邮箱
	private String email;

	//身份证号
	private String identityCard;
	/**
	 *学号
	 *@param studentNo
	 */
	public void setStudentNo(Integer studentNo){
		this.studentNo=studentNo;
	}

	/**
	 *学号
	 *@return Integer studentNo
	 */
	public Integer getStudentNo(){
		return studentNo;
	}

	/**
	 *密码
	 *@param loginPwd
	 */
	public void setLoginPwd(String loginPwd){
		this.loginPwd=loginPwd;
	}

	/**
	 *密码
	 *@return String loginPwd
	 */
	public String getLoginPwd(){
		return loginPwd;
	}

	/**
	 *学生姓名
	 *@param studentName
	 */
	public void setStudentName(String studentName){
		this.studentName=studentName;
	}

	/**
	 *学生姓名
	 *@return String studentName
	 */
	public String getStudentName(){
		return studentName;
	}

	/**
	 *性别
	 *@param sex
	 */
	public void setSex(String sex){
		this.sex=sex;
	}

	/**
	 *性别
	 *@return String sex
	 */
	public String getSex(){
		return sex;
	}

	/**
	 * 年纪对象
	 * @return Grade grade
	 */
	public Grade getGrade() {
		return grade;
	}

	/**
	 * 年纪对象
	 * @param grade
	 */
	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	/**
	 * 教师集合
	 * @return List<Teacher> teachers
	 */
	public List<Teacher> getTeachers() {
		return teachers;
	}

	/**
	 * 教师集合
	 * @param teachers
	 */
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	/**
	 *联系电话
	 *@param phone
	 */
	public void setPhone(String phone){
		this.phone=phone;
	}

	/**
	 *联系电话
	 *@return String phone
	 */
	public String getPhone(){
		return phone;
	}

	/**
	 *地址
	 *@param address
	 */
	public void setAddress(String address){
		this.address=address;
	}

	/**
	 *地址
	 *@return String address
	 */
	public String getAddress(){
		return address;
	}

	/**
	 *出生日期
	 *@param bornDate
	 */
	public void setBornDate(Date bornDate){
		this.bornDate=bornDate;
	}

	/**
	 *出生日期
	 *@return Date bornDate
	 */
	public Date getBornDate(){
		return bornDate;
	}

	/**
	 *电子邮箱
	 *@param email
	 */
	public void setEmail(String email){
		this.email=email;
	}

	/**
	 *电子邮箱
	 *@return String email
	 */
	public String getEmail(){
		return email;
	}

	/**
	 *身份证号
	 *@param identityCard
	 */
	public void setIdentityCard(String identityCard){
		this.identityCard=identityCard;
	}

	/**
	 *身份证号
	 *@return String identityCard
	 */
	public String getIdentityCard(){
		return identityCard;
	}
}

