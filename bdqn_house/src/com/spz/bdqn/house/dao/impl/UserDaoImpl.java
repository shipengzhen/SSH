/**
 * 
 */
package com.spz.bdqn.house.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.spz.bdqn.house.dao.IUserDao;
import com.spz.bdqn.house.entity.User;
import com.spz.bdqn.house.util.HibernateSessionFactory;

/**
 * @���� Dao���û�ʵ����
 * @���� ʩ����
 * @�������� 2017��12��18��
 * @����ʱ�� ����12:54:19
 */
public class UserDaoImpl implements IUserDao {

	private Session session=HibernateSessionFactory.getSession();

	/* ���� Javadoc��
	 * @see com.spz.bdqn.house.dao.IUserDao#findUser(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public User findUser(String username, String password) {
		String hql="from User u where u.username=:username and u.password=:password";
		Query<User> query=session.createQuery(hql);
		query.setParameter("username",username);
		query.setParameter("password",password);
		return query.uniqueResult();
	}

	/* ���� Javadoc��
	 * @see com.spz.bdqn.house.dao.IUserDao#addUser(com.spz.bdqn.house.entity.User)
	 */
	@Override
	public boolean addUser(User user) {
		boolean b=true;
		Transaction transaction=session.beginTransaction();
		try {
			session.save(user);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			b=false;
		}
		return b;
	}

	/* ���� Javadoc��
	 * @see com.spz.bdqn.house.dao.IUserDao#findMaxUserId()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Integer findMaxUserId() {
		String hql="select max(u.id) from User u";
		Query<Integer> query=session.createQuery(hql);
		Integer integer=query.uniqueResult();
		if (integer==null) {
			integer=0;
		}
		return integer;
	}

}
