/**
 * 
 */
package com.spz.sshm.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.spz.sshm.dao.IStudentDao;
import com.spz.sshm.entity.Student;

/**
 * @描述 sshm
 * @作者 施鹏振
 * @创建日期 2017年12月23日
 * @创建时间 下午2:09:58
 */
public class StudentDaoImpl extends HibernateDaoSupport implements IStudentDao {

	/* （非 Javadoc）
	 * @see com.spz.sshm.dao.IStudentDao#findStudent(java.lang.Integer, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Student findStudent(Integer studentNo, String loginPwd) {
		String hql="from Student where studentNo=? and loginPwd=?";
		Object[] objects={studentNo,loginPwd};
		List<Student> students=(List<Student>) getHibernateTemplate().find(hql, objects);
		Student student=null;
		for (Student student1 : students) {
			student=student1;
		}
		return student;
	}

}
