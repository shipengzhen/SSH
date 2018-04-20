/**
 * 
 */
package com.spz.bdqn.house.dao;

import com.spz.bdqn.house.entity.User;

/**
 * @描述 Dao层用户接口
 * @作者 施鹏振
 * @创建日期 2017年12月18日
 * @创建时间 上午11:54:12
 */
public interface IUserDao {


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
	
	/**
	 * 查询最大的
	 * @return Integer
	 */
	Integer findMaxUserId();
}
