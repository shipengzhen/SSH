package com.bdqn.spz.scott.test;

import java.util.List;
import org.hibernate.*;
import org.junit.Test;
import com.bdqn.spz.scott.entity.DeptSalary;
import com.bdqn.spz.scott.util.HibernateUtil;

public class GroupingTest {

	/**
	 * 按职位统计员工个数。
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void eg4() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.currentSession().beginTransaction();
			List<Object[]> list = HibernateUtil.currentSession()
					.createQuery("select e.job, count(e) from Emp e group by e.job").list();
			for (Object[] obj : list)
				System.out.println(obj[0] + ", " + obj[1]);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

	/**
	 * 统计各个部门的平均工资
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void eg5() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.currentSession().beginTransaction();
			List<Object[]> list = HibernateUtil.currentSession()
					.createQuery("select e.dept.deptName, avg(e.salary) from Emp e group by e.dept.deptName").list();
			for (Object[] obj : list)
				System.out.println(obj[0] + ", " + obj[1]);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

	/**
	 * 统计各个职位的最低工资和最高工资
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void eg6() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.currentSession().beginTransaction();
			List<Object[]> list = HibernateUtil.currentSession()
					.createQuery("select job,min(salary),max(salary) from Emp group by job").list();
			for (Object[] obj : list)
				System.out.println(obj[0] + ", " + obj[1] + ", " + obj[2]);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

	/**
	 * 统计各个部门平均工资高于4000元的部门名称，打印部门名称、部门平均工资
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void eg7() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.currentSession().beginTransaction();
			List<Object[]> list = HibernateUtil.currentSession()
					.createQuery("select e.dept.deptName, avg(e.salary) from Emp e"
							+ " group by e.dept.deptName having avg(e.salary) > 4000")
					.list();
			for (Object[] obj : list)
				System.out.println(obj[0] + ", " + obj[1]);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

	/**
	 * 统计各个部门平均工资高于2000元的部门名称，打印部门名称、部门平均工资，使用JavaBean封装查询结果
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void eg7_JavaBean() {
		Transaction tx = null;
		try {
			tx = HibernateUtil.currentSession().beginTransaction();
			List<DeptSalary> list = HibernateUtil.currentSession()
					.createQuery("select new com.bdqn.spz.scott.entity.DeptSalary(" + "dept.deptName, avg(salary))"
							+ " from Emp group by dept.deptName" + " having avg(salary) > 2000")
					.list();
			for (DeptSalary deptSalary : list)
				System.out.println(deptSalary.getDeptName() + ", " + deptSalary.getAvgSalary());
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

}
