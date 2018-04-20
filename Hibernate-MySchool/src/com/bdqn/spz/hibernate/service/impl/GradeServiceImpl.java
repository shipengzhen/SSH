package com.bdqn.spz.hibernate.service.impl;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import com.bdqn.spz.hibernate.dao.IGradeDao;
import com.bdqn.spz.hibernate.dao.impl.GradeDaoImpl;
import com.bdqn.spz.hibernate.entity.Grade;
import com.bdqn.spz.hibernate.service.IGradeService;
import com.bdqn.spz.hibernate.util.HibernateUtil;

/**
 * Service层年纪实现类
 * 
 * @author 施鹏振
 *
 */
public class GradeServiceImpl implements IGradeService {

	private IGradeDao gradeDao = new GradeDaoImpl();

	public IGradeDao getGradeDao() {
		return gradeDao;
	}

	public void setGradeDao(IGradeDao gradeDao) {
		this.gradeDao = gradeDao;
	}

	// 通过GradeDao.get()方法加载数据
	@Override
	public Grade findGradeById(Integer gradeId) {
		// Transaction tx = null;
		Grade grade = null;
		try {
			// tx = HibernateUtil.currentSession().beginTransaction();
			grade = gradeDao.get(gradeId);
			// tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			//if (tx != null) {
			//	tx.rollback();
			//}
		}
		return grade;
	}

	// 通过GradeDao.load()方法加载数据
	@Override
	public Grade findGradeById_2(Integer gradeId) {
		Transaction tx = null;
		Grade grade = null;
		try {
			tx = HibernateUtil.currentSession().beginTransaction();
			grade = gradeDao.load(gradeId);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
		return grade;
	}

	// 添加年纪
	@Override
	public Integer addGrade(Grade grade) {
		Transaction tx = null;
		Integer oId = null;
		try {
			tx = HibernateUtil.currentSession().beginTransaction();
			oId = gradeDao.save(grade);
			tx.commit();
			System.out.println("添加成功");
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("添加失败");
			if (tx != null)
				tx.rollback();
		}
		return oId;
	}

	// 修改年纪通过load()
	@Override
	public void updateGradeByload(Grade grade) {
		Transaction tx = null;
		try {
			tx = HibernateUtil.currentSession().beginTransaction();
			Grade gradeToUpdate = gradeDao.load(grade.getGradeId()); // 加载要修改的年纪对象
			// 更新的数据
			gradeToUpdate.setGradeName(grade.getGradeName());
			tx.commit();
			System.out.println("修改成功");
		} catch (HibernateException e) {
			System.out.println("修改失败");
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

	// 修改年纪通过update()
	@Override
	public void updateGrade(Grade grade) {
		Transaction tx = null;
		try {
			tx = HibernateUtil.currentSession().beginTransaction();
			gradeDao.update(grade);
			tx.commit();
			System.out.println("修改成功");
		} catch (HibernateException e) {
			System.out.println("修改失败");
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

	// 删除年纪
	@Override
	public void deleteGrade(Integer gradeId) {
		Transaction tx = null;
		try {
			tx = HibernateUtil.currentSession().beginTransaction();
			Grade gradeToDelete = gradeDao.load(gradeId);
			gradeDao.delete(gradeToDelete);
			tx.commit();
			System.out.println("删除成功");
		} catch (HibernateException e) {
			System.out.println("删除失败");
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

	// 使用merge()方法将游离对象的数据合并到拥有相同OID的持久态对象中或者保存临时对象的副本，得到新的持久态对象
	@Override
	public Grade mergeGrade(Grade grade) {
		Transaction tx = null;
		try {
			tx = HibernateUtil.currentSession().beginTransaction(); // 开启事务
			grade = gradeDao.merge(grade);
			tx.commit(); // 提交事务
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback(); // 回滚事务
		}
		return grade;
	}
}
