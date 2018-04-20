package com.bdqn.spz.hibernate.service;

import com.bdqn.spz.hibernate.entity.Grade;
/**
 * Service层年纪接口
 * @author 施鹏振
 *
 */
public interface IGradeService {

	/**
	 * 通过GradeDao.get()方法加载数据
	 * @param gradeId
	 * @return Grade
	 */
	public Grade findGradeById(Integer gradeId);

	/**
	 * 通过GradeDao.load()方法加载数据
	 * @param gradeId
	 * @return Grade
	 */
	public Grade findGradeById_2(Integer gradeId);

	/**
	 * 添加年纪
	 * @param grade
	 * @return Integer
	 */
	public Integer addGrade(Grade grade);

	/**
	 * //修改年纪通过load()
	 * @param grade
	 */
	public void updateGradeByload(Grade grade);

	/**
	 * 修改年纪通过update()
	 * @param grade
	 */
	public void updateGrade(Grade grade);

	/**
	 * 删除年纪
	 * @param gradeId
	 */
	public void deleteGrade(Integer gradeId);
	
	/**
	 * 使用merge()方法将游离对象的数据合并到拥有相同OID的持久态对象中或者保存临时对象的副本，得到新的持久态对象
	 * @param grade
	 * @return Grade
	 */
	public Grade mergeGrade(Grade grade);
}
