/**
 * 
 */
package com.spz.sshm.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.spz.sshm.entity.Student;
import com.spz.sshm.service.IStudentService;

/**
 * @描述 sshm
 * @作者 施鹏振
 * @创建日期 2017年12月23日
 * @创建时间 下午2:24:31
 */
@SuppressWarnings("serial")
public class StudentAction extends ActionSupport {

	private IStudentService studentService;

	public IStudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}
	
	private Student student;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	//登录
	public String login(){
		System.out.println("11111111111111111111");
		Student student1=studentService.findStudent(student.getStudentNo(),student.getLoginPwd());
		Map<String, Object> session = null;
		session = ActionContext.getContext().getSession();
		if (student1!=null) {
			session.put("student", student1);
		}
		return SUCCESS;
	}
}
