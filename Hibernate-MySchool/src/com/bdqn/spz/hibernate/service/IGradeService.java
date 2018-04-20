package com.bdqn.spz.hibernate.service;

import com.bdqn.spz.hibernate.entity.Grade;
/**
 * Service����ͽӿ�
 * @author ʩ����
 *
 */
public interface IGradeService {

	/**
	 * ͨ��GradeDao.get()������������
	 * @param gradeId
	 * @return Grade
	 */
	public Grade findGradeById(Integer gradeId);

	/**
	 * ͨ��GradeDao.load()������������
	 * @param gradeId
	 * @return Grade
	 */
	public Grade findGradeById_2(Integer gradeId);

	/**
	 * ������
	 * @param grade
	 * @return Integer
	 */
	public Integer addGrade(Grade grade);

	/**
	 * //�޸����ͨ��load()
	 * @param grade
	 */
	public void updateGradeByload(Grade grade);

	/**
	 * �޸����ͨ��update()
	 * @param grade
	 */
	public void updateGrade(Grade grade);

	/**
	 * ɾ�����
	 * @param gradeId
	 */
	public void deleteGrade(Integer gradeId);
	
	/**
	 * ʹ��merge()�����������������ݺϲ���ӵ����ͬOID�ĳ־�̬�����л��߱�����ʱ����ĸ������õ��µĳ־�̬����
	 * @param grade
	 * @return Grade
	 */
	public Grade mergeGrade(Grade grade);
}
