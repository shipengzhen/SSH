/**
 * 
 */
package com.spz.bdqn.house.ssh.service.impl;

import com.spz.bdqn.house.ssh.dao.IUserDao;
import com.spz.bdqn.house.ssh.entity.User;
import com.spz.bdqn.house.ssh.service.IUserService;

/**
 * @描述 bdqn_house
 * @作者 施鹏振
 * @创建日期 2017年12月18日
 * @创建时间 下午1:08:43
 */
public class UserServiceImpl implements IUserService {

	private IUserDao userDao;

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	/* （非 Javadoc）
	 * @see com.spz.bdqn.house.service.IUserService#findUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User findUser(String username, String password) {
		return userDao.findUser(username, password);
	}

	/* （非 Javadoc）
	 * @see com.spz.bdqn.house.service.IUserService#addUser(com.spz.bdqn.house.entity.User)
	 */
	@Override
	public boolean addUser(User user) {
		user.setId(userDao.findMaxUserId()+1);
		return userDao.addUser(user);
	}
	

}
