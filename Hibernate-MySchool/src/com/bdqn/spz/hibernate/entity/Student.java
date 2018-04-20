package com.bdqn.spz.hibernate.entity;

import java.util.Date;
import java.util.List;

/**
 * student(ѧ����)ʵ����
 * Wed Nov 08 11:32:15 CST 2017 ʩ����
 */ 
public class Student{

	//ѧ��
	private Integer studentNo;

	//����
	private String loginPwd;

	//ѧ������
	private String studentName;

	//�Ա�
	private String sex;

	//��Ͷ���
	private Grade grade;
	
	//��ʦ����
	private List<Teacher> teachers;

	//��ϵ�绰
	private String phone;

	//��ַ
	private String address;

	//��������
	private Date bornDate;

	//��������
	private String email;

	//���֤��
	private String identityCard;
	/**
	 *ѧ��
	 *@param studentNo
	 */
	public void setStudentNo(Integer studentNo){
		this.studentNo=studentNo;
	}

	/**
	 *ѧ��
	 *@return Integer studentNo
	 */
	public Integer getStudentNo(){
		return studentNo;
	}

	/**
	 *����
	 *@param loginPwd
	 */
	public void setLoginPwd(String loginPwd){
		this.loginPwd=loginPwd;
	}

	/**
	 *����
	 *@return String loginPwd
	 */
	public String getLoginPwd(){
		return loginPwd;
	}

	/**
	 *ѧ������
	 *@param studentName
	 */
	public void setStudentName(String studentName){
		this.studentName=studentName;
	}

	/**
	 *ѧ������
	 *@return String studentName
	 */
	public String getStudentName(){
		return studentName;
	}

	/**
	 *�Ա�
	 *@param sex
	 */
	public void setSex(String sex){
		this.sex=sex;
	}

	/**
	 *�Ա�
	 *@return String sex
	 */
	public String getSex(){
		return sex;
	}

	/**
	 * ��Ͷ���
	 * @return Grade grade
	 */
	public Grade getGrade() {
		return grade;
	}

	/**
	 * ��Ͷ���
	 * @param grade
	 */
	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	/**
	 * ��ʦ����
	 * @return List<Teacher> teachers
	 */
	public List<Teacher> getTeachers() {
		return teachers;
	}

	/**
	 * ��ʦ����
	 * @param teachers
	 */
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	/**
	 *��ϵ�绰
	 *@param phone
	 */
	public void setPhone(String phone){
		this.phone=phone;
	}

	/**
	 *��ϵ�绰
	 *@return String phone
	 */
	public String getPhone(){
		return phone;
	}

	/**
	 *��ַ
	 *@param address
	 */
	public void setAddress(String address){
		this.address=address;
	}

	/**
	 *��ַ
	 *@return String address
	 */
	public String getAddress(){
		return address;
	}

	/**
	 *��������
	 *@param bornDate
	 */
	public void setBornDate(Date bornDate){
		this.bornDate=bornDate;
	}

	/**
	 *��������
	 *@return Date bornDate
	 */
	public Date getBornDate(){
		return bornDate;
	}

	/**
	 *��������
	 *@param email
	 */
	public void setEmail(String email){
		this.email=email;
	}

	/**
	 *��������
	 *@return String email
	 */
	public String getEmail(){
		return email;
	}

	/**
	 *���֤��
	 *@param identityCard
	 */
	public void setIdentityCard(String identityCard){
		this.identityCard=identityCard;
	}

	/**
	 *���֤��
	 *@return String identityCard
	 */
	public String getIdentityCard(){
		return identityCard;
	}
}

