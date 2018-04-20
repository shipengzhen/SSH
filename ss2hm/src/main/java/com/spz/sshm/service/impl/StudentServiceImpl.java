/**
 * 
 */
package com.spz.sshm.service.impl;

import com.spz.sshm.dao.IStudentDao;
import com.spz.sshm.entity.Student;
import com.spz.sshm.service.IStudentService;

/**
 * @描述 sshm
 * @作者 施鹏振
 * @创建日期 2017年12月23日
 * @创建时间 下午2:21:02
 */
public class StudentServiceImpl implements IStudentService {

	private IStudentDao studentDao;
	
	public IStudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}

	/* （非 Javadoc）
	 * @see com.spz.sshm.service.IStudentService#findStudent(java.lang.Integer, java.lang.String)
	 */
	@Override
	public Student findStudent(Integer studentNo, String loginPwd) {
		return studentDao.findStudent(studentNo, loginPwd);
	}

}
