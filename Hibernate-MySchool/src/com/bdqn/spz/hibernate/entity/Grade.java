package com.bdqn.spz.hibernate.entity;

import java.util.List;

/**
 * gradeʵ����
 * Wed Nov 08 11:32:14 CST 2017 ʩ����
 */ 
public class Grade{

	//��ͱ��
	private Integer gradeId;

	//�������
	private String gradeName;
	
	//ѧ�����󼯺�
	//private Set<Student> students;
	private List<Student> students;

	/**
	 *��ͱ��
	 *@param gradeId
	 */
	public void setGradeId(Integer gradeId){
		this.gradeId=gradeId;
	}

	/**
	 *��ͱ��
	 *@return Integer gradeId
	 */
	public Integer getGradeId(){
		return gradeId;
	}

	/**
	 *�������
	 *@param gradeName
	 */
	public void setGradeName(String gradeName){
		this.gradeName=gradeName;
	}

	/**
	 *�������
	 *@return String gradeName
	 */
	public String getGradeName(){
		return gradeName;
	}
	
	/**
	 * ѧ�����󼯺�
	 * @return Set<Student>
	 */
//	public Set<Student> getStudents() {
//		return students;
//	}
	public List<Student> getStudents() {
		return students;
	}
	

	/**
	 * ѧ�����󼯺�
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

