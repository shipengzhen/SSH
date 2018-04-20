package com.bdqn.spz.hibernate.entity;

import java.util.List;

/**
 * teacher(教师表)实体类
 * Mon Nov 13 15:38:29 CST 2017 施鹏振
 */ 
public class Teacher{

	//教师编号
	private Integer teacherId;

	//教师名称
	private String teacherName;

	//年龄
	private Integer age;

	//教龄
	private Integer teacherYear;

	//所教年级
	private Grade grade;

	//所教学生的集合
	private List<Student> students;

	/**
	 *教师编号
	 *@param teacherId
	 */
	public void setTeacherId(Integer teacherId){
		this.teacherId=teacherId;
	}

	/**
	 *教师编号
	 *@return Integer teacherId
	 */
	public Integer getTeacherId(){
		return teacherId;
	}

	/**
	 *教师名称
	 *@param teacherName
	 */
	public void setTeacherName(String teacherName){
		this.teacherName=teacherName;
	}

	/**
	 *教师名称
	 *@return String teacherName
	 */
	public String getTeacherName(){
		return teacherName;
	}

	/**
	 *年龄
	 *@param age
	 */
	public void setAge(Integer age){
		this.age=age;
	}

	/**
	 *年龄
	 *@return Integer age
	 */
	public Integer getAge(){
		return age;
	}

	/**
	 *教龄
	 *@param teacherYear
	 */
	public void setTeacherYear(Integer teacherYear){
		this.teacherYear=teacherYear;
	}

	/**
	 *教龄
	 *@return Integer teacherYear
	 */
	public Integer getTeacherYear(){
		return teacherYear;
	}
	
	/**
	 * 所教年级
	 * @return Grade grade
	 */
	public Grade getGrade() {
		return grade;
	}

	/**
	 * 所教年级
	 * @param grade
	 */
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	/**
	 * 所教学生的集合
	 * @return List<Student> students
	 */
	public List<Student> getStudents() {
		return students;
	}

	/**
	 * 所教学生的集合
	 * @param students
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}
}

