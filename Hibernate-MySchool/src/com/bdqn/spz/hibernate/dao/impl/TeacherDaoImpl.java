package com.bdqn.spz.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bdqn.spz.hibernate.entity.Student;
import com.bdqn.spz.hibernate.entity.Teacher;
import com.bdqn.spz.hibernate.util.HibernateUtil;

/**
 * Dao层教师实现类
 * @author 施鹏振
 *
 */
public class TeacherDaoImpl {

	private static Session session = HibernateUtil.currentSession();
	
	@SuppressWarnings("unchecked")
	public void findTeacher(){
		String hql="from Teacher";
		Query query =session.createQuery(hql);
		for (Teacher teacher :(List<Teacher>)query.list()) {
			System.out.println("教师名称 ->"+teacher.getTeacherName());
			for (Student student : teacher.getStudents()) {
				System.out.println("所教学生->"+student.getStudentName());
			}
			System.out.println("-------------------------------------");
		}
	};
	
	public static void main(String[] args) {
		Transaction transaction = session.beginTransaction();
		new TeacherDaoImpl().findTeacher();
		transaction.commit();
	}
}
