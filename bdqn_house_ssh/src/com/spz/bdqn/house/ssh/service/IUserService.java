/**
 * 
 */
package com.spz.bdqn.house.ssh.service;

import com.spz.bdqn.house.ssh.entity.User;

/**
 * @描述 Service层用户接口
 * @作者 施鹏振
 * @创建日期 2017年12月18日
 * @创建时间 下午1:03:00
 */
public interface IUserService {


	/**
	 * 查询用户信息
	 * @param username
	 * @param password
	 * @return User
	 */
	User findUser(String username,String password);
	
	/**
	 * 新增用户
	 * @param user
	 * @return boolean
	 */
	boolean addUser(User user);
	
}
