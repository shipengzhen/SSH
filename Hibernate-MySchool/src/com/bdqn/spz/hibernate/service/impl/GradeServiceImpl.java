package com.bdqn.spz.hibernate.service.impl;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import com.bdqn.spz.hibernate.dao.IGradeDao;
import com.bdqn.spz.hibernate.dao.impl.GradeDaoImpl;
import com.bdqn.spz.hibernate.entity.Grade;
import com.bdqn.spz.hibernate.service.IGradeService;
import com.bdqn.spz.hibernate.util.HibernateUtil;

/**
 * Service�����ʵ����
 * 
 * @author ʩ����
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

	// ͨ��GradeDao.get()������������
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

	// ͨ��GradeDao.load()������������
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

	// ������
	@Override
	public Integer addGrade(Grade grade) {
		Transaction tx = null;
		Integer oId = null;
		try {
			tx = HibernateUtil.currentSession().beginTransaction();
			oId = gradeDao.save(grade);
			tx.commit();
			System.out.println("��ӳɹ�");
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("���ʧ��");
			if (tx != null)
				tx.rollback();
		}
		return oId;
	}

	// �޸����ͨ��load()
	@Override
	public void updateGradeByload(Grade grade) {
		Transaction tx = null;
		try {
			tx = HibernateUtil.currentSession().beginTransaction();
			Grade gradeToUpdate = gradeDao.load(grade.getGradeId()); // ����Ҫ�޸ĵ���Ͷ���
			// ���µ�����
			gradeToUpdate.setGradeName(grade.getGradeName());
			tx.commit();
			System.out.println("�޸ĳɹ�");
		} catch (HibernateException e) {
			System.out.println("�޸�ʧ��");
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

	// �޸����ͨ��update()
	@Override
	public void updateGrade(Grade grade) {
		Transaction tx = null;
		try {
			tx = HibernateUtil.currentSession().beginTransaction();
			gradeDao.update(grade);
			tx.commit();
			System.out.println("�޸ĳɹ�");
		} catch (HibernateException e) {
			System.out.println("�޸�ʧ��");
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

	// ɾ�����
	@Override
	public void deleteGrade(Integer gradeId) {
		Transaction tx = null;
		try {
			tx = HibernateUtil.currentSession().beginTransaction();
			Grade gradeToDelete = gradeDao.load(gradeId);
			gradeDao.delete(gradeToDelete);
			tx.commit();
			System.out.println("ɾ���ɹ�");
		} catch (HibernateException e) {
			System.out.println("ɾ��ʧ��");
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

	// ʹ��merge()�����������������ݺϲ���ӵ����ͬOID�ĳ־�̬�����л��߱�����ʱ����ĸ������õ��µĳ־�̬����
	@Override
	public Grade mergeGrade(Grade grade) {
		Transaction tx = null;
		try {
			tx = HibernateUtil.currentSession().beginTransaction(); // ��������
			grade = gradeDao.merge(grade);
			tx.commit(); // �ύ����
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback(); // �ع�����
		}
		return grade;
	}
}
