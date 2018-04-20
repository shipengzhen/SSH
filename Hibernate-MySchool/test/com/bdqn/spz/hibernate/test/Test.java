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

	//��ѯ�����Ϣ
	@org.junit.Test
	public void findGradeById(){
		Grade grade=gradeService.findGradeById(1);
		System.out.println(grade.getGradeName());
	}
	
	//��ѯ�����Ϣ
	@org.junit.Test
	public void findGradeById_2(){
		Grade grade=gradeService.findGradeById(1);
		System.out.println(grade.getGradeName());
	}
	
	//����꼶��Ϣ
	@org.junit.Test
	public void addGrade(){
		Grade grade=new Grade();
		grade.setGradeId(4);
		grade.setGradeName("�Ǻ�");
		System.out.println(gradeService.addGrade(grade));
	}
	
	//�޸����ͨ��load()
	@org.junit.Test
	public void updateGradeByload(){
		Grade grade=new Grade();
		grade.setGradeId(4);
		grade.setGradeName("����");
		gradeService.updateGradeByload(grade);
	}
	
	//�޸����ͨ��update()
	@org.junit.Test
	public void updateGrade(){
		Grade grade=new Grade();
		grade.setGradeId(4);
		grade.setGradeName("����");
		gradeService.updateGrade(grade);
	}
	
	//ɾ���꼶
	@org.junit.Test
	public void deleteGrade(){
		gradeService.deleteGrade(4);
	}
	
	//ʹ��merge()�����������������ݺϲ���ӵ����ͬOID�ĳ־�̬�����л��߱�����ʱ����ĸ������õ��µĳ־�̬����
	public void mergeGrade(){
		Grade grade=new Grade();
		grade.setGradeId(4);
		grade.setGradeName("����");
		System.out.println(gradeService.mergeGrade(grade).getGradeName());
	}
	
	public static void main(String[] args) {
		new Test().mergeGrade();
	}
}
