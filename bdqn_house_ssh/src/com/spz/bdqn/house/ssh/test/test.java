/**
 * 
 */
package com.spz.bdqn.house.ssh.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spz.bdqn.house.ssh.action.UserAction;
import com.spz.bdqn.house.ssh.dao.IUserDao;
import com.spz.bdqn.house.ssh.dao.impl.UserDaoImpl;
import com.spz.bdqn.house.ssh.service.IUserService;
import com.spz.bdqn.house.ssh.service.impl.UserServiceImpl;

/**
 * @描述 bdqn_house_ssh
 * @作者 施鹏振
 * @创建日期 2017年12月22日
 * @创建时间 上午10:35:02
 */
public class test {

	public static void main(String[] args) {
		new test().t();
	}
	
	@SuppressWarnings("resource")
	@Test
	public void t(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDao userDao=applicationContext.getBean(UserDaoImpl.class);
		System.out.println(userDao);
		IUserService userService=applicationContext.getBean(UserServiceImpl.class);
		System.out.println(userService.getClass());
		UserAction userAction=applicationContext.getBean(UserAction.class);
		System.out.println(userAction);
		userService.findUser("微笑吧","123");
	}
}
