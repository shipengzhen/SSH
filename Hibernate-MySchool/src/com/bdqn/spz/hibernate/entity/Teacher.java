package com.bdqn.spz.hibernate.entity;

import java.util.List;

/**
 * teacher(��ʦ��)ʵ����
 * Mon Nov 13 15:38:29 CST 2017 ʩ����
 */ 
public class Teacher{

	//��ʦ���
	private Integer teacherId;

	//��ʦ����
	private String teacherName;

	//����
	private Integer age;

	//����
	private Integer teacherYear;

	//�����꼶
	private Grade grade;

	//����ѧ���ļ���
	private List<Student> students;

	/**
	 *��ʦ���
	 *@param teacherId
	 */
	public void setTeacherId(Integer teacherId){
		this.teacherId=teacherId;
	}

	/**
	 *��ʦ���
	 *@return Integer teacherId
	 */
	public Integer getTeacherId(){
		return teacherId;
	}

	/**
	 *��ʦ����
	 *@param teacherName
	 */
	public void setTeacherName(String teacherName){
		this.teacherName=teacherName;
	}

	/**
	 *��ʦ����
	 *@return String teacherName
	 */
	public String getTeacherName(){
		return teacherName;
	}

	/**
	 *����
	 *@param age
	 */
	public void setAge(Integer age){
		this.age=age;
	}

	/**
	 *����
	 *@return Integer age
	 */
	public Integer getAge(){
		return age;
	}

	/**
	 *����
	 *@param teacherYear
	 */
	public void setTeacherYear(Integer teacherYear){
		this.teacherYear=teacherYear;
	}

	/**
	 *����
	 *@return Integer teacherYear
	 */
	public Integer getTeacherYear(){
		return teacherYear;
	}
	
	/**
	 * �����꼶
	 * @return Grade grade
	 */
	public Grade getGrade() {
		return grade;
	}

	/**
	 * �����꼶
	 * @param grade
	 */
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	/**
	 * ����ѧ���ļ���
	 * @return List<Student> students
	 */
	public List<Student> getStudents() {
		return students;
	}

	/**
	 * ����ѧ���ļ���
	 * @param students
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}
}

