package com.bdqn.spz.hibernate.test;


import com.bdqn.spz.hibernate.entity.Grade;
import com.bdqn.spz.hibernate.service.IGradeService;
import com.bdqn.spz.hibernate.service.impl.GradeServiceImpl;

public class Test {

	private IGradeService gradeService=new GradeServiceImpl();
	
	public IGradeService getGradeService() {
		return gradeService;
	}

	public void setGradeService(IGradeService gradeService) {
		this.gradeService = gradeService;
	}

	//查询年纪信息
	@org.junit.Test
	public void findGradeById(){
		Grade grade=gradeService.findGradeById(1);
		System.out.println(grade.getGradeName());
	}
	
	//查询年纪信息
	@org.junit.Test
	public void findGradeById_2(){
		Grade grade=gradeService.findGradeById(1);
		System.out.println(grade.getGradeName());
	}
	
	//添加年级信息
	@org.junit.Test
	public void addGrade(){
		Grade grade=new Grade();
		grade.setGradeId(4);
		grade.setGradeName("呵呵");
		System.out.println(gradeService.addGrade(grade));
	}
	
	//修改年纪通过load()
	@org.junit.Test
	public void updateGradeByload(){
		Grade grade=new Grade();
		grade.setGradeId(4);
		grade.setGradeName("哈哈");
		gradeService.updateGradeByload(grade);
	}
	
	//修改年纪通过update()
	@org.junit.Test
	public void updateGrade(){
		Grade grade=new Grade();
		grade.setGradeId(4);
		grade.setGradeName("嘻嘻");
		gradeService.updateGrade(grade);
	}
	
	//删除年级
	@org.junit.Test
	public void deleteGrade(){
		gradeService.deleteGrade(4);
	}
	
	//使用merge()方法将游离对象的数据合并到拥有相同OID的持久态对象中或者保存临时对象的副本，得到新的持久态对象
	public void mergeGrade(){
		Grade grade=new Grade();
		grade.setGradeId(4);
		grade.setGradeName("呜呜");
		System.out.println(gradeService.mergeGrade(grade).getGradeName());
	}
	
	public static void main(String[] args) {
		new Test().mergeGrade();
	}
}
