package com.bdqn.oa.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.xml.bind.TypeConstraintException;

import org.apache.struts2.util.StrutsTypeConverter;

public class MyDateConvert extends StrutsTypeConverter {
	@Override								 //���Խ��ܶ��
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		System.out.println("���� ת����--------");
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date;									
		
		try {
			date=sdf.parse(arg1[0]);
			
		} catch (ParseException e) {
			throw new TypeConstraintException("ת������ʧ�ܣ���");	//�Զ����쳣
		}
		return date;
	}

	//��ʾ
	@Override
	public String convertToString(Map arg0, Object arg1) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
		return sdf.format(arg1);
	}
}
