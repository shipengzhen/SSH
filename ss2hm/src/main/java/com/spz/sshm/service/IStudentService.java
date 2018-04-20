/**
 * 
 */
package com.spz.sshm.service;

import com.spz.sshm.entity.Student;

/**
 * @描述 sshm
 * @作者 施鹏振
 * @创建日期 2017年12月23日
 * @创建时间 下午2:20:22
 */
public interface IStudentService {

	/**
	 * 
	 * @param studentNo
	 * @param loginPwd
	 * @return Student
	 */
	Student findStudent(Integer studentNo,String loginPwd);
}
