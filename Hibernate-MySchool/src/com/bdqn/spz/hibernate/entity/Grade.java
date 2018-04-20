package com.bdqn.spz.hibernate.entity;

import java.util.List;

/**
 * grade实体类
 * Wed Nov 08 11:32:14 CST 2017 施鹏振
 */ 
public class Grade{

	//年纪编号
	private Integer gradeId;

	//年纪名称
	private String gradeName;
	
	//学生对象集合
	//private Set<Student> students;
	private List<Student> students;

	/**
	 *年纪编号
	 *@param gradeId
	 */
	public void setGradeId(Integer gradeId){
		this.gradeId=gradeId;
	}

	/**
	 *年纪编号
	 *@return Integer gradeId
	 */
	public Integer getGradeId(){
		return gradeId;
	}

	/**
	 *年纪名称
	 *@param gradeName
	 */
	public void setGradeName(String gradeName){
		this.gradeName=gradeName;
	}

	/**
	 *年纪名称
	 *@return String gradeName
	 */
	public String getGradeName(){
		return gradeName;
	}
	
	/**
	 * 学生对象集合
	 * @return Set<Student>
	 */
//	public Set<Student> getStudents() {
//		return students;
//	}
	public List<Student> getStudents() {
		return students;
	}
	

	/**
	 * 学生对象集合
	 * @param students
	 */
//	public void setStudents(Set<Student> students) {
//		this.students = students;
//	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Grade() {
		super();
	}
	
	public Grade(Integer gradeId, String gradeName) {
		super();
		this.gradeId = gradeId;
		this.gradeName = gradeName;
	}

	/*public Grade(Integer gradeId, String gradeName, Set<Student> students) {
		super();
		this.gradeId = gradeId;
		this.gradeName = gradeName;
		this.students = students;
	}*/
	public Grade(Integer gradeId, String gradeName, List<Student> students) {
		super();
		this.gradeId = gradeId;
		this.gradeName = gradeName;
		this.students = students;
	}
}

